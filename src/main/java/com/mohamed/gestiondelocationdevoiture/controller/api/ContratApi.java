package com.mohamed.gestiondelocationdevoiture.controller.api;

import com.mohamed.gestiondelocationdevoiture.dto.Contratdto;
import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.gestiondelocationdevoiture.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/Contrats")
public interface ContratApi {

    @PostMapping(value = APP_ROOT + "/contrats/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un contrat", notes = "Cette methode permet d'enregistrer ou modifier un contrat", response = Contratdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet contrat cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet contrat n'est pas valide")
    })
    Contratdto save(@RequestBody Contratdto dto);

    @GetMapping(value = APP_ROOT + "/contrats/{idContrat}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un contrat par ID", notes = "Cette methode permet rechercher un contrat par son id", response = Contratdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet contrat rechercher a été trouvé"),
            @ApiResponse(code = 404, message = "L'objet contrat n'existe pas dans la base avec l'id fournis")
    })
    Contratdto findById(@PathVariable("idContrat")Integer id);

    @GetMapping(value = APP_ROOT + "/contrats/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvois une liste des contrats", notes = "Cette methode permet renvois une liste des contrats", responseContainer = "List<Contratto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des contrats / une liste vide"),
    })
    List<Contratdto> findAll();

    @DeleteMapping(value = APP_ROOT + "/contrats/delete/{idContrat}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer un contrat", notes = "Cette methode permet de supprimer un contrat", response = Contratdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le contrat est supprimé"),
    })
    void delete(@PathVariable("idContrat")Integer id);
}
