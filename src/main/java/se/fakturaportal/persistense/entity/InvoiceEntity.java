package se.fakturaportal.persistense.entity;

import se.fakturaportal.core.model.Client;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.core.model.InvoiceRow;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linda on 2016-05-03.
 */
@Entity
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int invoiceNO;

    @ManyToOne
    @JoinColumn(name="id")
    private ClientEntity clientEntity;
    @OneToMany
    @JoinColumn(name="id")
    private List<InvoiceRowEntity> rowEntityList = new ArrayList<>();

    public InvoiceEntity fromModel(Invoice newInvoice) {
        if(!(newInvoice.getId() == null)){
            id = newInvoice.getId();
        }
        invoiceNO = newInvoice.getInvoiceNo();
        Client client = newInvoice.getClient();
        ClientEntity ce = new ClientEntity();
        clientEntity = ce.fromModel(client);
        List<InvoiceRowEntity> rowList = new ArrayList<>();
        for (InvoiceRow ir :newInvoice.getInvoiceRows()){
            InvoiceRowEntity ire = new InvoiceRowEntity();
            ire = ire.fromModel(ir);
            rowList.add(ire);
        }
        rowEntityList = rowList;
        return this;

    }
}
