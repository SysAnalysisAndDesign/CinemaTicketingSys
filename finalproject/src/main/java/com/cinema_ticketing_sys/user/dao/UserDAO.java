package com.cinema_ticketing_sys.user.dao;

import com.cinema_ticketing_sys.user.entity.User;

/**
 * Created by huitianrui on 2017/5/13.
 */
public interface UserDAO {

    /**
     * 通过id查询用户
     * @param userId
     * @return User
     */
    User findUserById(int userId);

    /**
     * 保存或更新用户
     * @param user
     */
    void saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param user
     */
    void deleteUser(User user);

    /**
     * 通过id删除用户
     * @param id
     */
    void deleteUserById(int id);

    /**
     * 通过用户名查询用户
     * @param username
     * @return User
     */
    User findUserByName(String username);
}
