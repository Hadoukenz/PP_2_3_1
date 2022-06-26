package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;


    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> res = entityManager.createQuery("SELECT c FROM User c", User.class);
        return res.getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException();
        }
        return user;
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        entityManager.remove(findUserById(id));
    }
}
