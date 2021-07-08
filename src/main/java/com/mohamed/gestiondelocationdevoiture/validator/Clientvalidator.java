package com.mohamed.gestiondelocationdevoiture.validator;

import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Clientvalidator {

    public static List<String> validate(Clientdto clientdto){
        List<String> errors = new ArrayList<>();
        if (clientdto==null){
            errors.add("veuillez renseigner votre nom");
            errors.add("veuillez renseigner votre prenom");
            errors.add("veuillez renseigner votre login");
            errors.add("veuillez renseigner votre password");
            errors.add("veuillez renseigner votre numero");
            errors.addAll(Adressevalidator.validate(null));
            return errors;
        }
        if (!StringUtils.hasLength(clientdto.getNom())) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(clientdto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom du client");
        }
        if (!StringUtils.hasLength(clientdto.getLogin())) {
            errors.add("Veuillez renseigner le login du client");
        }
        if (!StringUtils.hasLength(clientdto.getPassword())) {
            errors.add("Veuillez renseigner le mot de passe du client");
        }
        if (!StringUtils.hasLength(String.valueOf(clientdto.getNum()))) {
            errors.add("Veuillez renseigner le nom du client");
        }
        errors.addAll(Adressevalidator.validate(clientdto.getAdresse()));
        return errors;

    }

}
