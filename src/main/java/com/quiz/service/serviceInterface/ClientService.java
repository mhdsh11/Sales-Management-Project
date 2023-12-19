package com.quiz.service.serviceInterface;
import com.quiz.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Integer id);
    Client createClient(Client client);
    Client updateClient(Integer id, Client client);
}
