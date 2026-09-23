package hu.unideb.inf.keszletnyilvantarto.controller;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import hu.unideb.inf.keszletnyilvantarto.data.repository.FelhasznaloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("api/felhasznalo")
public class FelhasznaloController {

    //Field injection
    //@Autowired
    //FelhasznaloRepository repo;

    private final FelhasznaloRepository repo;

    public FelhasznaloController(FelhasznaloRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/init")
    public FelhasznaloEntity init(){
        FelhasznaloEntity e = new FelhasznaloEntity();
        e.setEmail("xy@mail.com");
        e.setNev("Józsi");
        e.setJelszo("password1");
        e.setFelhasznalonev("jozsi01");
        e.setSzuletesiDatum(LocalDate.now());

        e = repo.save(e);
        return e;

    }
}
