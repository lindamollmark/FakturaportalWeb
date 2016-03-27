package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void newClient(Client aClient) {
        ClientEntity client = new ClientEntity();
        client = client.fromModel(aClient);
        clientDAO.save(client);

    }

    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        Iterable<ClientEntity> clientEntitys = clientDAO.findAll();
        for (ClientEntity ce : clientEntitys) {
            Client client = ce.toModel();
            clients.add(client);
        }
        return clients;
    }
}
