package controller;

import model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Linda on 2016-03-12.
 */
@RestController
public class ClientController {

    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/views/newClient/", method = RequestMethod.POST)
    public boolean newClient(@RequestBody Client client){
        System.out.println("Kommer hit");
        return true;
    }
}
