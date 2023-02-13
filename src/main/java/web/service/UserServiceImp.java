package web.service;

import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return userDao.getAll() ;
    }
    @Transactional
    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Transactional
    @Override
    public void update(long id, User updateUser) {
        userDao.update(id,updateUser);

    }
    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);

    }
    @Transactional
    @Override
    public void delete(long id) {
    userDao.delete(id);
    }
}
