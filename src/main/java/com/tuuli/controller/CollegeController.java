package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.dto.ClassDto;
import com.tuuli.dto.CollegeDto;
import com.tuuli.service.ICollegeService;
import com.tuuli.vo.ClassVo;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.CollegeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    ICollegeService collegeService;

    @PostMapping("/getCollegePage")
    public R<List<CollegeVo>> getCollegePage(@RequestBody CollegeDto collegeDto) {
        System.out.println("collegeDto = " + collegeDto);
        List<CollegeVo> collegeVoList = collegeService.getCollegePage(collegeDto);
        System.out.println("collegeVoList = " + collegeVoList);
        return R.success(collegeVoList);
    }

    @PostMapping("/getSelectCollege")
    public R<List<CollegeAndClassAndCourseVo>> getAllCollege() {
        List<CollegeAndClassAndCourseVo> collegeList = collegeService.getAllCollege();
        return R.success(collegeList);
    }
}

