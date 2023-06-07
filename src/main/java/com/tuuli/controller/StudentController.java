package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.domain.Student;
import com.tuuli.dto.AddStudentDto;
import com.tuuli.dto.ListCallDto;
import com.tuuli.dto.StudentDto;
import com.tuuli.service.IStudentService;
import com.tuuli.vo.ListCallVo;
import com.tuuli.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@CrossOrigin(origins = "http://localhost:8089", methods = {RequestMethod.POST,RequestMethod.GET}, allowCredentials = "true")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/getStudentPage")
    public R<List<StudentVo>> getStudentPage(@RequestBody StudentDto studentDto) {
        List<StudentVo> studentVoList = studentService.getStudentPage(studentDto);
        return R.success(studentVoList);
    }

    @PostMapping("/getListCallPage")
    public R<List<ListCallVo>> getListCallPage(@RequestBody ListCallDto listCallDto) {
        List<ListCallVo> listCallVoList = studentService.getListCallPage(listCallDto);
        return R.success(listCallVoList);
    }

    @GetMapping("/queryStudentById/{id}")
    public R<StudentVo> queryStudentById(@PathVariable Integer id){
        StudentVo studentVo = studentService.queryStudentById(id);
        return R.success(studentVo);
    }

    @PostMapping("/updateStudent")
    public R<String> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return R.success("success");
    }

    @PostMapping("/addStudent")
    public R<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return R.success("success");
    }

    @PostMapping("/deleteStudent")
    public R<String> deleteStudent(@RequestBody Integer[] id){
        studentService.deleteStudent(id);
        return R.success("success");
    }
}

