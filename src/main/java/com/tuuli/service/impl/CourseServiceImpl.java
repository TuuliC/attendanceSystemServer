package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuuli.domain.Course;
import com.tuuli.dao.CourseDao;
import com.tuuli.dto.CourseDto;
import com.tuuli.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.CourseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseDao, Course> implements ICourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<CollegeAndClassAndCourseVo> getAllCourse(Integer[] classId) {
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.in("cc.class_id", Arrays.asList(classId));
        List<CollegeAndClassAndCourseVo> courseVoList = courseDao.getAllCourse(courseQueryWrapper);
        return courseVoList;
    }

    @Override
    public List<CourseVo> getCoursePage(CourseDto courseDto) {
        //System.out.println("courseDto = " + courseDto);
        IPage<Course> page = new Page<>(courseDto.getPage(), courseDto.getPageSize());
        QueryWrapper<Course> courseQueryWrapper = new QueryWrapper<>();
        courseQueryWrapper.lambda().like(!StringUtils.isBlank(courseDto.getName()), Course::getCourseName, courseDto.getName());
        List<CourseVo> courseVoList = courseDao.getCoursePage(page, courseQueryWrapper);
        //System.out.println("courseVoList = " + courseVoList);
        return courseVoList;
    }

    @Override
    public CourseVo queryCourseById(Integer id) {
        Course course = courseDao.selectOne(new QueryWrapper<Course>().lambda().select(Course::getCourseName).eq(Course::getId, id));
        List<CollegeAndClassAndCourseVo> courseVoList = courseDao.getSelectClassByCourseId(id);
        CourseVo courseVo = new CourseVo();
        courseVo.setCourseName(course.getCourseName());
        courseVo.setSelectClassList(courseVoList);
        return courseVo;
    }
}
