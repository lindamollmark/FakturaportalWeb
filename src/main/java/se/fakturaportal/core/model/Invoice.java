package se.fakturaportal.core.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * POJO model for invoice, holds the invoiceInformation
 */
public class Invoice {
    int id;
    int invoiceNo;
    Client client;
    String orderNo;
    String invoiceDate;
    String dueDate;
    List<InvoiceRow> invoiceRows;
    double invoiceTotal;
    User user;
    double pastDueDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<InvoiceRow> getInvoiceRows() {
        return invoiceRows;
    }

    public void setInvoiceRows(List<InvoiceRow> invoiceRows) {
        for(InvoiceRow row : invoiceRows){
            invoiceTotal += row.getRowTotal();
        }
        this.invoiceRows = invoiceRows;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPastDueDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dueDate, formatter);
        if (date.isBefore(LocalDate.now())) {
            pastDueDate = invoiceTotal;
        }
        return pastDueDate;
    }

    public void setPastDueDate(double pastDueDate) {
        this.pastDueDate = pastDueDate;
    }
}
