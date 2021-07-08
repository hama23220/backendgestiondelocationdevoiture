package com.mohamed.gestiondelocationdevoiture.validator;

import com.mohamed.gestiondelocationdevoiture.dto.Contratdto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Contratvalidator {
    public static List<String> validate(Contratdto contratdto){
        List<String> errors = new ArrayList<>();
        if (contratdto==null){
            errors.add("veuillez renseigner le numero du contrat");
            errors.add("veuillez renseigner le prixht");
            errors.add("veuillez renseigner le Tva");
            errors.add("veuillez renseigner le acompte");
            errors.add("veuillez renseigner le reste");
            errors.add("veuillez renseigner le mode de payement");
            return errors;
        }
        if (!StringUtils.hasLength(String.valueOf(contratdto.getNumcontrat()))) {
            errors.add("veuillez renseigner le numero du contrat");
        }
        if (!StringUtils.hasLength(String.valueOf(contratdto.getPrixht()))) {
            errors.add("veuillez renseigner le prixht");
        }
        if (!StringUtils.hasLength(String.valueOf(contratdto.getTva()))) {
            errors.add("veuillez renseigner le Tva");
        }
        if (!StringUtils.hasLength(String.valueOf(contratdto.getAcompte()))) {
            errors.add("veuillez renseigner le acompte");
        }
        if (!StringUtils.hasLength(String.valueOf(contratdto.getReste()))) {
            errors.add("veuillez renseigner le reste");
        }
        if (!StringUtils.hasLength(contratdto.getModepayement())) {
            errors.add("veuillez renseigner le mode de payement");
        }
        return errors;
    }
}
