package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.dto.StudentDto;
import com.tuuli.service.IStudentService;
import com.tuuli.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@RestController
@RequestMapping("/student")
public class StudentController {

//    @Autowired
//    private IStudentService studentService;

    @PostMapping("/getStudentPage")
    public R<List<StudentVo>> getStudentPage(StudentDto studentDto){
//        List<StudentVo> studentVoList = studentService.getStudentPage(studentDto);
//        return R.success(studentVoList);
        return null;
    }


}

