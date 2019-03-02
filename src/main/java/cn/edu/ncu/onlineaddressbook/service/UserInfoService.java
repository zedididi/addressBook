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

    public UserInfo getUserInfoByUsername(String username){
        return userInfoRepository.getOne(username);
    }

    public List<UserInfo> getUserInfoByName(String name){
        return userInfoRepository.getUserInfoByName(name);
    }

    public List<UserInfo> getUserInfoByMajor(String major){
        return userInfoRepository.getUserInfoByMajor(major);
    }

    public List<UserInfo> getUserInfoByClasss(String classs){
        return userInfoRepository.getUserInfoByClasss(classs);
    }

    public int insertUserInfo(UserInfo userInfo){
        return userInfoRepository.insertUserInfo(userInfo.getUsername(),userInfo.getPassword(),userInfo.getName(),userInfo.getMajor(),userInfo.getClasss(),userInfo.getEnrollmentYear(),userInfo.getParticularYear(),userInfo.getCompany(),userInfo.getCity(),userInfo.getAddress(),userInfo.getEmail());
    }

    public int updateUser(UserInfo userInfo){
        return userInfoRepository.updateUser(userInfo.getPassword(),userInfo.getName(),userInfo.getMajor(),userInfo.getClasss(),userInfo.getEnrollmentYear(),userInfo.getParticularYear(),userInfo.getCompany(),userInfo.getCity(),userInfo.getAddress(),userInfo.getEmail(),userInfo.getUsername());
    }
}
