package org.lerob.commande.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LigneLivraisonDto {
    private Long id;
    private Double qteLivraison;
    private Double prixLivraison;
    private String etatLivraison;
    private LivraisonDto livraison;
    private LigneCommandeDto lignecommande;
    private FournitureDto fourniture;
}
