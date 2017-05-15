package com.cinema_ticketing_sys.user.service;

import com.cinema_ticketing_sys.user.callback.UserRegisterCallback;
import com.cinema_ticketing_sys.user.entity.User;

import java.util.Map;

/**
 * Created by huitianrui on 2017/5/13.
 */
public interface UserService {

    /**
     * 通过用户名查询用户
     * @param username
     * @return User
     */
    User findUserByUsername(String username);

    /**
     * 注册接口
     * @param userInfo 用户注册信息
     * @param callback 注册回调接口
     */
    void register(Map<String, Object> userInfo, UserRegisterCallback callback);

    /**
     * 检查当前用户名是否已被注册
     *
     * @param username 用户名
     * @return true则表示该用户名已被注册
     */
    boolean checkUserNameRegistered(String username);

    /**
     * 通过id删除用户
     * @param id
     */
    void deleteUserById(int id);

}
