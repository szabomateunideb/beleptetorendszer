package hu.unideb.inf.beleptetorendszer.service.impl;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.data.entity.JogEntity;
import hu.unideb.inf.beleptetorendszer.data.repository.FelhasznaloRepository;
import hu.unideb.inf.beleptetorendszer.data.repository.JogRepository;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloLoginDto;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloSaveDto;
import hu.unideb.inf.beleptetorendszer.service.mapper.FelhasznaloMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final FelhasznaloRepository repo;
    private final FelhasznaloMapper fmapper;
    private final JogRepository jrepo;
    private final AuthenticationManager authManager;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public FelhasznaloSaveDto register(FelhasznaloSaveDto dto) {
        FelhasznaloEntity e = fmapper.entityDtoToEntity(dto);
        JogEntity j = jrepo.findByNev("FELHASZNALO").orElse(null);

        if (j != null) {
            e.setJogosultsagok(Set.of(j));
        } else {
            j = new JogEntity();
            j.setNev("FELHASZNALO");
            j = jrepo.save(j);

            e.setJogosultsagok(Set.of(j));
        }
        e.setJelszo(passwordEncoder.encode(e.getJelszo()));
        e = repo.save(e);

        return fmapper.entityToSaveDto(e);
    }

    public void login(FelhasznaloLoginDto dto) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getFelhasznalonev(), dto.getJelszo()
                )
        );
        context.setAuthentication(auth);

    }
}
