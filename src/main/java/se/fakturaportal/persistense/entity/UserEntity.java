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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCompanyName() {
        return userCompanyName;
    }

    public void setUserCompanyName(String userCompanyName) {
        this.userCompanyName = userCompanyName;
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

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    /**
     * Help method for convert the user model to entity
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

    /**
     * Help method for turning the entity to a model
     * @return the created user
     */
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
