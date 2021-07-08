package com.mohamed.gestiondelocationdevoiture.services.impl;

import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import com.mohamed.gestiondelocationdevoiture.dto.ReservationClientdto;
import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidEntityException;
import com.mohamed.gestiondelocationdevoiture.repository.ReservationRepository;
import com.mohamed.gestiondelocationdevoiture.services.ReservationService;
import com.mohamed.gestiondelocationdevoiture.validator.Modelevalidator;
import com.mohamed.gestiondelocationdevoiture.validator.ReservationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReservationServiceImpl implements ReservationService {

    public ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public ReservationClientdto save(ReservationClientdto dto) {
        List<String> errors = ReservationValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("reservation is not valid{}",dto);
            throw new InvalidEntityException("reservation n'est pas valide", ErrorCodes.MODELE_NOT_VALID);
        }
        return ReservationClientdto.fromEntity(reservationRepository.save(ReservationClientdto.toEntity(dto)));
    }

    @Override
    public ReservationClientdto findById(Integer id) {
        if (id == null) {
            log.error("reservation ID is null");
            return null;
        }
        return reservationRepository.findById(id).map(ReservationClientdto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune reservation avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.RESERVATIONCLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ReservationClientdto> findAll() {
        return reservationRepository.findAll().stream()
                .map(ReservationClientdto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        reservationRepository.deleteById(id);
    }
}
