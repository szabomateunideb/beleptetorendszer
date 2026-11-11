package hu.unideb.inf.beleptetorendszer.controller;

import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloLoginDto;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloSaveDto;
import hu.unideb.inf.beleptetorendszer.service.impl.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthenticationServiceImpl authService;
    public AuthController(AuthenticationServiceImpl authService) {
        this.authService = authService;
    }

    @PostMapping("/regisztracio")
    public FelhasznaloSaveDto regisztracio(
            @Valid
            @RequestBody FelhasznaloSaveDto dto){
        return authService.register(dto);
    }

    @PostMapping("/bejelentkezes")
    public void bejelentkezes(
            @Valid
            @RequestBody FelhasznaloLoginDto dto){
        authService.login(dto);
    }
}
