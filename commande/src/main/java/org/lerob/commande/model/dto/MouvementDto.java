package org.lerob.commande.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MouvementDto {
    private Long id;
    private String codeMouv;
    private LocalDate datemouv;
    private LocalDate dateInventaire;
    private Double qteMouv;
    private String natureMouv;
    private String etatMouv;

    private LigneLivraisonDto lignelivraison;
    private SortieDto sortie;
    private FournitureDto fourniture;
}
