package com.mohamed.gestiondelocationdevoiture.controller;

import com.mohamed.gestiondelocationdevoiture.controller.api.ClientApi;
import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import com.mohamed.gestiondelocationdevoiture.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {

        this.clientService = clientService;
    }

    @Override
    public Clientdto save(Clientdto dto) {

        return clientService.save(dto);
    }

    @Override
    public Clientdto findById(Integer id) {

        return clientService.findById(id);
    }

    @Override
    public List<Clientdto> findAll() {

        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {

        clientService.delete(id);
    }
}
