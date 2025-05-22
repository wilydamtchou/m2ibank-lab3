package com.m2i.mapper.impl;

import com.m2i.dto.ClientCreateDTO;
import com.m2i.entity.Client;
import com.m2i.mapper.ClientCreateMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientCreateMapperImpl implements ClientCreateMapper {

    @Override
    public Client toEntity(ClientCreateDTO dto) {
        Client client = new Client();
        client.setNom(dto.nom());
        client.setPrenom(dto.prenom());
        client.setEmail(dto.email());
        client.setTelephone(dto.telephone());
        return client;
    }

    @Override
    public ClientCreateDTO toDto(Client entity) {
        return new ClientCreateDTO(
            entity.getNom(),
            entity.getPrenom(),
            entity.getEmail(),
            entity.getTelephone()
        );
    }
}
