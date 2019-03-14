package cn.edu.ncu.onlineaddressbook.service;

import cn.edu.ncu.onlineaddressbook.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/13 23:21
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getAllUsers() {
        ///List<User> users=userService.getAllUsers(0,2).getContent();
        int users=15/15;
        System.out.println(users);
    }
}