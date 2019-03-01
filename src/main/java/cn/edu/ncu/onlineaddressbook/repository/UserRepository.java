package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:04
 */

public interface UserRepository extends JpaRepository<User,String> {
}
