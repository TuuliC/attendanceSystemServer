package com.tuuli.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tuuli.domain.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tuuli.vo.CallNameVo;
import com.tuuli.vo.PageVo;
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

    //    @Select(" select student.id       as id,\n" +
//            "               student.stu_num  as num,\n" +
//            "               student.stu_name as name,\n" +
//            "               student.gender   as gender,\n" +
//            "               class.cl_name    as className,\n" +
//            "               college.col_name as college\n" +
//            "        from tb_student student\n" +
//            "                 left join tb_class class on student.class_id = class.id\n" +
//            "                 left join tb_college college on class.college_id = college.id #{ew.customSqlSegment}")
    List<StudentVo> selectListPage(IPage<Student> page, @Param(Constants.WRAPPER) QueryWrapper<Student> studentQueryWrapper);

    Integer selectListPageCount(@Param(Constants.WRAPPER) QueryWrapper<Student> studentQueryWrapper);

    List<CallNameVo> getListCallPage(IPage<Student> page, @Param(Constants.WRAPPER) QueryWrapper<Student> listCallDto);

    Integer getListCallPageCount(@Param(Constants.WRAPPER) QueryWrapper<Student> listCallDto);

    @Select("SELECT s.stu_num num, s.stu_name name, s.gender, co.col_name  AS college, c.cl_name AS className\n" +
            "FROM tb_student s\n" +
            "JOIN tb_class c ON s.class_id = c.id \n" +
            "JOIN tb_college co ON c.college_id = co.id \n" +
            "WHERE s.id = #{id}")
    StudentVo queryStudentById(Integer id);

    List<CallNameVo> getRandomStuList(@Param(Constants.WRAPPER) QueryWrapper<Student> studentQueryWrapper);
}
