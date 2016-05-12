package se.fakturaportal.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.fakturaportal.core.model.User;
import se.fakturaportal.core.service.UserService;

/**
 * Created by Linda on 2016-05-12.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private User user;

    @RequestMapping(value = "/views/login", method = RequestMethod.POST)
    public Boolean login(@RequestBody String loginInfo){
        User userToLogin = new Gson().fromJson(loginInfo, User.class);

        user = userService.findUser(userToLogin.getUsername());

        if (user != null) {

            return true;
        } else {
            return false;
        }
    }
    @RequestMapping(value="/views/newUser", method = RequestMethod.POST)
    public String newUser(@RequestBody String newUser){
        User user = new Gson().fromJson(newUser, User.class);
        user = userService.saveUser(user);
        return newUser;
    }
}
