package cn.edu.ncu.onlineaddressbook.bean;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 21:47
 */

@Getter
@Setter
@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "res_name")
    private String res_name;

    public Resource() {
    }

    public Resource(String url, String res_name) {
        this.url = url;
        this.res_name = res_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", res_name='" + res_name + '\'' +
                '}';
    }
}
