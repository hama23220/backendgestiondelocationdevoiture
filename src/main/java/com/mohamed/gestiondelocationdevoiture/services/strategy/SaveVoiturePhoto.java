package com.mohamed.gestiondelocationdevoiture.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.mohamed.gestiondelocationdevoiture.dto.Voituredto;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidOperationException;
import com.mohamed.gestiondelocationdevoiture.model.Voiture;
import com.mohamed.gestiondelocationdevoiture.services.FlickrService;
import com.mohamed.gestiondelocationdevoiture.services.VoitureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("voitureStrategy")
@Slf4j
public class SaveVoiturePhoto implements Strategy<Voituredto>{

    private FlickrService flickrService;
    private VoitureService voitureService;

    @Autowired
    public SaveVoiturePhoto(FlickrService flickrService, VoitureService voitureService) {
        this.flickrService = flickrService;
        this.voitureService = voitureService;
    }

    @Override
    public Voituredto savePhoto(Integer id,InputStream photo, String titre) throws FlickrException {

        Voituredto voituredto = voitureService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo,titre);
        if (!StringUtils.hasLength(urlPhoto)){
             throw new InvalidOperationException("erreur lors de l'enregistrement de la photo de la voiture", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        voituredto.setPhoto(urlPhoto);
        return voitureService.save(voituredto);
    }
}
