package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.CategorieDto;
import org.lerob.commande.model.entities.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface CategorieMapper {
    Categorie toEntity(CategorieDto categorieDto);
    CategorieDto toDto(Categorie categorie);

    void copy(CategorieDto categorieDto, @MappingTarget Categorie categorie);
}
