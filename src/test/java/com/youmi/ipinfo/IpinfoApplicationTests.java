package com.youmi.ipinfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpinfoApplicationTests {

    @Test
    public void contextLoads() {

        System.out.println("start");
        Map<String, Integer> map;
        map = new HashMap<>();
        map.put("127.0.0.1", 1);

        System.out.println(map.get("127.0.0.1"));
    }

}

