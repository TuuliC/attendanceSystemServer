package com.tuuli.dao;

import com.tuuli.domain.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tuuli
 * @since 2024-06-23
 */
@Mapper
public interface UserDao extends BaseMapper<UserInfo> {

}
