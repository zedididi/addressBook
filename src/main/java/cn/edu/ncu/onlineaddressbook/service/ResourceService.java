package cn.edu.ncu.onlineaddressbook.service;

import cn.edu.ncu.onlineaddressbook.bean.Resource;
import cn.edu.ncu.onlineaddressbook.bean.Role;
import cn.edu.ncu.onlineaddressbook.repository.ResourceRepository;
import cn.edu.ncu.onlineaddressbook.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/3/1 7:10
 */

@Service
public class ResourceService {


    @Autowired
    private ResourceRepository resourceRepository;


    @Autowired
    private RoleRepository roleRepository;

    /**
     * 根据url查询权限表
     *
     * @param url
     * @return
     */
    public Resource findResourceByUrl(String url){
        return resourceRepository.findResourceByUrl(url);
    }

    /**
     * 根据权限id查询权限表
     *
     * @param resourceId
     * @return
     */
    public List<Role> getRoles(int resourceId){
        return roleRepository.findRolesOfResource(resourceId);
    }
}
