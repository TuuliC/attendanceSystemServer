package com.tuuli.vo;

import lombok.Data;

/**
 * @author tuuli
 * @time Created in 2023/5/26 19:43
 * @description 前端出参
 */
@Data
public class StudentVo {
    private Integer id;
    private Integer num;
    private String name;
    private String gender;
    private String className;
    private String college;
}
