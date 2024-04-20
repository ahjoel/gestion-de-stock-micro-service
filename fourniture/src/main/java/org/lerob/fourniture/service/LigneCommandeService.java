package org.lerob.fourniture.service;

import org.lerob.fourniture.model.dto.LigneCommandeDto;
import org.lerob.fourniture.model.entities.Commande;
import org.lerob.fourniture.model.entities.Fourniture;
import org.lerob.fourniture.model.entities.LigneCommande;
import org.lerob.fourniture.repository.CommandeRepository;
import org.lerob.fourniture.repository.FournitureRepository;
import org.lerob.fourniture.repository.LigneCommandeRepository;
import org.lerob.fourniture.service.mapper.LigneCommandeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LigneCommandeService {
    @Autowired
    LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    FournitureRepository fournitureRepository;

    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    LigneCommandeMapper ligneCommandeMapper;

    public List<LigneCommandeDto> listLigneCommandes(){
        return ligneCommandeRepository.findAll().stream().sorted(Comparator.comparingLong(LigneCommande::getId).reversed()).map(ligneCommandeMapper::toDto).collect(Collectors.toList());
    }

    public List<LigneCommandeDto> trierLigneCommandeParFournitureNonLivre() {
        return ligneCommandeRepository.trierLigneCommandeParFournitureNonLivre().stream().map(ligneCommandeMapper::toDto).collect(Collectors.toList());
    }

    public Long ajouterLigneCommande(LigneCommandeDto ligneCommandeDto){
        //checkCodeComAlreadyUsed(commandeDto);
        return ligneCommandeRepository.save(ligneCommandeMapper.toEntity(ligneCommandeDto)).getId();
    }

    public LigneCommandeDto getLigneCommandeById(LigneCommandeDto ligneCommandeDto) {
        LigneCommande ligneCommande = ligneCommandeMapper.toEntity(ligneCommandeDto);

        LigneCommande ligneCommandeFound = ligneCommandeRepository.findById(ligneCommande.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id de la ligne commande n'existe pas"));

        return ligneCommandeMapper.toDto(ligneCommandeFound);
    }

    public boolean modifierLigneCommande(LigneCommandeDto ligneCommandeDto){
        LigneCommande ligneCommande = ligneCommandeMapper.toEntity(ligneCommandeDto);

        LigneCommande ligneCommandeFound = ligneCommandeRepository.findById(ligneCommande.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : la ligne commande que vous voulez modifier n'existe pas"));

        // Récupération de la fourniture associée à partir de la base de données
        Fourniture fourniture = fournitureRepository.findById(ligneCommande.getFourniture().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Fourniture introuvable"));

        // Récupération de la commande associée à partir de la base de données
        Commande commande = commandeRepository.findById(ligneCommande.getCommande().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Commande introuvable"));

        ligneCommandeMapper.copy(ligneCommandeDto, ligneCommandeFound);

        ligneCommandeRepository.save(ligneCommandeFound);

        return true;
    }

    public boolean supprimerLigneCommande(Long id){
        LigneCommande ligneCommande = ligneCommandeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : la ligne commande que vous voulez supprimer n'existe pas"));

        ligneCommandeRepository.deleteById(ligneCommande.getId());

        return true;
    }

    public void markAsLivree(Long id) {
        ligneCommandeRepository.updateEtatToLivreeById(id);
    }
}
