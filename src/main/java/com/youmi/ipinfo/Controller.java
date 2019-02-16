package com.youmi.ipinfo;

import com.youmi.service.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class Controller {

    @Autowired
    UserDao user;

    @RequestMapping(value = "/submit", method= RequestMethod.POST)
    public String index(HttpServletRequest request){
        String nick=request.getParameter("nick");
        nick=nick==null?"":nick;
        String ip=request.getRemoteAddr();
        System.out.println(nick +"|" + ip);
       //System.out.println(user.islogin());
        int count=user.islogin(ip);
        return "您好" + nick + ",您的ip地址是：" + ip + ",提交次数："+ count;
    }

    @RequestMapping(value = "/facebook/callback",method = RequestMethod.GET)
    public String callback(HttpServletRequest request){
        String code=request.getRequestURI();//request.getParameter("access_token");
        return "收到callback"+code ;
    }
    @RequestMapping("/user")

    public String getUsers() {
        return "Hello Spring Security";
    }

}
