package com.m2i.dao;

import java.util.List;
import com.m2i.entity.Client;

public interface ClientDAO {
	public Client createClient(Client client);
	public List<Client> findAll();
	Client findByEmail(String email);
}
