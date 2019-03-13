package cn.edu.ncu.onlineaddressbook.controller;

import cn.edu.ncu.onlineaddressbook.bean.User;
import cn.edu.ncu.onlineaddressbook.service.UserService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/7 21:31
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取正常用户
     *
     * @param param 1:分页 0：不分页
     * @return
     */
    @PostMapping("/normal")
    @ResponseBody
    public List<User> getNormalUsers(String param){

        if ("1".equals(param))
            return userService.getUsersByEnabledAndLocked(1,1);
        else
            return userService.getUsersByEnabledAndLocked(1,1);
    }

    /**
     * 获取审核中用户
     *
     * @param param 1:分页 0：不分页
     * @return
     */
    @ResponseBody
    @PostMapping("/disabled")
    public List<User> getDisabledUsers(String param){
        return userService.getUserByEnabled(0);
    }

    /**
     * 获取被禁止登录的用户
     *
     * @param param 1:分页 0：不分页
     * @return
     */
    @ResponseBody
    @PostMapping("/locked")
    public List<User> getLockedUsers(){
        return userService.getUserByLocked(0);
    }


    /**
     * 获取所有用户
     *
     * @param param 1:分页 0：不分页
     * @return
     */
    @ResponseBody
    @PostMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


}
