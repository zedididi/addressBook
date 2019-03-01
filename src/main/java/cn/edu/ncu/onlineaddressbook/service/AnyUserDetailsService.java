package cn.edu.ncu.onlineaddressbook.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/27 18:01
 * 自定义UserDetailsService
 */


public class AnyUserDetailsService implements UserDetailsService {

    private Logger logger= LoggerFactory.getLogger(getClass());

    private final UserService userService;

    public AnyUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        logger.info("用户的用户名：{}",userName);
        // TODO 根据用户名，查找到对应的密码，与权限

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限

        String password=passwordEncoder.encode("123123");

        User user=new User(userName,"password", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;


    }
}
