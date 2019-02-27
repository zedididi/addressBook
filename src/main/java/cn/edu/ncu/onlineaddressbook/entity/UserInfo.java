package cn.edu.ncu.onlineaddressbook.entity;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/26 21:08
 */
public class UserInfo{

    //表名
    private static final String Table="UserInfo";

    private String id;
    private String password;
    private String name;
    //专业
    private String major;
    //班级
    private String Class;
    //入学年份
    private String enrollmentYear;
    //毕业年份
    private String particularYear;
    //就业单位
    private String company;
    //所在城市
    private String city;
    //联系方式
    private String address;
    //电子邮箱
    private String email;

    public UserInfo(String id, String password, String name, String major, String aClass, String enrollmentYear, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.major = major;
        Class = aClass;
        this.enrollmentYear = enrollmentYear;
        this.address = address;
    }

    public UserInfo(String id, String password, String name, String major, String aClass, String enrollmentYear, String particularYear, String company, String city, String address, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.major = major;
        Class = aClass;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return Class;
    }

    public void setClass(String aClass) {
        Class = aClass;
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
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", Class='" + Class + '\'' +
                ", enrollmentYear='" + enrollmentYear + '\'' +
                ", particularYear='" + particularYear + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
