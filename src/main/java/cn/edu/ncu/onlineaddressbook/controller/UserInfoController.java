package cn.edu.ncu.onlineaddressbook.controller;

import cn.edu.ncu.onlineaddressbook.bean.User;
import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import cn.edu.ncu.onlineaddressbook.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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


    @PostMapping("/query/{type}")
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
    }

}
