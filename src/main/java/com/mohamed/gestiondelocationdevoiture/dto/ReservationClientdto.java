package com.mohamed.gestiondelocationdevoiture.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.gestiondelocationdevoiture.model.ReservationClient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationClientdto {

    private Integer id ;

    private Integer numres;

    private String datedebut;

    private String datefin;

    private String heuredebut;

    private String heurefin;

    private String lieu;

    private Conducteurdto conducteur;

    private Contratdto contrat ;


    public static ReservationClientdto fromEntity(ReservationClient reservationClient){
        if (reservationClient==null){
            return null ;
        }
        return ReservationClientdto.builder()
                .id(reservationClient.getId())
                .numres(reservationClient.getNumres())
                .datedebut(reservationClient.getDatedebut())
                .datefin(reservationClient.getDatefin())
                .heuredebut(reservationClient.getHeuredebut())
                .heurefin(reservationClient.getHeurefin())
                .lieu(reservationClient.getLieu())
                .build();
    }
    public static ReservationClient toEntity(ReservationClientdto reservationClientdto){
        if (reservationClientdto==null){
            return null;
        }
        ReservationClient reservationClient = new ReservationClient();
        reservationClient.setId(reservationClientdto.getId());
        reservationClient.setNumres(reservationClientdto.getNumres());
        reservationClient.setDatedebut(reservationClientdto.getDatedebut());
        reservationClient.setDatefin(reservationClientdto.getDatefin());
        reservationClient.setHeuredebut(reservationClientdto.getHeuredebut());
        reservationClient.setHeurefin(reservationClientdto.getHeurefin());
        reservationClient.setLieu(reservationClientdto.getLieu());
        return reservationClient;
    }
}
