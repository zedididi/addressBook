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

    public static String getTable() {
        return Table;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(String enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public String getParticularYear() {
        return particularYear;
    }

    public void setParticularYear(String particularYear) {
        this.particularYear = particularYear;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
