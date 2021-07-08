package com.mohamed.gestiondelocationdevoiture.services.impl;

import com.mohamed.gestiondelocationdevoiture.dto.Conducteurdto;
import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidEntityException;
import com.mohamed.gestiondelocationdevoiture.repository.ConducteurRepository;
import com.mohamed.gestiondelocationdevoiture.services.ConducteurService;
import com.mohamed.gestiondelocationdevoiture.validator.Conducteurvalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConducteurServiceImpl implements ConducteurService {

    private ConducteurRepository conducteurRepository;

    @Autowired
    public ConducteurServiceImpl(ConducteurRepository conducteurRepository) {
        this.conducteurRepository = conducteurRepository;
    }

    @Override
    public Conducteurdto save(Conducteurdto dto) {
        List<String> errors = Conducteurvalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("conducteur is not valid{}",dto);
            throw new InvalidEntityException("le conducteur n'est pas valide",ErrorCodes.CONDUCTEUR_NOT_VALID);
        }
        return Conducteurdto.fromEntity(conducteurRepository.save(Conducteurdto.toEntity(dto)));
    }

    @Override
    public Conducteurdto findById(Integer id) {
        if (id == null) {
            log.error("Conducteur ID is null");
            return null;
        }
        return conducteurRepository.findById(id).map(Conducteurdto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Conducteur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.CONDUCTEUR_NOT_FOUND)
        );
    }

    @Override
    public List<Conducteurdto> findAll() {
        return conducteurRepository.findAll().stream()
                .map(Conducteurdto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Conducteur id is null");
            return ;
        }
        conducteurRepository.deleteById(id);
    }

}
