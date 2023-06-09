package com.tuuli.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tuuli.domain.RecordDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * VIEW Mapper 接口
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Mapper
public interface RecordDetailDao extends BaseMapper<RecordDetail> {

    //List<RecordDetail> selectListPage(IPage<RecordDetail> page, @Param(Constants.WRAPPER) QueryWrapper<RecordDetail> studentQueryWrapper);
}
