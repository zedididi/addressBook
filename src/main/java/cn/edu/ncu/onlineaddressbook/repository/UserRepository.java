package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:04
 */

@Repository
public interface UserRepository extends JpaRepository<User,String> {


     User getUserByUsername(String username);

     User getUserByName(String name);

    @Transactional
    @Modifying
    @Query(value = "insert into users(username,password,name,enabled) values(?1,?2,?3,?4,?5)",nativeQuery = true)
     int insertUser(String username,String password,String name,int enabled);

    @Transactional
    @Modifying
    @Query(value = "update users set password=?1 where username=?2",nativeQuery = true)
    int  updatePasswordOfUser(String password,String username);

    @Transactional
    @Modifying
    @Query(value = "update users set enabled=?1 where username=?2",nativeQuery = true)
    int  updateEnabledOfUser(int enabled,String username);

}
