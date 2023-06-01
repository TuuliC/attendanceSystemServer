package com.tuuli.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tuuli.domain.College;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.CollegeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Mapper
public interface CollegeDao extends BaseMapper<College> {
    @Select("select id, col_name name from tb_college college where deleted = 0")
    List<CollegeAndClassAndCourseVo> getAllCollege();

    List<CollegeVo> selectListPage(IPage<College> page, @Param(Constants.WRAPPER) LambdaQueryWrapper<College> classQueryWrapper);
}
