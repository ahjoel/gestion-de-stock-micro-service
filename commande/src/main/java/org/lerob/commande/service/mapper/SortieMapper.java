package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.EmployeDto;
import org.lerob.commande.model.dto.FournitureDto;
import org.lerob.commande.model.dto.SortieDto;
import org.lerob.commande.model.entities.Employe;
import org.lerob.commande.model.entities.Fourniture;
import org.lerob.commande.model.entities.Sortie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface SortieMapper {
    Sortie toEntity(SortieDto sortieDto);
    SortieDto toDto(Sortie sortie);

    Fourniture toFournitureEntity(FournitureDto fournitureDto);
    Employe toEmployeEntity(EmployeDto employeDto);

    void copy(SortieDto sortieDto, @MappingTarget Sortie sortie);
}
