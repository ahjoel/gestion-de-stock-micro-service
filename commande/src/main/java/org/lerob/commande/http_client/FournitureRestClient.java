package org.lerob.commande.http_client;

import org.lerob.commande.model.dto.CategorieDto;
import org.lerob.commande.model.dto.CommandeDto;
import org.lerob.commande.model.dto.EmployeDto;
import org.lerob.commande.model.dto.FournitureDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "FOURNITURE-SERVICE")
public interface FournitureRestClient {

    // CATEGORIES API(s) CALL
    @GetMapping("/api/categories")
    List<CategorieDto> listeCategorie();

    @PostMapping("/api/categorie/addcat")
    Long enregistrerCategorie(@RequestBody CategorieDto categorieDto);

    @GetMapping("/api/categorie/{id}")
    CategorieDto afficherCategorie(@PathVariable("id") Long id);

    @PutMapping("/api/categorie/modifiercat")
    boolean modifierCategorie(@RequestBody CategorieDto categorieDto);

    @DeleteMapping("/api/categorie/delete/{id}")
    boolean deleteCategorie(@PathVariable("id") Long id);


    // COMMANDES API(s) CALL
    @GetMapping("/api/commandes")
    List<CommandeDto> listeCommande();

    @PostMapping("/api/commande/addcom")
    CommandeDto enregistrerCommande(@RequestBody CommandeDto commandeDto);

    @GetMapping("/api/commande/{id}")
    CommandeDto afficherCommande(@PathVariable("id") Long id);

    @DeleteMapping("/api/commande/delete/{id}")
    Boolean supprimerCommande(@PathVariable("id") Long id);


    // EMPLOYES API(s) CALL
    @GetMapping("/api/employes")
    List<EmployeDto> listeEmploye();

    @PostMapping("/api/employe/addemp")
    Long enregistrerEmploye(@RequestBody EmployeDto employeDto);

    @GetMapping("/api/employe/{id}")
    EmployeDto afficherEmploye(@PathVariable("id") Long id);

    @PutMapping("/api/employe/modifieremp")
    boolean modifierEmploye(@RequestBody EmployeDto employeDto);

    @DeleteMapping("/api/employe/delete/{id}")
    boolean deleteEmploye(@PathVariable("id") Long id);


    // FOURNITURES API(s) CALL
    @GetMapping("/api/fournitures")
    List<FournitureDto> listeFourniture();

    @PostMapping("/api/fourniture/addfour")
    Long enregistrerFourniture(@RequestBody FournitureDto fournitureDto);

    @GetMapping("/api/fourniture/{id}}")
    FournitureDto afficherFourniture(@PathVariable("id") Long id);

    @PutMapping("/api/fourniture/modifierfour")
    Boolean modifierFourniture(@RequestBody FournitureDto fournitureDto);

    @DeleteMapping("/api/fourniture/delete/{id}")
    Boolean supprimerFourniture(@PathVariable("id") Long id);

}
