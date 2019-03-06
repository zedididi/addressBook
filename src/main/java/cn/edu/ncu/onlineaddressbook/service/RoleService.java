package cn.edu.ncu.onlineaddressbook.service;

import cn.edu.ncu.onlineaddressbook.bean.Role;
import cn.edu.ncu.onlineaddressbook.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/3/1 7:06
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    /**
     * 根据用户名查找该用户所有权限
     *
     * @param username
     * @return
     */
    public List<Role> getRolesOfUser(String username){
        return roleRepository.findRoleOfUser(username);
    }

    /**
     * 根据resource的主键查找resource允许的所有权限
     *
     * @param resourceId
     * @return
     */
    public List<Role> getRoleOfResource(int resourceId){
        return roleRepository.findRolesOfResource(resourceId);
    }
}
