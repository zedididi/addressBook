package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:08
 */
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
