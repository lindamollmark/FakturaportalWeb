package se.fakturaportal.persistense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.fakturaportal.persistense.entity.ClientEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 *  Layer to speak with the database regarding clients.
 */
@Transactional
public interface ClientDAO extends JpaRepository<ClientEntity, Integer> {

    List<ClientEntity> findByClientNo(int clientNo);

    List<ClientEntity> findByUserIdOrderByClientNoAsc(int userID);

    List<ClientEntity> findByClientNoAndUserId(int clientNo, int userId);



}
