package com.mohamed.gestiondelocationdevoiture.repository;

import com.mohamed.gestiondelocationdevoiture.model.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConducteurRepository extends JpaRepository<Conducteur,Integer> {

    Optional<Conducteur> findConducteurByNumpermis(Integer numpermis);
}
