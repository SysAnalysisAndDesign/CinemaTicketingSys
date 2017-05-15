package com.cinema_ticketing_sys.user.dao;

import com.cinema_ticketing_sys.support.base.BaseDAOImpl;
import com.cinema_ticketing_sys.user.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by huitianrui on 2017/5/13.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }

    @Override
    public User findUserById(int userId) {
        return get(userId);
    }

    @Override
    public void saveOrUpdateUser(User user) {
        save(user);
    }

    @Override
    public void deleteUser(User user) {
        delete(user);
    }

    @Override
    public void deleteUserById(int id) {delete(User.class, id);}

    @Override
    public User findUserByName(String username) {
        return findByUnique("userName", username);
    }

}
