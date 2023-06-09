package com.tuuli.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author tuuli
 * @time Created in 2023/6/2 19:59
 * @description
 */
@Data
public class CallNameVo  {
    private Integer id;
    private Integer num;
    private String name;
    private String gender;
    private String className;
    private String college;
    private String status;
}
