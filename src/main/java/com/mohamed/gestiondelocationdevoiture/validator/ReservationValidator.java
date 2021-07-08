package com.mohamed.gestiondelocationdevoiture.validator;

import com.mohamed.gestiondelocationdevoiture.dto.ReservationClientdto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ReservationValidator {
    public static List<String> validate(ReservationClientdto reservationClientdto){
        List<String> errors = new ArrayList<>();
        if (reservationClientdto==null){
            errors.add("Veuillez renseigner le numero de réservation");
            errors.add("Veuillez renseigner la date de début");
            errors.add("Veuillez renseigner la date fin");
            errors.add("Veuillez renseigner l'heure de début");
            errors.add("Veuillez renseigner l'heure de fin");
            errors.add("Veuillez renseigner le lieu");
        return errors ;
        }

        if (!StringUtils.hasLength(String.valueOf(reservationClientdto.getNumres()))) {
            errors.add("Veuillez renseigner le numero de réservation");
        }
        if (!StringUtils.hasLength(reservationClientdto.getDatedebut())) {
            errors.add("Veuillez renseigner la date de début");
        }
        if (!StringUtils.hasLength(reservationClientdto.getDatefin())) {
            errors.add("Veuillez renseigner la date fin");
        }
        if (!StringUtils.hasLength(reservationClientdto.getHeuredebut())) {
            errors.add("Veuillez renseigner l'heure de début");
        }
        if (!StringUtils.hasLength(reservationClientdto.getHeurefin())) {
            errors.add("Veuillez renseigner l'heure de fin");
        }
        if (!StringUtils.hasLength(reservationClientdto.getLieu())) {
            errors.add("Veuillez renseigner le lieu");
        }

        return errors;
    }
}
