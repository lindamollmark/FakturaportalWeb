package se.fakturaportal.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.core.model.TestId;
import se.fakturaportal.core.service.InvoiceService;

import java.util.List;

/**
 * Class to handle the invoices
 */
@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    /**
     * Method to save the new invoice.
     * @param invoice the information to save
     * @return the saved invoice
     */
    @RequestMapping(value = "/views/newInvoice", method = RequestMethod.POST)
    public String newInvoice(@RequestBody String invoice){
        Invoice newInvoice = invoiceFromJson(invoice);
        newInvoice = invoiceService.newInvoice(newInvoice);
        String json = invoiceToJson(newInvoice);
        return json;
    }

    /**
     * Help method to make a Json format of a invoice
     * @param invoice the invoice to format
     * @return the Json string
     */
    private String invoiceToJson(Invoice invoice) {
        return new Gson().toJson(invoice);
    }

    /**
     * Help method to make an invoice from a Json
     * @param invoice the Json string with the invoice information
     * @return the invoice
     */
    private Invoice invoiceFromJson(String invoice) {
        return new Gson().fromJson(invoice, Invoice.class);
    }

    /**
     * Method to fetch a invoice from the database
     * @param invoiceNo the invoice number you want to receive
     * @return the invoice in Json format.
     */
    @RequestMapping(value="/views/fetchInvoice", method = RequestMethod.POST)
    public String fetchInvoice(@RequestBody String invoiceNo){
        Invoice invoice = invoiceFromJson(invoiceNo);
        invoice = invoiceService.fetchInvoice(invoice);
        String json = invoiceToJson(invoice);
        return json;
    }

    /**
     * Gets the next invoiceNumber to use.
     * @return next avalible invoicenumber.
     */
    @RequestMapping(value = "/views/newInvoiceNo", method = RequestMethod.GET)
    public int getInvoiceNo(){
        int invoiceNo = invoiceService.getInvoiceNo();
        return invoiceNo;
    }

    /**
     * Fetches all the invoices from the database
     * @return Json string with all the invoices.
     */
    @RequestMapping(value = "/views/invoicelist", method = RequestMethod.GET)
    public String invoiceList() {
        List<Invoice> invoices = invoiceService.fetchInvoiceList();
        String json = new Gson().toJson(invoices);
        return json;
    }

    /**
     * Fetches the invoices for a specific client
     * @param clientId the Id for the client we want the invoices for.
     * @return the list of invoices in a Json string
     */
    @RequestMapping(value = "/views/clientInvoicelist", method = RequestMethod.POST)
    public String clientInvoiceList(@RequestBody String clientId) {
        TestId clientID = new Gson().fromJson(clientId, TestId.class);
        List<Invoice> invoices = invoiceService.fetchClientInvoiceList(clientID);
        String json = new Gson().toJson(invoices);
        return json;
    }

    /**
     * Method to update the invoice.
     * @param invoiceToUpdate the invoice with the information that shall be updated.
     */
    @RequestMapping(value= "views/updateInvoice", method = RequestMethod.POST)
    public void updateInvoice(@RequestBody String invoiceToUpdate){
        Invoice invoice = invoiceFromJson(invoiceToUpdate);
        invoiceService.updateInvoice(invoice);
    }
}
