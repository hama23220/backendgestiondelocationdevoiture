package com.mohamed.gestiondelocationdevoiture.services;

import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;

import java.util.List;

public interface ModeleService {

    Modeledto save(Modeledto dto);

    Modeledto findById(Integer id);

    List<Modeledto> findAll();

    void delete(Integer id);
}
