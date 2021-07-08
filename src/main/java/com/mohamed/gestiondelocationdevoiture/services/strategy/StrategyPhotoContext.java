package com.mohamed.gestiondelocationdevoiture.services.strategy;


import com.flickr4java.flickr.FlickrException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidOperationException;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class StrategyPhotoContext {

    private BeanFactory beanFactory;
    private Strategy strategy;
    @Setter
    private String context;

    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object savePhoto(String context, Integer id, InputStream photo, String title) throws FlickrException {
        determinContext(context);
        return strategy.savePhoto(id,photo,title);
    }

    private void determinContext(String context){

        final String beanName = context + "strategy";

        switch (context){
            case "voiture":
                strategy = beanFactory.getBean(beanName,SaveVoiturePhoto.class);
                break;
            case "client":
                strategy = beanFactory.getBean(beanName,SaveClientPhoto.class);
                break;
            default: throw new InvalidOperationException("context inconnue pour l'enregistrement", ErrorCodes.UNKNOWN_CONTEXT);
        }
    }
}
