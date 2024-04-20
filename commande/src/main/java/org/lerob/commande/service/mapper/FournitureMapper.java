package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.CategorieDto;
import org.lerob.commande.model.dto.FournitureDto;
import org.lerob.commande.model.entities.Fourniture;
import org.lerob.commande.model.entities.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface FournitureMapper {
    Fourniture toEntity(FournitureDto fournitureDto);
    FournitureDto toDto(Fourniture fourniture);

    Categorie toCategoryEntity(CategorieDto categorieDto);

    void copy(FournitureDto fournitureDto, @MappingTarget Fourniture fourniture);
}
