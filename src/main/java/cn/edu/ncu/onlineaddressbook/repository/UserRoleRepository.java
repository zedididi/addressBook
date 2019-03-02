package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:08
 */

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {


    @Transactional
    @Modifying
    @Query(value = "insert into user_role(username,rid) values(?1,?2)",nativeQuery = true)
    int insertUserRole(String username,int rid);

    UserRole getUserRoleByUsername(String username);
}
