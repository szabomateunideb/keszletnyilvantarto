package hu.unideb.inf.keszletnyilvantarto.controller;

import hu.unideb.inf.keszletnyilvantarto.service.FelhasznaloCrudService;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloSaveDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/felhasznalo")
@AllArgsConstructor
public class FelhasznaloCrudController {

    private final FelhasznaloCrudService fService;

    @PostMapping
    FelhasznaloSaveDto insert(@RequestBody FelhasznaloSaveDto f){
        return fService.save(f);
    }

}
