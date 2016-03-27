package se.fakturaportal.controller;

import com.google.gson.Gson;
import se.fakturaportal.core.service.ClientService;
import se.fakturaportal.core.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
//        RestRespond respond = new RestRespond();
        System.out.println("Kommer in i controllern");
        List<Client> clients = clientService.getClients();

        String json = new Gson().toJson(clients);
        return json;

    }
}
