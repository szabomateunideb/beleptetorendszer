package hu.unideb.inf.beleptetorendszer.controller;

import hu.unideb.inf.beleptetorendszer.service.FelhasznaloCrudService;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloSaveDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/felhasznalo")
@AllArgsConstructor
public class FelhasznaloCrudController {

    private final FelhasznaloCrudService fcService;

    @PostMapping
    FelhasznaloSaveDto save(@Valid
                            @RequestBody FelhasznaloSaveDto dto) {
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

    @PutMapping
    FelhasznaloSaveDto update(@Valid
                              @RequestBody FelhasznaloSaveDto dto) {
        return fcService.update(dto);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        fcService.delete(id);
    }

    @DeleteMapping
    ResponseEntity delete(@Valid
                          @RequestBody FelhasznaloSaveDto dto) {
        fcService.deleteByFelhasznalonev(dto.getFelhasznalonev());
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/felhasznalok")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAll() {fcService.deleteAll();}
}
