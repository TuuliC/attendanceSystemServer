package com.tuuli.service;

import com.tuuli.domain.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuuli.dto.CourseDto;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.CourseVo;
import com.tuuli.vo.PageVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
public interface ICourseService extends IService<Course> {
    List<CollegeAndClassAndCourseVo> getAllCourse(Integer[] classId);

    PageVo<CourseVo> getCoursePage(CourseDto courseDto);

    CourseVo queryCourseById(Integer id);
}
