package com.example.provider.config;

import com.alibaba.fastjson.JSON;
import com.example.provider.filter.JWTAuthenticationFilter;
import com.example.provider.model.TokenJsonResult;
import com.example.provider.security.*;
import com.example.provider.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Constants;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yangpengcheng
 * @ClassName SecurityConfig
 * @Description:
 * @date 2020/11/218:22
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private MySecurityMetadataSource mySecurityMetadataSource;
    @Autowired
    private MyAccessDecisionManager myAccessDecisionManager;
    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Autowired
    private SecuritySuccessHandler securitySuccessHandler;
    @Autowired
    private SecurityFailedHandler securityFailedHandler;
    @Autowired
    private SecurityLogoutSuccessHandler securityLogoutSuccessHandler;
    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//        auth.inMemoryAuthentication().withUser("user001").roles("admin").password("$2a$10$KjWd1uD5aduk3/mQfxWwb.HO6rh8/zcBLoU/mOdy2ZLBcTzoNOWMS")
//                .and()
//                .withUser("user002").roles("admin").password("$2a$10$KjWd1uD5aduk3/mQfxWwb.HO6rh8/zcBLoU/mOdy2ZLBcTzoNOWMS");
        auth.userDetailsService(myUserDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()//开启登录配置
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(mySecurityMetadataSource);
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        return o;
                    }
                })
//                .antMatchers("/person/**").hasRole("admin")//表示访问 /hello 这个接口，需要具备 admin 这个角色
                .anyRequest().authenticated()//表示剩余的其他接口，登录之后就能访问
                .and()
                .formLogin()
                //定义登录页面，未登录时，访问一个需要登录之后才能访问的接口，会自动跳转到该页面
//                .loginPage("/login_p")
                //登录处理接口
//                .loginProcessingUrl("/doLogin")
                //定义登录时，用户名的 key，默认为 username
//                .usernameParameter("uname")
                //定义登录时，用户密码的 key，默认为 password
//                .passwordParameter("passwd")
                //登录成功的处理器
                .successHandler(securitySuccessHandler)
                .failureHandler(securityFailedHandler)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(securityLogoutSuccessHandler)
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                //前后端分离采用JWT 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);



    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/person/**");
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

}
