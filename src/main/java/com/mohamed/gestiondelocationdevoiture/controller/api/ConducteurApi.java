package com.mohamed.gestiondelocationdevoiture.controller.api;

import com.mohamed.gestiondelocationdevoiture.dto.Conducteurdto;
import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.gestiondelocationdevoiture.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/conducteurs")
public interface ConducteurApi {

    @PostMapping(value = APP_ROOT + "/conducteurs/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un conducteur", notes = "Cette methode permet d'enregistrer ou modifier un conducteur", response = Conducteurdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet conducteur cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet conducteur n'est pas valide")
    })
    Conducteurdto save(@RequestBody Conducteurdto dto);

    @GetMapping(value = APP_ROOT + "/conducteurs/{idConducteur}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un conducteur par ID", notes = "Cette methode permet rechercher un conducteur par son id", response = Conducteurdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet conducteur rechercher a été trouvé"),
            @ApiResponse(code = 404, message = "L'objet conducteur n'existe pas dans la base avec l'id fournis")
    })
    Conducteurdto findById(@PathVariable("idConducteur") Integer id);

    @GetMapping(value = APP_ROOT + "/conducteurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvois une liste des conducteurs", notes = "Cette methode permet renvois une liste des conducteurs", responseContainer = "List<Conducteurdto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des conducteurs / une liste vide"),
    })
    List<Conducteurdto> findAll();

    @DeleteMapping(value = APP_ROOT+"conducteurs/delete/{idConducteur}")
    @ApiOperation(value = "supprimer un conducteur", notes = "Cette methode permet de supprimer un conducteur", response = Conducteurdto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le conducteur est supprimé"),
    })
    void delete(@PathVariable("idConducteur")  Integer id);
}
