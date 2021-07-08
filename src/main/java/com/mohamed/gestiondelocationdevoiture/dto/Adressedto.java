package com.mohamed.gestiondelocationdevoiture.dto;

import com.mohamed.gestiondelocationdevoiture.model.Adresse;
import com.mohamed.gestiondelocationdevoiture.model.Client;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;


@Data
@Builder
public class Adressedto {

    private  String adresse1;

    private String adresse2;

    private String ville;

    private String codepostale;

    private String pays;

    public static Adressedto fromEntity(Adresse adresse){
        if (adresse==null){
            return null ;
        }
        return Adressedto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .ville(adresse.getVille())
                .codepostale(adresse.getCodepostale())
                .pays(adresse.getPays())
                .build();
    }
    public static Adresse toEntity(Adressedto adressedto){
        if (adressedto==null){
            return null;
        }
        Adresse adresse= new Adresse();
        adresse.setAdresse1(adressedto.getAdresse1());
        adresse.setAdresse2(adressedto.getAdresse2());
        adresse.setVille(adressedto.getVille());
        adresse.setCodepostale(adressedto.getCodepostale());
        adresse.setPays(adressedto.getPays());
        return adresse;
    }
}
