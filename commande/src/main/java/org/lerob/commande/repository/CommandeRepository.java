package org.lerob.commande.repository;

import org.lerob.commande.model.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    boolean existsByCodeComIgnoreCase(String reference);
}
