package se.fakturaportal.persistense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import se.fakturaportal.persistense.entity.UserEntity;

import java.util.List;

/**
 * Layer to speak with the database regarding the user
 */
public interface UserDAO extends JpaRepository<UserEntity, Integer> {

    public UserEntity findByUsername(String username);
}
