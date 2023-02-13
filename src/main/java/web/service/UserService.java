package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
        public List<User> getAll();
        public User get(long id);
        public void update(long id,User updateUser);
        public void save(User user);
        public void delete(long id);
}
