package org.lerob.fourniture.service.mapper;

import org.lerob.fourniture.model.dto.CategorieDto;
import org.lerob.fourniture.model.dto.FournitureDto;
import org.lerob.fourniture.model.entities.Fourniture;
import org.lerob.fourniture.model.entities.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface FournitureMapper {
    Fourniture toEntity(FournitureDto fournitureDto);
    FournitureDto toDto(Fourniture fourniture);

    Categorie toCategoryEntity(CategorieDto categorieDto);

    void copy(FournitureDto fournitureDto, @MappingTarget Fourniture fourniture);
}
