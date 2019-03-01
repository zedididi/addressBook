package cn.edu.ncu.onlineaddressbook.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 21:51
 */

@Setter
@Getter
@Entity
@Table(name = "role_resource")
public class RoleResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rid")
    private int rid;

    @Column(name = "res_id")
    private int resid;

    public RoleResource() {
    }

    public RoleResource(int rid, int resid) {
        this.rid = rid;
        this.resid = resid;
    }

    @Override
    public String toString() {
        return "RoleResource{" +
                "id=" + id +
                ", rid=" + rid +
                ", resid=" + resid +
                '}';
    }
}
