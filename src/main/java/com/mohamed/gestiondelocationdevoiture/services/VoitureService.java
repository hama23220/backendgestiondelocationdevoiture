package com.mohamed.gestiondelocationdevoiture.services;

import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import com.mohamed.gestiondelocationdevoiture.dto.Voituredto;

import java.util.List;

public interface VoitureService {

    Voituredto save(Voituredto dto);

    Voituredto findById(Integer id);

    Voituredto findVoitureByNummatricule(String NumMatricule);

    List<Voituredto> findAll();


    void delete(Integer id);

}
