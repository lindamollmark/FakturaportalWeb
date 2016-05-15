package se.fakturaportal.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.fakturaportal.core.model.User;
import se.fakturaportal.core.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Controller for handeling the user
 */
@RestController

public class UserController {

    @Autowired
    private UserService userService;
    private User user;
    HttpSession session;

    /**
     * Will forward a question if the username and password if for a existing user
     * @param loginInfo the username and password
     * @return true if the user exist and false if anything is wrong
     */
    @RequestMapping(value = "/views/login", method = RequestMethod.POST)
    public Boolean login(@RequestBody String loginInfo){
        User userToLogin = new Gson().fromJson(loginInfo, User.class);
       Boolean exists = userService.findUser(userToLogin);
        if(exists){

        }
       return exists;
    }

    /**
     * Adds a new user to the database
     * @param newUser the user information to be saved.
     * @return the saved user.
     */
    @RequestMapping(value="/views/newUser", method = RequestMethod.POST)
    public String newUser(@RequestBody String newUser){
        User user = new Gson().fromJson(newUser, User.class);
        user = userService.saveUser(user);
        String json = new Gson().toJson(user);
        return json;
    }
}
