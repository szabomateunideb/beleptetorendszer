package hu.unideb.inf.beleptetorendszer.service.impl;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.data.repository.FelhasznaloRepository;
import hu.unideb.inf.beleptetorendszer.service.FelhasznaloMegjelenitoService;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloDisplayDto;
import hu.unideb.inf.beleptetorendszer.service.mapper.FelhasznaloMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FelhasznaloMegjelenitoServiceImpl
    implements FelhasznaloMegjelenitoService {

    private final FelhasznaloRepository repo;
    private final FelhasznaloMapper mapper;

    @Override
    public List<FelhasznaloDisplayDto> findAllFelhasznalo() {
        repo.findAll()
                .forEach(x ->
                        System.out.println(x.getFelhasznalonev()));
        mapper.entityListToDisplayDtoList(repo.findAll())
                .forEach(x ->
                        System.out.println(x.getFelhasznalonev()));
        return mapper.entityListToDisplayDtoList(repo.findAll());
    }

    @Override
    public FelhasznaloDisplayDto findFelhasznaloByNev(String nev) {
        return mapper.entityToDisplayDto(repo.findByNative(nev));

    }
}
