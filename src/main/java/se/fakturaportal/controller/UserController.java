package se.fakturaportal.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.fakturaportal.core.model.User;
import se.fakturaportal.core.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * Controller for handling the user
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private User user;


    /**
     * Will forward a question if the username and password if for a existing user
     * @param loginInfo the username and password
     * @param session   Session for the login user.
     * @return true if the user exist and false if anything is wrong
     */
    @RequestMapping(value = "/views/login", method = RequestMethod.POST)
    public Boolean login(@RequestBody String loginInfo, HttpSession session) {
        User userToLogin = new Gson().fromJson(loginInfo, User.class);
        userToLogin = userService.findUser(userToLogin);
        if (userToLogin != null) {
            session.setAttribute("user", userToLogin);
            return true;
        }
        return false;
    }

    /**
     * Adds a new user to the database
     * @param newUser the user information to be saved.
     * @return the saved user.
     */
    @RequestMapping(value = "/views/newUser", method = RequestMethod.POST)
    public String newUser(@RequestBody String newUser) {
        return saveUser(newUser);
    }

    @RequestMapping(value = "/views/updateUser", method = RequestMethod.POST)
    public String updateUser(@RequestBody String userToUpdate) {
        return saveUser(userToUpdate);
    }

    private String saveUser(@RequestBody String userToUpdate) {
        User user = new Gson().fromJson(userToUpdate, User.class);
        user = userService.saveUser(user);
        return new Gson().toJson(user);
    }

    @RequestMapping(value = "/views/username", method = RequestMethod.POST)
    public Boolean checkUsername(@RequestBody String username) {
        return userService.checkUsername(username);
    }

    @RequestMapping(value = "/views/fetchUser", method = RequestMethod.POST)
    public String fetchUser(@RequestBody String activeUser) {
        User user = new Gson().fromJson(activeUser, User.class);
        user = userService.findUser(user);
        return new Gson().toJson(user);
    }

//    @RequestMapping(value="views/saveLogo", method = RequestMethod.POST)
//    public void saveLogo(@RequestParam(value = "file", required = true) File file){
//        System.out.println("kommer hit!");
//
//    }
}
