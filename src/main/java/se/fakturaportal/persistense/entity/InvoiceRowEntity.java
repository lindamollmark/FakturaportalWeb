package se.fakturaportal.persistense.entity;

import se.fakturaportal.core.model.InvoiceRow;

import javax.persistence.*;

/**
 * Created by Linda on 2016-05-04.
 */
@Entity
@Table(name = "invoiceRow")
public class InvoiceRowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int rowNo;
    String articleNo;
    int quantity;
    String description;
    double unitPrice;

    public InvoiceRowEntity fromModel(InvoiceRow ir) {
        if(ir.getId() > 0){
            id = ir.getId();
        }
        rowNo = ir.getRowNo();
        articleNo = ir.getArticleNo();
        quantity = ir.getQuantity();
        description = ir.getDescription();
        unitPrice = ir.getUnitPrice();
        return this;
    }

    public InvoiceRow toModel() {
        InvoiceRow row = new InvoiceRow();
        row.setId(id);
        row.setRowNo(rowNo);
        row.setArticleNo(articleNo);
        row.setQuantity(quantity);
        row.setDescription(description);
        row.setUnitPrice(unitPrice);
        return row;
    }
}
