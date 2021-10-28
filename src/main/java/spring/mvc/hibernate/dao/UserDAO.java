package spring.mvc.hibernate.dao;

import spring.mvc.hibernate.model.User;

import java.util.List;

public interface UserDAO {
//    void add(User user);

    List<User> listUsers();

//    List<User> getUserByCar(String model, int series);
}
