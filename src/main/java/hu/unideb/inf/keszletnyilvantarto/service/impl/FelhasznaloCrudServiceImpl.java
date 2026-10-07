package hu.unideb.inf.keszletnyilvantarto.service.impl;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import hu.unideb.inf.keszletnyilvantarto.data.repository.FelhasznaloRepository;
import hu.unideb.inf.keszletnyilvantarto.service.FelhasznaloCrudService;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloSaveDto;
import hu.unideb.inf.keszletnyilvantarto.service.mapper.FelhasznaloMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FelhasznaloCrudServiceImpl
        implements FelhasznaloCrudService {

    private final FelhasznaloMapper fMapper;
    private final FelhasznaloRepository fRepo;


    @Override
    public FelhasznaloSaveDto save(FelhasznaloSaveDto dto) {
        FelhasznaloEntity e = new FelhasznaloEntity();
        e = fMapper.toEntity(dto);
        //van id
        e = fRepo.save(e);

        return fMapper.toSaveDto(e);
    }

    @Override
    public FelhasznaloSaveDto findById(Long id) {
        return null;
    }

    @Override
    public List<FelhasznaloSaveDto> findAll() {
        return List.of();
    }

    @Override
    public FelhasznaloSaveDto findByFelhasznalonev(String felhasznalonev) {
        return null;
    }

    @Override
    public FelhasznaloSaveDto update(FelhasznaloSaveDto dto) {
        return null;
    }

    @Override
    public FelhasznaloSaveDto changePassword(Long id, String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void delete(FelhasznaloSaveDto dto) {

    }
}
