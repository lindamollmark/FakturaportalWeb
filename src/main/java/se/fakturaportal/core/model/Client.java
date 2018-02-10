package se.fakturaportal.core.model;

/**
 * Module class POJO that holds the client information
 */
public class Client {
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
    private String totalInvoiceAmount;
    private int numberOfInvoices;
    private String pastDueDate;
    private int numberOfOverdueBills;
    private User user;

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

    public String getTotalInvoiceAmount() {
        return totalInvoiceAmount;
    }

    public void setTotalInvoiceAmount(String totalInvoiceAmount) {
        this.totalInvoiceAmount = totalInvoiceAmount;
    }

    public int getNumberOfInvoices() {
        return numberOfInvoices;
    }

    public void setNumberOfInvoices(int numberOfInvoices) {
        this.numberOfInvoices = numberOfInvoices;
    }

    public String getPastDueDate() {
        return pastDueDate;
    }

    public void setPastDueDate(String pastDueDate) {
        this.pastDueDate = pastDueDate;
    }

    public int getNumberOfOverdueBills() {
        return numberOfOverdueBills;
    }

    public void setNumberOfOverdueBills(int numberOfOverdueBills) {
        this.numberOfOverdueBills = numberOfOverdueBills;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
