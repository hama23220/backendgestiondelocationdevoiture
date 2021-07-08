package com.mohamed.gestiondelocationdevoiture.services.impl;

import com.mohamed.gestiondelocationdevoiture.dto.ChangerMotDePasseClientDto;
import com.mohamed.gestiondelocationdevoiture.dto.Clientdto;
import com.mohamed.gestiondelocationdevoiture.execption.EntityNotFoundException;
import com.mohamed.gestiondelocationdevoiture.execption.ErrorCodes;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidEntityException;
import com.mohamed.gestiondelocationdevoiture.execption.InvalidOperationException;
import com.mohamed.gestiondelocationdevoiture.model.Client;
import com.mohamed.gestiondelocationdevoiture.repository.ClientRepository;
import com.mohamed.gestiondelocationdevoiture.repository.VoitureRepository;
import com.mohamed.gestiondelocationdevoiture.services.ClientService;
import com.mohamed.gestiondelocationdevoiture.validator.Clientvalidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private VoitureRepository voitureRepository;

    //ici c'est l'injection de clientrepository
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository,VoitureRepository  voitureRepository) {

        this.voitureRepository = voitureRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public Clientdto save(Clientdto dto) {
        List<String> errors = Clientvalidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("client non valid",dto);
            throw new InvalidEntityException("le client n'est pas valid", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return Clientdto.fromEntity(
                clientRepository.save(Clientdto.toEntity(dto)));
    }

    @Override
    public Clientdto findById(Integer id) {
        if (id==null){
            log.error("client id is null");
            return null;
        }
        return clientRepository.findById(id)
                .map(Clientdto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("aucun Client avec l'Id"+id+"n'est pas trouve dans la base",
                        ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<Clientdto> findAll() {
        return clientRepository.findAll().stream()
                .map(Clientdto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Clientdto findByEmail(String login){
        return clientRepository.findClientByLogin(login)
                .map(Clientdto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "aucun utilisateur avec l'email = " +login+ "n'est pas trouve dans la BDD",
                        ErrorCodes.CLIENT_NOT_FOUND)
                );
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("client id is null");
            return ;
        }
        clientRepository.deleteById(id);
    }

    @Override
    public Clientdto changerMotDePasse(ChangerMotDePasseClientDto dto) {
        validate(dto);
        Optional<Client> clientOptional = clientRepository.findById(dto.getId());
        if (clientOptional.isEmpty()){
            log.warn("aucun utlisateur n'a ete trouver dans la base avec l'ID" + dto.getId());
            throw new EntityNotFoundException("aucun utlisateur n'a ete trouver dans la base avec l'ID" + dto.getId(),ErrorCodes.CLIENT_NOT_FOUND);
        }
        Client client = clientOptional.get();
        client.setPassword(dto.getMotdepasse());
        return Clientdto.fromEntity(
                clientRepository.save(client)
        );
    }

    public void validate(ChangerMotDePasseClientDto dto){
        if (dto == null){
            log.warn("impossible de modifier le mot de passe avec un objet NULL");
            throw new InvalidOperationException("acune information n'a ete fourni pour pouvoir changer le mot de passe",
                    ErrorCodes.CLIENT_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (dto.getId() == null){
            log.warn("impossible de modifier le mot de passe avec un ID est NULL");
            throw new InvalidOperationException("ID utilisateur null : Impossible de modifierle mot de passe ",
                    ErrorCodes.CLIENT_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!StringUtils.hasLength(dto.getMotdepasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse())){
            log.warn("impossible de modifier le mot de passe avec un Mot de passe est NULL");
            throw new InvalidOperationException("Mot de passe utilisateur null : Impossible de modifierle mot de passe ",
                    ErrorCodes.CLIENT_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!dto.getMotdepasse().equals(dto.getConfirmMotDePasse())){
            log.warn("le mot de passe et ConfirmMotDePasse ne sont pas identiques");
            throw new InvalidOperationException("le mot de passe et ConfirmMotDePasse ne sont pas identiques : Impossible de modifierle mot de passe ",
                    ErrorCodes.CLIENT_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
    }
}
