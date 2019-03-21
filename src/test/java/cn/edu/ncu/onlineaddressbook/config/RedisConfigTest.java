package cn.edu.ncu.onlineaddressbook.config;

import cn.edu.ncu.onlineaddressbook.bean.UserVo;
import cn.edu.ncu.onlineaddressbook.service.RedisService;
import cn.edu.ncu.onlineaddressbook.util.RedisKeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Resource
    private RedisService redisService;

    @Test
    public void testObj() throws Exception{
         UserVo userVo = new UserVo();
        userVo.setAddress("上海");
        userVo.setName("测试dfas");
        userVo.setAge(123);
        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
        redisService.expireKey("name",20, TimeUnit.SECONDS);
        String key = RedisKeyUtil.getKey(UserVo.Table,"name",userVo.getName());
        System.out.println("KEY::::::"+key);
        operations.set(key,userVo);
       // UserVo vo = (UserVo) operations.get(key);
       // System.out.println(vo);
        System.out.println(operations.get(key));
    }

    @Test
    public void testValueOption( )throws  Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("上海");
        userVo.setName("jantent");
        userVo.setAge(23);
        valueOperations.set("test",userVo);

        System.out.println(valueOperations.get("test"));
    }

    @Test
    public void testSetOperation() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserVo auserVo = new UserVo();
        auserVo.setAddress("n柜昂周");
        auserVo.setName("antent");
        auserVo.setAge(23);
        setOperations.add("user:test",userVo,auserVo);
        Set<Object> result = setOperations.members("user:test");
        System.out.println(result);
    }

    @Test
    public void testZSetOperation() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserVo auserVo = new UserVo();
        auserVo.setAddress("n柜昂周");
        auserVo.setName("antent");
        auserVo.setAge(22);
        zSetOperations.add("user:test:zSet", auserVo,auserVo.getAge());
      /*  Set<Object> result = (Set<Object>) zSetOperations.reverseRange(userVo,0,1);
        System.out.println(result);*/
    }

    @Test
    public void HashOperations() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("南昌");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserVo userVo1 = new UserVo();
        userVo1.setAddress("北京11");
        userVo1.setName("jantent");
        userVo1.setAge(2311);
        hashOperations.put("hash:user",userVo1.getName(),userVo1);
        System.out.println(hashOperations.get("hash:user",userVo1.getName()));
    }

    @Test
    public void  ListOperations() throws Exception{
        UserVo userVo = new UserVo();
        userVo.setAddress("北京");
        userVo.setName("jantent");
        userVo.setAge(23);
        UserVo userVo1 = new UserVo();
        userVo1.setAddress("北京11");
        userVo1.setName("jantent11");
        userVo1.setAge(2311);
       // listOperations.leftPush("list:user",userVo);
       // listOperations.leftPush("list:user",userVo1);
     //   System.out.println(listOperations.leftPop("list:user"));
        // pop之后 值会消失
   //     System.out.println(listOperations.leftPop("list:user"));

        listOperations.remove("list:user",1,userVo);
    }
}