package com.m2i.mapper.impl;

import com.m2i.dto.ClientDTO;
import com.m2i.entity.Client;
import com.m2i.mapper.ClientMapper;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientMapperImpl implements ClientMapper {

    @Override
    public Client toEntity(ClientDTO dto) {
        Client client = new Client();
        client.setClientId(dto.getClientId());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setEmail(dto.getEmail());
        client.setTelephone(dto.getTelephone());
        return client;
    }

    @Override
    public ClientDTO toDto(Client entity) {
        ClientDTO dto = new ClientDTO();
        dto.setClientId(entity.getClientId());
        dto.setNom(entity.getNom());
        dto.setPrenom(entity.getPrenom());
        dto.setEmail(entity.getEmail());
        dto.setTelephone(entity.getTelephone());
        dto.setDateCreation(entity.getDateCreation());
            
        return dto;
    }
}
