package com.m2i.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.m2i.db.FakeDatabase;
import com.m2i.dto.ClientCreateDTO;
import com.m2i.dto.ClientDTO;
import com.m2i.entity.Client;
import com.m2i.mapper.ClientCreateMapper;
import com.m2i.mapper.ClientMapper;
import com.m2i.service.ClientService;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless(name = "localclient")
public class LocalClientServiceImpl implements ClientService {

    @Inject
    private ClientMapper clientMapper;

    @Inject
    private ClientCreateMapper clientCreateMapper;

    @Inject
    private FakeDatabase db;

    @Override
    public ClientDTO createClient(ClientCreateDTO dto) {
        Client client = clientCreateMapper.toEntity(dto);
        db.getClients().put(client.getClientId(), client);
        System.out.println("Enregistrement du client " + client + " en base de données");
        
        return clientMapper.toDto(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = new ArrayList<>(db.getClients().values());

        return clients.stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

	@Override
	public ClientDTO getClientByEmail(String email) {
		return null;
	}
}
