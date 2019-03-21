package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.User;
import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:10
 */

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {


    @Transactional
    @Modifying
    @Query(value = "insert into user_info(username,`name`,major,classs,enrollment_year,particular_year,company,city,address,email) values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",nativeQuery = true)
    int insertUserInfo(String username,String name,String major,String classs,String enrollmentYear,String particularYear,String company,String city,String address,String email);

    @Transactional
    @Modifying
    @Query(value = "update user_info set `name`=?1,major=?2,classs=?3,enrollment_year=?4,particular_year=?5,company=?6,city=?7,address=?8,email=?9 where username=?10",nativeQuery = true)
    int  updateUser(String name,String major,String classs,String enrollmentYear,String particularYear,String company,String city,String address,String email,String username);

    @Query(value = "select ui.* from user_info ui,user_role ur where ur.rid=?1 and ui.username=?2 and ur.username=ui.username",nativeQuery = true)
    UserInfo getUserInfoByUsername(int rid, String name);

    @Query(value = "select ui.* from user_info ui,user_role ur where ur.rid=?1 and ui.name=?2 and ur.username=ui.username",nativeQuery = true)
     List<UserInfo> getUserInfoByName(int rid,String name);

    @Query(value = "select ui.* from user_info ui,user_role ur where ur.rid=?1 and ui.classs=?2 and ur.username=ui.username",nativeQuery = true)
     List<UserInfo> getUserInfoByClasss(int rid,String classs);

    @Query(value = "select ui.* from user_info ui,user_role ur where ur.rid=?1 and ui.major=?2 and ur.username=ui.username",nativeQuery = true)
     List<UserInfo> getUserInfoByMajor(int rid,String major);

    @Query(value = "select ui.* from user_info ui,user_role ur where ur.rid=?1 and ui.enrollment_year=?2 and ur.username=ui.username",nativeQuery = true)
    List<UserInfo> getUserInfoByEnYear(int rid,String enrollmentYear);
}
