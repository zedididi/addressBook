package cn.edu.ncu.onlineaddressbook.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/26 21:08
 */

@Entity
@Getter
@Setter
@Table(name = "user_info")
public class UserInfo{

    //表名
    private static final String Table="UserInfo";


    @Id
    private String username;

    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;

    @Column(name = "major")
    //专业
    private String major;

    @Column(name = "classs")
    //班级
    private String classs;

    //入学年份
    @Column(name = "enrollment_year")
    private String enrollmentYear;

    //毕业年份
    @Column(name = "particular_year")
    private String particularYear;

    //就业单位
    @Column(name = "company")
    private String company;

    //所在城市
    @Column(name = "city")
    private String city;

    //联系方式
    @Column(name = "address")
    private String address;

    //电子邮箱
    @Column(name = "email")
    private String email;

    public UserInfo() {
    }

    public UserInfo(String username, String password, String name, String major, String classs, String enrollmentYear, String particularYear, String company, String city, String address, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.major = major;
        this.classs = classs;
        this.enrollmentYear = enrollmentYear;
        this.particularYear = particularYear;
        this.company = company;
        this.city = city;
        this.address = address;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", classs='" + classs + '\'' +
                ", enrollmentYear='" + enrollmentYear + '\'' +
                ", particularYear='" + particularYear + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
