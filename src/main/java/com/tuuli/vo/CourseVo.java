package com.tuuli.vo;

import lombok.Data;

import java.util.List;

/**
 * @author tuuli
 * @time Created in 2023/6/7 14:44
 * @description
 */
@Data
public class CourseVo {
    private Integer id;
    private String courseName;
    private String classListStr;
    private Integer classCount;
    private List<CollegeAndClassAndCourseVo> selectClassList;
}
