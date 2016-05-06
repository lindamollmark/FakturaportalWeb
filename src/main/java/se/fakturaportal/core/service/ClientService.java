package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.persistense.dao.ClientDAO;
import se.fakturaportal.persistense.entity.ClientEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linda on 2016-03-27.
 */
@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    public Client newClient(Client aClient) {
        ClientEntity client = new ClientEntity();
         client.fromModel(aClient);
        clientDAO.save(client);
        Client savedClient = client.toModel();
        return savedClient;

    }

    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        Iterable<ClientEntity> clientEntitys = clientDAO.findAll(new Sort(Sort.Direction.ASC, "clientNo"));
        for (ClientEntity ce : clientEntitys) {
            Client client = ce.toModel();
            clients.add(client);
        }
        return clients;
    }

    public Client fetchClient(String clientID) {
        int id = Integer.valueOf(clientID);
        ClientEntity ce = clientDAO.findOne(id);
        Client client = ce.toModel();
        return client;
    }

    public void deleteClient(String clientId) {
        int id = Integer.valueOf(clientId);
        clientDAO.delete(id);
    }

    public Client updateClient(Client aClient) {
        ClientEntity ce = clientDAO.findOne(aClient.getId());

        ce = ce.fromModel(aClient);
        ClientEntity saved = clientDAO.save(ce);
        Client c = saved.toModel();
        return c;
    }

    public Boolean checkClientNo(int clientNo) {
       List<ClientEntity> ce = clientDAO.findByClientNo(clientNo);

        if(ce.size()>0){
            return true;
        }
        return false;
    }
}
