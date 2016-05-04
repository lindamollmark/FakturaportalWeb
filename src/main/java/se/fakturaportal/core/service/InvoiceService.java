package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.persistense.dao.InvoiceDAO;
import se.fakturaportal.persistense.entity.InvoiceEntity;

/**
 * Created by Linda on 2016-05-03.
 */
@Service
public class InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    public void newInvoice(Invoice newInvoice) {
        InvoiceEntity ie = new InvoiceEntity();
        ie = ie.fromModel(newInvoice);
        invoiceDAO.save(ie);
    }


}
