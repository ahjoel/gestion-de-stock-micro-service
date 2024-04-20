package org.lerob.commande.service.mapper;

import org.lerob.commande.model.dto.EmployeDto;
import org.lerob.commande.model.entities.Employe;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel="spring")
public interface EmployeMapper {
    Employe toEntity(EmployeDto employeDto);
    EmployeDto toDto(Employe employe);

    void copy(EmployeDto employeDto, @MappingTarget Employe employe);
}
