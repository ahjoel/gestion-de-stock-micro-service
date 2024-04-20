package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.FournitureDto;
import org.lerob.commande.model.dto.LigneLivraisonDto;
import org.lerob.commande.model.dto.MouvementDto;
import org.lerob.commande.model.dto.SortieDto;
import org.lerob.commande.model.entities.Fourniture;
import org.lerob.commande.model.entities.LigneLivraison;
import org.lerob.commande.model.entities.Mouvement;
import org.lerob.commande.model.entities.Sortie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface MouvementMapper {
    Mouvement toEntity(MouvementDto mouvementDto);
    MouvementDto toDto(Mouvement mouvement);

    Fourniture toFournitureEntity(FournitureDto fournitureDto);
    LigneLivraison toLigneLivraisonEntity(LigneLivraisonDto ligneLivraisonDto);
    Sortie toSortieEntity(SortieDto sortieDto);

    void copy(MouvementDto mouvementDto, @MappingTarget Mouvement mouvement);
}
