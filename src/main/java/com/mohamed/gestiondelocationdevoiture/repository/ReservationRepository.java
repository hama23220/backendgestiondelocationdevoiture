package com.mohamed.gestiondelocationdevoiture.repository;

import com.mohamed.gestiondelocationdevoiture.model.ReservationClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationClient,Integer> {

    Optional<ReservationClient> findByConducteurId(Integer Idconducteur);
}
