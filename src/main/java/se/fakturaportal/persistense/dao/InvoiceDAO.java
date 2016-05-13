package se.fakturaportal.persistense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import se.fakturaportal.persistense.entity.ClientEntity;
import se.fakturaportal.persistense.entity.InvoiceEntity;

import java.util.List;

/**
 * Layer to speak with the database regarding invoices
 */
@Transactional
public interface InvoiceDAO extends JpaRepository<InvoiceEntity, Integer> {

    public List<InvoiceEntity> findByClientEntity(ClientEntity clientEntity);
    public InvoiceEntity findByInvoiceNo(int invoiceNo);

}
