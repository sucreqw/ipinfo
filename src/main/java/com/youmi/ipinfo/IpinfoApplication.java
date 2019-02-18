package com.youmi.ipinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
@ComponentScan(basePackages={"com.youmi.ipinfo", "com.youmi.service","com.youmi.oauth2"})
public class IpinfoApplication {

    public static void main(String[] args) {

        SpringApplication.run(IpinfoApplication.class, args);
    }

}

