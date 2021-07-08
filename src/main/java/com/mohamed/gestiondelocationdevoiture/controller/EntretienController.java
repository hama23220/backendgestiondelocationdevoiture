package com.mohamed.gestiondelocationdevoiture.controller;

import com.mohamed.gestiondelocationdevoiture.controller.api.EntretienApi;
import com.mohamed.gestiondelocationdevoiture.dto.Entretiendto;
import com.mohamed.gestiondelocationdevoiture.services.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntretienController implements EntretienApi {

    private EntretienService entretienService;

    @Autowired
    public EntretienController(EntretienService entretienService) {
        this.entretienService = entretienService;
    }

    @Override
    public Entretiendto save(Entretiendto dto) {
        return entretienService.save(dto);
    }

    @Override
    public Entretiendto findById(Integer id) {
        return entretienService.findById(id);
    }

    @Override
    public List<Entretiendto> findAll() {
        return entretienService.findAll();
    }

    @Override
    public void delete(Integer id) {

        entretienService.delete(id);
    }
}
