package com.mohamed.gestiondelocationdevoiture.controller;

import com.mohamed.gestiondelocationdevoiture.controller.api.ContratApi;
import com.mohamed.gestiondelocationdevoiture.dto.Contratdto;
import com.mohamed.gestiondelocationdevoiture.services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContratController implements ContratApi {

    private ContratService contratService;

    @Autowired
    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @Override
    public Contratdto save(Contratdto dto) {
        return contratService.save(dto);
    }

    @Override
    public Contratdto findById(Integer id) {
        return contratService.findById(id);
    }

    @Override
    public List<Contratdto> findAll() {
        return contratService.findAll();
    }

    @Override
    public void delete(Integer id) {

        contratService.delete(id);
    }
}
