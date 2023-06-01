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
@TableName("tb_sc")
public class Sc implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "course_id")
    private Integer courseId;

    @TableField(value = "stu_id")
    private Integer stuId;

    @TableLogic
    private Integer deleted;


}
