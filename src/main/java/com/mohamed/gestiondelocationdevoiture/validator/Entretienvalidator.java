package com.mohamed.gestiondelocationdevoiture.validator;

import com.mohamed.gestiondelocationdevoiture.dto.Entretiendto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Entretienvalidator {
    public static List<String> validate(Entretiendto entretiendto){
        List<String> errors = new ArrayList<>();
        if(entretiendto ==null){
            errors.add("Veuillez renseigner le type d'entretien");
            errors.add("Veuillez renseigner la date d'entretien");
            errors.add("Veuillez renseigner le kilométrage prévu");
            errors.add("Veuillez renseigner le prix");
        }
        if (!StringUtils.hasLength(String.valueOf(entretiendto.getType()))) {
            errors.add("Veuillez renseigner le type d'entretien");
        }
        if (!StringUtils.hasLength(String.valueOf(entretiendto.getDateentretien()))) {
            errors.add("Veuillez renseigner la date d'entretien");
        }
        if (!StringUtils.hasLength(String.valueOf(entretiendto.getKiloprevu()))) {
            errors.add("Veuillez renseigner le kilométrage prévu");
        }
        if (!StringUtils.hasLength(String.valueOf(entretiendto.getPrix()))) {
            errors.add("Veuillez renseigner le prix");
        }
        return errors;
    }
}
