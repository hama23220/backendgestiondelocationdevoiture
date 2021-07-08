package com.mohamed.gestiondelocationdevoiture.services;

import com.mohamed.gestiondelocationdevoiture.dto.ChangerMotDePasseClientDto;
import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import java.util.List;


public interface ClientService {

    Clientdto save(Clientdto dto);

    Clientdto findById(Integer id);

    List<Clientdto> findAll();

    Clientdto findByEmail(String login);

    void delete(Integer id);

    Clientdto changerMotDePasse(ChangerMotDePasseClientDto dto);
}
