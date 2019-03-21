package cn.edu.ncu.onlineaddressbook.service;

import org.springframework.stereotype.Service;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/21 10:31
 */

@Service
public class UserInfoRedisService {

    private static final String USERS_LOCKED="USERS_LOCKED";

    private static final String USERS_DISABLED="USERS_DISABLED";
    private static final String USER_NORMAL="USER_NORMAL";
    private static final String USER_ALL="USER_ALL";

}
