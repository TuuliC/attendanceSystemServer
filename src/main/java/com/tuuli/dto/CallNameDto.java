package com.tuuli.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tuuli.domain.Student;
import lombok.Data;

/**
 * @author tuuli
 * @time Created in 2023/6/2 20:01
 * @description
 */
@Data
public class CallNameDto {
    private Integer page;
    private Integer pageSize;
    private String name;
    private String gender;
    private Integer courseId;
    private Integer[] collegeList;
    private Integer[] classList;
    private String[] stateList;
}
