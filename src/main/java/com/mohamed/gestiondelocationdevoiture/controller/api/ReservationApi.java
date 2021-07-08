package com.mohamed.gestiondelocationdevoiture.controller.api;

import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import com.mohamed.gestiondelocationdevoiture.dto.ReservationClientdto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.gestiondelocationdevoiture.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/reservations")
public interface ReservationApi {

    @PostMapping(value = APP_ROOT + "/reservations/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une reservation", notes = "Cette methode permet d'enregistrer ou modifier une reservation", response = ReservationClientdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet reservation cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet reservation n'est pas valide")
    })
    ReservationClientdto save(@RequestBody ReservationClientdto dto);

    @GetMapping(value = APP_ROOT + "/reservations/{idReservation}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une reservation par ID", notes = "Cette methode permet rechercher une reservation par son id", response = ReservationClientdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet modele rechercher a été trouvé"),
            @ApiResponse(code = 404, message = "L'objet modele n'existe pas dans la base avec l'id fournis")
    })
    ReservationClientdto findById(@PathVariable("idReservation")  Integer id);

    @GetMapping(value = APP_ROOT + "/reservations/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvois une liste des reservations", notes = "Cette methode permet renvois une liste des reservations", responseContainer = "List<Reservationdto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des reservations / une liste vide"),
    })
    List<ReservationClientdto> findAll();

    @DeleteMapping(value = APP_ROOT + "/reservations/delete/{idReservation}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer une reservation", notes = "Cette methode permet de supprimer une reservation", response = ReservationClientdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la reservation est supprimé"),
    })
    void delete(@PathVariable("idReservation") Integer id);
}
