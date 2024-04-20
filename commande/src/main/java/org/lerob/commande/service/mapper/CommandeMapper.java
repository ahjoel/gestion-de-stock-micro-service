package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.CommandeDto;
import org.lerob.commande.model.dto.EmployeDto;
import org.lerob.commande.model.entities.Commande;
import org.lerob.commande.model.entities.Employe;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface CommandeMapper {
    Commande toEntity(CommandeDto commandeDto);
    CommandeDto toDto(Commande commande);
    Employe toEmployeEntity(EmployeDto employeDto);
    void copy(CommandeDto commandeDto, @MappingTarget Commande commande);
}
