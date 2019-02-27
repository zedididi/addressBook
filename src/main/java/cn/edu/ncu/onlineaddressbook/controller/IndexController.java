package cn.edu.ncu.onlineaddressbook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @Author： LiuZedi
 * @Date： 2019/2/27 8:44
 */

@Controller
public class IndexController {


    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @GetMapping("")
    public String login(){
        return "login";
    }


    @PostMapping("/lo")
    public String login(String id,String password){
     //   if ()

        return null;
    }
}
