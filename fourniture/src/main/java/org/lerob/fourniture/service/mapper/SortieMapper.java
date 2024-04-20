package org.lerob.fourniture.service.mapper;

import org.lerob.fourniture.model.dto.EmployeDto;
import org.lerob.fourniture.model.dto.FournitureDto;
import org.lerob.fourniture.model.dto.SortieDto;
import org.lerob.fourniture.model.entities.Employe;
import org.lerob.fourniture.model.entities.Fourniture;
import org.lerob.fourniture.model.entities.Sortie;
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
