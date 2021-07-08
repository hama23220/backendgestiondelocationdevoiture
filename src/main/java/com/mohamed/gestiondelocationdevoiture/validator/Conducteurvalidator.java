package com.mohamed.gestiondelocationdevoiture.validator;

import com.mohamed.gestiondelocationdevoiture.dto.Conducteurdto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Conducteurvalidator {

    public static List<String> validate(Conducteurdto conducteurdto){
        List<String> errors = new ArrayList<>();
        if (conducteurdto==null){
            errors.add("veuillez renseigner le nom du conducteur");
            errors.add("veuillez renseigner le prenom du conducteur");
            errors.add("veuillez renseigner le numéro du permis");
            errors.add("veuillez renseigner le numéro du cin");
            errors.add("veuillez renseigner le date du permis");
            return errors;
        }
        if (!StringUtils.hasLength(conducteurdto.getNomc())) {
            errors.add("veuillez renseigner le nom du conducteur");
        }
        if (!StringUtils.hasLength(conducteurdto.getPrenomc())) {
            errors.add("veuillez renseigner le prenom du conducteur");
        }
        if (!StringUtils.hasLength(String.valueOf(conducteurdto.getNumpermis()))) {
            errors.add("veuillez renseigner le numero de permis du conducteur");
        }
        if (!StringUtils.hasLength(String.valueOf(conducteurdto.getNumcin()))) {
            errors.add("veuillez renseigner le numero de cin du conducteur");
        }
        if (!StringUtils.hasLength(conducteurdto.getDatepermis())) {
            errors.add("veuillez renseigner la date du permis");
        }

        return errors;
    }


}
