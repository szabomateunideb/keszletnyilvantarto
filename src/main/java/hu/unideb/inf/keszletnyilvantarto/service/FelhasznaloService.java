package hu.unideb.inf.keszletnyilvantarto.service;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloDisplayDto;

import java.util.List;

public interface FelhasznaloService {

    List<FelhasznaloDisplayDto> findAll();

    FelhasznaloDisplayDto findByNev(String nev);
}
