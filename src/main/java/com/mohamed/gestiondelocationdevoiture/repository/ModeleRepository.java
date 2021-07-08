package com.mohamed.gestiondelocationdevoiture.repository;

import com.mohamed.gestiondelocationdevoiture.model.Modele;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModeleRepository extends JpaRepository<Modele,Integer> {

    Optional<Modele> findModeleByMarque(String marque);
}
