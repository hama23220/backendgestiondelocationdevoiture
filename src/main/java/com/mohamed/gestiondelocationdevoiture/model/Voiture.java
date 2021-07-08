package com.mohamed.gestiondelocationdevoiture.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Voiture")
public class Voiture extends AbstractEntity{

    @Column(name = "nummatricule")
    private String nummatricule ;

    @Column(name = "nom")
    private String nom;

    @Column(name = "numchassis")
    private String numchassis;

    @Column(name = "kilometrage")
    private Double kilometrage ;

    @Column(name = "couleur")
    private String couleur;

    @Column(name = "nbplaces")
    private Integer nbplaces;

    @Column(name = "dateachat")
    private String dateachat;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idmodele")
    private Modele modele;

    @OneToMany(mappedBy = "voiture")
    private List<Entretien> entretiens;

   @OneToMany(mappedBy = "voiture")
    private List<Client> clients;
}
