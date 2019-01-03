package com.youmi.ipinfo;

import com.youmi.service.UserDao;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
       System.out.println(user.islogin());
        return "您好" +nick + ",您的ip地址是：" + ip ;
    }
}
