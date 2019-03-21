package cn.edu.ncu.onlineaddressbook.controller;

import cn.edu.ncu.onlineaddressbook.bean.User;
import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import cn.edu.ncu.onlineaddressbook.service.UserInfoRedisService;
import cn.edu.ncu.onlineaddressbook.service.UserInfoService;
import cn.edu.ncu.onlineaddressbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/1 22:09
 */

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoRedisService userInfoRedisService;

    @PostMapping("/query/{type}")
    @ResponseBody
    public List<UserInfo>  queryUserInfo(@PathVariable String type, String info){

        List<UserInfo> userInfoList=new ArrayList<>();

        switch(type){
            case "id": userInfoList.add(userInfoRedisService.getUserByUsername(info.trim())) ; return userInfoList;
            default: return (List<UserInfo>) userInfoRedisService.getUsersByOption(type,info.trim());
        }

    }

  /*  @PostMapping("/query/{type}")
    @ResponseBody
    public List<UserInfo>  QueryUserInfo(@PathVariable String type, String info){

        List<UserInfo> userInfoList=new ArrayList<>();

        switch(type){
            case "id": userInfoList.add(userInfoService.getUserInfoByUsername(1,info.trim())) ; return userInfoList;
            case "name":return userInfoService.getUserInfoByName(1,info.trim());
            case "year":return userInfoService.getUserInfoByEnYear(1,info.trim());
            case "major":return userInfoService.getUserInfoByMajor(1,info.trim());
            case "classs":return userInfoService.getUserInfoByClasss(1,info.trim());
        }

        return null;
    }*/

    @PostMapping("/change")
    public String changeUserInfo(UserInfo userInfo, Model model){

        System.out.println("CHANGE++userInfo"+userInfo);
        String status;

        UserInfo oldUserInfo=userInfoRedisService.getUserByUsername(userInfo.getUsername());
        if (userInfoService.updateUser(userInfo)==1&&userService.updateNameOfUser(userInfo.getName(),userInfo.getUsername())==1) {
            userInfoRedisService.updateUserInfo(oldUserInfo,userInfo);
            status = "修改成功!!!";
        }
        else
            status="修改失败!!!";

        model.addAttribute("status", status);
        model.addAttribute("tip","以上是你的账号登录错误信息！！！");
        return "landing";

    }


}
