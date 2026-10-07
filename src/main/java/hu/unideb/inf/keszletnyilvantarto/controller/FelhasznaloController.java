package hu.unideb.inf.keszletnyilvantarto.controller;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import hu.unideb.inf.keszletnyilvantarto.data.entity.JogEntity;
import hu.unideb.inf.keszletnyilvantarto.data.repository.FelhasznaloRepository;
import hu.unideb.inf.keszletnyilvantarto.data.repository.JogRepository;
import hu.unideb.inf.keszletnyilvantarto.service.FelhasznaloService;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloDisplayDto;
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

    private final FelhasznaloRepository repo;
    private final JogRepository jogRepo;
    private final FelhasznaloService felhasznaloService;

    public FelhasznaloController(FelhasznaloRepository repo
            ,  JogRepository jogRepo
            , FelhasznaloService felhasznaloService) {
        this.felhasznaloService = felhasznaloService;
        this.repo = repo;
        this.jogRepo = jogRepo;
    }

    @GetMapping
    public List<FelhasznaloDisplayDto> findAll() {
        return  felhasznaloService.findAll();
    }

    @GetMapping("/init")
    public FelhasznaloEntity init(){
        JogEntity j = new JogEntity();
        j.setNev("user");
        j = jogRepo.save(j);

        FelhasznaloEntity e = new FelhasznaloEntity();
        e.setJogosultsagok(Set.of(j));
        e.setEmail("xy@mail.com");
        e.setNev("Józsi");
        e.setJelszo("password1");
        e.setFelhasznalonev("jozsi01");
        e.setSzuletesiDatum(LocalDate.now());

        e = repo.save(e);
        return e;

    }
}
