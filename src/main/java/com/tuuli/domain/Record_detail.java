package com.tuuli.domain;

import java.time.LocalDateTime;
import java.io.Serializable;
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
public class Record_detail implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer stu_num;

    private String stu_name;

    private String gender;

    private String class_name;

    private String col_name;

    private String course_name;

    private LocalDateTime time;


}
