package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.User;
import se.fakturaportal.persistense.dao.UserDAO;
import se.fakturaportal.persistense.entity.UserEntity;
import se.fakturaportal.utilityClasses.SHA256;

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
    public User findUser(User user) {
        SHA256 decrypt1 = new SHA256(user.getUsername());
        UserEntity ue = userDAO.findByUsername(decrypt1.getHashValue());
        SHA256 decrypt2 = new SHA256(user.getPassword());
       String loginpassword = decrypt2.getHashValue();
        if (ue != null) {
            String userpassword = ue.getPassword();
            if (loginpassword.equals(userpassword)) {
                return ue.toModel();
            }

        } return null;
    }
    /**
     * Saves a new user
     * @param user the information to save
     * @return the saved user.
     */
    public User saveUser(User user) {
        SHA256 decrypt1 = new SHA256(user.getUsername());
        user.setUsername(decrypt1.getHashValue());
        SHA256 decrypt2 = new SHA256(user.getPassword());
        user.setPassword(decrypt2.getHashValue());
        UserEntity ue = new UserEntity();
        ue = ue.fromModel(user);
        userDAO.save(ue);
        User saved = ue.toModel();
        return saved;
    }

    public Boolean checkUsername(String username) {
        SHA256 decrypt1 = new SHA256(username);
        UserEntity ue = userDAO.findByUsername(decrypt1.getHashValue());
        if(ue == null){
            return false;
        }
        return true;
    }
}
