package org.lerob.commande.service;

import org.lerob.commande.model.dto.EmployeDto;
import org.lerob.commande.model.entities.Employe;
import org.lerob.commande.repository.EmployeRepository;
import org.lerob.commande.service.mapper.EmployeMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class EmployeServiceTest {

    @Mock
    private EmployeRepository employeRepository;

    @Mock
    private EmployeMapper employeMapper;

    @InjectMocks
    private EmployeService employeService;

    private EmployeDto testEmployeDto;

    @BeforeEach
    void setUp() {
        testEmployeDto = EmployeDto.builder()
                .id(1L)
                .codeEmp("EMP001")
                .nomEmp("Doe")
                .prenomEmp("John")
                .serviceEmp("ADMINISTRATIF")
                .build();
    }

    @Test
    void ajouterEmploye() {
        when(employeRepository.existsByCodeEmpIgnoreCase(anyString())).thenReturn(false);
        when(employeMapper.toEntity(any(EmployeDto.class))).thenReturn(new Employe());
        when(employeRepository.save(any(Employe.class))).thenReturn(new Employe());

        Long id = employeService.ajouterEmploye(testEmployeDto);

        assertNotNull(id);
        verify(employeRepository, times(1)).save(any(Employe.class));
    }

    @Test
    void ajouterEmployes() {
    }

    @Test
    void getEmployeByCodeEmp() {
    }

    @Test
    void getEmployeById() {
    }

    @Test
    void modifierEmploye() {
    }

    @Test
    void supprimerEmploye() {
    }
}