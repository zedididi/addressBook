package cn.edu.ncu.onlineaddressbook.service;

import cn.edu.ncu.onlineaddressbook.bean.User;
import cn.edu.ncu.onlineaddressbook.bean.UserDetailsImpl;
import cn.edu.ncu.onlineaddressbook.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/27 9:18
 */
@Service
public class UserService implements UserDetailsService{


    private Logger logger= LoggerFactory.getLogger(getClass());



    @Autowired
    UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    /**
     * 获取所有用户
     *
     * @return
     */
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    /**
     * 根据用户账号名查询用户
     *
     * @param username
     * @return
     */
    public User getUserByUsername(String username){
        return userRepository.getOne(username);
    }

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @Transactional
    public int insertUser(User user){
        return userRepository.insertUser(user.getUsername(),user.getPassword(),user.getName(),user.getEnabled());
    }

    /**
     * 根据用户账号名查询用户 修改用户账号密码
     *
     * @param pasword
     * @param username
     * @return
     */
    @Transactional
    public int updatePasswordOfUser(String pasword,String username){
        return userRepository.updatePasswordOfUser(pasword,username);
    }

    /**
     * 根据用户账号名查询用户 修改用户状态
     *
     * @param enabled  0：禁止登录 1：允许登录
     * @param username
     * @return
     */
    @Transactional
    public int updateEnabledOfUser(int enabled,String username){
        return userRepository.updateEnabledOfUser(enabled,username);
    }

    /**
     * 根据用户姓名查询用户
     *
     * @param name
     * @return
     */
    public List<User> getUsersByName(String name){
        return userRepository.getUsersByName(name);
    }


    /**
     * 重写UserDetailsService接口里面的抽象方法
     * 根据用户名 返回一个UserDetails的实现类的实例
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("用户的用户名：{}",username);

        User user=getUserByUsername(username);

        logger.info("用户信息：{}",user);
        if(user==null)
            throw new UsernameNotFoundException("没有该用户");

        //查到User后将其封装为UserDetails的实现类的实例供程序调用
        //用该User和它对应的Role实体们构造UserDetails的实现类
        return new UserDetailsImpl(user,roleService.getRolesOfUser(user.getUsername()));
    }
}
