package com.mohamed.gestiondelocationdevoiture.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Modele")
public class Modele extends AbstractEntity{

    @Column(name = "marque")
    private String marque;

    @Column(name = "nomm")
    private String nomm;

    @Column(name = "carburant")
    private String carburant;

    @Column(name = "puissance")
    private Integer puissance;

    @OneToMany(mappedBy = "modele")
    private List<Voiture> voitures;
}
