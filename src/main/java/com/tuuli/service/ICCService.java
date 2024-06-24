package com.tuuli.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tuuli.domain.CC;
import com.tuuli.domain.Course;

/**
 * @author tuuli
 * @time Created in 2024/6/23 0:28
 * @description
 */
public interface ICCService extends IService<CC> {
    void setCCStatus(Integer courseId, Integer classsId, Integer status);
}
