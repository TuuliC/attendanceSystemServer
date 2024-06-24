package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.domain.College;
import com.tuuli.dto.CollegeDto;
import com.tuuli.service.ICollegeService;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.CollegeVo;
import com.tuuli.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@CrossOrigin(origins = "http://localhost:8089", methods = {RequestMethod.POST, RequestMethod.GET}, allowCredentials = "true")
@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    ICollegeService collegeService;

    @PreAuthorize("hasAnyRole('1')")
    @PostMapping("/getCollegePage")
    public R<PageVo<CollegeVo>> getCollegePage(@RequestBody CollegeDto collegeDto) {
        PageVo<CollegeVo> collegeVoList = collegeService.getCollegePage(collegeDto);
        return R.success(collegeVoList);
    }

    @PreAuthorize("hasAnyRole('1')")
    @PostMapping("/getSelectCollege")
    public R<List<CollegeAndClassAndCourseVo>> getAllCollege() {
        List<CollegeAndClassAndCourseVo> collegeList = collegeService.getAllCollege();
        return R.success(collegeList);
    }

    @PreAuthorize("hasAnyRole('1')")
    @GetMapping("/queryCollegeById/{id}")
    public R<College> queryStudentById(@PathVariable Integer id) {
        College classVo = collegeService.queryClassById(id);
        return R.success(classVo);
    }

    @PreAuthorize("hasAnyRole('1')")
    @PostMapping("/updateCollege")
    public R<String> updateCollege(@RequestBody College college) {
        collegeService.updateCollege(college);
        return R.success("success");
    }

    @PreAuthorize("hasAnyRole('1')")
    @PostMapping("/addCollege")
    public R<String> adCollege(@RequestBody College college) {
        collegeService.addCollege(college);
        return R.success("success");
    }

    @PreAuthorize("hasAnyRole('1')")
    @PostMapping("/deleteCollege")
    public R<String> deleteCollege(@RequestBody Integer[] id) {
        collegeService.deleteCollege(id);
        return R.success("success");
    }
}

