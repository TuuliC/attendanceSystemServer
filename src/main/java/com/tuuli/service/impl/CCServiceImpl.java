package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.dao.CCDao;
import com.tuuli.dao.ClassDao;
import com.tuuli.domain.CC;
import com.tuuli.service.ICCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tuuli
 * @time Created in 2024/6/23 0:30
 * @description
 */
@Service
public class CCServiceImpl extends ServiceImpl<CCDao, CC> implements ICCService {

    @Autowired
    private CCDao ccDao;

    @Override
    public void setCCStatus(Integer courseId, Integer classsId, Integer status) {
        CC cc = new CC();
        cc.setStatus(status);
        ccDao.update(cc, new LambdaQueryWrapper<CC>().eq(CC::getClassId, classsId).eq(CC::getCourseId, courseId));
    }
}
