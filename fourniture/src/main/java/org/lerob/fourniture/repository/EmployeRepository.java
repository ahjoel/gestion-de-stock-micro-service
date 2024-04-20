package org.lerob.fourniture.repository;

import org.lerob.fourniture.model.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    boolean existsByCodeEmpIgnoreCase(String reference);

    Optional<Employe> findEmployeByCodeEmp(String nom);
}
