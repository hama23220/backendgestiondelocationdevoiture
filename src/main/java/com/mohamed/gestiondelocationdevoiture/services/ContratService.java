package com.mohamed.gestiondelocationdevoiture.services;

import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import com.mohamed.gestiondelocationdevoiture.dto.Contratdto;

import java.util.List;

public interface ContratService {

    Contratdto save(Contratdto dto);

    Contratdto findById(Integer id);

    List<Contratdto> findAll();

    void delete(Integer id);
}
