package se.fakturaportal.persistense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import se.fakturaportal.persistense.entity.InvoiceEntity;

/**
 * Created by Linda on 2016-05-03.
 */
@Transactional
public interface InvoiceDAO extends JpaRepository<InvoiceEntity, Long> {
}
