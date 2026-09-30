package hu.unideb.inf.beleptetorendszer.service;

import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloDisplayDto;

import java.util.List;

public interface FelhasznaloMegjelenitoService {

    List<FelhasznaloDisplayDto> findAllFelhasznalo();

    FelhasznaloDisplayDto findFelhasznaloByNev(String nev);
}
