package com.gym.repository;

import com.gym.entity.Client;

import java.util.List;

public interface ClientRepository {

    void save(Client client);

    List<Client> findAll();

    Client findById(Integer id);

    List<Client> findByName(String name);

    Client findByLogin(String login);

    void deleteById(Integer id);
}
