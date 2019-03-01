package cn.edu.ncu.onlineaddressbook.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 21:54
 */

@Setter
@Getter
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "rid")
    private int rid;

    public UserRole() {
    }

    public UserRole(String username, int rid) {
        this.username = username;
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", rid=" + rid +
                '}';
    }
}
