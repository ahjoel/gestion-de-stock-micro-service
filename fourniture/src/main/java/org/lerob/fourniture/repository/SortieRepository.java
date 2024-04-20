package org.lerob.fourniture.repository;

import org.lerob.fourniture.model.entities.Sortie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SortieRepository extends JpaRepository<Sortie, Long> {
    boolean existsByCodeSortIgnoreCase(String reference);
    Optional<Sortie> findSortieByCodeSort(String nom);

}
