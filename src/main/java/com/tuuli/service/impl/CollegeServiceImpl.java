package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuuli.domain.Classs;
import com.tuuli.domain.College;
import com.tuuli.dao.CollegeDao;
import com.tuuli.dto.CollegeDto;
import com.tuuli.service.ICollegeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.ClassVo;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.CollegeVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Service
public class CollegeServiceImpl extends ServiceImpl<CollegeDao, College> implements ICollegeService {

    @Autowired
    private CollegeDao collegeDao;

    @Override
    public List<CollegeAndClassAndCourseVo> getAllCollege() {
        List<CollegeAndClassAndCourseVo> collegeVoList = collegeDao.getAllCollege();
        return collegeVoList;
    }

    @Override
    public List<CollegeVo> getCollegePage(CollegeDto collegeDto) {
        IPage<College> page = new Page<>(collegeDto.getPage(), collegeDto.getPageSize());
        LambdaQueryWrapper<College> classQueryWrapper = new LambdaQueryWrapper<>();
        classQueryWrapper.like(!StringUtils.isBlank(collegeDto.getName()),College::getName,collegeDto.getName());
        List<CollegeVo> collegeVoList = collegeDao.selectListPage(page, classQueryWrapper);
        return collegeVoList;
    }
}
