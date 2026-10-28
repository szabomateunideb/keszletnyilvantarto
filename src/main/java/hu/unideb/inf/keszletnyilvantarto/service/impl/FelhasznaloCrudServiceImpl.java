package hu.unideb.inf.keszletnyilvantarto.service.impl;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import hu.unideb.inf.keszletnyilvantarto.data.entity.JogEntity;
import hu.unideb.inf.keszletnyilvantarto.data.repository.FelhasznaloRepository;
import hu.unideb.inf.keszletnyilvantarto.service.FelhasznaloCrudService;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloSaveDto;
import hu.unideb.inf.keszletnyilvantarto.service.mapper.FelhasznaloMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
        return fMapper.toSaveDto(fRepo.getReferenceById(id));
    }

    @Override
    public List<FelhasznaloSaveDto> findAll() {
        return fMapper.toSaveDtos(fRepo.findAll());
    }

    @Override
    public FelhasznaloSaveDto findByFelhasznalonev(String felhasznalonev) {
        return fMapper.toSaveDto(
                fRepo.findByFelhasznalonev(felhasznalonev)
        );
    }

    @Override
    public FelhasznaloSaveDto update(FelhasznaloSaveDto dto) {
        FelhasznaloEntity e = fRepo.getReferenceById(dto.getId());
        Set<JogEntity> j = e.getJogosultsagok();
        e = fMapper.toEntity(dto); //eltűnnek a jogosultságok
        e.setJogosultsagok(j);
        e = fRepo.save(e);
        return fMapper.toSaveDto(e);
    }

    @Override
    public FelhasznaloSaveDto changePassword(Long id, String oldPassword, String newPassword)
    {
        FelhasznaloEntity e = fRepo.getReferenceById(id);
        if(e.getJelszo().equals(oldPassword))
        {
            e.setJelszo(newPassword);
        }
        e = fRepo.save(e);
        return fMapper.toSaveDto(e);
    }

    @Override
    public void deleteById(Long id) {
        fRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        fRepo.deleteAll();
    }

    @Override
    public void delete(FelhasznaloSaveDto dto) {
        fRepo.delete(fMapper.toEntity(dto));
        //fRepo.deleteById(dto.getId());
    }
}
