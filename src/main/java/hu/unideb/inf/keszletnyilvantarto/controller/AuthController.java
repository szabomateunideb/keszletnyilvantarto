package hu.unideb.inf.keszletnyilvantarto.controller;

import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloLoginDto;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloSaveDto;
import hu.unideb.inf.keszletnyilvantarto.service.impl.AuthenticaionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthenticaionService authService;

    public AuthController(AuthenticaionService authService) {
        this.authService = authService;
    }

    @PostMapping("/regisztracio")
    public FelhasznaloSaveDto regisztracio(
            @Valid @RequestBody FelhasznaloSaveDto dto){
        return authService.regisztracio(dto);
    }

    @PostMapping("/bejelentkezes")
    public String bejelentkezes(
            @RequestBody FelhasznaloLoginDto dto){
        return authService.bejelentkezes(dto);
    }
}
