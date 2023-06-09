package com.tuuli.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
@TableName("tb_record")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value="stu_id")
    private Integer stuId;

    @TableField(value="course_id")
    private Integer courseId;

    private String status;

    //private LocalDateTime time;
    private Timestamp time;

    @TableLogic
    private Integer deleted;


}
