package cn.edu.ncu.onlineaddressbook.util;

import cn.edu.ncu.onlineaddressbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/27 15:32
 */

@Component
public class IdUtil {

    @Autowired
    private UserService userService;

    public String createId(){

        String id;
        Random random=new Random();
       int j=0;

       do{
           id="6";
           for (int i=0;i<5;i++)
               id+=random.nextInt(10);

           j++;
           System.out.println("第"+j+"次生成账号：：： "+id);
       }while (userService.getUserByUsername(id)==null);

       return id;
    }

}
