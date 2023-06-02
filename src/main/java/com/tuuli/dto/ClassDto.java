package com.tuuli.dto;

import lombok.Data;

/**
 * @author tuuli
 * @time Created in 2023/5/31 21:41
 * @description
 */@Data
public class ClassDto {
    private Integer page;
    private Integer pageSize;
    private String name;
    private Integer[] collegeList;
}
