package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.core.model.User;
import se.fakturaportal.persistense.dao.ClientDAO;
import se.fakturaportal.persistense.dao.InvoiceDAO;
import se.fakturaportal.persistense.dao.UserDAO;
import se.fakturaportal.persistense.entity.ClientEntity;
import se.fakturaportal.persistense.entity.InvoiceEntity;
import se.fakturaportal.persistense.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer class to handle the logic for the client.
 */
@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private UserDAO userDAO;

    /**
     * Saves the new Client
     * @param aClient the client information to save
     * @return the saved information.
     */
    public Client newClient(Client aClient) {
        ClientEntity client = new ClientEntity();
        client.fromModel(aClient);
        clientDAO.save(client);
        Client savedClient = client.toModel();
        return savedClient;

    }

    /**
     * Gets the hole clientList
     * @return All the clients
     * @param user
     */
    public List<Client> getClients(User user) {
        List<Client> clients = new ArrayList<>();
        List<ClientEntity> clientEntitys = clientDAO.findByUserId(user.getId());
        for (ClientEntity ce : clientEntitys) {
            Client client = ce.toModel();
            clients.add(client);
        }
        return clients;
    }

    /**
     * Fetches a specific client from the database
     * @param clientID the ID for the client to fetch
     * @return the asked client.
     */
    public Client fetchClient(int clientID) {
        ClientEntity ce = clientDAO.findOne(clientID);
        Client client = ce.toModel();
        return client;
    }

    /**
     * Deletes the client if the client hasn't got any invoices
     * @param clientId the id to be deleted
     * @return true if we were able to delete the client, false if it has invoices and there for cant be deleated.
     */
    public Boolean deleteClient(int clientId) {
        ClientEntity ce = clientDAO.findOne(clientId);
        List<InvoiceEntity> invList = invoiceDAO.findByClientEntity(ce);
        if(invList.size() == 0){
            clientDAO.delete(clientId);
            return true;
        }
        return false;
    }

    /**
     * Method for updating a client
     * @param aClient the information to update
     * @return the updated client.
     */
    public Client updateClient(Client aClient) {
        ClientEntity ce = clientDAO.findOne(aClient.getId());
        ce = ce.fromModel(aClient);
        ClientEntity saved = clientDAO.save(ce);
        Client c = saved.toModel();
        return c;
    }

    /**
     * Method to check if the clientNo if free to use.
     * @param clientNo the asked clientNo
     * @param user
     * @return true if you can use it, false if its already taken.
     */
    public Boolean checkClientNo(int clientNo, User user) {
        List<ClientEntity> ce = clientDAO.findByClientNoAndUserId(clientNo, user.getId());
        if(ce.size()>0){
            return true;
        }
        return false;
    }
}
