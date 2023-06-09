package com.tuuli.dto;

import lombok.Data;

/**
 * @author tuuli
 * @time Created in 2023/6/7 20:54
 * @description
 */
@Data
public class ListAttendanceDto {
    private Integer[] ids;
    private Integer courseId;
    private String status;
}
