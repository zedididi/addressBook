package cn.edu.ncu.onlineaddressbook.controller;

import cn.edu.ncu.onlineaddressbook.bean.User;
import cn.edu.ncu.onlineaddressbook.service.UserService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
     * @param pageNumber 当前第几页
     * @param pageSize   一页大小
     * @return
     */
    @PostMapping("/normal")
    @ResponseBody
    public List<User> getNormalUsers(@RequestParam(required = false)Integer pageNumber, @RequestParam(required = false)Integer pageSize){

        System.out.println(pageNumber+"    "+pageSize);

        if (pageNumber==null&&pageSize==null)
            return userService.getUsersByEnabledAndLocked(1,1);
        else
            return userService.getUsersByEnabledAndLocked(1, 1, pageNumber-1, pageSize).getContent();

    }

    /**
     * 得到页数 一页15条记录
     *
     * @return
     */
    @PostMapping("/normal/num")
    @ResponseBody
    public int getNormalNum(){

       /* int size=userService.getUsersByEnabledAndLocked(1,1).size();
        System.out.println("size::::::"+size);*/
        return userService.getUsersByEnabledAndLocked(1,1).size();
    }

    /**
     * 获取审核中用户
     *
     * @param pageNumber 当前第几页
     * @param pageSize   一页大小
     * @return
     */
    @ResponseBody
    @PostMapping("/disabled")
    public List<User> getDisabledUsers(@RequestParam(required = false)Integer pageNumber, @RequestParam(required = false)Integer pageSize){

        System.out.println(pageNumber+"    "+pageSize);

        if (pageNumber==null&&pageSize==null)
            return userService.getUserByEnabled(0);
        else
            return userService.getUserByEnabled(0,pageNumber-1, pageSize).getContent();

    }

    /**
     *得到页数 一页15条记录
     *
     * @return
     */
    @PostMapping("/disabled/num")
    @ResponseBody
    public int getDisabledNum(){

        int size=userService.getUserByEnabled(0).size();
        System.out.println("size::::::"+size);
        return userService.getUserByEnabled(0).size();
    }

    /**
     * 获取被禁止登录的用户
     *
     * @param pageNumber 当前第几页
     * @param pageSize   一页大小
     * @return
     */
    @ResponseBody
    @PostMapping("/locked")
    public List<User> getLockedUsers(@RequestParam(required = false)Integer pageNumber, @RequestParam(required = false)Integer pageSize){

        System.out.println(pageNumber+"    "+pageSize);

        if (pageNumber==null&&pageSize==null)
            return userService.getUserByLocked(0);
        else
            return userService.getUserByLocked(0,pageNumber-1, pageSize).getContent();

    }

    /**
     * 得到页数 一页15条记录
     *
     * @return
     */
    @PostMapping("/locked/num")
    @ResponseBody
    public int getLockedNum(){
        System.out.println("locked:::"+userService.getUserByLocked(0).size());
        return userService.getUserByLocked(0).size();
    }

    /**
     * 获取所有用户
     *
     * @param pageNumber 当前第几页
     * @param pageSize   一页大小
     * @return
     */
    @ResponseBody
    @PostMapping("/all")
    public List<User> getAllUsers(@RequestParam(required = false)Integer pageNumber, @RequestParam(required = false)Integer pageSize){

        if (pageNumber==null&&pageSize==null)
            return userService.getAllUsers();
        else
            return userService.getAllUsers(pageNumber-1, pageSize).getContent();

    }

    /**
     * 得到页数 一页15条记录
     *
     * @return
     */
    @PostMapping("/all/num")
    @ResponseBody
    public int getAllNum(){

        return getNum(userService.getAllUsers().size());

    }


    public int getNum(int size){

        int number;
        if (size==0)
            number=0;
        else if(size%15==0)
            number=size/15;
        else
            number=size/15+1;
        return number;
    }

}
