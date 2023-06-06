package com.tuuli.dto;

import lombok.Data;

/**
 * @author tuuli
 * @time Created in 2023/6/2 20:01
 * @description
 */
@Data
public class ListCallDto {
    private Integer page;
    private Integer pageSize;
    private String name;
    private String gender;
    private Integer courseId;
    private Integer[] collegeList;
    private Integer[] classList;
    private String[] stateList;
}
