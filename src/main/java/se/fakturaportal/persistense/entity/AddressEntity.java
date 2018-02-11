package se.fakturaportal.persistense.entity;

import se.fakturaportal.core.model.Address;
import se.fakturaportal.core.model.AddressType;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address1;
    private String address2;
    private String postCode;
    private String postAddress;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AddressEntity fromModel(Address address, AddressType type) {
        if(address.getId() > 0){
            this.id = address.getId();
        }

        this.address1 = address.getAddress1();
        this.address2 = address.getAddress2();
        this.postCode = address.getPostCode();
        this.postAddress = address.getPostAddress();
        this.type = type.name();

        return this;
    }

    public Address toModel() {
        Address main = new Address();
        main.setAddress1(address1);
        main.setAddress2(address2);
        main.setPostCode(postCode);
        main.setPostAddress(postAddress);
        main.setType(AddressType.valueOf(getType()));
        return main;
    }
}
