package hu.unideb.inf.beleptetorendszer.service.mapper;

import hu.unideb.inf.beleptetorendszer.data.entity.FelhasznaloEntity;
import hu.unideb.inf.beleptetorendszer.service.dto.FelhasznaloDisplayDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FelhasznaloMapper {

    //@Mapping(source = "felhasznalonev", target = "felhasznalonev")
    FelhasznaloDisplayDto entityToDisplayDto(FelhasznaloEntity e);

    List<FelhasznaloDisplayDto> entityListToDisplayDtoList(
            List<FelhasznaloEntity> e);

}
