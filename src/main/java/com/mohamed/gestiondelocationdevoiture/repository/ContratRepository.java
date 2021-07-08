package com.mohamed.gestiondelocationdevoiture.repository;

import com.mohamed.gestiondelocationdevoiture.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {

    Optional<Contrat> findContratByNumcontrat(Integer numcontrat);
}
