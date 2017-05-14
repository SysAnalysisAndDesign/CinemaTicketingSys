package com.cinema_ticketing_sys.auth.user;

import com.cinema_ticketing_sys.user.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by huitianrui on 2017/5/13.
 * CinemaSysUserDetails 实现 UserDetails接口
 * UserDetails 是Spring Security中获取用户名、密码、权限等认证相关信息的接口
 */
public class CinemaSysUserDetails implements UserDetails {

    private User user;
    private String rolePrefix = "";

    public CinemaSysUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(rolePrefix + "USER"));
        grantedAuthorities.add(new SimpleGrantedAuthority(rolePrefix + "ANONYMOUS"));

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isEnable();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isEnable();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isEnable();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnable();
    }

    public String getRolePrefix() {
        return rolePrefix;
    }

    public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }

}
