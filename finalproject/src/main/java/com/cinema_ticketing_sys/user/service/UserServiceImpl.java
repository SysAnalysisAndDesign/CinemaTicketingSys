package com.cinema_ticketing_sys.user.service;

import com.cinema_ticketing_sys.user.callback.UserRegisterCallback;
import com.cinema_ticketing_sys.user.dao.UserDAO;
import com.cinema_ticketing_sys.user.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by huitianrui on 2017/5/13.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findUserByName(username);
    }

    @Override
    public void register(Map<String, Object> userInfo, UserRegisterCallback callback) {
        User user = null;
        user = checkAndSetUserInfo(userInfo, callback);
        if (user != null) {
            userDAO.saveOrUpdateUser(user);
            callback.onRegisterSucceed(user);
        }
    }

    @Override
    public boolean checkUserNameRegistered(String username) {
        return findUserByUsername(username) != null;
    }

    @Override
    public void deleteUserById(int id) {
        userDAO.deleteUserById(id);
    }

    /**
     * 检查用户注册信息
     * 没有问题就设置用户属性并返回对象
     * @param userInfo
     * @param callback
     * @return User
     */
    private User checkAndSetUserInfo(Map<String, Object> userInfo, UserRegisterCallback callback) {
        if (userInfo == null) {
            throw new NullPointerException("UserInfo cannot be null");
        }
        String username = (String) userInfo.get("username");
        String password = (String) userInfo.get("password");
        if (username == null || username.isEmpty()) {
            registerFail(callback, "用户名不能为空");
            return null;
        }
        if (checkUserNameRegistered(username)) {
            registerFail(callback, "该用户名[" + username + "]已被注册");
            return null;
        }
        if (password == null || password.isEmpty()) {
            registerFail(callback, "密码不能为空");
            return null;
        }
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        return user;
    }

    /**
     * 注册失败
     * @param callback
     * @param msg
     */
    private static void registerFail(UserRegisterCallback callback, String msg) {
        if (callback != null) {
            logger.warn(msg);
            callback.onRegisterFail(msg);
        }
    }
}
