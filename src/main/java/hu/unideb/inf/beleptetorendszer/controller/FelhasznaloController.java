package hu.unideb.inf.beleptetorendszer.controller;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.data.entity.JogEntity;
import hu.unideb.inf.beleptetorendszer.data.repository.FelhasznaloRepository;
import hu.unideb.inf.beleptetorendszer.data.repository.JogRepository;
import hu.unideb.inf.beleptetorendszer.service.FelhasznaloMegjelenitoService;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloDisplayDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
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
    private final FelhasznaloMegjelenitoService megjelenitoService;

    public FelhasznaloController(FelhasznaloRepository repo
            , JogRepository jogRepo
            , FelhasznaloMegjelenitoService megjelenitoService) {
        this.repo = repo;
        this.jogRepo = jogRepo;
        this.megjelenitoService = megjelenitoService;
    }

    @GetMapping
    public List<FelhasznaloDisplayDto> findAll() {
        return megjelenitoService.findAllFelhasznalo();
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
