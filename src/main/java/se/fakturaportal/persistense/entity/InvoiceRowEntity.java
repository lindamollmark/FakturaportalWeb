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

    /**
     * Help method for creating a row entity from the model
     * @param ir the rowmodel
     * @return the entity that has been created.
     */
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

    /**
     * Help method to create a model of the entity
     * @return the created model.
     */
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
