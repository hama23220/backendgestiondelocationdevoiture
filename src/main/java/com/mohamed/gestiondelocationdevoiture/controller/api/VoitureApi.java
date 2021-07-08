package com.mohamed.gestiondelocationdevoiture.controller.api;

import com.mohamed.gestiondelocationdevoiture.dto.Voituredto;
import com.mohamed.gestiondelocationdevoiture.model.Voiture;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.gestiondelocationdevoiture.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/voitures")
public interface VoitureApi {

    @PostMapping(value = APP_ROOT + "/voitures/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une voiture", notes = "Cette methode permet d'enregistrer ou modifier une voiture", response = Voituredto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet modele cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet modele n'est pas valide")
    })
    Voituredto save(@RequestBody Voituredto dto);

    @GetMapping(value = APP_ROOT + "/voitures/{idVoiture}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "rechercher une voiture par ID", notes = "Cette methode permet rechercher une voiture par son id", response = Voituredto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet modele rechercher a été trouvé"),
            @ApiResponse(code = 404, message = "L'objet modele n'existe pas dans la base avec l'id fournis")
    })
    Voituredto findById(@PathVariable("idVoiture") Integer id);

    @GetMapping(value = APP_ROOT + "/voitures/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvois une liste des voitures", notes = "Cette methode permet renvois une liste des voitures", responseContainer = "List<Voituredto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des voitures / une liste vide"),
    })
    List<Voituredto> findAll();




    @DeleteMapping(value = APP_ROOT + "/voitures/delete/{idVoiture}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer une voiture", notes = "Cette methode permet de supprimer une voiture", response = Voituredto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la voiture est supprimé"),
    })
    void delete(@PathVariable("idVoiture") Integer id);
}
