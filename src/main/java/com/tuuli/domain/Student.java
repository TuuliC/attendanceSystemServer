package com.tuuli.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "stu_num")
    private Integer num;

    @TableField(value = "stu_name")
    private String name;

    private String gender;

    @TableField(value = "class_id")
    private Integer classId;

    @TableLogic
    private Integer deleted;


}
