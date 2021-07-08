package com.mohamed.gestiondelocationdevoiture.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidOperationException;
import com.mohamed.gestiondelocationdevoiture.model.Client;
import com.mohamed.gestiondelocationdevoiture.services.ClientService;
import com.mohamed.gestiondelocationdevoiture.services.FlickrService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("clientStrategy")
@Slf4j
public class SaveClientPhoto implements Strategy<Clientdto>{

    private FlickrService flickrService;
    private ClientService clientService;

    @Autowired
    public SaveClientPhoto(FlickrService flickrService, ClientService clientService) {
        this.flickrService = flickrService;
        this.clientService = clientService;
    }

    @Override
    public Clientdto savePhoto(Integer id,InputStream photo, String titre) throws FlickrException {
        Clientdto clientdto = clientService.findById(id);
        String urlphoto = flickrService.savePhoto(photo,titre);
        if (!StringUtils.hasLength(urlphoto)){
            throw new InvalidOperationException("erreur lors de l'enregistrement de la photo du client", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        return clientService.save(clientdto);
    }
}
