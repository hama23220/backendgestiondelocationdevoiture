package com.mohamed.gestiondelocationdevoiture.controller.api;

import com.mohamed.gestiondelocationdevoiture.dto.Entretiendto;
import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mohamed.gestiondelocationdevoiture.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/entretiens")
public interface EntretienApi {

    @PostMapping(value = APP_ROOT + "/entretiens/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un entretien", notes = "Cette methode permet d'enregistrer ou modifier un entretien", response = Entretiendto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet entretien cree / modifie"),
            @ApiResponse(code = 400, message = "L'objet entretien n'est pas valide")
    })
    Entretiendto save(@RequestBody Entretiendto dto);

    @GetMapping(value = APP_ROOT + "/entretiens/{idEntretien}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un entretien par ID", notes = "Cette methode permet rechercher un entretien par son id", response = Entretiendto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet entretien rechercher a été trouvé"),
            @ApiResponse(code = 404, message = "L'objet entretien n'existe pas dans la base avec l'id fournis")
    })
    Entretiendto findById(@PathVariable("idEntretien")Integer id);

    @GetMapping(value = APP_ROOT + "/entretiens/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "renvois une liste des entretiens", notes = "Cette methode permet renvois une liste des entretiens", responseContainer = "List<Entretiendto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des entretiens / une liste vide"),
    })
    List<Entretiendto> findAll();

    @DeleteMapping(value = APP_ROOT + "/entretiens/delete/{idEntretien}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer un entretien", notes = "Cette methode permet de supprimer un entretien", response = Entretiendto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le entretien est supprimé"),
    })
    void delete(@PathVariable("idEntretien") Integer id);
}
