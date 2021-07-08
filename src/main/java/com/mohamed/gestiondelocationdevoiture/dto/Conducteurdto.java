package com.mohamed.gestiondelocationdevoiture.dto;

import com.mohamed.gestiondelocationdevoiture.model.Conducteur;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Builder
@Data
public class Conducteurdto {

    private Integer id ;

    private String nomc;

    private String prenomc;

    private Integer numpermis;

    private Integer numcin;

    private String datepermis;

    private List<ReservationClientdto> reservationClients;

    public static Conducteurdto fromEntity(Conducteur conducteur){
        if (conducteur==null){
            return null ;
        }
        //mapping between client -> clientdto
        return Conducteurdto.builder()
                .id(conducteur.getId())
                .nomc(conducteur.getNomc())
                .prenomc(conducteur.getPrenomc())
                .numpermis(conducteur.getNumpermis())
                .numcin(conducteur.getNumcin())
                .datepermis(conducteur.getDatepermis())
                .build();
    }
    public static Conducteur toEntity(Conducteurdto conducteurdto){
        if (conducteurdto==null){
            return null;
        }
        Conducteur conducteur = new Conducteur();
        conducteur.setId(conducteurdto.getId());
        conducteur.setNomc(conducteurdto.getNomc());
        conducteur.setPrenomc(conducteurdto.getPrenomc());
        conducteur.setNumpermis(conducteurdto.getNumpermis());
        conducteur.setNumcin(conducteurdto.getNumcin());
        conducteur.setDatepermis(conducteurdto.getDatepermis());
        return conducteur;
    }
}
