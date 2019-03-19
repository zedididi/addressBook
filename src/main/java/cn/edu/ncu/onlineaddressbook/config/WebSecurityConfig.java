package cn.edu.ncu.onlineaddressbook.config;


import cn.edu.ncu.onlineaddressbook.component.MyAccessDecisionManager;
import cn.edu.ncu.onlineaddressbook.component.MyAccessDeniedHandler;
import cn.edu.ncu.onlineaddressbook.component.MyFilterInvocationSecurityMetadataSource;
import cn.edu.ncu.onlineaddressbook.service.RoleService;
import cn.edu.ncu.onlineaddressbook.service.UserService;
import com.sun.xml.internal.ws.api.policy.PolicyResolver;
import org.apache.catalina.Session;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.SessionCookieConfig;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author： LiuZedi
 * @Date： 2019/2/27 16:55
 */

@Configuration
@EnableWebSecurity     //注解开启Spring Security 的功能
//WebSecurityConfigurerAdapter：  自定义Security策略
// 重写它的方法来设置一些web的安全细节
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


   /* @Bean
    UserDetailsService customUserService(){
        return new UserService();
    }*/

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

   @Autowired
   private UserService userService;

   @Autowired
   private RoleService roleService;

   //接受一个用户的信息和访问一个url所需要的权限，判断该用户是否可以访问
   @Autowired
   private MyAccessDecisionManager myAccessDecisionManager;

   //403页面
   @Autowired
   private MyAccessDeniedHandler myAccessDeniedHandler;

   //根据一个url请求，获得访问它所需要的roles权限
   @Autowired
   private MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected  void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()       //配置安全策略
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        return o;
                    }
                })
//                .antMatchers("/hello").hasAuthority("ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
//                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
               // .failureUrl("/login-error")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

                        String status;
                        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
                            status="用户名或密码输入错误，登录失败!";
                        } else if (e instanceof DisabledException) {
                            status="账户还在审核中，登录失败，请联系管理员!";
                        }else if (e instanceof LockedException)
                            status="账户被禁用，登录失败，请联系管理员!";
                        else {
                           status="登录失败!";
                        }

                        logger.info(status);
                        httpServletRequest.getSession();
                        httpServletRequest.setAttribute("status",status);
                        httpServletRequest.getRequestDispatcher("/status").forward(httpServletRequest,httpServletResponse);

                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

                        String username=SecurityContextHolder.getContext().getAuthentication().getName();
                       // if (roleService.getRolesOfUser(username).get(0).getRoleName().equals("ROLE_ADMIN")){
                            httpServletRequest.getSession().setAttribute("username",username);
                            httpServletRequest.getRequestDispatcher("/loginPage").forward(httpServletRequest,httpServletResponse);
                        //}
                        //else
                        //    System.out.println("USER");

                    }
                })
                .and()
                .logout()
                .permitAll()
                .and()
                //解决非thymeleaf的form表单提交被拦截问题
                .csrf().disable()
                .exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);


       /* http
                .authorizeRequests() //定义那些url需要保护
                      .antMatchers("/login").permitAll() //定义不需要认证就可以访问
                      .antMatchers("/index").hasRole("USER")
                      .anyRequest().authenticated()   //任何请求，登录后可以访问
                      .and()
                .formLogin()
                      .loginPage("/login")//定义当需要用户登录时候，转到的登录页面
                      .loginProcessingUrl("/login")
                      .usernameParameter("username")
                      .passwordParameter("password")
                      .defaultSuccessUrl("/index")
                      .failureUrl("/index" )
                      .permitAll()
                      .and()
                .logout()
                      .permitAll()
                      .and()
                .csrf().disable();    // 关闭csrf防护

*/
      /*  http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/")           // 设置登录页面
                .loginProcessingUrl("/")  // 自定义的登录接口
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/").permitAll()     // 设置所有人都可以访问登录页面
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();          // 关闭csrf防护
       */
     }

    // Spring Security should completely ignore URLs starting with /resources/
    @Override
    public void configure(WebSecurity web){
        web.ignoring().antMatchers("/resources/**","/assets/**");
    }


    //AuthenticationManagerBuilder  自定义认证策略
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       /* auth
                .inMemoryAuthentication()
                .withUser("user").password(new BCryptPasswordEncoder().encode("123123")).roles("ADMIN");
         //在内存中创建了一个用户，该用户的名称为user，密码为password，用户角色为USER*/


       auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }


}
