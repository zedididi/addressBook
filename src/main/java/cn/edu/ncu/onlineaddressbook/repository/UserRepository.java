package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:04
 */

@Repository
public interface UserRepository extends JpaRepository<User,String> {



    List<User> getUsersByName(String name);

    User getUserByUsername(String username);
    @Transactional
    @Modifying
    @Query(value = "insert into users(username,password,name,enabled,locked,register_time,login_time,login_times) values(?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery = true)
     int insertUser(String username, String password, String name, int enabled,Timestamp register_time, Timestamp login_time, int login_times);

    @Transactional
    @Modifying
    @Query(value = "update users set password=?1 where username=?2",nativeQuery = true)
    int  updatePasswordOfUser(String password,String username);

    @Transactional
    @Modifying
    @Query(value = "update users set enabled=?1 where username=?2",nativeQuery = true)
    int  updateEnabledOfUser(int enabled,String username);

    @Transactional
    @Modifying
    @Query(value = "update users set locked=?1 where username=?2",nativeQuery = true)
    int  updateLockedOfUser(int locked,String username);


    @Transactional
    @Modifying
    @Query(value = "update users set login_times=?1 where username=?2",nativeQuery = true)
    int  updateLoginTimesOfUser(int loginTimes,String username);

    @Transactional
    @Modifying
    @Query(value = "update users set login_time=?1 where username=?2",nativeQuery = true)
    int  updateLoginTimeOfUser(Timestamp loginTime, String username);

    @Transactional
    @Modifying
    @Query(value = "update users set login_time=?1,login_times=?2 where username=?3",nativeQuery = true)
    int  updateLoginTimeAndLoginTimesOfUser(Timestamp loginTime,int loginTimes,String username);

}
