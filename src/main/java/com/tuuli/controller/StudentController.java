package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.dto.StudentDto;
import com.tuuli.service.IStudentService;
import com.tuuli.vo.StudentVo;
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
@CrossOrigin(origins = "http://localhost:8089", methods = {RequestMethod.POST}, allowCredentials = "true")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/getStudentPage")
    public R<List<StudentVo>> getStudentPage(@RequestBody StudentDto studentDto) {
        System.out.println("studentDto = " + studentDto);
        List<StudentVo> studentVoList = studentService.getStudentPage(studentDto);
        System.out.println("studentVoList = " + studentVoList);
        return R.success(studentVoList);
    }


}

