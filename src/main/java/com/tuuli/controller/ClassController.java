package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.domain.Classs;
import com.tuuli.dto.ClassDto;
import com.tuuli.service.IClassService;
import com.tuuli.vo.ClassVo;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.PageVo;
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
    public R<PageVo<ClassVo>> getClassPage(@RequestBody ClassDto classDto) {
        PageVo<ClassVo> classVoList = classService.getClassPage(classDto);
        return R.success(classVoList);
    }

    @PostMapping("/getSelectClass")
    public R<List<CollegeAndClassAndCourseVo>> getAllClass(@RequestBody Integer[] collegeId){
        List<CollegeAndClassAndCourseVo> classVoList = classService.getAllClass(collegeId);
        return R.success(classVoList);
    }

    @GetMapping("/queryClassById/{id}")
    public R<ClassVo> queryStudentById(@PathVariable Integer id){
        ClassVo classVo = classService.queryClassById(id);
        return R.success(classVo);
    }

    @PostMapping("/updateClass")
    public R<String> updateStudent(@RequestBody Classs classs){
        //classService.update(classs,null);
        classService.updateClass(classs);
        return R.success("success");
    }

    @PostMapping("/addClass")
    public R<String> addClass(@RequestBody Classs classs){
        classService.addClass(classs);
        return R.success("success");
    }

    @PostMapping("/deleteClass")
    public R<String> deleteClass(@RequestBody Integer[] id){
        //System.out.println("id = " + Arrays.toString(id));
        classService.deleteClass(id);
        return R.success("success");
    }

}

