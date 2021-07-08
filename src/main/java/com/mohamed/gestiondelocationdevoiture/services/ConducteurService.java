package com.mohamed.gestiondelocationdevoiture.services;

import com.mohamed.gestiondelocationdevoiture.dto.Conducteurdto;

import java.util.List;

public interface ConducteurService {

    Conducteurdto save(Conducteurdto dto);

    Conducteurdto findById(Integer id);

    List<Conducteurdto> findAll();

    void delete(Integer id);
}
