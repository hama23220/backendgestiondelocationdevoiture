package com.mohamed.gestiondelocationdevoiture.controller;

import com.mohamed.gestiondelocationdevoiture.controller.api.VoitureApi;
import com.mohamed.gestiondelocationdevoiture.dto.Voituredto;
import com.mohamed.gestiondelocationdevoiture.services.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.lang.ref.PhantomReference;
import java.util.List;

@RestController
public class VoitureController implements VoitureApi {

    private VoitureService voitureService;

    @Autowired
    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @Override
    public Voituredto save(Voituredto dto) {
        return voitureService.save(dto);
    }

    @Override
    public Voituredto findById(Integer id) {
        return voitureService.findById(id);
    }

    @Override
    public List<Voituredto> findAll() {
        return voitureService.findAll();
    }


    @Override
    public void delete(Integer id) {

        voitureService.delete(id);
    }
}
