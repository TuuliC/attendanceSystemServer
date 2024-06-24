package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tuuli.domain.UserInfo;
import com.tuuli.dao.UserDao;
import com.tuuli.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tuuli
 * @since 2024-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserInfo> implements IUserService {
    @Autowired
    private UserDao userDao;

//    @Autowired
//    @Lazy //懒加载，避免循环依赖
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo getUserInfo(String username) {
        LambdaQueryWrapper<UserInfo> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(UserInfo::getUsername,username);
        return userDao.selectOne(userLambdaQueryWrapper);
    }


}
