package hu.unideb.inf.keszletnyilvantarto.service.impl;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import hu.unideb.inf.keszletnyilvantarto.data.repository.FelhasznaloRepository;
import hu.unideb.inf.keszletnyilvantarto.service.FelhasznaloService;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloDisplayDto;
import hu.unideb.inf.keszletnyilvantarto.service.mapper.FelhasznaloMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FelhasznaloServiceImpl
    implements FelhasznaloService {

    private final FelhasznaloRepository repo;
    private final FelhasznaloMapper mapper;

    @Override
    public List<FelhasznaloDisplayDto> findAll() {
        return mapper.toDtos(repo.findAll());
        /*List<FelhasznaloDisplayDto> dtos = new ArrayList<>();
        List<FelhasznaloEntity> entities = repo.findAll();

        for (FelhasznaloEntity entity : entities) {
            FelhasznaloDisplayDto dto = new FelhasznaloDisplayDto();
            dto.setNev(entity.getNev());
            dto.setNem(entity.getNem());
            dto.setSzulDatum(entity.getSzuletesiDatum());
            dtos.add(dto);
        }*/
    }

    @Override
    public FelhasznaloDisplayDto findByNev(String nev) {
        return mapper.toDto(repo.findByNative(nev));
    }
}
