package hu.unideb.inf.beleptetorendszer.service.impl;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.data.repository.FelhasznaloRepository;
import hu.unideb.inf.beleptetorendszer.service.FelhasznaloMegjelenitoService;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloDisplayDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FelhasznaloMegjelenitoServiceImpl
    implements FelhasznaloMegjelenitoService {

    private final FelhasznaloRepository repo;

    @Override
    public List<FelhasznaloDisplayDto> findAllFelhasznalo() {
        List<FelhasznaloEntity> entities = repo.findAll();
        List<FelhasznaloDisplayDto> dtos = new ArrayList<>();
        for (FelhasznaloEntity entity : entities) {
            FelhasznaloDisplayDto dto = new FelhasznaloDisplayDto();
            dto.setFelhasznalonev(entity.getFelhasznalonev());
            dto.setNem(entity.getNem());
            dto.setSzuletesiDatum(entity.getSzuletesiDatum());
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public FelhasznaloDisplayDto findFelhasznaloByNev(String nev) {
        return null;
    }
}
