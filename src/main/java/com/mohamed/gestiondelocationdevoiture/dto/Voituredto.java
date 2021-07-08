package com.mohamed.gestiondelocationdevoiture.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.gestiondelocationdevoiture.model.Voiture;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class Voituredto {

    private Integer id ;

    private String nom ;

    private String nummatricule ;

    private String numchassis;

    private Double kilometrage ;

    private String couleur;

    private Integer nbplaces;

    private String dateachat;

    private String photo ;

    private Modeledto modele;


    private List<Entretiendto> entretiens;


    private List<Clientdto> clients;

    public static Voituredto fromEntity(Voiture voiture){
        if (voiture==null){
            return null ;
        }
        return Voituredto.builder()
                .id(voiture.getId())
                .nom(voiture.getNom())
                .nummatricule(voiture.getNummatricule())
                .numchassis(voiture.getNumchassis())
                .kilometrage(voiture.getKilometrage())
                .couleur(voiture.getCouleur())
                .nbplaces(voiture.getNbplaces())
                .dateachat(voiture.getDateachat())
                .photo(voiture.getPhoto())
                .build();
    }
    public static Voiture toEntity(Voituredto voituredto){
        if (voituredto==null){
            return null;
        }
        Voiture voiture = new Voiture();
        voiture.setId(voituredto.getId());
        voiture.setNom(voituredto.getNom());
        voiture.setNummatricule(voituredto.getNummatricule());
        voiture.setNumchassis(voituredto.getNumchassis());
        voiture.setKilometrage(voituredto.getKilometrage());
        voiture.setCouleur(voituredto.getCouleur());
        voiture.setNbplaces(voituredto.getNbplaces());
        voiture.setDateachat(voituredto.getDateachat());
        voiture.setPhoto(voituredto.getPhoto());
        return voiture;
    }

}
