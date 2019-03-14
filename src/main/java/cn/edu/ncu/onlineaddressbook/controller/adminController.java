package cn.edu.ncu.onlineaddressbook.controller;

import cn.edu.ncu.onlineaddressbook.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/13 14:32
 */
@RequestMapping("/admin")
@Controller
public class adminController {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    /**
     * 只有管理员有权限的访问的页面
     * 对用户信息进行审核
     * 对未审核通过的用户可以进行删除
     * 对审核通过用户可以禁用账号
     *
     * @return
     */
    @RequestMapping("/table")
    public String adminTable(HttpServletRequest request, Model model){


        String username= (String) request.getSession().getAttribute("username");
        logger.info("管理员登录：："+username);

        model.addAttribute("username",username);
        return "admin-table";
    }
}
