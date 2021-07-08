package com.mohamed.gestiondelocationdevoiture.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerMotDePasseClientDto {

    private Integer id;

    private String motdepasse;

    private String confirmMotDePasse;
}
