package cn.edu.ncu.onlineaddressbook.controller;

import cn.edu.ncu.onlineaddressbook.bean.User;
import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import cn.edu.ncu.onlineaddressbook.service.UserInfoService;
import cn.edu.ncu.onlineaddressbook.service.UserRoleService;
import cn.edu.ncu.onlineaddressbook.service.UserService;
import cn.edu.ncu.onlineaddressbook.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


    @Autowired
    private IdUtil idUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserRoleService userRoleService;

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

    @PostMapping("/re")
    public String  register(UserInfo userInfo,Model model){

        String message=idUtil.createId();
        userInfo.setUsername(message);
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getName());
        if (!(userService.insertUser(user)==1&&userInfoService.insertUserInfo(userInfo)==1&&userRoleService.insertUserRole(message,1)==1)) {
            message = "注册失败      请再次注册！！！";
            logger.info(message);
        }else
            logger.info("注册成功：{}",userInfo);

        model.addAttribute("message",message);

        return "landing";
    }

    @GetMapping("/login-error")
    public String loginError(){
        return "login-error";
    }

    @GetMapping("/error")
    public String error(){
        return "/admin/admin-404";
    }
}
