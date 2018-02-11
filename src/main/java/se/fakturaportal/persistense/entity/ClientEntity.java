package se.fakturaportal.persistense.entity;

import com.sun.xml.internal.bind.v2.TODO;
import org.hibernate.annotations.Cascade;
import se.fakturaportal.core.model.Address;
import se.fakturaportal.core.model.AddressType;
import se.fakturaportal.core.model.Client;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private String email;
    private String orgNumber;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;
    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private List<AddressEntity> addressEntityList = new ArrayList<>();

    /**
     * Help method to convert a client Model to an entity
     * @param aClient the client
     * @return the ceatedentity
     */
    public ClientEntity fromModel(Client aClient) {
        // a new client hasn't got any id yet.
        if (aClient.getId() > 0) {
            this.id = aClient.getId();
        }
        this.clientNo = aClient.getClientNo();
        this.companyName = aClient.getCompanyName();

        this.contact = aClient.getContact();
        this.phoneNumber = aClient.getPhoneNumber();
        this.email = aClient.getEmail();
        this.orgNumber = aClient.getOrgNumber();
        this.user = new UserEntity().fromModel(aClient.getUser());

        final AddressEntity mainAddress = new AddressEntity().fromModel(aClient.getMainAddress());
        final AddressEntity deliveryAddress = new AddressEntity().fromModel(aClient.getDeliveryAddress());
        final AddressEntity invoiceAddress = new AddressEntity().fromModel(aClient.getInvoiceAddress());
        this.addressEntityList.add(mainAddress);
        this.addressEntityList.add(deliveryAddress);
        this.addressEntityList.add(invoiceAddress);

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
        client.setContact(contact);
        client.setPhoneNumber(phoneNumber);
        client.setUser(user.toModel());
        client.setEmail(email);
        client.setOrgNumber(orgNumber);

        final List<Address> addresses = addressEntityList.stream()
                .map(AddressEntity::toModel)
                .collect(Collectors.toList());

        if (addresses.isEmpty()){
            client.setMainAddress(getAddress(AddressType.MAIN));
            client.setDeliveryAddress(getAddress(AddressType.DELIVERY));
            client.setInvoiceAddress(getAddress(AddressType.INVOICE));
        }

        for (final Address address : addresses) {
            final AddressType addressType = address.getType();
            if (addressType.equals(AddressType.MAIN)) {
                client.setMainAddress(address);
            } else if (addressType.equals(AddressType.DELIVERY)) {
                client.setDeliveryAddress(address);
            } else if (addressType.equals(AddressType.INVOICE)) {
                client.setInvoiceAddress(address);
            }
        }
        return client;
    }

    private Address getAddress(AddressType type) {
        Address main = new Address();
        main.setAddress1(address1);
        main.setAddress2(address2);
        main.setPostCode(postCode);
        main.setPostAddress(postAddress);
        main.setType(type);
        return main;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
