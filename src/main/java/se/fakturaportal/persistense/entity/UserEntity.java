package se.fakturaportal.persistense.entity;

import se.fakturaportal.core.model.User;

import javax.persistence.*;

/**
 * Created by Linda on 2016-05-12.
 */
@Entity
@Table (name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;
    String userCompanyName;
    String address1;
    String address2;
    String postCode;
    String postAddress;
    String contact;
    String phoneNumber;
    String email;
    String orgNumber;
    String bankNumber;

    /**
     * Convert the usermodel to entity
     * @param user the model to convert
     * @return the entity
     */
    public UserEntity fromModel(User user) {

        if(user.getId() > 0){
            this.id = user.getId();
        }
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.userCompanyName = user.getUserCompanyName();
        this.address1 = user.getAddress1();
        if(user.getAddress2() != null){
            this.address2 = user.getAddress2();
        }

        this.postCode = user.getPostCode();
        this.postAddress = user.getPostAddress();
        this.contact = user.getContact();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.orgNumber = user.getOrgNumber();
        this.bankNumber = user.getBankNumber();

        return this;


    }

    public User toModel() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setUserCompanyName(userCompanyName);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setPostCode(postCode);
        user.setPostAddress(postAddress);
        user.setContact(contact);
        user.setPhoneNumber(phoneNumber);
        user.setEmail(email);
        user.setOrgNumber(orgNumber);
        user.setBankNumber(bankNumber);
        return user;
    }
}
