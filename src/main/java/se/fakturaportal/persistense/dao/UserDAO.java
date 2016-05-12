package se.fakturaportal.persistense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.fakturaportal.persistense.entity.UserEntity;

import java.util.List;

/**
 * Created by Linda on 2016-05-12.
 */
public interface UserDAO extends JpaRepository<UserEntity, Integer> {

    public List<UserEntity> findByUsername(String username);
}
