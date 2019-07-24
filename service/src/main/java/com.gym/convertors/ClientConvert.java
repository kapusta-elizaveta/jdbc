package com.gym.convertors;

import com.gym.dto.ClientDto;
import com.gym.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientConvert {

    public ClientDto convert(Client client){
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setEmail(client.getEmail());
        clientDto.setLogin(client.getLogin());
        clientDto.setName(client.getName());
        clientDto.setPassword(client.getPassword());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        return clientDto;
    }

    public Client convert(ClientDto clientDto){
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setEmail(clientDto.getEmail());
        client.setLogin(clientDto.getLogin());
        client.setName(clientDto.getName());
        client.setPassword(clientDto.getPassword());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        return client;
    }
}
