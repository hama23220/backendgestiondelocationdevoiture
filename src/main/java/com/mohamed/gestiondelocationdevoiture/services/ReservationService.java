package com.mohamed.gestiondelocationdevoiture.services;

import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import com.mohamed.gestiondelocationdevoiture.dto.ReservationClientdto;

import java.util.List;

public interface ReservationService {

    ReservationClientdto save(ReservationClientdto dto);

    ReservationClientdto findById(Integer id);

    List<ReservationClientdto> findAll();

    void delete(Integer id);

}
