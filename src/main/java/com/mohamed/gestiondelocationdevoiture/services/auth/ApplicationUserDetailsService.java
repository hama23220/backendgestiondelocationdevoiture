package com.mohamed.gestiondelocationdevoiture.services.auth;

import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.model.Client;
import com.mohamed.gestiondelocationdevoiture.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository repository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = repository.findClientByLogin(login).orElseThrow(()->
                new EntityNotFoundException("aucun utilisateur avec l'email fournis", ErrorCodes.CLIENT_NOT_FOUND));

        return new User(client.getLogin(), client.getPassword(),Collections.emptyList());
    }
}
