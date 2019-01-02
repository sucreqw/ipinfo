package com.youmi.ipinfo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {


    @RequestMapping(value = "/submit", method= RequestMethod.POST)
    public String index(HttpServletRequest request){
        String nick=request.getParameter("nick");
        String ip=request.getRemoteAddr();
        System.out.println(nick +"|" + ip);
        return "您好" +nick + ",您的ip地址是：" + ip ;
    }
}
