package com.m2i.db;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.m2i.entity.Client;

import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
public class FakeDatabase {
    private Map<Long, Client> clients = new ConcurrentHashMap<>();

    public Map<Long, Client> getClients() {
        return clients;
    }
}
