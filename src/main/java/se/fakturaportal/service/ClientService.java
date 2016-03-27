package se.fakturaportal.service;

import org.springframework.stereotype.Service;
import se.fakturaportal.model.Client;

/**
 * Created by Linda on 2016-03-27.
 */
@Service
public class ClientService {

    public void newClient(Client aClient) {
        System.out.println(aClient.getCompanyName() + "is now in the Service!");
    }
}
