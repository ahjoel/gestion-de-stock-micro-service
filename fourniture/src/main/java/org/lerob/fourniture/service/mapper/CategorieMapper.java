package org.lerob.fourniture.service.mapper;

import org.lerob.fourniture.model.dto.CategorieDto;
import org.lerob.fourniture.model.entities.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface CategorieMapper {
    Categorie toEntity(CategorieDto categorieDto);
    CategorieDto toDto(Categorie categorie);

    void copy(CategorieDto categorieDto, @MappingTarget Categorie categorie);
}
