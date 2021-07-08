package com.mohamed.gestiondelocationdevoiture.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.gestiondelocationdevoiture.model.Modele;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Modeledto {

    private Integer id ;

    private String marque;

    private String nomm;

    private String carburant;

    private Integer puissance;
    @JsonIgnore
    private List<Voituredto> voitures;

    public static Modeledto fromEntity(Modele modele){
        if (modele==null){
            return null ;
        }
        return Modeledto.builder()
                .id(modele.getId())
                .marque(modele.getMarque())
                .nomm(modele.getNomm())
                .carburant(modele.getCarburant())
                .puissance(modele.getPuissance())
                .build();
    }
    public static Modele toEntity(Modeledto modeledtodto){
        if (modeledtodto==null){
            return null;
        }
        Modele modele = new Modele();
        modele.setId(modeledtodto.getId());
        modele.setMarque(modeledtodto.getMarque());
        modele.setNomm(modeledtodto.getNomm());
        modele.setCarburant(modeledtodto.getCarburant());
        modele.setPuissance(modeledtodto.getPuissance());
        return modele;
    }
}
