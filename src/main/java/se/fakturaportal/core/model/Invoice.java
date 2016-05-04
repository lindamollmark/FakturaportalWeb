package se.fakturaportal.core.model;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Linda on 2016-05-03.
 */
public class Invoice {
    Long id;
    int invoiceNo;
    Client client;
    List<InvoiceRow> invoiceRows;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        this.invoiceRows = invoiceRows;
    }
}
