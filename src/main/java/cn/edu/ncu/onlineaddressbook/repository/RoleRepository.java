package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:07
 */

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {


    //自定义sql语句并且开启本地sql
    //根据用户名查找该用户所有权限
    @Query(value = "select r.* from role r,user_role ur where ur.username=?1 and ur.rid=r.id",nativeQuery = true)
    public List<Role> findRoleOfUser(String username);


    //根据resource的主键查找resource允许的所有权限
    @Query(value = "select r.* from role r,role_resource rr where rr.res_id=?1 and rr.rid=r.id",nativeQuery = true)
    public List<Role> findRolesOfResource(int resourceId);


}
