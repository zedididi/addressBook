package cn.edu.ncu.onlineaddressbook.util;

import org.springframework.stereotype.Component;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/26 11:44
 *
 * redis  Key设计
 */

@Component
public class RedisKeyUtil {

    /**
     * redis的key
     * 形式为：
     * 表名：主键名：主键值：列名：
     *
     * @param tableName
     * @param majorKey
     * @param majorKeyValue
     * @param column
     * @return
     */
    public static String getKeyWithColumn(String tableName,String majorKey,String majorKeyValue,String column){

        StringBuffer buffer= new StringBuffer();
        buffer.append(tableName).append(":");
        buffer.append(majorKey).append(":");
        buffer.append(majorKeyValue).append(":");
        buffer.append(column).append(":");
        return buffer.toString();

    }

    /**
     * redis的key
     * 形式为：
     * 表名：主键名：主键值：
     * @param tableName
     * @param majorKey
     * @param majorKeyValue
     * @return
     */
    public static String getKey(String tableName,String majorKey,String majorKeyValue){

        StringBuffer buffer=new StringBuffer();
        buffer.append(tableName).append(":");
        buffer.append(majorKey).append(":");
        buffer.append(majorKeyValue).append(":");
        return buffer.toString();
    }
}
