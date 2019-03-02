package cn.edu.ncu.onlineaddressbook.component;

import cn.edu.ncu.onlineaddressbook.bean.Resource;
import cn.edu.ncu.onlineaddressbook.bean.Role;
import cn.edu.ncu.onlineaddressbook.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @Author： LiuZedi
 * @Date： 2019/3/1 9:20
 */

@Component
//接收用户请求的地址，返回访问该地址需要的所有权限
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private Logger logger= LoggerFactory.getLogger(getClass());


    @Autowired
    private ResourceService resourceService;

    @Override
    //接收用户请求的地址，返回访问该地址需要的所有权限
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        //得到用户的请求地址，控制台输出一下
        String requestUrl=((FilterInvocation) object).getRequestUrl();
        logger.info("用户请求的地址是：{} ",requestUrl);

        //如果登录页面不需要权限
        if ("/login".equals(requestUrl)||"/login-error".equals(requestUrl)||"/register".equals(requestUrl)||"/re".equals(requestUrl))
            return null;

        Resource resource=resourceService.findResourceByUrl(requestUrl);

        //如果没有匹配的url则说明大家都可以访问
        if (resource==null){
            return SecurityConfig.createList("ROLE_LOGIN");
        }

        //将resource所需要到的roles按框架要求封装返回（ResourceService里面的getRoles方法是基于RoleRepository实现的）
        List<Role> roles=resourceService.getRoles(resource.getId());
        int size=roles.size();

        String[] values=new String[size];

        for (int i=0;i<size;i++)
            values[i]=roles.get(i).getRoleName();

        return SecurityConfig.createList(values);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
