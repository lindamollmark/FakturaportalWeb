package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.User;
import se.fakturaportal.persistense.dao.UserDAO;
import se.fakturaportal.persistense.entity.UserEntity;
import se.fakturaportal.utilityClasses.SHA256;

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
        String loginpassword = encrypte(user.getPassword());
        if (ue != null) {
            String userpassword = ue.getPassword();
            if (loginpassword.equals(userpassword)) {
                User foundUser = ue.toModel();
                foundUser.setUsername(user.getUsername());
                foundUser.setPassword(user.getPassword());

                return foundUser;
            }

        } return null;
    }

    /**
     * Saves a new user
     * @param user the information to save
     * @return the saved user.
     */
    public User saveUser(User user) {
        user.setUsername(encrypte(user.getUsername()));
        user.setPassword(encrypte(user.getPassword()));
        UserEntity ue = new UserEntity();
        ue = ue.fromModel(user);
        userDAO.save(ue);
        User saved = ue.toModel();
        return saved;
    }

    /**
     * HelpMethod for encrypt the username and password
     * @param toencrypte the username/password you would like to encrypte
     * @return the encrypted String
     */
    private String encrypte(String toencrypte) {
        SHA256 encrypt = new SHA256(toencrypte);
        return encrypt.getHashValue();
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
    public User findActiveUser(User user) {
        UserEntity ue = getUserEntity(user.getUsername());
        String loginpassword = encrypte(user.getPassword());
        if (ue != null) {
            String userpassword = ue.getPassword();
            if (loginpassword.equals(userpassword)) {
                ue.setPassword(loginpassword);
                ue.setUsername(user.getUsername());
                return ue.toModel();
            }

        } return null;
    }

    /**
     * Help method for finding the userEntity by username
     * @param username The username to find
     * @return the result of the search.
     */
    private UserEntity getUserEntity(String username) {
        System.out.println(username + " username = " + encrypte(username));
        return userDAO.findByUsername(encrypte(username));
    }

}
