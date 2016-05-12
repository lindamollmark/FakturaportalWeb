package se.fakturaportal.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.fakturaportal.core.model.User;
import se.fakturaportal.persistense.dao.UserDAO;
import se.fakturaportal.persistense.entity.UserEntity;

import java.util.List;

/**
 * Created by Linda on 2016-05-12.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;
    public User findUser(String usernamne) {
        List<UserEntity> ue = userDAO.findByUsername(usernamne);
        User user = ue.get(0).toModel();
        return user;
    }

    public User saveUser(User user) {
        UserEntity ue = new UserEntity();
        ue = ue.fromModel(user);
        userDAO.save(ue);
        User saved = ue.toModel();
        return saved;
    }
}
