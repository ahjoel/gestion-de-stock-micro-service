package org.lerob.commande.service;

import org.lerob.commande.model.dto.SortieDto;
import org.lerob.commande.model.entities.Employe;
import org.lerob.commande.model.entities.Fourniture;
import org.lerob.commande.model.entities.Sortie;
import org.lerob.commande.repository.EmployeRepository;
import org.lerob.commande.repository.FournitureRepository;
import org.lerob.commande.repository.SortieRepository;
import org.lerob.commande.service.mapper.SortieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortieService {

    @Autowired
    SortieRepository sortieRepository;

    @Autowired
    FournitureRepository fournitureRepository;

    @Autowired
    EmployeRepository employeRepository;

    @Autowired
    SortieMapper sortieMapper;

    public List<SortieDto> listSorties(){
        return sortieRepository.findAll().stream().sorted(Comparator.comparingLong(Sortie::getId).reversed()).map(sortieMapper::toDto).collect(Collectors.toList());
    }

    public Long ajouterSortie(SortieDto sortieDto){
        checkCodeSortAlreadyUsed(sortieDto);
        return sortieRepository.save(sortieMapper.toEntity(sortieDto)).getId();
    }

    private void checkCodeSortAlreadyUsed(SortieDto sortieDto) {
        if (sortieRepository.existsByCodeSortIgnoreCase(sortieDto.getCodeSort())){
            throw new RuntimeException("Code 5268 : Il existe déjà une sortie avec ce code");
        }
    }

    public SortieDto getSortieByCodeSort(SortieDto sortieDto) {
        Sortie sortie = sortieMapper.toEntity(sortieDto);

        Sortie sortieFound = sortieRepository.findSortieByCodeSort(sortie.getCodeSort())
                .orElseThrow(() -> new RuntimeException("Code 257 : le code sortie envoye n'existe pas"));

        return sortieMapper.toDto(sortieFound);
    }

    public SortieDto getSortieById(SortieDto sortieDto) {
        Sortie sortie = sortieMapper.toEntity(sortieDto);

        Sortie sortieFound = sortieRepository.findById(sortie.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : l'id de la sortie n'existe pas"));

        return sortieMapper.toDto(sortieFound);
    }

    public boolean modifierSortie(SortieDto sortieDto){
        Sortie sortie = sortieMapper.toEntity(sortieDto);

        Sortie sortieFound = sortieRepository.findById(sortie.getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : la sortie que vous voulez modifier n'existe pas"));

        // Récupération de la fourniture associée à partir de la base de données
        Fourniture fourniture = fournitureRepository.findById(sortieDto.getFourniture().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Fourniture introuvable"));

        // Récupération de l'employe associée à partir de la base de données
        Employe employe = employeRepository.findById(sortieDto.getEmploye().getId())
                .orElseThrow(() -> new RuntimeException("Code 257 : Employe introuvable"));

        sortieMapper.copy(sortieDto, sortieFound);

        sortieRepository.save(sortieFound);

        return true;
    }

    public boolean supprimerSortie(Long id){
        Sortie sortie = sortieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Code 256 : la sortie que vous voulez supprimer n'existe pas"));

        sortieRepository.deleteById(sortie.getId());

        return true;
    }
}
