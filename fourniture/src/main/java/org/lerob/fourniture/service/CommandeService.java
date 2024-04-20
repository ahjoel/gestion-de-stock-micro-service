package org.lerob.fourniture.service;

import org.lerob.fourniture.model.dto.CommandeDto;
import org.lerob.fourniture.model.entities.Commande;
import org.lerob.fourniture.repository.CommandeRepository;
import org.lerob.fourniture.service.mapper.CommandeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Autowired
    CommandeMapper commandeMapper;

    public List<CommandeDto> listCommandes(){
        return commandeRepository.findAll().stream().sorted(Comparator.comparingLong(Commande::getId).reversed()).map(commandeMapper::toDto).collect(Collectors.toList());
    }

    public CommandeDto ajouterCommande(CommandeDto commandeDto){
        checkCodeComAlreadyUsed(commandeDto);
        Commande commande = commandeRepository.save(commandeMapper.toEntity(commandeDto));
        return commandeMapper.toDto(commande);
    }

    private void checkCodeComAlreadyUsed(CommandeDto commandeDto) {
        if (commandeRepository.existsByCodeComIgnoreCase(commandeDto.getCodeCom())){
            throw new RuntimeException("Code 5268 : Il existe déjà une commande avec ce code");
        }
    }

    public CommandeDto getCommandeById(CommandeDto commandeDto) {
        Commande commande = commandeMapper.toEntity(commandeDto);

        Commande commmandeFound = commandeRepository.findById(commande.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id introuvable dans la base"));

        return commandeMapper.toDto(commmandeFound);
    }

    public boolean supprimerCommande(Long id){
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : la commande que vous voulez supprimer n'existe pas"));

        commandeRepository.deleteById(commande.getId());

        return true;
    }
}
