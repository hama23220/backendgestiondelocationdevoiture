package com.mohamed.gestiondelocationdevoiture.validator;

import com.mohamed.gestiondelocationdevoiture.dto.Voituredto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Voiturevalidator {
    public static List<String> validate(Voituredto voituredto){
        List<String> errors = new ArrayList<>();
        if (voituredto==null){
            errors.add("veuillez saisir le numero d'immatricualtion");
            errors.add("veuillez saisir le numero de chassis");
            errors.add("veuillez saisir le kilométrage");
            errors.add("veuillez saisir le couleur");
            errors.add("veuillez saisir le nombre de place");
            errors.add("veuillez saisir la date d'achats");
            errors.add("veuillez sélectionner un modele");
            return errors;

        }
        if (!StringUtils.hasLength(voituredto.getNummatricule())) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(voituredto.getNumchassis())) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(String.valueOf(voituredto.getKilometrage()))) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(String.valueOf(voituredto.getNbplaces()))) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasLength(voituredto.getDateachat())) {
            errors.add("Veuillez renseigner le nom du client");
        }
        if (voituredto.getModele()==null){
            errors.add("veuillez sélectionner un modele");
        }
        return errors;
    }
}
