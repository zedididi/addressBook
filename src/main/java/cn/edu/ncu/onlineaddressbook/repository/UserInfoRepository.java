package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:10
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {


    @Transactional
    @Modifying
    @Query(value = "insert into user_info(username,password,name,major,classs,enrollment_year,particular_year,company,city,address,email) values(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)",nativeQuery = true)
    int insertUserInfo(String username,String password,String name,String major,String classs,String enrollmentYear,String particularYear,String company,String city,String address,String email);

    @Transactional
    @Modifying
    @Query(value = "update user_info set password=?1,name=?2,major=?3,classs=?4,enrollment_year=?5,particular_year=?6,company=?7,city=?8,address=?9,email=?10 where username=?11",nativeQuery = true)
    int  updatePasswordOfUser(String password,String name,String major,String classs,String enrollmentYear,String particularYear,String company,String city,String address,String email,String username);

    @Query(value = "select ui.* from user_info ui where ui.name=?1",nativeQuery = true)
     List<UserInfo> getUserInfoByName(String name);

    @Query(value = "select ui.* from user_info ui where ui.classs=?1",nativeQuery = true)
     List<UserInfo> getUserInfoByClasss(String classs);

    @Query(value = "select ui.* from user_info ui where ui.major=?1",nativeQuery = true)
     List<UserInfo> getUserInfoByMajor(String major);
}
