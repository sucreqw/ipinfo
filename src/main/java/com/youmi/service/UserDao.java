package com.youmi.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserDao {

    private Map<String,Integer> map;

    public UserDao() {
        map=new HashMap<>();
    }

    public int islogin(String ip){
        Integer i;
        i= map.get(ip);
        if(i !=null) {

            i++;
        }else{
            i=1;

        }
        map.put(ip, i);

        return i.intValue();
    }

    public UserDetails loadUserByUsername(String name){
        UserDetails user=new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public String getUsername() {
                return null;
            }

            @Override
            public boolean isAccountNonExpired() {
                return false;
            }

            @Override
            public boolean isAccountNonLocked() {
                return false;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return false;
            }

            @Override
            public boolean isEnabled() {
                return false;
            }
        };

        return user;
    }
}
