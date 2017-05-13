package com.cinema_ticketing_sys.user.callback;

import com.cinema_ticketing_sys.user.entity.User;

/**
 * Created by huitianrui on 2017/5/13.
 * 用户注册处理回调接口
 */
public interface UserRegisterCallback {

    /**
     * 注册失败回调方法
     * @param msg 注册失败反馈信息
     */
    void onRegisterFail(String msg);

    /**
     * 注册成功回调方法
     * @param user 注册成功的用户
     */
    void onRegisterSucceed(User user);

}
