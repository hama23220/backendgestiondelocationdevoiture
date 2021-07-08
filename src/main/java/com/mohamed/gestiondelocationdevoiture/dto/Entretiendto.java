package com.mohamed.gestiondelocationdevoiture.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.gestiondelocationdevoiture.model.Entretien;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Entretiendto {

    private Integer id ;

    private Integer type;

    private String dateentretien;

    private Double kiloprevu;

    private Double prix;

    private Voituredto voiture;

    public static Entretiendto fromEntity(Entretien entretien){
        if (entretien==null){
            return null ;
        }
        return Entretiendto.builder()
                .id(entretien.getId())
                .type(entretien.getType())
                .dateentretien(entretien.getDateentretien())
                .kiloprevu(entretien.getKiloprevu())
                .prix(entretien.getPrix())
                .build();
    }
    public static Entretien toEntity(Entretiendto entretiendto){
        if (entretiendto==null){
            return null;
        }
        Entretien entretien = new Entretien();
        entretien.setId(entretiendto.getId());
        entretien.setType(entretiendto.getType());
        entretien.setDateentretien(entretiendto.getDateentretien());
        entretien.setKiloprevu(entretiendto.getKiloprevu());
        entretien.setPrix(entretiendto.getPrix());

        return entretien;
    }
}
