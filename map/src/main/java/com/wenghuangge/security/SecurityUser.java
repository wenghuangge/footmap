package com.wenghuangge.security;

import com.wenghuangge.bean.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ProjectName footmap
 * @ClassName SecurityUser
 * @Date 2021/2/22 16:09
 * @Author wenghuangge
 * @Version 1.0
 */
public class SecurityUser extends User implements UserDetails {
    private static final long serivalVersionUID=1L;

    public SecurityUser(User user){
        if(user!=null){
            this.setId(user.getId());
            this.setUsername(user.getUsername());
            this.setPassword(user.getPassword());
            if(user.getPhone()!=null){
                this.setPhone(user.getPhone());
            }
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       Collection<GrantedAuthority> authorities=new ArrayList<>();
       String username=this.getUsername();
       if(username!=null){
           SimpleGrantedAuthority authority=new SimpleGrantedAuthority(username);
           authorities.add(authority);
       }
       return authorities;
    }

    /**
     * 账户是否过期,过期无法验证
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //指定用户是否解锁 锁定的用户无法进行身份验证
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //指定是否已过期的用户的凭据，过期的凭据防止认证
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //是否可用,禁止的用户不能身份验证
    @Override
    public boolean isEnabled() {
        return true;
    }
}
