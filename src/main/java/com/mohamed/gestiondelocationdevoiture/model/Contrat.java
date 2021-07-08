package com.mohamed.gestiondelocationdevoiture.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Contrat")
public class Contrat extends AbstractEntity{

    @Column(name = "numcontrat")
    private Integer numcontrat;

    @Column(name = "prixht")
    private Double prixht;

    @Column(name = "tva")
    private Integer tva;

    @Column(name = "acompte")
    private Double acompte;

    @Column(name = "reste")
    private Double reste;

    @Column(name = "modepayement")
    private String modepayement;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "numres", nullable = false)
    private ReservationClient reservationClient ;
}
