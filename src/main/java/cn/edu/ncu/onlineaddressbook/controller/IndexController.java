package cn.edu.ncu.onlineaddressbook.controller;

import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @Author： LiuZedi
 * @Date： 2019/2/27 8:44
 */

@Controller

public class IndexController {


    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/index")
    public String index(){
        return "/admin/admin-index";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }
    @GetMapping("/login-error")
    public String loginError(){
        return "login-error";
    }
    @GetMapping("/error")
    public String error(){
        return "/admin/admin-404";
    }
  /*  public String login(String id, String password,String remember){
     //   if ()

        System.out.println(id+password+remember);
        return "login";
    }
*/
}
