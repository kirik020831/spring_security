package spring.mvc.hibernate.service;

import spring.mvc.hibernate.model.User;

import java.util.List;

public interface UserService {
    List<User> getListUsers();

    void saveUser(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);

    User getUser(String userName);
}
