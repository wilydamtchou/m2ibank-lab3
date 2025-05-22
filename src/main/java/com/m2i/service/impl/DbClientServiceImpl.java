package com.m2i.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.m2i.dao.ClientDAO;
import com.m2i.dto.ClientCreateDTO;
import com.m2i.dto.ClientDTO;
import com.m2i.entity.Client;
import com.m2i.mapper.ClientCreateMapper;
import com.m2i.mapper.ClientMapper;
import com.m2i.service.ClientService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless(name = "dbclient")
public class DbClientServiceImpl implements ClientService {

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private ClientCreateMapper clientCreateMapper;

    @Inject
    private ClientDAO clientDAO;

    @Override
    public ClientDTO createClient(ClientCreateDTO dto) {
        Client client = clientCreateMapper.toEntity(dto);
        
        client = clientDAO.createClient(client);
        
        return clientMapper.toDto(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<ClientDTO> clients = clientDAO.findAll().stream().
        		map(clientMapper::toDto).
        		collect(Collectors.toList());
        
        return clients;
    }

	@Override
	public ClientDTO getClientByEmail(String email) {
		return null;
	}
}
