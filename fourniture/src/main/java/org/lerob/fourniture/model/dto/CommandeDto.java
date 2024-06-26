package org.lerob.fourniture.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandeDto {
    private Long id;
    private String codeCom;
    private LocalDate dateCom;
    private EmployeDto employe;
}
