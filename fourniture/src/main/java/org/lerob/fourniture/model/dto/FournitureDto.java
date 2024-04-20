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
public class FournitureDto {
    private Long id;
    private String codeFour;
    private String nomFour;
    private String mesureFour;
    private String qteMinFour;
    private LocalDate dateCreation;
    private LocalDate dateModification;
    private String etatFour;
    private CategorieDto categorie;
}
