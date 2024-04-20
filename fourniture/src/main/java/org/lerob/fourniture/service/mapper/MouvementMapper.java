package org.lerob.fourniture.service.mapper;

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
