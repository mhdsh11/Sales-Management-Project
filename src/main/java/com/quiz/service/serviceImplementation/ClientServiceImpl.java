package com.quiz.service.serviceImplementation;

import com.quiz.model.Client;
import com.quiz.repository.ClientRepository;
import com.quiz.service.serviceInterface.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Integer id, Client updatedClient) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setName(updatedClient.getName());
            existingClient.setLastName(updatedClient.getLastName());
            existingClient.setMobile(updatedClient.getMobile());
            return clientRepository.save(existingClient);
        }
        return null;
    }
}
