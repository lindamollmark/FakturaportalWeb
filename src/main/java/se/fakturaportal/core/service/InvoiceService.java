package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.core.model.Invoice;
import se.fakturaportal.core.model.User;
import se.fakturaportal.persistense.dao.ClientDAO;
import se.fakturaportal.persistense.dao.InvoiceDAO;
import se.fakturaportal.persistense.entity.ClientEntity;
import se.fakturaportal.persistense.entity.InvoiceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer for invoices, handles the logic
 */
@Service
public class InvoiceService {

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private ClientDAO clientDAO;

    /**
     * Method for saving new invoices
     *
     * @param newInvoice the invoice information to save
     * @return the saved invoice, with its new ID.
     */
    public Invoice newInvoice(Invoice newInvoice) {
        InvoiceEntity ie = new InvoiceEntity();
        ie = ie.fromModel(newInvoice);
        invoiceDAO.save(ie);
        Invoice invoice = ie.toModel();
        return invoice;
    }

    /**
     * Method to receive the next invoiceNo to use.
     *
     * @param user
     * @return the invoice number to use.
     */
    public int getInvoiceNo(User user) {
        List<InvoiceEntity> ie = invoiceDAO.findAllByUserIdOrderByInvoiceNoDesc(user.getId());
        if (ie.size() > 0) {
            int invoiceNo = ie.get(0).getInvoiceNo();
            return invoiceNo + 1;
        }
        return Integer.parseInt(user.getInvoiceNoStart());
    }

    /**
     * Method to fetch all the invoices for the user
     * * @param user The user that is logged in
     *
     * @return a list of invoices
     */
    public List<Invoice> fetchInvoiceList(User user) {
        List<InvoiceEntity> entityList = invoiceDAO.findAllByUserIdOrderByInvoiceNoAsc(user.getId());
        List<Invoice> invoiceList = new ArrayList<>();
        for (InvoiceEntity ie : entityList) {
            Invoice invoice = ie.toModel();
            invoiceList.add(invoice);
        }
        return invoiceList;
    }

    /**
     * Method to fetch an invoiceslist for a specific cklient.
     *
     * @param clientID the client id to fetch the invoices for.
     * @return a list of invoices.
     */
    public List<Invoice> fetchClientInvoiceList(Client clientID) {
        ClientEntity ce = clientDAO.findOne(clientID.getId());
        List<InvoiceEntity> entityList = invoiceDAO.findByClientEntity(ce);
        List<Invoice> invoiceList = new ArrayList<>();
        for (InvoiceEntity ie : entityList) {
            Invoice invoice = ie.toModel();
            invoiceList.add(invoice);
        }
        return invoiceList;
    }

    /**
     * Method to save an updated invoice.
     *
     * @param invoice the invoice information to save.
     */
    public void updateInvoice(Invoice invoice) {
        InvoiceEntity ie = invoiceDAO.findOne(invoice.getId());
        ie = ie.fromModel(invoice);
        invoiceDAO.save(ie);
    }

    /**
     * Method to fetch a specific invoice
     *
     * @param invoice class containing the invoiceNo and user.
     * @return the invoice.
     */
    public Invoice fetchInvoice(Invoice invoice) {
        InvoiceEntity ie = invoiceDAO.findByInvoiceNoAndUserId(invoice.getInvoiceNo(), invoice.getUser().getId());
        return ie.toModel();
    }
}