package com.mohamed.gestiondelocationdevoiture.controller.api;

import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.gestiondelocationdevoiture.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/modeles")
public interface ModeleApi {

    @PostMapping(value = APP_ROOT + "/modeles/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un modele", notes = "Cette methode permet d'enregistrer ou modifier un modele", response = Modeledto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet modele cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet modele n'est pas valide")
    })
    Modeledto save(@RequestBody Modeledto dto);

    @GetMapping(value = APP_ROOT + "/modeles/{idModele}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un modele par ID", notes = "Cette methode permet rechercher un modele par son id", response = Modeledto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet modele rechercher a été trouvé"),
            @ApiResponse(code = 404, message = "L'objet modele n'existe pas dans la base avec l'id fournis")
    })
    Modeledto findById(@PathVariable("idModele") Integer id);

    @GetMapping(value = APP_ROOT + "/modeles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvois une liste des modeles", notes = "Cette methode permet renvois une liste des modeles", responseContainer = "List<Modeledto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des modeles / une liste vide"),
    })
    List<Modeledto> findAll();

    @DeleteMapping(value = APP_ROOT+ "/modeles/delete/{idModele}")
    @ApiOperation(value = "supprimer un modele", notes = "Cette methode permet de supprimer un modele", response = Modeledto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le modele est supprimé"),
    })
    void delete(@PathVariable("idModele") Integer id);

}
