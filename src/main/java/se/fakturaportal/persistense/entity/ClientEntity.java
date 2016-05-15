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
    private int id;
    private int clientNo;
    private String companyName;
    private String address1;
    private String address2;
    private String postCode;
    private String postAddress;
    private String contact;
    private String phoneNumber;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="userId", referencedColumnName = "id")
    private UserEntity user;

    /**
     * Help method to convert a client Model to an entity
     * @param aClient the client
     * @return the ceatedentity
     */
    public ClientEntity fromModel(Client aClient) {
        // a new client hasn't got any id yet.
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
        this.user = new UserEntity().fromModel(aClient.getUser());

        return this;

    }

    /**
     * Help method to convert the entity to a client model
     * @return the created model.
     */
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
        client.setUser(user.toModel());

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
