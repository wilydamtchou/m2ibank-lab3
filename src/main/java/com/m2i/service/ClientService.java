package com.m2i.service;

import com.m2i.dto.ClientCreateDTO;
import com.m2i.dto.ClientDTO;

import jakarta.ejb.LocalBean;

import java.util.List;

@LocalBean
public interface ClientService {
    ClientDTO createClient(ClientCreateDTO dto);
    ClientDTO getClientByEmail(String email);
    List<ClientDTO> getAllClients();
}
