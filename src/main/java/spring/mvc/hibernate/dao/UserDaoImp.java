package spring.mvc.hibernate.dao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import spring.mvc.hibernate.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
//         return entityManager.createQuery("from User").getResultList();
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> getUserByCar(String model, int series) {
//        Query query = sessionFactory.getCurrentSession()
//                .createQuery("from User where car.model=:model and car.series=:series")
//                .setParameter("model", model)
//                .setParameter("series", series);
//        return query.getResultList();
//    }
}