package spring.mvc.hibernate.dao;

import org.springframework.stereotype.Repository;
import spring.mvc.hibernate.model.Role;
import spring.mvc.hibernate.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImp implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getListRole() {
        return entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role getById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getByName(String roleName) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT role FROM Role role WHERE role.role = :role", Role.class);
        return query
                .setParameter("role", roleName)
                .getSingleResult();
    }

    @Override
    public Set<Role> getRoleSet(String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (String roles : role) {
            roleSet.add(getByName(roles));
        }
        return roleSet;
    }
}
