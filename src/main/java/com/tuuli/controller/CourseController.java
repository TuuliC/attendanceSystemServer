package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.service.ICourseService;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@CrossOrigin(origins = "http://localhost:8089", methods = {RequestMethod.POST, RequestMethod.GET}, allowCredentials = "true")
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @GetMapping("/getSelectCourse/{classId}")
    public R<List<CollegeAndClassAndCourseVo>> getAllClass(@PathVariable Integer classId){
        List<CollegeAndClassAndCourseVo> courseVoList = courseService.getAllCourse(classId);
        return R.success(courseVoList);
    }


}

