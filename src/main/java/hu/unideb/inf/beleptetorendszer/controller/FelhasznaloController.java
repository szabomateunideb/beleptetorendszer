package hu.unideb.inf.beleptetorendszer.controller;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.data.entity.JogEntity;
import hu.unideb.inf.beleptetorendszer.data.repository.FelhasznaloRepository;
import hu.unideb.inf.beleptetorendszer.data.repository.JogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("api/felhasznalo")
public class FelhasznaloController {

    //Field injection
    //@Autowired
    //FelhasznaloRepository repo;

    //constructor injection
    private final FelhasznaloRepository repo;
    private final JogRepository jogRepo;

    public FelhasznaloController(FelhasznaloRepository repo
            , JogRepository jogRepo) {
        this.repo = repo;
        this.jogRepo = jogRepo;
    }

    //TODO uni-directional, bidirection

    @GetMapping("/init")
    public FelhasznaloEntity saveMock(){
        JogEntity jogEntity = new JogEntity();
        jogEntity.setNev("FELHASZNALO");
        jogEntity.setLeiras("Minden felhasználó rendelkezik ezzel a joggal");
        jogEntity = jogRepo.save(jogEntity);


        FelhasznaloEntity entity = new FelhasznaloEntity();
        entity.setJogosultsagok(Set.of(jogEntity));
        entity.setEmail("xy@mail.com");
        entity.setFelhasznalonev("jozsi01");
        entity.setJelszo("password0");
        entity.setSzuletesiDatum(LocalDate.now());

        return repo.save(entity);
    }
}
