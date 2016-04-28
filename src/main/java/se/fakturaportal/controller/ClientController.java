package se.fakturaportal.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.gson.Gson;
import se.fakturaportal.core.model.TestId;
import se.fakturaportal.core.service.ClientService;
import se.fakturaportal.core.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Linda on 2016-03-12.
 */
@RestController
public class ClientController {


    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/newClient", method = RequestMethod.POST)
    public void newClient(@RequestBody String client){
        Client aClient = new Gson().fromJson(client, Client.class);
        clientService.newClient(aClient);
   }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/clientlist", method = RequestMethod.GET)
    public String clientList(){
        List<Client> clients = clientService.getClients();

        String json = new Gson().toJson(clients);
        return json;

    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/clientView", method = RequestMethod.POST)
    public String clientView(@RequestBody String client){
       TestId clientID = new Gson().fromJson(client, TestId.class);

        Client theClient = clientService.fetchClient(clientID.getId());

        String json = new Gson().toJson(theClient);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/deleteClient", method = RequestMethod.POST)
    public void deleteClient(@RequestBody String client){
        System.out.println("första i controllern " +client);
        TestId aClient = new Gson().fromJson(client, TestId.class);
        System.out.println(aClient.getId());
        clientService.deleteClient(aClient.getId());
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/updateClient", method = RequestMethod.POST)
    public String updateClient(@RequestBody String client){
        Client aClient = new Gson().fromJson(client, Client.class);
        Client updated = clientService.updateClient(aClient);
        String json = new Gson().toJson(updated);
        return json;
    }
}
