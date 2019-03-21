package cn.edu.ncu.onlineaddressbook.service;

import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
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
 * @Date： 2019/3/21 15:33
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRedisServiceTest {

    @Autowired
    UserInfoRedisService userInfoRedisService;

    @Test
    public void getUserByUsername() {

        UserInfo userInfo=userInfoRedisService.getUserByUsername("640832");
        System.out.println("UserInfo:::::::::"+userInfo);
    }

    @Test
    public void getUsersByOption() {
        List<Object> list= (List<Object>) userInfoRedisService.getUsersByOption("name","刘泽迪");
        int time=0;
        for (Object o:list){
            System.out.println(o);
            System.out.println("time:"+time++);
        }
        System.out.println("list:::::::::"+list);
    }
}