package org.lerob.fourniture.repository;

import org.lerob.fourniture.model.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    boolean existsBycodeLivIgnoreCase(String reference);
}
