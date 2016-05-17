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
        UserEntity ue = getUserEntity(user.getUsername());
        String loginpassword = decrypte(user.getPassword());
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
        user.setUsername(decrypte(user.getUsername()));
        user.setPassword(decrypte(user.getPassword()));
        UserEntity ue = new UserEntity();
        ue = ue.fromModel(user);
        userDAO.save(ue);
        User saved = ue.toModel();
        return saved;
    }

    /**
     * HelpMethod for decrypt the username and password
     * @param todecrypte the username/password you would like to decrypte
     * @return the decrypted String
     */
    private String decrypte(String todecrypte) {
        SHA256 decrypt = new SHA256(todecrypte);
        return decrypt.getHashValue();
    }


    /**
     * Method to see if the username exists
     * @param username the username the user would like to have
     * @return true if its already taken or false if its free to use.
     */
    public Boolean checkUsername(String username) {
        UserEntity ue = getUserEntity(username);
        if(ue == null){
            return false;
        }
        return true;
    }

    /**
     * Help method for finding the userEntity by username
     * @param username The username to find
     * @return the result of the search.
     */
    private UserEntity getUserEntity(String username) {
        return userDAO.findByUsername(decrypte(username));
    }
}
