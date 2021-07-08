package com.mohamed.gestiondelocationdevoiture.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Entretien")
public class Entretien extends AbstractEntity{

    @Column(name = "type")
    private Integer type;

    @Column(name = "dateentretien")
    private String dateentretien;

    @Column(name = "kiloprevu")
    private Double kiloprevu;

    @Column(name = "prix")
    private Double prix;

    @ManyToOne
    @JoinColumn(name = "nummatricule")
    private Voiture voiture;
}
