package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.LivraisonDto;
import org.lerob.commande.model.entities.Livraison;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface LivraisonMapper {
    Livraison toEntity(LivraisonDto livraisonDto);
    LivraisonDto toDto(Livraison livraison);
    void copy(LivraisonDto livraisonDto, @MappingTarget Livraison livraison);
}
