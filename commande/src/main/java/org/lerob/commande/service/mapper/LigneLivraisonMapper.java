package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.FournitureDto;
import org.lerob.commande.model.dto.LigneCommandeDto;
import org.lerob.commande.model.dto.LigneLivraisonDto;
import org.lerob.commande.model.dto.LivraisonDto;
import org.lerob.commande.model.entities.Fourniture;
import org.lerob.commande.model.entities.LigneCommande;
import org.lerob.commande.model.entities.LigneLivraison;
import org.lerob.commande.model.entities.Livraison;
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
