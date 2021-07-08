package com.mohamed.gestiondelocationdevoiture.controller;

import com.mohamed.gestiondelocationdevoiture.controller.api.ConducteurApi;
import com.mohamed.gestiondelocationdevoiture.dto.Conducteurdto;
import com.mohamed.gestiondelocationdevoiture.services.ConducteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConducteurController implements ConducteurApi {

    private ConducteurService conducteurService;

    @Autowired
    public ConducteurController(ConducteurService conducteurService) {
        this.conducteurService = conducteurService;
    }

    @Override
    public Conducteurdto save(Conducteurdto dto) {

        return conducteurService.save(dto);
    }

    @Override
    public Conducteurdto findById(Integer id) {
        return conducteurService.findById(id);
    }

    @Override
    public List<Conducteurdto> findAll() {
        return conducteurService.findAll();
    }

    @Override
    public void delete(Integer id) {

        conducteurService.delete(id);
    }
}
