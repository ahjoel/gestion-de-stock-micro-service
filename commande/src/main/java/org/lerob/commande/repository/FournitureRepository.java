package org.lerob.commande.repository;

import org.lerob.commande.model.entities.Fourniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournitureRepository extends JpaRepository<Fourniture, Long> {
    boolean existsByCodeFourIgnoreCase(String reference);
    Optional<Fourniture> findFournitureByCodeFour(String nom);
}
