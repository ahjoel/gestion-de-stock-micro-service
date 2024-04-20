package org.lerob.commande.service;

import org.lerob.commande.model.dto.LigneLivraisonDto;
import org.lerob.commande.model.entities.LigneCommande;
import org.lerob.commande.model.entities.LigneLivraison;
import org.lerob.commande.service.mapper.LigneLivraisonMapper;
import org.lerob.commande.model.entities.Fourniture;
import org.lerob.commande.model.entities.Livraison;
import org.lerob.commande.repository.FournitureRepository;
import org.lerob.commande.repository.LigneCommandeRepository;
import org.lerob.commande.repository.LigneLivraisonRepository;
import org.lerob.commande.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LigneLivraisonService {
    @Autowired
    LigneLivraisonRepository ligneLivraisonRepository;

    @Autowired
    FournitureRepository fournitureRepository;

    @Autowired
    LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    LivraisonRepository livraisonRepository;

    @Autowired
    LigneLivraisonMapper ligneLivraisonMapper;

    public List<LigneLivraisonDto> listLigneLivraisons(){
        return ligneLivraisonRepository.findAll().stream().sorted(Comparator.comparingLong(
            LigneLivraison::getId).reversed()).map(ligneLivraisonMapper::toDto).collect(Collectors.toList());
    }

    public Long ajouterLigneLivraison(LigneLivraisonDto ligneLivraisonDto){
        //checkCodeComAlreadyUsed(commandeDto);
        return ligneLivraisonRepository.save(ligneLivraisonMapper.toEntity(ligneLivraisonDto)).getId();
    }

    public LigneLivraisonDto getLigneLivraisonById(LigneLivraisonDto ligneLivraisonDto) {
        LigneLivraison ligneLivraison = ligneLivraisonMapper.toEntity(ligneLivraisonDto);

        LigneLivraison ligneLivraisonFound = ligneLivraisonRepository.findById(ligneLivraison.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id de la ligne livraison n'existe pas"));

        return ligneLivraisonMapper.toDto(ligneLivraisonFound);
    }

    public boolean modifierLigneLivraison(LigneLivraisonDto ligneLivraisonDto){
        LigneLivraison ligneLivraison = ligneLivraisonMapper.toEntity(ligneLivraisonDto);

        LigneLivraison ligneLivraisonFound = ligneLivraisonRepository.findById(ligneLivraison.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : la ligne livraison que vous voulez modifier n'existe pas"));

        // Récupération de la Ligne commande associée à partir de la base de données
        LigneCommande
            ligneCommande = ligneCommandeRepository.findById(ligneLivraison.getLignecommande().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Ligne commande introuvable"));

        // Récupération de la fourniture associée à partir de la base de données
        Fourniture fourniture = fournitureRepository.findById(ligneLivraison.getFourniture().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Fourniture introuvable"));

        // Récupération de la livraison associée à partir de la base de données
        Livraison livraison = livraisonRepository.findById(ligneLivraison.getLivraison().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Livraison introuvable"));

        ligneLivraisonMapper.copy(ligneLivraisonDto, ligneLivraisonFound);

        ligneLivraisonRepository.save(ligneLivraisonFound);

        return true;
    }

    public boolean supprimerLigneLivraison(Long id){
        LigneLivraison ligneLivraison = ligneLivraisonRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : la ligne livraison que vous voulez supprimer n'existe pas"));

        ligneLivraisonRepository.deleteById(ligneLivraison.getId());

        return true;
    }
}
