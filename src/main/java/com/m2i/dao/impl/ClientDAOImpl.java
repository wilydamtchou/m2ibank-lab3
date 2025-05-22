package com.m2i.dao.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.m2i.dao.ClientDAO;
import com.m2i.entity.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

public class ClientDAOImpl implements ClientDAO {
	@PersistenceContext(unitName = "M2iBankPU")
	private EntityManager em;

	@Override
	public Client createClient(Client client) {
		em.persist(client);

		return client;
	}

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		String req = "SELECT c FROM Client c";
		TypedQuery<Client> result = em.createQuery(req, Client.class);
		
		return result.getResultList();
	}

	@Override
	public Client findByEmail(String email) {
		String req = "SELECT c FROM Client c WHERE c.email = :email";
		TypedQuery<Client> result = em.createQuery(req, Client.class);
		
		result = result.setParameter("email", email);
		Stream<Client> stream = result.getResultStream();
		Optional<Client> client = stream.findFirst();

		return client.orElse(null);
	}
}
