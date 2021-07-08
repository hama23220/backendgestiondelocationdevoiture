package com.mohamed.gestiondelocationdevoiture.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse {
    @Column(name = "adresse1")
    private  String adresse1;

    @Column(name = "adresse2")
    private String adresse2;

    @Column(name = "ville")
    private String ville;

    @Column(name = "codepostale")
    private String codepostale;

    @Column(name = "pays")
    private String pays;
}
