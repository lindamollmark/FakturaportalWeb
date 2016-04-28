package se.fakturaportal.persistense.dao;

import org.springframework.data.repository.CrudRepository;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.persistense.entity.ClientEntity;

import javax.transaction.Transactional;

/**
 * Created by Linda on 2016-03-27.
 */
@Transactional
public interface ClientDAO extends CrudRepository<ClientEntity, Long> {

}
