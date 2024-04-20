package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.CommandeDto;
import org.lerob.commande.model.dto.FournitureDto;
import org.lerob.commande.model.dto.LigneCommandeDto;
import org.lerob.commande.model.entities.Commande;
import org.lerob.commande.model.entities.Fourniture;
import org.lerob.commande.model.entities.LigneCommande;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface LigneCommandeMapper {
    LigneCommande toEntity(LigneCommandeDto ligneCommandeDto);
    LigneCommandeDto toDto(LigneCommande ligneCommande);

    Commande toCommandeEntity(CommandeDto commandeDto);
    Fourniture toFournitureEntity(FournitureDto fournitureDto);

    void copy(LigneCommandeDto ligneCommandeDto, @MappingTarget LigneCommande ligneCommande);
}
