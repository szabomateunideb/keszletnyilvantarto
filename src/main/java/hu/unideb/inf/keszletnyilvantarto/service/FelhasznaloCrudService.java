package hu.unideb.inf.keszletnyilvantarto.service;

import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloSaveDto;

import java.util.List;

public interface FelhasznaloCrudService {
    //Create
    FelhasznaloSaveDto save(FelhasznaloSaveDto dto);
    //Read
    FelhasznaloSaveDto findById(Long id);
    List<FelhasznaloSaveDto> findAll();
    FelhasznaloSaveDto findByFelhasznalonev(String felhasznalonev);
    //Update
    FelhasznaloSaveDto update(FelhasznaloSaveDto dto);
    FelhasznaloSaveDto changePassword(Long id, String oldPassword, String newPassword);
    //Delete
    void deleteById(Long id);
    void deleteAll();
    void delete(FelhasznaloSaveDto dto);

}
