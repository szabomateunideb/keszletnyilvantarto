package hu.unideb.inf.keszletnyilvantarto.service.mapper;

import hu.unideb.inf.keszletnyilvantarto.data.entity.FelhasznaloEntity;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloDisplayDto;
import hu.unideb.inf.keszletnyilvantarto.service.dto.FelhasznaloSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    @Mapping(target = "szulDatum", source = "szuletesiDatum")
    FelhasznaloDisplayDto toDto(
            FelhasznaloEntity e);

    List<FelhasznaloDisplayDto> toDtos(
            List<FelhasznaloEntity> entities);

    FelhasznaloSaveDto toSaveDto(
            FelhasznaloEntity e);

    List<FelhasznaloSaveDto> toSaveDtos(
            List<FelhasznaloEntity> entities);

    @Mapping(target = "jogosultsagok", ignore = true)
    FelhasznaloEntity toEntity(FelhasznaloSaveDto dto);
    List<FelhasznaloEntity> toEntityList(
            List<FelhasznaloSaveDto> dtos);
}
