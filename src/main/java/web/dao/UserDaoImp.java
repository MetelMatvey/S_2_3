package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
     return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();

    }

    @Override
    public void save(User user) {
         entityManager.persist(user);

    }

    @Override
    public  User get(long id) {
        return entityManager.find(User.class,id);

    }

    @Override
    public void update(long id,User updateUser) {

        User user = entityManager.find(User.class,id);
        user.setName(updateUser.getName());
        user.setAge(updateUser.getAge());
        user.setEmail(updateUser.getEmail());


    }


    @Override
    public void delete(long id) {
          entityManager.createQuery("DELETE FROM User WHERE id= ?1").setParameter(1,id).executeUpdate();
    }
}
