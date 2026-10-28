package hu.unideb.inf.keszletnyilvantarto.controller;

import hu.unideb.inf.keszletnyilvantarto.service.FelhasznaloCrudService;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloSaveDto;
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

    private final FelhasznaloCrudService fService;

    @PostMapping
    FelhasznaloSaveDto insert(@Valid
                              @RequestBody FelhasznaloSaveDto f){
        return fService.save(f);
    }

    @GetMapping("/{id}")
    FelhasznaloSaveDto byId(@PathVariable Long id){
        return fService.findById(id);
    }

    @GetMapping
    List<FelhasznaloSaveDto> find(
            @RequestParam(required = false) String felhasznalonev){
        System.out.println("felhasznalonev:"+felhasznalonev);
        if(felhasznalonev==null){
            return fService.findAll();
        } else {
            return List.of(
                    fService.findByFelhasznalonev(felhasznalonev)
            );
        }
    }

    @PutMapping
    FelhasznaloSaveDto update(@Valid
                              @RequestBody FelhasznaloSaveDto f){
        return fService.update(f);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable Long id){
        fService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    void delete(@Valid
                @RequestBody FelhasznaloSaveDto f){
        fService.delete(f);
    }

    @DeleteMapping("/felhasznalok")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteAll(){
        fService.deleteAll();
    }

}
