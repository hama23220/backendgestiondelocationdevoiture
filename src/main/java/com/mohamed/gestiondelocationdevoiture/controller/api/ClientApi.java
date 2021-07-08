package com.mohamed.gestiondelocationdevoiture.controller.api;
import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.gestiondelocationdevoiture.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/clients")
public interface ClientApi {


    @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un client", notes = "Cette methode permet d'enregistrer ou modifier un client", response = Clientdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet client n'est pas valide")
    })
    Clientdto save(@RequestBody Clientdto dto);

    @GetMapping(value = APP_ROOT + "/clients/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un client par ID", notes = "Cette methode permet rechercher un client par son id", response = Clientdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet client rechercher a été trouvé"),
            @ApiResponse(code = 404, message = "L'objet client n'existe pas dans la base avec l'id fournis")
    })
    Clientdto findById(@PathVariable("idClient") Integer id);

    @GetMapping(value = APP_ROOT+ "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvois une liste des clients", notes = "Cette methode permet renvois une liste des clients", responseContainer = "List<Clientdto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des clients / une liste vide"),
    })
    List<Clientdto> findAll();

    @DeleteMapping(value = APP_ROOT+"/clients/delete/{idClient}")
    @ApiOperation(value = "supprimer un client", notes = "Cette methode permet de supprimer un client", response = Clientdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le client est supprimé"),
    })
    void delete(@PathVariable("idClient") Integer id);


}
