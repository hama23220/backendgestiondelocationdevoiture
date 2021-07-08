package com.mohamed.gestiondelocationdevoiture.services.impl;

import com.mohamed.gestiondelocationdevoiture.dto.Voituredto;
import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidEntityException;
import com.mohamed.gestiondelocationdevoiture.repository.VoitureRepository;
import com.mohamed.gestiondelocationdevoiture.services.VoitureService;
import com.mohamed.gestiondelocationdevoiture.validator.Voiturevalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VoitureServiceImpl implements VoitureService {

    private VoitureRepository voitureRepository;

    @Autowired
    public VoitureServiceImpl(VoitureRepository voitureRepository) {

        this.voitureRepository = voitureRepository;
    }

    @Override
    public Voituredto save(Voituredto dto) {
        List<String> errors = Voiturevalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("voiture is not valid{}",dto);
            throw new InvalidEntityException("voiture n'est pas valide", ErrorCodes.VOITURE_NOT_VALID);
        }
        return Voituredto.fromEntity(voitureRepository.save(Voituredto.toEntity(dto)));
    }

    @Override
    public Voituredto findById(Integer id) {
        if (id == null) {
            log.error("voiture ID is null");
            return null;
        }
        return voitureRepository.findById(id).map(Voituredto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune voiture avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.VOITURE_NOT_FOUND)
        );
    }
    @Override
    public Voituredto findVoitureByNummatricule(String NumMatricule){
        if (!StringUtils.hasLength(NumMatricule)) {
            log.error("numero immatriculation voiture is null");
            return null;
        }
        return voitureRepository.findVoitureByNummatricule(NumMatricule).map(Voituredto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune voiture avec le num immatricule = " + NumMatricule + " n' ete trouve dans la BDD",
                        ErrorCodes.VOITURE_NOT_FOUND)
        );
    }

    @Override
    public List<Voituredto> findAll() {
        return voitureRepository.findAll().stream()
                .map(Voituredto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        voitureRepository.deleteById(id);
    }
}
