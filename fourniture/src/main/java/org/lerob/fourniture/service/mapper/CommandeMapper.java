package org.lerob.fourniture.service.mapper;

import org.lerob.fourniture.model.dto.CommandeDto;
import org.lerob.fourniture.model.dto.EmployeDto;
import org.lerob.fourniture.model.entities.Commande;
import org.lerob.fourniture.model.entities.Employe;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel="spring")
public interface CommandeMapper {
    Commande toEntity(CommandeDto commandeDto);
    CommandeDto toDto(Commande commande);
    Employe toEmployeEntity(EmployeDto employeDto);
    void copy(CommandeDto commandeDto, @MappingTarget Commande commande);
}
