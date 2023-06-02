package com.tuuli.dto;

import lombok.Data;

/**
 * @author tuuli
 * @time Created in 2023/5/26 19:37
 * @description 前端入参
 */
@Data
public class StudentDto {
   private Integer page;
   private Integer pageSize;
   private String name;
   private String gender;
   private Integer[] collegeList;
   private Integer[] classList;
}
