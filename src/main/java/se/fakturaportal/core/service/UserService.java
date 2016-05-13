package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.User;
import se.fakturaportal.persistense.dao.UserDAO;
import se.fakturaportal.persistense.entity.UserEntity;

import java.util.List;

/**
 * Class for preforming the logic and transform the entity to a model and the oposit around
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    /**
     * Method for investigating if the user exists in the database.
     * @param user the login information sent in to search for.
     * @return true if the user exists.
     */
    public Boolean findUser(User user) {
        List<UserEntity> ue = userDAO.findByUsername(user.getUsername());
        String loginpassword = user.getPassword();
        if (ue.size() > 0) {
            String userpassword = ue.get(0).getPassword();
            if (loginpassword.equals(userpassword)) {
                return true;
            }

        } return false;
    }
    /**
     * Saves a new user
     * @param user the information to save
     * @return the saved user.
     */
    public User saveUser(User user) {
        UserEntity ue = new UserEntity();
        ue = ue.fromModel(user);
        userDAO.save(ue);
        User saved = ue.toModel();
        return saved;
    }
}
