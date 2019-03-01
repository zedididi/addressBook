package cn.edu.ncu.onlineaddressbook.repository;

import cn.edu.ncu.onlineaddressbook.bean.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/28 22:05
 */
public interface ResourceRepository extends JpaRepository<Resource,Integer> {



    @Query(value = "select r.* from resource r where r.url=?1",nativeQuery = true)
    public Resource findResourceByUrl(String url);
}
