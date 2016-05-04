package se.fakturaportal.core.model;

/**
 * Created by Linda on 2016-05-03.
 */
public class InvoiceRow {
    int id;
    int rowNo;
    String articleNo;
    int quantity;
    String description;
    int unitPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int price) {
        this.unitPrice = price;
    }
}
