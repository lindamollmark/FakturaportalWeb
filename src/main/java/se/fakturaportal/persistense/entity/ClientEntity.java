package se.fakturaportal.persistense.entity;

import se.fakturaportal.core.model.Client;

import javax.persistence.*;

/**
 * Created by Linda on 2016-03-27.
 */
@Entity
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String clientNo;
    String companyName;
    String address1;
    String address2;
    String postCode;
    String postAddress;
    String contact;
    String phoneNumber;

    public ClientEntity fromModel(Client aClient) {

        this.clientNo = aClient.getClientNo();
        this.companyName = aClient.getCompanyName();
        this.address1 = aClient.getAddress1();
        this.address2 = aClient.getAddress2();
        this.postCode = aClient.getPostCode();
        this.postAddress = aClient.getPostAddress();
        this.contact = aClient.getContact();
        this.phoneNumber = aClient.getPhoneNumber();

        return this;

    }

    public Client toModel() {
        Client client = new Client();
        client.setId(id);
        client.setClientNo(clientNo);
        client.setCompanyName(companyName);
        client.setAddress1(address1);
        client.setAddress2(address2);
        client.setPostCode(postCode);
        client.setPostAddress(postAddress);
        client.setContact(contact);
        client.setPhoneNumber(phoneNumber);

        return client;
    }
}
