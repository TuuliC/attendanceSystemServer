package com.tuuli.domain;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RecordDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField(value = "stu_num")
    private Integer num;

    @TableField(value = "stu_name")
    private String name;

    private String gender;

    @TableField(value = "class_name")
    private String className;

    @TableField(value = "col_name")
    private String collegeName;

    @TableField(value = "course_name")
    private String courseName;

    private String time;


}
