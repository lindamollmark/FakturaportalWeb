package se.fakturaportal.controller;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.core.service.InvoiceService;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @RequestMapping(value = "/views/newInvoice", method = RequestMethod.POST)
    public void newInvoice(@RequestBody String invoice){
        Invoice newInvoice = new Gson().fromJson(invoice, Invoice.class);
        invoiceService.newInvoice(newInvoice);
    }
}
