package com.mohamed.gestiondelocationdevoiture.validator;

import com.mohamed.gestiondelocationdevoiture.dto.Adressedto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Adressevalidator {

    public static List<String> validate(Adressedto adressedto){
        List<String> errors = new ArrayList<>();
        if (adressedto == null){
            errors.add("veuillez renseigner l'adresse1");
            errors.add("veuillez renseigner la ville");
            errors.add("veuillez renseigner le pays");
            errors.add("veuillez renseigner le code postale");
            return errors ;
        }
        if (!StringUtils.hasLength(adressedto.getAdresse1())){
            errors.add("veuillez renseigner l'adresse1");
        }
        if (!StringUtils.hasLength(adressedto.getVille())){
            errors.add("veuillez renseigner la ville");
        }
        if (!StringUtils.hasLength(adressedto.getPays())){
            errors.add("veuillez renseigner le pays");
        }
        if (!StringUtils.hasLength(adressedto.getCodepostale())){
            errors.add("veuillez renseigner le code postale");
        }
        return errors;
    }

}
