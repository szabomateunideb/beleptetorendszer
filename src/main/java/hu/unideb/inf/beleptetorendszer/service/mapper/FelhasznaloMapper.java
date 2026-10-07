package hu.unideb.inf.beleptetorendszer.service.mapper;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloDisplayDto;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloSaveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    //@Mapping(source = "felhasznalonev", target = "felhasznalonev")
    FelhasznaloDisplayDto entityToDisplayDto(FelhasznaloEntity e);

    List<FelhasznaloDisplayDto> entityListToDisplayDtoList(
            List<FelhasznaloEntity> e);

    FelhasznaloSaveDto entityToSaveDto(FelhasznaloEntity e);
    List<FelhasznaloSaveDto> entityListToSaveDtoList(List<FelhasznaloEntity> e);

    @Mapping(target = "jogosultsagok", ignore = true)
    FelhasznaloEntity entityDtoToEntity(FelhasznaloSaveDto dto);
    List<FelhasznaloEntity> entityDtoListToEntity(List<FelhasznaloSaveDto> dtoList);

}
