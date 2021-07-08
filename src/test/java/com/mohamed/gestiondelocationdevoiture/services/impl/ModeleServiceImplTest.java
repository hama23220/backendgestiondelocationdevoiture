package com.mohamed.gestiondelocationdevoiture.services.impl;

import com.mohamed.gestiondelocationdevoiture.dto.Modeledto;
import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidEntityException;
import com.mohamed.gestiondelocationdevoiture.services.ModeleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ModeleServiceImplTest {

    @Autowired
    private ModeleService service;

    @Test
    public void shouldSaveModeleWithSuccess(){
        Modeledto expectedModele =  Modeledto.builder()
                .nomm("picanto test")
                .marque("kia test")
                .build();

        Modeledto savedModele = service.save(expectedModele);

        assertNotNull(savedModele);
        assertNotNull(savedModele.getId());
        assertEquals(expectedModele.getNomm(), savedModele.getNomm());
        assertEquals(expectedModele.getMarque(), savedModele.getMarque());
   }

    @Test
    public void shouldUpdateModeleWithSuccess(){
        Modeledto expectedCategory =  Modeledto.builder()
                .nomm("picanto test")
                .marque("kia test")
                .build();

        Modeledto savedModele = service.save(expectedCategory);

        Modeledto modeleToUpdate = savedModele;
        modeleToUpdate.setNomm("picanto test");

        savedModele = service.save(modeleToUpdate);

        assertNotNull(modeleToUpdate);
        assertNotNull(modeleToUpdate.getId());
        assertEquals(modeleToUpdate.getNomm(), savedModele.getNomm());
        assertEquals(modeleToUpdate.getMarque(), savedModele.getMarque());
    }

    @Test
    public void shouldThrowEntityNotFoundException(){

        EntityNotFoundException expectedException = assertThrows(EntityNotFoundException.class, ()-> service.findById(0));

        assertEquals(ErrorCodes.MODELE_NOT_FOUND, expectedException.getErrorCodes());

        assertEquals("Aucun modele avec l'ID = 0 n' ete trouve dans la BDD",expectedException.getMessage());


    }

    @Test
    public void shouldThrowInvalidEntityException(){
        Modeledto expectedModele =  Modeledto.builder().build();

        InvalidEntityException expectedException = assertThrows(InvalidEntityException.class,() -> service.save(expectedModele));
       assertEquals(ErrorCodes.MODELE_NOT_VALID,expectedException.getErrorCodes());

    }
}