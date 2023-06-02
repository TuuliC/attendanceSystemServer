package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuuli.domain.Classs;
import com.tuuli.dao.ClassDao;
import com.tuuli.dto.ClassDto;
import com.tuuli.service.IClassService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.ClassVo;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
public class ClassServiceImpl extends ServiceImpl<ClassDao, Classs> implements IClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public List<CollegeAndClassAndCourseVo> getAllClass(Integer[] collegeId) {
        QueryWrapper<Classs> classLambdaQueryWrapper = new QueryWrapper<>();
        classLambdaQueryWrapper.lambda().in(Classs::getCollegeId,Arrays.asList(collegeId));
        List<CollegeAndClassAndCourseVo> classVoList = classDao.getAllClass(classLambdaQueryWrapper);
        return classVoList;
    }

    @Override
    public List<ClassVo> getClassPage(ClassDto classDto) {
        IPage<Classs> page = new Page<>(classDto.getPage(), classDto.getPageSize());
        LambdaQueryWrapper<Classs> classQueryWrapper = new LambdaQueryWrapper<>();
        classQueryWrapper.in(classDto.getCollegeList().length>0, Classs::getCollegeId, Arrays.asList(classDto.getCollegeList()))
                .like(!StringUtils.isBlank(classDto.getName()),Classs::getClassName,classDto.getName());
        List<ClassVo> classVoList = classDao.selectListPage(page, classQueryWrapper);
        return classVoList;
    }
}
