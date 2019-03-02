package cn.edu.ncu.onlineaddressbook.bean;

import cn.edu.ncu.onlineaddressbook.service.RoleService;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/3/1 8:30
 */

public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private boolean enabled;

    //包含着用户对应的所有Role，在使用时调用者给对象注入roles
    private List<Role> roles;

    @Autowired
    private RoleService roleService;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(User user){
        this.username=user.getUsername();
        this.password=user.getPassword();
        if (user.getEnabled()==0)
            this.enabled=false;
        else
            this.enabled=true;
    }

    public UserDetailsImpl(User user,List<Role> roles){
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.roles=roles;
        if (user.getEnabled()==0)
            this.enabled=false;
        else
            this.enabled=true;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    //返回用户所有角色的封装，一个Role对应一个GrantedAuthority
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities=new ArrayList<>();
        for (Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    //判断账号是否已经过期，默认没有过期
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    //判断账号是否被锁定，默认没有锁定
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    //判断信用凭证是否过期，默认没有过期
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    //判断账号是否可用，默认可用
    public boolean isEnabled() {
        return enabled;
    }


}
