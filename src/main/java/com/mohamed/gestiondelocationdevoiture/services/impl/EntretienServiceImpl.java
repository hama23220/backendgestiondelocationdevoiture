package com.mohamed.gestiondelocationdevoiture.services.impl;

import com.mohamed.gestiondelocationdevoiture.dto.Entretiendto;
import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidEntityException;
import com.mohamed.gestiondelocationdevoiture.repository.EntretienRepository;
import com.mohamed.gestiondelocationdevoiture.services.EntretienService;
import com.mohamed.gestiondelocationdevoiture.validator.Entretienvalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntretienServiceImpl implements EntretienService {

    private EntretienRepository entretienRepository;

    @Autowired
    public EntretienServiceImpl(EntretienRepository entretienRepository) {
        this.entretienRepository = entretienRepository;
    }

    @Override
    public Entretiendto save(Entretiendto dto) {
        List<String> errors = Entretienvalidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("entretien is not valid{}",dto);
            throw new InvalidEntityException("le contrat n'est pas valide", ErrorCodes.ENTRETIEN_NOT_VALID);
        }
        return Entretiendto.fromEntity(entretienRepository.save(Entretiendto.toEntity(dto)));
    }

    @Override
    public Entretiendto findById(Integer id) {

        if (id == null) {
            log.error("entretien ID is null");
            return null;
        }
        return entretienRepository.findById(id).map(Entretiendto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun entretien avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.ENTRETIEN_NOT_FOUND)
        );
    }

    @Override
    public List<Entretiendto> findAll() {

        return entretienRepository.findAll().stream()
                .map(Entretiendto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        entretienRepository.deleteById(id);
    }
}
