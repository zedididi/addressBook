package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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
public interface UserRepository extends JpaRepository<User,String>, JpaSpecificationExecutor<User>{


    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1  and ur.username=u.username",countQuery = "select count(*) from user_role  where rid=?1 ",nativeQuery = true)
    Page<User> getAllUsers(int rid, Pageable pageable );

    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1 and u.name=?2 and ur.username=u.username",nativeQuery = true)
    List<User> getUsersByName(int rid,String name);

    @Query(value = "select u.* from users u,user_role ur,user_info ui where ur.rid=?1 and ui.major=?2 and ur.username=u.username and ui.username=u.username",nativeQuery = true)
    List<User> getUsersByMajor(int rid,String major);

    @Query(value = "select u.* from users u,user_role ur,user_info ui where ur.rid=?1 and ui.classs=?2 and ur.username=u.username and ui.username=u.username",nativeQuery = true)
    List<User> getUsersByClasss(int rid,String classs);

    @Query(value = "select u.* from users u,user_role ur,user_info ui where ur.rid=?1 and ui.enrollment_year=?2 and ur.username=u.username and ui.username=u.username",nativeQuery = true)
    List<User> getUsersByEnYear(int rid,String enYear);

    @Query(value = "select u.* from users u where u.username=?1",nativeQuery = true)
    User getUserOrAdmin(String username);


    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1  and ur.username=u.username",nativeQuery = true)
    List<User> getAllUsers(int rid);


    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1 and u.username=?2 and ur.username=u.username",nativeQuery = true)
    User getUserByUsername(int rid,String username);

    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1 and u.enabled=?2 and ur.username=u.username",countQuery = "select count(*) from users u,user_role ur where ur.rid=?1 and u.enabled=?2 and ur.username=u.username",nativeQuery = true)
    Page<User> getUsersByEnabled(int rid,int enabled,Pageable pageable);

    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1 and u.enabled=?2 and ur.username=u.username",nativeQuery = true)
    List<User> getUsersByEnabled(int rid,int enabled);

    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1 and u.locked=?2 and ur.username=u.username",countQuery = "select count (*) from users u,user_role ur where ur.rid=?1 and u.locked=?2 and ur.username=u.username",nativeQuery = true)
    Page<User> getUsersByLocked(int rid,int locked,Pageable pageable);

    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1 and u.locked=?2 and ur.username=u.username",nativeQuery = true)
    List<User> getUsersByLocked(int rid,int locked);

    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1 and u.enabled=?2 and u.locked=?3 and ur.username=u.username",countQuery = "select count (*) from users u,user_role ur where ur.rid=?1 and u.enabled=?2 and u.locked=?3 and ur.username=u.username",nativeQuery = true)
    Page<User> getUsersByEnabledAndLocked(int rid,int enabled,int locked,Pageable pageable);

    @Query(value = "select u.* from users u,user_role ur where ur.rid=?1 and u.enabled=?2 and u.locked=?3 and ur.username=u.username",nativeQuery = true)
    List<User> getUsersByEnabledAndLocked(int rid,int enabled,int locked);

    @Transactional
    @Modifying
    @Query(value = "insert into users(username,password,name,enabled,register_time,login_time,login_times) values(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
     int insertUser(String username, String password, String name, int enabled,Timestamp registerTime, Timestamp loginTime, int loginTimes);

    @Transactional
    @Modifying
    @Query(value = "update users set password=?1 where username=?2",nativeQuery = true)
    int  updatePasswordOfUser(String password,String username);


    @Transactional
    @Modifying
    @Query(value = "update users set `name`=?1 where username=?2",nativeQuery = true)
    int  updateNameOfUser(String name,String username);

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
