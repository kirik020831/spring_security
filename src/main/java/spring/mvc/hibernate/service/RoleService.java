package spring.mvc.hibernate.service;

import spring.mvc.hibernate.model.Role;
import spring.mvc.hibernate.model.User;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<User> getListRole();

    void add(Role role);

    void update(Role role);

    Role getById(int id);

    Role getByName(String roleName);

    Set<Role> getRoleSet(String[] role);
}
