package com.cinema_ticketing_sys.auth.security;

import com.cinema_ticketing_sys.auth.user.CinemaSysUserDetails;
import com.cinema_ticketing_sys.user.entity.User;
import com.cinema_ticketing_sys.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by huitianrui on 2017/5/13.
 * 实现UserDetailsService接口
 * 登录认证的时Spring Security通过UserDetailsService的loadUserByUsername()方法获取对应的UserDetails进行认证
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    private String rolePrefix = "";

    @Override
    public UserDetails loadUserByUsername(String username) throws RuntimeException {
        User user = null;
        try {
            user = userService.findUserByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException("查询用户数据库出错");
        }

        if (user == null) {
            throw new RuntimeException("账号[" + username + "]不存在！");
        }

        CinemaSysUserDetails cinemaSysUserDetails = new CinemaSysUserDetails(user);
        cinemaSysUserDetails.setRolePrefix(rolePrefix);
        return cinemaSysUserDetails;
    }

    public String getRolePrefix() {
        return rolePrefix;
    }

    public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }
}
