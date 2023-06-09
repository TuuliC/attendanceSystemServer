package com.tuuli.vo;

import lombok.Data;

import java.util.List;

/**
 * @author tuuli
 * @time Created in 2023/6/8 22:18
 * @description
 */
@Data
public class PageVo<T> {
    private List<T> dataList;
    private Integer count;
}
