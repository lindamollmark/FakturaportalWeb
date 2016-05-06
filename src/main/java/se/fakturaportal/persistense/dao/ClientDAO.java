package se.fakturaportal.persistense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import se.fakturaportal.core.model.Client;
import se.fakturaportal.persistense.entity.ClientEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Linda on 2016-03-27.
 */
@Transactional
public interface ClientDAO extends JpaRepository<ClientEntity, Integer> {

    public List<ClientEntity> findByClientNo(int clientNo);


    }
