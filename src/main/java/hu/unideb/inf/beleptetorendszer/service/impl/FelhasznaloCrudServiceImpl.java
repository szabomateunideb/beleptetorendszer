package hu.unideb.inf.beleptetorendszer.service.impl;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.data.repository.FelhasznaloRepository;
import hu.unideb.inf.beleptetorendszer.service.FelhasznaloCrudService;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloSaveDto;
import hu.unideb.inf.beleptetorendszer.service.mapper.FelhasznaloMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FelhasznaloCrudServiceImpl
        implements FelhasznaloCrudService {

    private final FelhasznaloRepository frepo;
    private final FelhasznaloMapper fmapper;

    @Override
    public FelhasznaloSaveDto save(FelhasznaloSaveDto felhasznaloSaveDto) {
        FelhasznaloEntity e = new FelhasznaloEntity();
        e = fmapper.entityDtoToEntity(felhasznaloSaveDto);
        e = frepo.save(e);

        return fmapper.entityToSaveDto(e);
    }

    @Override
    public FelhasznaloSaveDto findById(Long id) {
        return fmapper.entityToSaveDto(frepo.getReferenceById(id));
    }

    @Override
    public List<FelhasznaloSaveDto> findAll() {
        return fmapper.entityListToSaveDtoList(frepo.findAll());
    }

    @Override
    public FelhasznaloSaveDto findByFelhasznalonev(String felhasznalonev) {
        return fmapper.entityToSaveDto(
                frepo.findByFelhasznalonev(felhasznalonev)
        );

    }

    @Override
    public FelhasznaloSaveDto update(FelhasznaloSaveDto felhasznaloSaveDto) {
        FelhasznaloEntity e = fmapper
                .entityDtoToEntity(felhasznaloSaveDto);

        return fmapper.entityToSaveDto(frepo.save(e));

    }

    @Override
    public void delete(Long id) {
        frepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        frepo.deleteAll();
    }

    @Override
    public void deleteByFelhasznalonev(String felhasznalonev) {
        frepo.deleteByFelhasznalonev(felhasznalonev);
    }
}
