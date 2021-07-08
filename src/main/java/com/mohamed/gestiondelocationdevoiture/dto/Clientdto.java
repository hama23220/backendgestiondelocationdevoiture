package com.mohamed.gestiondelocationdevoiture.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mohamed.gestiondelocationdevoiture.model.Client;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Clientdto {

    private Integer id ;

    private String nom ;

    private String prenom;

    private Adressedto adresse;

    private String login ;

    private String password;

    private String photo;

    private Integer num ;

    private Voituredto voiture;

    public static Clientdto fromEntity(Client client){
        if (client==null){
            return null ;
        }
        //mapping between client -> clientdto
        return Clientdto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .num(client.getNum())
                .photo(client.getPhoto())
                .adresse(Adressedto.fromEntity(client.getAdresse()))
                .build();
    }
    public static Client toEntity(Clientdto clientdto){
        if (clientdto==null){
            return null;
        }
       Client client = new Client();
        client.setId(clientdto.getId());
        client.setNom(clientdto.getNom());
        client.setPrenom(clientdto.getPrenom());
        client.setNum(clientdto.getNum());
        client.setPhoto(clientdto.getPhoto());
        client.setAdresse(Adressedto.toEntity(clientdto.getAdresse()));
        return client;
    }

}
