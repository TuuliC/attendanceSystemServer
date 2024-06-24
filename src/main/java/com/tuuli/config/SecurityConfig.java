package com.tuuli.config;

import com.alibaba.fastjson.JSON;
import com.tuuli.common.R;
import com.tuuli.service.impl.CustomUserDetailsService;
import com.tuuli.service.impl.MyPersistentTokenBasedRememberMeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsUtils;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.UUID;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;
    private final DataSource dataSource;

    @Autowired
    public SecurityConfig(CustomUserDetailsService userDetailsService, DataSource dataSource) {
        this.userDetailsService = userDetailsService;
        this.dataSource = dataSource;
    }

    //自定义 filter 交给工厂管理
    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        //指定认证url
        loginFilter.setFilterProcessesUrl("/doLogin");
        //指定认证参数
        loginFilter.setUsernameParameter("username");
        loginFilter.setPasswordParameter("password");
        loginFilter.setKaptchaParameter("code");
        //指定认证管理器
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        //设置认证成功时使用自定义rememberMeService
        loginFilter.setRememberMeServices(rememberMeServices());
        //指定认证成功和失败时处理
        loginFilter.setAuthenticationSuccessHandler(new MyAuthenticationSuccessHandler());
        loginFilter.setAuthenticationFailureHandler(new MyAuthenticationFailureHandler());
        return loginFilter;
    }

    //加密方式
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        // 使用BCrypt加密密码
//        return new BCryptPasswordEncoder();
//    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/vcimg").permitAll() //不需要验证的请求
                .anyRequest().authenticated() // 所有请求都需要验证
                .and()
                .formLogin() // 使用默认的登录页面
                .and()
                .logout()//开启注销功能
                .logoutUrl("/logout")
                .logoutSuccessHandler(new MyAuthenticationLogoutHandler())
                .and()
                .rememberMe() //开启记住我功能
//                .rememberMeServices(rememberMeServices())  //设置自动登录使用哪个 rememberMeServices
                .and()
                .exceptionHandling()//异常处理
                .authenticationEntryPoint((request, response, e) -> {
                    R<String> r = R.error("请登录！");
                    String s = JSON.toJSONString(r);
                    //所有情况http返回码均为200
                    response.setStatus(HttpStatus.OK.value());
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().println(s);
                })
                .accessDeniedHandler((request, response, e) -> {
                    System.out.println("request.getServletPath() = " + request.getServletPath());
                    System.out.println("e.getMessage() = " + e.getMessage());
                    e.printStackTrace();
                    R<String> r = R.error("无权访问！");
                    String s = JSON.toJSONString(r);
                    //所有情况http返回码均为200
                    response.setStatus(HttpStatus.OK.value());
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().println(s);
                })
                .and()
                .cors()
                .configurationSource(configurationSource())
                .and()
                .addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();// post请求要关闭csrf验证,不然访问报错；实际开发中开启，需要前端配合传递其他参数
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    CorsConfigurationSource configurationSource() {
        CorsConfiguration corsConfiguration = new
                CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.addAllowedOriginPattern("*");
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new
                UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",
                corsConfiguration);
        return source;
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return new MyPersistentTokenBasedRememberMeServices(UUID.randomUUID().toString(), userDetailsService(), tokenRepository);
    }
}
