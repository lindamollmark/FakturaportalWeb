package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.core.model.InvoiceId;
import se.fakturaportal.core.model.TestId;
import se.fakturaportal.persistense.dao.ClientDAO;
import se.fakturaportal.persistense.dao.InvoiceDAO;
import se.fakturaportal.persistense.entity.ClientEntity;
import se.fakturaportal.persistense.entity.InvoiceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linda on 2016-05-03.
 */
@Service
public class InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private ClientDAO clientDAO;

    public Invoice newInvoice(Invoice newInvoice) {
        InvoiceEntity ie = new InvoiceEntity();
        ie = ie.fromModel(newInvoice);
        invoiceDAO.save(ie);
        Invoice invoice = ie.toModel();
        return invoice;
    }


    public int getInvoiceNo() {
        List<InvoiceEntity> ie = invoiceDAO.findAll(new Sort(Sort.Direction.DESC, "invoiceNo"));
        if(ie.size()> 0){
            int invoiceNo = ie.get(0).getInvoiceNo();
            return invoiceNo+1 ;

        }
        return 1;

    }

    public List<Invoice> fetchInvoiceList() {
        List<InvoiceEntity> entityList = invoiceDAO.findAll(new Sort(Sort.Direction.ASC, "invoiceNo"));
        List<Invoice> invoiceList = new ArrayList<>();
        for(InvoiceEntity ie: entityList){
            Invoice invoice = ie.toModel();
            invoiceList.add(invoice);
        }
        return invoiceList;
    }

    public List<Invoice> fetchClientInvoiceList(TestId clientID) {
        ClientEntity ce = clientDAO.findOne(Integer.parseInt(clientID.getClientId()));
        List<InvoiceEntity> entityList = invoiceDAO.findByClientEntity(ce);
        List<Invoice> invoiceList = new ArrayList<>();
        for(InvoiceEntity ie: entityList){
            Invoice invoice = ie.toModel();
            invoiceList.add(invoice);
        }
        return invoiceList;
    }

    public void updateInvoice(Invoice invoice) {
        InvoiceEntity ie = invoiceDAO.findOne(invoice.getId());
        ie = ie.fromModel(invoice);
        invoiceDAO.save(ie);
    }

    public Invoice fetchInvoice(Invoice invoice) {
        InvoiceEntity ie = invoiceDAO.findByInvoiceNo(invoice.getInvoiceNo());
       return ie.toModel();
    }
}
