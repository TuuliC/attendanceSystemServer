package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuuli.dao.ClassDao;
import com.tuuli.dao.CollegeDao;
import com.tuuli.dao.CourseDao;
import com.tuuli.domain.Classs;
import com.tuuli.domain.College;
import com.tuuli.domain.Course;
import com.tuuli.domain.RecordDetail;
import com.tuuli.dao.RecordDetailDao;
import com.tuuli.dto.RecordDto;
import com.tuuli.service.IRecordDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.PageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Service
public class RecordDetailServiceImpl extends ServiceImpl<RecordDetailDao, RecordDetail> implements IRecordDetailService {

    @Autowired
    private RecordDetailDao recordDetailDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CollegeDao collegeDao;
    @Autowired
    private ClassDao classDao;

    @Override
    public PageVo<RecordDetail> getRecordPage(RecordDto recordDto) {

        //String courseName = null, collegeName = null, className = null;
        //recordDto获取的是id，需将id转为name
        String courseName = null;
        ArrayList<String> collegeName = new ArrayList<>(), className = new ArrayList<>();
        if (recordDto.getCourseId() != null) {
            LambdaQueryWrapper<Course> courseLambdaQueryWrapper = new LambdaQueryWrapper<>();
            courseLambdaQueryWrapper.select(Course::getCourseName).eq(Course::getId, recordDto.getCourseId());
            Course course = courseDao.selectOne(courseLambdaQueryWrapper);
            courseName = course.getCourseName();
        }
        if (recordDto.getCollegeList().length > 0) {
            LambdaQueryWrapper<College> collegeLambdaQueryWrapper = new LambdaQueryWrapper<>();
            collegeLambdaQueryWrapper.select(College::getCollegeName).in(College::getId, Arrays.asList(recordDto.getCollegeList()));
            List<College> collegeList = collegeDao.selectList(collegeLambdaQueryWrapper);
            //collegeName = college.getName();
            for (College c : collegeList
            ) {
                collegeName.add(c.getCollegeName());
            }
        }
        if (recordDto.getClassList().length > 0) {
            LambdaQueryWrapper<Classs> classLambdaQueryWrapper = new LambdaQueryWrapper<>();
            classLambdaQueryWrapper.select(Classs::getClassName).in(Classs::getId, Arrays.asList(recordDto.getClassList()));
            List<Classs> classList = classDao.selectList(classLambdaQueryWrapper);
//            className = classs.getClassName();
            for (Classs c : classList
            ) {
                className.add(c.getClassName());
            }
        }

        IPage<RecordDetail> page = new Page<>(recordDto.getPage(), recordDto.getPageSize());
        QueryWrapper<RecordDetail> recordQueryWrapper = new QueryWrapper<>();
        recordQueryWrapper.lambda().in(recordDto.getClassList().length > 0, RecordDetail::getClassName, className)
                .in(recordDto.getCollegeList().length > 0, RecordDetail::getCollegeName, collegeName)
                .eq(recordDto.getCourseId() != null, RecordDetail::getCourseName, courseName);
        recordQueryWrapper.lambda().and(!StringUtils.isBlank(recordDto.getName()), qw -> qw
                .like(RecordDetail::getName, recordDto.getName())
                .or()
                .like(RecordDetail::getNum, recordDto.getName()));
        IPage<RecordDetail> recordDetailIPage = recordDetailDao.selectPage(page, recordQueryWrapper);
        PageVo<RecordDetail> recordDetailPageVo = new PageVo<>();
        recordDetailPageVo.setDataList(recordDetailIPage.getRecords());
        recordDetailPageVo.setCount(recordDetailPageVo.getCount());
        return recordDetailPageVo;
    }
}
