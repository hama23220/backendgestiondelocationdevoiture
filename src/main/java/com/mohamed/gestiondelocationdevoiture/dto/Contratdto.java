package com.mohamed.gestiondelocationdevoiture.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.gestiondelocationdevoiture.model.Contrat;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Contratdto {

    private Integer id ;

    private Integer numcontrat;

    private Double prixht;

    private Integer tva;

    private Double acompte;

    private Double reste;

    private String modepayement;

    private ReservationClientdto reservationClient ;

    public static Contratdto fromEntity(Contrat contrat){
        if (contrat==null){
            return null ;
        }
        return Contratdto.builder()
                .id(contrat.getId())
                .numcontrat(contrat.getNumcontrat())
                .prixht(contrat.getPrixht())
                .tva(contrat.getTva())
                .acompte(contrat.getAcompte())
                .reste(contrat.getReste())
                .modepayement((contrat.getModepayement()))
                .build();
    }
    public static Contrat toEntity(Contratdto contratdto){
        if (contratdto==null){
            return null;
        }
        Contrat contrat = new Contrat();
        contrat.setId(contratdto.getId());
        contrat.setNumcontrat(contratdto.getNumcontrat());
        contrat.setPrixht(contratdto.getPrixht());
        contrat.setTva(contratdto.getTva());
        contrat.setAcompte(contratdto.getAcompte());
        contrat.setReste(contratdto.getReste());
        contrat.setModepayement(contratdto.getModepayement());
        return contrat;
    }
}
