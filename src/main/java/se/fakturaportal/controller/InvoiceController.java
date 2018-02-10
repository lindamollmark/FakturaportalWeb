package se.fakturaportal.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.core.model.User;
import se.fakturaportal.core.service.InvoiceService;

import javax.servlet.http.HttpSession;
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
     * @param session the logged in user
     * @return the saved invoice
     */
    @RequestMapping(value = "/views/newInvoice", method = RequestMethod.POST)
    public String newInvoice(@RequestBody String invoice, HttpSession session){
        User user = (User) session.getAttribute("user");
        Invoice newInvoice = invoiceFromJson(invoice);
        newInvoice.setUser(user);
        newInvoice = invoiceService.newInvoice(newInvoice);
        return invoiceToJson(newInvoice);
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
     * @param session the logged in user
     * @return the invoice in Json format.
     */
    @RequestMapping(value="/views/fetchInvoice", method = RequestMethod.POST)
    public String fetchInvoice(@RequestBody String invoiceNo, HttpSession session){
        User user = (User) session.getAttribute("user");
        Invoice invoice = invoiceFromJson(invoiceNo);
        invoice.setUser(user);
        invoice = invoiceService.fetchInvoice(invoice);
        return invoiceToJson(invoice);
    }

    /**
     * Gets the next invoiceNumber to use.
     * @return next avalible invoicenumber.
     */
    @RequestMapping(value = "/views/newInvoiceNo", method = RequestMethod.GET)
    public int getInvoiceNo(HttpSession session){
        User user = (User) session.getAttribute("user");
        return invoiceService.getInvoiceNo(user);
    }

    /**
     * Fetches all the invoices from the database
     * @param session the logged in user
     * @return Json string with all the invoices.
     */
    @RequestMapping(value = "/views/invoicelist", method = RequestMethod.GET)
    public String invoiceList(HttpSession session) {
        User user = (User)session.getAttribute("user");
        List<Invoice> invoices = invoiceService.fetchInvoiceList(user);
        return new Gson().toJson(invoices);
    }

    /**
     * Fetches the invoices for a specific client
     * @param clientId the Id for the client we want the invoices for.
     * @return the list of invoices in a Json string
     */
    @RequestMapping(value = "/views/clientInvoicelist", method = RequestMethod.POST)
    public String clientInvoiceList(@RequestBody String clientId) {
        Client clientID = new Gson().fromJson(clientId, Client.class);
        List<Invoice> invoices = invoiceService.fetchClientInvoiceList(clientID);
        return new Gson().toJson(invoices);
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
