package org.lerob.fourniture.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LigneCommandeDto {
    private Long id;
    private Double qteLigneCom;
    private String etatLigneCom;
    private CommandeDto commande;
    private FournitureDto fourniture;
}
