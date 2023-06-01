package com.tuuli.service.impl;

import com.tuuli.domain.Course;
import com.tuuli.dao.CourseDao;
import com.tuuli.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
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
    public List<CollegeAndClassAndCourseVo> getAllCourse(Integer classId) {
        List<CollegeAndClassAndCourseVo> courseVoList = courseDao.getAllCourse(classId);
        return courseVoList;
    }
}
