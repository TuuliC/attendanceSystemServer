package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuuli.domain.Student;
import com.tuuli.dao.StudentDao;
import com.tuuli.dto.StudentDto;
import com.tuuli.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.StudentVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

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
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<StudentVo> getStudentPage(StudentDto studentDto) {
        IPage<Student> page = new Page<>(studentDto.getPage(), studentDto.getPageSize());
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq(studentDto.getCollegeId() != null, "class.college_id", studentDto.getCollegeId())
                .lambda().eq(!StringUtils.isBlank(studentDto.getGender()), Student::getGender, studentDto.getGender())
                .eq(studentDto.getClassId() != null, Student::getClassId, studentDto.getClassId());
        studentQueryWrapper.and(!StringUtils.isBlank(studentDto.getName()), qw -> qw.lambda()
                .like(Student::getName, studentDto.getName())
                .or()
                .like(Student::getNum, studentDto.getName()));
        List<StudentVo> studentVoList = studentDao.selectListPage(page, studentQueryWrapper);

        return studentVoList;


    }
}
