package se.fakturaportal.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.core.model.InvoiceNo;
import se.fakturaportal.core.model.TestId;
import se.fakturaportal.core.service.InvoiceService;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(value = "/views/newInvoice", method = RequestMethod.POST)
    public void newInvoice(@RequestBody String invoice){
        Invoice newInvoice = new Gson().fromJson(invoice, Invoice.class);
        invoiceService.newInvoice(newInvoice);
    }

    @RequestMapping(value = "/views/newInvoiceNo", method = RequestMethod.GET)
    public int getInvoiceNo(){
        int invoiceNo = invoiceService.getInvoiceNo();

        return invoiceNo;
    }

    @RequestMapping(value = "/views/invoicelist", method = RequestMethod.GET)
    public String invoiceList() {
        List<Invoice> invoices = invoiceService.fetchInvoiceList();

        String json = new Gson().toJson(invoices);
        return json;
    }

    @RequestMapping(value = "/views/clientInvoicelist", method = RequestMethod.POST)
    public String clientInvoiceList(@RequestBody String client) {
        TestId clientID = new Gson().fromJson(client, TestId.class);
        List<Invoice> invoices = invoiceService.fetchClientInvoiceList(clientID);

        String json = new Gson().toJson(invoices);
        return json;
    }

    @RequestMapping(value= "views/updateInvoice", method = RequestMethod.POST)
    public void updateInvoice(@RequestBody String invoiceToUpdate){
        Invoice invoice = new Gson().fromJson(invoiceToUpdate, Invoice.class);
        invoiceService.updateInvoice(invoice);
    }
}
