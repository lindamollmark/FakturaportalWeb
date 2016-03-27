package se.fakturaportal.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import se.fakturaportal.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.fakturaportal.service.ClientService;

/**
 * Created by Linda on 2016-03-12.
 */
@RestController
public class ClientController {


    @Autowired private ClientService clientService;

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/newClient", method = RequestMethod.POST)
    public boolean newClient(@RequestBody String client){

        Client aClient = new Gson().fromJson(client, Client.class);
        System.out.println("Kommer hit" + aClient.getClientNo());
        clientService.newClient(aClient);

        return true;
    }
}
