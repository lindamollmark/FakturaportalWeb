package se.fakturaportal.persistense.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.core.model.InvoiceRow;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Linda on 2016-05-03.
 */
@Entity
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int invoiceNo;

    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private ClientEntity clientEntity;

    @OneToMany
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "InvoiceId", referencedColumnName = "id")
    private List<InvoiceRowEntity> rowEntityList = new ArrayList<>();

    private String orderNo;
    private Date invoiceDate;
    private Date dueDate;
    @ManyToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private UserEntity user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNO(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public List<InvoiceRowEntity> getRowEntityList() {
        return rowEntityList;
    }

    public void setRowEntityList(List<InvoiceRowEntity> rowEntityList) {
        this.rowEntityList = rowEntityList;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setInvoiceNo(int invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    /**
     * Help method for converint an invoice model to an Entity
     * @param newInvoice the model
     * @return the created entity
     */
    public InvoiceEntity fromModel(Invoice newInvoice) {
        if (!(newInvoice.getId() > 0)) {
            id = newInvoice.getId();
        }
        invoiceNo = newInvoice.getInvoiceNo();
        orderNo = newInvoice.getOrderNo();
        invoiceDate = Date.valueOf(newInvoice.getInvoiceDate().substring(0, 10));
        dueDate = Date.valueOf(newInvoice.getDueDate().substring(0, 10));
        Client client = newInvoice.getClient();
        ClientEntity ce = new ClientEntity();
        clientEntity = ce.fromModel(client);

        final List<InvoiceRow> invoiceRows = newInvoice.getInvoiceRows();
        this.rowEntityList = invoiceRows.stream()
                .map(row -> new InvoiceRowEntity().fromModel(row))
                .collect(Collectors.toList());

        user = new UserEntity().fromModel(newInvoice.getUser());
        return this;
    }

    /**
     * Helpmethod to create a model of the entity.
     * @return the created model
     */
    public Invoice toModel() {
        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setInvoiceNo(invoiceNo);
        invoice.setOrderNo(orderNo);
        invoice.setInvoiceDate(invoiceDate.toString());
        invoice.setDueDate(dueDate.toString());
        invoice.setClient(clientEntity.toModel());
        List<InvoiceRow> rowList = new ArrayList<>();
        for (InvoiceRowEntity ire : rowEntityList) {
            InvoiceRow row = ire.toModel();
            rowList.add(row);
        }
        invoice.setInvoiceRows(rowList);
        invoice.setUser(user.toModel());
        return invoice;
    }
}
