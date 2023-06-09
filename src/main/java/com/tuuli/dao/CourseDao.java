package com.tuuli.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.tuuli.domain.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tuuli.domain.Student;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.CourseVo;
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
public interface CourseDao extends BaseMapper<Course> {
    //    @Select("select course.id, course.course_name name\n" +
//            "from tb_course course \n" +
//            "join tb_SC sc on course.id = SC.course_id\n" +
//            "join tb_student student on SC.stu_id = student.id\n" +
//            "where student.class_id in #{classId} and course.deleted = 0 and sc.deleted = 0 and student.deleted = 0")
    List<CollegeAndClassAndCourseVo> getAllCourse(@Param(Constants.WRAPPER) QueryWrapper<Course> classId);

    List<CourseVo> getCoursePage(IPage<Course> page, @Param(Constants.WRAPPER) QueryWrapper<Course> queryWrapper);

    @Select("SELECT cl.id, cl.cl_name\n" +
            "FROM tb_course c\n" +
            "INNER JOIN tb_cc cc ON c.id = cc.course_id \n" +
            "INNER JOIN tb_class cl ON cc.class_id = cl.id \n" +
            "WHERE c.id = #{id}")
    List<CollegeAndClassAndCourseVo> getSelectClassByCourseId(Integer id);

    Integer getCoursePageCount(@Param(Constants.WRAPPER) QueryWrapper<Course> courseQueryWrapper);
}
