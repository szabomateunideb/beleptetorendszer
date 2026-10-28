package hu.unideb.inf.beleptetorendszer.controller;

import hu.unideb.inf.beleptetorendszer.service.FelhasznaloCrudService;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloSaveDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/felhasznalo")
@AllArgsConstructor
public class FelhasznaloCrudController {

    private final FelhasznaloCrudService fcService;

    @PostMapping
    FelhasznaloSaveDto save(@RequestBody FelhasznaloSaveDto dto) {
        return fcService.save(dto);
    }

    @GetMapping
    List<FelhasznaloSaveDto> find(
            @RequestParam(required = false) String felhasznalonev) {
        System.out.println("felhasznalonev: " + felhasznalonev);
        if (felhasznalonev == null) {
            return fcService.findAll();
        } else {
            return List.of(
                    fcService.findByFelhasznalonev(felhasznalonev)
            );
        }
    }

    @GetMapping("/{id}")
    FelhasznaloSaveDto findOneById(@PathVariable Long id){
        return fcService.findById(id);
    }
}
