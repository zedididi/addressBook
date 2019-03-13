package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/7 17:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void getUsersByName(){


     //   System.out.println(userRepository.getUsersByName("刘泽迪"));
    }

    @Test
    public void updateLoginTimeOfUser(){
        userRepository.updateLoginTimeOfUser(new Timestamp(new Date().getTime()),"652928");
       // System.out.println(userRepository.getUserByUsername("652928"));
    }
}