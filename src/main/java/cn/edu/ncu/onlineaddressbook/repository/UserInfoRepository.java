package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:10
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    @Query(value = "select ui.* from user_info ui where ui.name=?1",nativeQuery = true)
    public List<UserInfo> getUserInfoByName(String name);

    @Query(value = "select ui.* from user_info ui where ui.classs=?1",nativeQuery = true)
    public List<UserInfo> getUserInfoByClasss(String classs);

    @Query(value = "select ui.* from user_info ui where ui.major=?1",nativeQuery = true)
    public List<UserInfo> getUserInfoByMajor(String major);
}
