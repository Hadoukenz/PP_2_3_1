package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> showAllUsers();
    void addUser(User user);
    void updateUser(User user);
    User findUserById(Long id);
    void deleteUserById(Long id);
}