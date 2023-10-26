package com.champion.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor

public class LoginUser implements UserDetails {

    private User user;

    private List<String> permissions;

    public LoginUser(User user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    //作为成员变量，只加载一次就可以
    @JSONField(serialize = false)//使该属性不被序列化到redis中
    private List<SimpleGrantedAuthority> authorities;

    //springSecurity使用时不会自动调用该类中的属性，所以我们应该将设置的权限信息放入到getAuthorities（）方法中

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        ArrayList<GrantedAuthority> newList = new ArrayList<>();
//        //把permission中string权限信息封装成他的一个实现类SimpleGrantedAuthority
//        for (String permission : permissions) {
//            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(permission);
//            newList.add(authority);
//        }

        if (authorities!=null){
            return authorities;
        }
        //使用函数式变成
        authorities = permissions.stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    //是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //凭证是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
