package com.mohamed.gestiondelocationdevoiture.controller;

import com.mohamed.gestiondelocationdevoiture.controller.api.ReservationApi;
import com.mohamed.gestiondelocationdevoiture.dto.ReservationClientdto;
import com.mohamed.gestiondelocationdevoiture.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController implements ReservationApi {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Override
    public ReservationClientdto save(ReservationClientdto dto) {
        return reservationService.save(dto);
    }

    @Override
    public ReservationClientdto findById(Integer id) {
        return reservationService.findById(id);
    }

    @Override
    public List<ReservationClientdto> findAll() {
        return reservationService.findAll();
    }

    @Override
    public void delete(Integer id) {

        reservationService.delete(id);
    }
}
