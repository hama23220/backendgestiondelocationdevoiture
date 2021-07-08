package com.mohamed.gestiondelocationdevoiture.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "Client")
public class Client extends AbstractEntity{

 @Column(name = "nom")
 private String nom ;

 @Column(name = "prenom")
 private String prenom;

 @Embedded
 private Adresse adresse;

 @Column(name = "login")
 private String login ;

 @Column(name = "password")
 private String password;

 @Column(name = "num")
 private Integer num ;

 @Column(name = "photo")
 private String photo;

 @ManyToOne
 @JoinColumn(name = "nummatricule")
 private Voiture voiture;

}
