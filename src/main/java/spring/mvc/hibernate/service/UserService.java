package spring.mvc.hibernate.service;

import spring.mvc.hibernate.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
}
