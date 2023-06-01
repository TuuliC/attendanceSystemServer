package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.dto.ClassDto;
import com.tuuli.dto.StudentDto;
import com.tuuli.service.IClassService;
import com.tuuli.vo.ClassVo;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@CrossOrigin(origins = "http://localhost:8089", methods = {RequestMethod.POST,RequestMethod.GET}, allowCredentials = "true")
@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    IClassService classService;

    @PostMapping("/getClassPage")
    public R<List<ClassVo>> getClassPage(@RequestBody ClassDto classDto) {
        System.out.println("classDto = " + classDto);
        List<ClassVo> classVoList = classService.getClassPage(classDto);
        System.out.println("classVoList = " + classVoList);
        return R.success(classVoList);
    }

    @GetMapping("/getSelectClass/{collegeId}")
    public R<List<CollegeAndClassAndCourseVo>> getAllClass(@PathVariable Integer collegeId){
        List<CollegeAndClassAndCourseVo> classVoList = classService.getAllClass(collegeId);
        return R.success(classVoList);
    }
}

