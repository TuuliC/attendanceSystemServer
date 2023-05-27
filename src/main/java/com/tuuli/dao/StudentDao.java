package com.tuuli.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tuuli.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tuuli.vo.StudentVo;
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
public interface StudentDao extends BaseMapper<Student> {

    List<StudentVo> selectListPage(IPage<Student> page, @Param(Constants.WRAPPER) QueryWrapper<Student> studentQueryWrapper);
}
