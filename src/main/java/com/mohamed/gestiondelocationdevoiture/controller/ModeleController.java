package com.mohamed.gestiondelocationdevoiture.controller;

import com.mohamed.gestiondelocationdevoiture.controller.api.ModeleApi;
import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import com.mohamed.gestiondelocationdevoiture.services.ModeleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ModeleController implements ModeleApi {

    private ModeleService modeleService;

    @Autowired
    public ModeleController(ModeleService modeleService) {
        this.modeleService = modeleService;
    }

    @Override
    public Modeledto save(Modeledto dto) {
        return modeleService.save(dto);
    }

    @Override
    public Modeledto findById(Integer id) {
        return modeleService.findById(id);
    }

    @Override
    public List<Modeledto> findAll() {
        return modeleService.findAll();
    }

    @Override
    public void delete(Integer id) {

        modeleService.delete(id);
    }
}
