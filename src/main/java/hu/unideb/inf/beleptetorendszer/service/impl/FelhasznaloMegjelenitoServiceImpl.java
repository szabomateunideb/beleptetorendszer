package hu.unideb.inf.beleptetorendszer.service.impl;

import hu.unideb.inf.beleptetorendszer.service.FelhasznaloMegjelenitoService;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloDisplayDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FelhasznaloMegjelenitoServiceImpl
    implements FelhasznaloMegjelenitoService {
    @Override
    public List<FelhasznaloDisplayDto> findAllFelhasznalo() {
        return List.of();
    }

    @Override
    public FelhasznaloDisplayDto findFelhasznaloByNev(String nev) {
        return null;
    }
}
