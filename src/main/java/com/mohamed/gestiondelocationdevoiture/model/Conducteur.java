package com.mohamed.gestiondelocationdevoiture.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Conducteur")
public class Conducteur extends AbstractEntity{

    @Column(name = "nomc")
    private String nomc;

    @Column(name = "prenomc")
    private String prenomc;

    @Column(name = "numpermis")
    private Integer numpermis;

    @Column(name = "numcin")
    private Integer numcin;

    @Column(name = "datepermis")
    private String datepermis;

    @OneToMany(mappedBy = "conducteur")
    private List<ReservationClient> reservationClients;


}
