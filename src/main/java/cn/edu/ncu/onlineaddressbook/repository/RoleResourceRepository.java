package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.RoleResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:08
 */

@Repository
public interface RoleResourceRepository extends JpaRepository<RoleResource,Integer> {
}
