package org.lerob.fourniture.rest.ressource;

import org.lerob.fourniture.model.dto.FournitureDto;
import org.lerob.fourniture.service.FournitureService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FournitureControllerTest {

    @InjectMocks
    private FournitureController fournitureController;

    @Mock
    private FournitureService fournitureService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void ListeFourniture() {
        // Données de test
        FournitureDto fourniture1 = FournitureDto.builder().codeFour("Fourniture 1").build();
        FournitureDto fourniture2 = FournitureDto.builder().codeFour("Fourniture 2").build();

        List<FournitureDto> fournitureList = Arrays.asList(fourniture1, fourniture2);

        // Configuration du comportement du service mock
        when(fournitureService.listFournitures()).thenReturn(fournitureList);

        // Appel de la méthode du contrôleur
        List<FournitureDto> result = fournitureController.listeFourniture();

        // Vérification du résultat
        assertEquals(fournitureList, result);
    }
}