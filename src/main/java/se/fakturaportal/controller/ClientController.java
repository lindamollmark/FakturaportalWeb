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
    public String newClient(@RequestBody String client){
        Client aClient = new Gson().fromJson(client, Client.class);
         aClient = clientService.newClient(aClient);
        return new Gson().toJson(aClient);
   }

//    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/clientlist", method = RequestMethod.GET)
    public String clientList(){
        List<Client> clients = clientService.getClients();
        String json = new Gson().toJson(clients);
        return json;

    }

//    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/clientView", method = RequestMethod.POST)
    public String clientView(@RequestBody String client){
       TestId clientID = new Gson().fromJson(client, TestId.class);
        Client theClient = clientService.fetchClient(clientID.getClientId());
        String json = new Gson().toJson(theClient);
        return json;
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/deleteClient", method = RequestMethod.POST)
    public void deleteClient(@RequestBody String client){
        TestId aClient = new Gson().fromJson(client, TestId.class);
        System.out.println(aClient.getClientId());
        clientService.deleteClient(aClient.getClientId());
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/updateClient", method = RequestMethod.POST)
    public String updateClient(@RequestBody String client){
        Client aClient = new Gson().fromJson(client, Client.class);
        Client updated = clientService.updateClient(aClient);
        String json = new Gson().toJson(updated);
        return json;
    }

    @RequestMapping(value = "views/clientNo", method = RequestMethod.POST)
    public Boolean checkClientNo(@RequestBody String clientNo){
        Boolean exist = clientService.checkClientNo(Integer.parseInt(clientNo));

        return exist;
    }
}
