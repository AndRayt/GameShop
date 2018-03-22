package com.labratorij.gameshop.service.Impl;


import com.labratorij.gameshop.entity.ClientEntity;
import com.labratorij.gameshop.repository.ClientRepository;
import com.labratorij.gameshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void add(ClientEntity client) {
        clientRepository.saveAndFlush(client);
    }

    public void edit(ClientEntity client_temp, int id) {
        ClientEntity client = clientRepository.getOne(id);
        client.setName(client_temp.getName());
        client.setEmail(client_temp.getEmail());
        client.setTelephone(client_temp.getTelephone());
        client.setOrdersByClientId(client_temp.getOrdersByClientId());
        clientRepository.save(client);
    }

    public void delete(int id) {
        clientRepository.delete(id);
    }

    public ClientEntity get(int id) {
        return clientRepository.getOne(id);
    }

    public List<ClientEntity> getAll() {
        return clientRepository.findAll();
    }
}
