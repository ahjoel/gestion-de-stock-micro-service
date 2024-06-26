package org.lerob.commande.service;

import org.lerob.commande.model.dto.LivraisonDto;
import org.lerob.commande.model.entities.Livraison;
import org.lerob.commande.repository.LivraisonRepository;
import org.lerob.commande.service.mapper.LivraisonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivraisonService {
    @Autowired
    LivraisonRepository livraisonRepository;

    @Autowired
    LivraisonMapper livraisonMapper;

    public List<LivraisonDto> listLivraisons(){
        return livraisonRepository.findAll().stream().sorted(Comparator.comparingLong(Livraison::getId).reversed()).map(livraisonMapper::toDto).collect(Collectors.toList());
    }

    public LivraisonDto ajouterLivraison(LivraisonDto livraisonDto){
        checkCodeLivAlreadyUsed(livraisonDto);
        Livraison livraison = livraisonRepository.save(livraisonMapper.toEntity(livraisonDto));
        return livraisonMapper.toDto(livraison);
    }

    private void checkCodeLivAlreadyUsed(LivraisonDto livraisonDto) {
        if (livraisonRepository.existsBycodeLivIgnoreCase(livraisonDto.getCodeLiv())){
            throw new RuntimeException("Code 5268 : Il existe déjà une livraison avec ce code");
        }
    }

    public LivraisonDto getLivraisonById(LivraisonDto livraisonDto) {
        Livraison livraison = livraisonMapper.toEntity(livraisonDto);

        Livraison livraisonFound = livraisonRepository.findById(livraison.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id introuvable dans la base"));

        return livraisonMapper.toDto(livraisonFound);
    }

    public boolean supprimerLivraison(Long id){
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : la livraison que vous voulez supprimer n'existe pas"));

        livraisonRepository.deleteById(livraison.getId());

        return true;
    }
}
