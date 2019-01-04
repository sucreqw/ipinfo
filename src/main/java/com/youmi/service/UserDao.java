package com.youmi.service;

import org.springframework.stereotype.Service;

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
}
