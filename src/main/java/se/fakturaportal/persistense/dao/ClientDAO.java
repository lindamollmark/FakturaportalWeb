package se.fakturaportal.persistense.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.persistense.entity.ClientEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 *  Layer to speak with the database regarding clients.
 */
@Transactional
public interface ClientDAO extends JpaRepository<ClientEntity, Integer> {

    public List<ClientEntity> findByClientNo(int clientNo);
    public List<ClientEntity> findByUserId(int userID);
    public List<ClientEntity> findByClientNoAndUserId(int clientNo, int userId);



}
