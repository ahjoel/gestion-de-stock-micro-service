package org.lerob.fourniture.service.mapper;

import org.lerob.fourniture.model.dto.LivraisonDto;
import org.lerob.fourniture.model.entities.Livraison;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface LivraisonMapper {
    Livraison toEntity(LivraisonDto livraisonDto);
    LivraisonDto toDto(Livraison livraison);
    void copy(LivraisonDto livraisonDto, @MappingTarget Livraison livraison);
}
