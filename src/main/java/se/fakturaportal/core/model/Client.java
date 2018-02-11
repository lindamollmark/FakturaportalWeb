package se.fakturaportal.core.model;

/**
 * Module class POJO that holds the client information
 */
public class Client {
    private int id;
    private int clientNo;
    private String companyName;
    private Address mainAddress;
    private Address invoiceAddress;
    private Address deliveryAddress;
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

    public Address getMainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Address getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(Address invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
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
