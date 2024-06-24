package com.tuuli.service.impl;

import com.tuuli.domain.UserInfo;
import com.tuuli.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tuuli
 * @time Created in 2024/3/27 21:11
 * @description 用户登录接口
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    @Autowired
    public CustomUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserInfo userInfo = userService.getUserInfo(username);
        if (userInfo == null) {
//            throw new BusinessException(ReturnCode.RC401);
            return null;
        }
        //定义权限列表
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userInfo.getRole()));
        UserVo user = new UserVo(userInfo.getUsername(),
                "{noop}" + userInfo.getPassword(),
                authorities,
                userInfo.getId(),
                userInfo.getRole());
        System.out.println("---------user = " + user);
        return user;

    }
}
