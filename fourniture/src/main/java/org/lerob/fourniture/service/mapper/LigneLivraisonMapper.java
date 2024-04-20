package org.lerob.fourniture.service.mapper;

import org.lerob.fourniture.model.dto.FournitureDto;
import org.lerob.fourniture.model.dto.LigneCommandeDto;
import org.lerob.fourniture.model.dto.LigneLivraisonDto;
import org.lerob.fourniture.model.dto.LivraisonDto;
import org.lerob.fourniture.model.entities.Fourniture;
import org.lerob.fourniture.model.entities.LigneCommande;
import org.lerob.fourniture.model.entities.LigneLivraison;
import org.lerob.fourniture.model.entities.Livraison;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface LigneLivraisonMapper {
    LigneLivraison toEntity(LigneLivraisonDto livraisonDto);
    LigneLivraisonDto toDto(LigneLivraison ligneLivraison);

    Livraison toLivraisonEntity(LivraisonDto livraisonDto);
    LigneCommande toLigneCommandeEntity(LigneCommandeDto ligneCommandeDto);
    Fourniture toFournitureEntity(FournitureDto fournitureDto);

    void copy(LigneLivraisonDto livraisonDto, @MappingTarget LigneLivraison livraison);
}
