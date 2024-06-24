package com.tuuli.service;

import com.tuuli.domain.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tuuli
 * @since 2024-06-23
 */
public interface IUserService extends IService<UserInfo> {
    /**
     * 根据用户账号查询用户信息
     * @param username 用户账号
     * @return
     */
    UserInfo getUserInfo(String username);
}
