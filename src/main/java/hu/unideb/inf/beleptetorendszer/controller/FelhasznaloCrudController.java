package hu.unideb.inf.beleptetorendszer.controller;

import hu.unideb.inf.beleptetorendszer.service.FelhasznaloCrudService;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloSaveDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/felhasznalo")
@AllArgsConstructor
public class FelhasznaloCrudController {

    private final FelhasznaloCrudService fcService;

    @PostMapping
    FelhasznaloSaveDto save(@RequestBody FelhasznaloSaveDto dto) {
        return fcService.save(dto);
    }
}
