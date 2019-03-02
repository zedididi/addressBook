package cn.edu.ncu.onlineaddressbook.service;

import cn.edu.ncu.onlineaddressbook.bean.UserRole;
import cn.edu.ncu.onlineaddressbook.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/2 8:48
 */

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;


    public int insertUserRole(String username,int rid){
        return userRoleRepository.insertUserRole(username,rid);
    }

    public UserRole getUserRoleByUsername(String username){
        return userRoleRepository.getUserRoleByUsername(username);
    }

}
