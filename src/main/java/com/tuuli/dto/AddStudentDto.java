package com.tuuli.dto;

import lombok.Data;

/**
 * @author tuuli
 * @time Created in 2023/6/4 21:49
 * @description
 */
@Data
public class AddStudentDto {
    private String name;
    private String gender;
    private Integer classId;
    private Integer collegeId;
}
