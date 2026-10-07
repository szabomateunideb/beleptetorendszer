package hu.unideb.inf.beleptetorendszer.service;

import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloSaveDto;

import java.util.List;

public interface FelhasznaloCrudService {
    //Create
    FelhasznaloSaveDto save(FelhasznaloSaveDto felhasznaloSaveDto);
    //Read
    FelhasznaloSaveDto findById(Long id);
    List<FelhasznaloSaveDto> findAll();
    FelhasznaloSaveDto findByFelhasznalonev(String felhasznalonev);
    //Update
    FelhasznaloSaveDto update(FelhasznaloSaveDto felhasznaloSaveDto);
    //Delete
    void delete(Long id);
    void deleteAll();
    void deleteByFelhasznalonev(String felhasznalonev);

}
