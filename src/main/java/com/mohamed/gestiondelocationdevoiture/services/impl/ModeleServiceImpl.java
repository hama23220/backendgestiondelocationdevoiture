package com.mohamed.gestiondelocationdevoiture.services.impl;

import com.mohamed.gestiondelocationdevoiture.dto.Entretiendto;
import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidEntityException;
import com.mohamed.gestiondelocationdevoiture.repository.ModeleRepository;
import com.mohamed.gestiondelocationdevoiture.services.ModeleService;
import com.mohamed.gestiondelocationdevoiture.validator.Modelevalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ModeleServiceImpl implements ModeleService {

    private ModeleRepository modeleRepository;

    @Autowired
    public ModeleServiceImpl(ModeleRepository modeleRepository) {

        this.modeleRepository = modeleRepository;
    }

    @Override
    public Modeledto save(Modeledto dto) {
        List<String> errors = Modelevalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("modele is not valid{}",dto);
            throw new InvalidEntityException("le modele n'est pas valide", ErrorCodes.MODELE_NOT_VALID);
        }
        return Modeledto.fromEntity(modeleRepository.save(Modeledto.toEntity(dto)));
    }

    @Override
    public Modeledto findById(Integer id) {
        if (id == null) {
            log.error("modele ID is null");
            return null;
        }
        return modeleRepository.findById(id).map(Modeledto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun modele avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.MODELE_NOT_FOUND)
        );
    }

    @Override
    public List<Modeledto> findAll() {
        return modeleRepository.findAll().stream()
                .map(Modeledto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        modeleRepository.deleteById(id);
    }
}
