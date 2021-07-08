package com.mohamed.gestiondelocationdevoiture.validator;

import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Modelevalidator {
    public static List<String> validate(Modeledto modeledto){
        List<String> errors = new ArrayList<>();
        if (modeledto ==null ||!StringUtils.hasLength(modeledto.getMarque())){
            errors.add("veuillez renseigner le modele de voiture");
        }
        return errors;
    }
}
