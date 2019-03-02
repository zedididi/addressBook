package cn.edu.ncu.onlineaddressbook.bean;

import java.io.Serializable;

/**
 * @program: onlineAddressBook
 * @Author： LiuZedi
 * @Date： 2019/3/2 11:56
 */


public class UserVo implements Serializable {


    public  static final String Table = "t_user";

    private String name;
    private String address;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "UserVo{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
