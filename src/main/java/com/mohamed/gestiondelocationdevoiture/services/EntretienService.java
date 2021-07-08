package com.mohamed.gestiondelocationdevoiture.services;

import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import com.mohamed.gestiondelocationdevoiture.dto.Entretiendto;

import java.util.List;

public interface EntretienService {

    Entretiendto save(Entretiendto dto);

    Entretiendto findById(Integer id);

    List<Entretiendto> findAll();

    void delete(Integer id);
}
