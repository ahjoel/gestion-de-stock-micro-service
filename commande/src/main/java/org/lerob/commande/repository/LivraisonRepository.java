package org.lerob.commande.repository;

import org.lerob.commande.model.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    boolean existsBycodeLivIgnoreCase(String reference);
}
