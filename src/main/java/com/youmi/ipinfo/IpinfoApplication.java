package com.youmi.ipinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.youmi.ipinfo", "com.youmi.service"})
public class IpinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpinfoApplication.class, args);
    }

}

