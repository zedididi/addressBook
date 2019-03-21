package cn.edu.ncu.onlineaddressbook.service;

import cn.edu.ncu.onlineaddressbook.bean.User;
import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import cn.edu.ncu.onlineaddressbook.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/3/1 7:14
 */

@Service
public class UserInfoService {

    @Autowired
    private   UserInfoRepository userInfoRepository;

    /**
     * 根据账号查询用户/管理员信息
     *
     * @param username
     * @return
     */
    public UserInfo getUserInfoByUsername(String username){
        return userInfoRepository.getOne(username);
    }

    /**
     * 根据用户账号查询用户信息
     *
     * @param rid：1：为用户，2：为管理员
     * @param username
     * @return
     */
    public UserInfo getUserInfoByUsername(int rid,String username){
        return userInfoRepository.getUserInfoByUsername(rid,username);
    }
    /**
     * 根据用户姓名查询用户信息
     *
     * @param rid：1：为用户，2：为管理员
     * @param name
     * @return
     */
    public List<UserInfo> getUserInfoByName(int rid,String name){
        return userInfoRepository.getUserInfoByName(rid,name);
    }

    /**
     * 根据专业来查询用户信息
     *
     * @param rid：1：为用户，2：为管理员
     * @param major
     * @return
     */
    public List<UserInfo> getUserInfoByMajor(int rid,String major){
        return userInfoRepository.getUserInfoByMajor(rid,major);
    }

    /**
     * 根据班级查询用户信息
     *
     * @param rid：1：为用户，2：为管理员
     * @param classs
     * @return
     */
    public List<UserInfo> getUserInfoByClasss(int rid,String classs){
        return userInfoRepository.getUserInfoByClasss(rid,classs);
    }

    /**
     * 根据入学年份查询用户信息
     *
     * @param rid：1：为用户，2：为管理员
     * @param enYear
     * @return
     */
    public List<UserInfo> getUserInfoByEnYear(int rid,String enYear){
        return userInfoRepository.getUserInfoByEnYear(rid,enYear);
    }

    /**
     * 插入用户信息
     *
     * @param userInfo
     * @return
     */
    public int insertUserInfo(UserInfo userInfo){
        return userInfoRepository.insertUserInfo(userInfo.getUsername(),userInfo.getName(),userInfo.getMajor(),userInfo.getClasss(),userInfo.getEnrollmentYear(),userInfo.getParticularYear(),userInfo.getCompany(),userInfo.getCity(),userInfo.getAddress(),userInfo.getEmail());
    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     * @return
     */
    public int updateUser(UserInfo userInfo){
        return userInfoRepository.updateUser(userInfo.getName(),userInfo.getMajor(),userInfo.getClasss(),userInfo.getEnrollmentYear(),userInfo.getParticularYear(),userInfo.getCompany(),userInfo.getCity(),userInfo.getAddress(),userInfo.getEmail(),userInfo.getUsername());
    }
}
