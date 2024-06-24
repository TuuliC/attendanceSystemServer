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
import com.tuuli.vo.PageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
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
        System.out.println(collegeId.length);
        System.out.println(collegeId[0]);
        QueryWrapper<Classs> classLambdaQueryWrapper = new QueryWrapper<>();
        classLambdaQueryWrapper.eq("class.deleted", 0)
                .lambda().in(collegeId.length > 0 && collegeId[0] != null, Classs::getCollegeId, Arrays.asList(collegeId));
        List<CollegeAndClassAndCourseVo> classVoList = classDao.getAllClass(classLambdaQueryWrapper);
        System.out.println(classVoList);
        return classVoList;
    }

    @Override
    public PageVo<ClassVo> getClassPage(ClassDto classDto) {
        IPage<Classs> page = new Page<>(classDto.getPage(), classDto.getPageSize());
        QueryWrapper<Classs> classQueryWrapper = new QueryWrapper<>();
        classQueryWrapper.eq("class.deleted", 0).eq("college.deleted", 0)
                .lambda().in(classDto.getCollegeList().length > 0, Classs::getCollegeId, Arrays.asList(classDto.getCollegeList()))
                .like(!StringUtils.isBlank(classDto.getName()), Classs::getClassName, classDto.getName());
        List<ClassVo> classVoList = classDao.selectListPage(page, classQueryWrapper);
        Integer count = classDao.selectListPageCount(classQueryWrapper);

        PageVo<ClassVo> classVoPageVo = new PageVo<>();
        classVoPageVo.setDataList(classVoList);
        classVoPageVo.setCount(count);
        return classVoPageVo;
    }

    @Override
    public ClassVo queryClassById(Integer id) {
        ClassVo classVo = classDao.queryClassById(id);
        return classVo;
    }

    @Override
    public void updateClass(Classs classs) {
        classDao.updateById(classs);
    }

    @Override
    public void addClass(Classs classs) {
        classDao.insert(classs);
    }

    @Override
    public void deleteClass(Integer[] id) {
        classDao.deleteBatchIds(Arrays.asList(id));
    }
}
