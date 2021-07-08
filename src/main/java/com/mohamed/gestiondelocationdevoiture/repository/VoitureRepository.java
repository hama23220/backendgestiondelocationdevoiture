package com.mohamed.gestiondelocationdevoiture.repository;

import com.mohamed.gestiondelocationdevoiture.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface VoitureRepository extends JpaRepository<Voiture,Integer> {

   Optional<Voiture> findVoitureByNummatricule(String NumMatricule);

   //Optional<Voiture> findAllByClientId(Integer idClient);





}
