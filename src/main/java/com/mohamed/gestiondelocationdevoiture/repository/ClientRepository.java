package com.mohamed.gestiondelocationdevoiture.repository;

import com.mohamed.gestiondelocationdevoiture.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    //JPQL query
    @Query(value = "select c from Client c where c.nom = :nom")
    Optional<Client> findClientsByNom(@Param("nom") String nom);

    Optional<Client> findClientByLogin(String login);

}
