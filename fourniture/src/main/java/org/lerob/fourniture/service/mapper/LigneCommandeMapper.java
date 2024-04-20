package org.lerob.fourniture.service.mapper;

import org.lerob.fourniture.model.dto.CommandeDto;
import org.lerob.fourniture.model.dto.FournitureDto;
import org.lerob.fourniture.model.dto.LigneCommandeDto;
import org.lerob.fourniture.model.entities.Commande;
import org.lerob.fourniture.model.entities.Fourniture;
import org.lerob.fourniture.model.entities.LigneCommande;
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
