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
    int id;
    int clientNo;
    String companyName;
    String address1;
    String address2;
    String postCode;
    String postAddress;
    String contact;
    String phoneNumber;

    public ClientEntity fromModel(Client aClient) {
        if(aClient.getId() > 0){
            this.id = aClient.getId();
        }
        this.clientNo = aClient.getClientNo();
        this.companyName = aClient.getCompanyName();
        this.address1 = aClient.getAddress1();
        if(aClient.getAddress2() != null){
            this.address2 = aClient.getAddress2();
        }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientNo() {
        return clientNo;
    }

    public void setClientNo(int clientNo) {
        this.clientNo = clientNo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
