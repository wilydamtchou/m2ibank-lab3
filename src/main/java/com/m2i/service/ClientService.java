package com.m2i.service;

import com.m2i.dto.ClientCreateDTO;
import com.m2i.dto.ClientDTO;

import jakarta.ejb.LocalBean;

import java.util.List;

@LocalBean
public interface ClientService {
    void createClient(ClientCreateDTO dto);
    ClientDTO getClientById(Long id);
    List<ClientDTO> getAllClients();
    void updateClient(ClientDTO dto);
    void deleteClient(Long id);
}
