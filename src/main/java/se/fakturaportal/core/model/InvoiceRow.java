package se.fakturaportal.core.model;

import java.text.DecimalFormat;

/**
 * POJO model for invoiceRows, holds the row information
 */
public class InvoiceRow {
    int id;
    int rowNo;
    String articleNo;
    int quantity;
    String description;
    double unitPrice;
    double rowTotal;

    private static DecimalFormat df2 = new DecimalFormat("#.00");

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

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double price) {
    // calculates and sets the total row price
      setRowTotal(price * quantity);
        this.unitPrice = price;
    }

    public double getRowTotal() {
        return rowTotal;
    }

    public void setRowTotal(double rowTotal) {

        this.rowTotal = rowTotal;
    }
}
