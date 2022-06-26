package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> showAllUsers() {
        return userDAO.showAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDAO.deleteUserById(id);
    }

    @Override
    @Transactional
    public User findUserById(Long id) {
        return userDAO.findUserById(id);
    }
}
