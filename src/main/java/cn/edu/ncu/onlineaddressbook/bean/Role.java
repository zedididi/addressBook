package cn.edu.ncu.onlineaddressbook.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 21:43
 */

@Entity
@Setter
@Getter
@Table(name = "role")
public class Role {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   @Column(name = "role_name")
   private String roleName;

   @Column(name = "role_name_Zh")
    private String roleNameZh;

    public Role() {
    }

    public Role(String roleName, String roleNameZh) {
        this.roleName = roleName;
        this.roleNameZh = roleNameZh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNameZh() {
        return roleNameZh;
    }

    public void setRoleNameZh(String roleNameZh) {
        this.roleNameZh = roleNameZh;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleNameZh='" + roleNameZh + '\'' +
                '}';
    }
}
