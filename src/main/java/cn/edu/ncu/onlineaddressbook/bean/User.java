package cn.edu.ncu.onlineaddressbook.bean;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/26 21:08
 */

@Entity
@Table(name = "users")
@Proxy(lazy = false)
public class User {


    @Id
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "enabled")
    private int enabled;

    @Column(name = "locked")
    private int locked;

    @Column(name = "register_time")
    private Timestamp registerTime;

    @Column(name = "login_time")
    private Timestamp loginTime;

    @Column(name = "login_times")
    private int loginTimes;

    public User() {
    }

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled=0;
        this.locked=1;
        this.registerTime=new Timestamp(System.currentTimeMillis());
        this.loginTime= null;
        this.loginTimes=0;
    }

    public User(String username, String password, String name, int enabled,int locked,Timestamp registerTime,Timestamp loginTime,int loginTimes) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.enabled = enabled;
        this.locked=locked;
        this.registerTime=registerTime;
        this.loginTime=loginTime;
        this.loginTimes=loginTimes;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public int getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(int loginTimes) {
        this.loginTimes = loginTimes;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", locked=" + locked +
                ", registerTime=" + registerTime +
                ", loginTime=" + loginTime +
                ", loginTimes=" + loginTimes +
                '}';
    }
}
