package cn.edu.ncu.onlineaddressbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/13 14:32
 */
@RequestMapping("/admin")
@Controller
public class adminController {

    /**
     * 只有管理员有权限的访问的页面
     * 对用户信息进行审核
     * 对未审核通过的用户可以进行删除
     * 对审核通过用户可以禁用账号
     *
     * @return
     */
    @RequestMapping("/table")
    public String adminTable(){
        return "admin-table";
    }
}
