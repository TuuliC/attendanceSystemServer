package com.tuuli.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tuuli.domain.Classs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tuuli.vo.ClassVo;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
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
public interface ClassDao extends BaseMapper<Classs> {

    //@Select("select id, cl_name name from tb_class where college_id in #{collegeIdList} and  deleted = 0")
    List<CollegeAndClassAndCourseVo> getAllClass(@Param(Constants.WRAPPER) QueryWrapper<Classs> classQueryWrapper);

    List<ClassVo> selectListPage(IPage<Classs> page, @Param(Constants.WRAPPER) QueryWrapper<Classs> classQueryWrapper);

    Integer selectListPageCount(@Param(Constants.WRAPPER) QueryWrapper<Classs> classQueryWrapper);

    @Select("select class.cl_name className,college.col_name college " +
            "from tb_class class " +
            "left join tb_college college on college.id = class.college_id " +
            "where class.id = #{id} " +
            "and class.deleted = 0 " +
            "and college.deleted = 0")
    ClassVo queryClassById(Integer id);


}
