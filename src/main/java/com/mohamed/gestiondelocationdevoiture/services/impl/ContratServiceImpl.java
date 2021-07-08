package com.mohamed.gestiondelocationdevoiture.services.impl;

import com.mohamed.gestiondelocationdevoiture.dto.Contratdto;
import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidEntityException;
import com.mohamed.gestiondelocationdevoiture.repository.ContratRepository;
import com.mohamed.gestiondelocationdevoiture.services.ContratService;
import com.mohamed.gestiondelocationdevoiture.validator.Contratvalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ContratServiceImpl implements ContratService {

    private ContratRepository contratRepository;

    @Autowired
    public ContratServiceImpl(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public Contratdto save(Contratdto dto) {
        List<String> errors = Contratvalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("contrat is not valid{}",dto);
            throw new InvalidEntityException("le contrat n'est pas valide", ErrorCodes.CONTRAT_NOT_VALID);
        }
        return Contratdto.fromEntity(contratRepository.save(Contratdto.toEntity(dto)));
    }

    @Override
    public Contratdto findById(Integer id) {
        if (id == null) {
            log.error("CONTRAT ID is null");
            return null;
        }
        return contratRepository.findById(id).map(Contratdto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun contrat avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CONDUCTEUR_NOT_FOUND)
        );
    }

    @Override
    public List<Contratdto> findAll() {
        return contratRepository.findAll().stream()
                .map(Contratdto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id==null){
            log.error("Contrat id is null");
            return ;
        }
        contratRepository.deleteById(id);
    }
}
