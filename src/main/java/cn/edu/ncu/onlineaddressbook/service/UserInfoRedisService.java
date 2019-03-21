package cn.edu.ncu.onlineaddressbook.service;

import cn.edu.ncu.onlineaddressbook.bean.UserInfo;
import cn.edu.ncu.onlineaddressbook.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/21 10:31
 */

@Service
public class UserInfoRedisService {

    //set
    //被禁用用户
    private static final String USERS_LOCKED = "USERS_LOCKED";
    //未审核通过用户
    private static final String USERS_DISABLED = "USERS_DISABLED";
    //正常使用用户
    private static final String USER_NORMAL = "USER_NORMAL";
    //所有用户
    private static final String USER_ALL = "USER_ALL";

    //hash key
    //key：USER_USERNAME   根据用户账号存储
    private static final String USER_USERNAME = "USER_USERNAME";


    //key:USER_NAME    根据用户名存储
    private static final String USER_NAME = "USER_NAME";
    //key:USER_MAJOR   根据用户专业存储
    private static final String USER_MAJOR = "USER_MAJOR";
    //key:USER_CLASSS  根据用户班级存储
    private static final String USER_CLASSS = "USER_CLASSS";
    //key:USER_ENYEAR  根据入学年份存储
    private static final String USER_ENYEAR = "USER_ENYEAR";

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;

    @Resource
    private RedisService redisService;

    /**
     * redis：hash存储
     * 以USER_USERNAME为主键，username为hashKey,用户信息为Object
     *
     * @param username
     * @return
     */
    public UserInfo getUserByUsername(String username) {

        //key
        String key = "HASH:" + USER_USERNAME;

        boolean hash = hashOperations.hasKey(key, username);
        if (hash)
            return (UserInfo) hashOperations.get(key, username);
        else {
            UserInfo userInfo = userInfoRepository.getUserInfoByUsername(1, username);
            hashOperations.put(key, username, userInfo);
            return userInfo;
        }
    }

    /**
     * 根据不同的type 查找相对应的list返回用户信息
     *
     * @param type name:以用户名 ， major:以专业 ， classs：以班级 ， year：以入学年份
     * @param info 查询的详细信息
     * @return
     */
    public List<?> getUsersByOption(String type, String info) {

        //key
        String key = "LIST:" + type.toUpperCase() + ":" + info;

        if (listOperations.size(key) > 0)
            return listOperations.range(key, 0, -1);
        else {

            List<UserInfo> userInfoList = new ArrayList<>();
            switch (type) {
                case "name":
                    userInfoList = userInfoRepository.getUserInfoByName(1, info);
                    break;
                case "major":
                    userInfoList = userInfoRepository.getUserInfoByMajor(1, info);
                    break;
                case "classs":
                    userInfoList = userInfoRepository.getUserInfoByClasss(1, info);
                    break;
                case "year":
                    userInfoList = userInfoRepository.getUserInfoByEnYear(1, info);
                    break;
            }

            if (userInfoList.size() > 0)
                for (Object o : userInfoList) {
                    listOperations.leftPush(key, o);

                }

            return userInfoList;
        }
    }

    /**
     * 更新redis中的数据
     *
     * @param oldUserInfo
     * @param newUserInfo
     */
    public void updateUserInfo(UserInfo oldUserInfo, UserInfo newUserInfo) {


        if (hashOperations.delete("HASH:" + USER_USERNAME, newUserInfo.getUsername())==1)
            hashOperations.put("HASH:" + USER_USERNAME, newUserInfo.getUsername(), newUserInfo);

        String[] oldKeys=getKeys(oldUserInfo);
        String[] newKeys=getKeys(newUserInfo);

        for (int i=0;i<oldKeys.length;i++){

            listOperations.remove(oldKeys[i],1, oldUserInfo);
            if (listOperations.size(newKeys[i])>0)
                listOperations.leftPush(newKeys[i],newUserInfo);
        }
    }

    /**
     * 生成Key
     *
     * @param userInfo
     * @return
     */
    private String[] getKeys(UserInfo userInfo){
        String[] keys=new String[4];

        keys[0]= "LIST:NAME:" + userInfo.getName();
        keys[1]= "LIST:MAJOR:" + userInfo.getMajor();
        keys[2] = "LIST:CLASSS:" + userInfo.getClasss();
        keys[3] = "LIST:YEAR:" + userInfo.getEnrollmentYear();

        return keys;
    }

    /**
     * 插入用户信息到redis中list
     *
     * @param userInfo
     * @param key
     */
    private void insertUtil(UserInfo userInfo,String key) {

        if (listOperations.size(key)>0)
            listOperations.leftPush(key, userInfo);
    }

    /**
     * 插入用户信息到redis中
     *
     * @param userInfo
     */
    public void insertUserInfo(UserInfo userInfo) {

        String[] keys=getKeys(userInfo);

        hashOperations.put("HASH:" + USER_USERNAME, userInfo.getUsername(), userInfo);

        for (String s:keys
             ) {
            insertUtil(userInfo,s);
        }
    }
}
