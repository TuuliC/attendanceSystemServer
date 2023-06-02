package com.tuuli.dto;

import lombok.Data;

/**
 * @author tuuli
 * @time Created in 2023/5/31 22:43
 * @description
 */
@Data
public class RecordDto {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer courseId;
    private Integer[] collegeList;
    private Integer[] classList;
}
