package com.mohamed.gestiondelocationdevoiture.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "ReservationClient")
public class ReservationClient extends AbstractEntity{

    @Column(name = "numres")
    private Integer numres;

    @Column(name = "datedebut")
    private String datedebut;

    @Column(name = "datefin")
    private String datefin;

    @Column(name = "heuredebut")
    private String heuredebut;

    @Column(name = "heurefin")
    private String heurefin;

    @Column(name = "lieu")
    private String lieu;


    @ManyToOne
    @JoinColumn(name = "idconducteur")
    private Conducteur conducteur;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "reservationClient")
    private Contrat contrat ;
}
