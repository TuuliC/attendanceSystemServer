package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuuli.dao.ClassDao;
import com.tuuli.dao.CollegeDao;
import com.tuuli.dao.CourseDao;
import com.tuuli.domain.Student;
import com.tuuli.dao.StudentDao;
import com.tuuli.dto.CallNameDto;
import com.tuuli.dto.StudentDto;
import com.tuuli.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.CallNameVo;
import com.tuuli.vo.PageVo;
import com.tuuli.vo.StudentVo;
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
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements IStudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private CollegeDao collegeDao;
    @Autowired
    private ClassDao classDao;

    @Override
    public PageVo<StudentVo> getStudentPage(StudentDto studentDto) {
        IPage<Student> page = new Page<>(studentDto.getPage(), studentDto.getPageSize());
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        System.out.println("studentDto = " + studentDto);
        studentQueryWrapper.in(studentDto.getCollegeList().length > 0, "class.college_id", Arrays.asList(studentDto.getCollegeList()))
                .eq("student.deleted", 0).eq("class.deleted", 0).eq("college.deleted", 0)
                .lambda().eq(!StringUtils.isBlank(studentDto.getGender()), Student::getGender, studentDto.getGender())
                .in(studentDto.getClassList().length > 0, Student::getClassId, Arrays.asList(studentDto.getClassList()));

        studentQueryWrapper.and(!StringUtils.isBlank(studentDto.getName()), qw -> qw.lambda()
                .like(Student::getName, studentDto.getName())
                .or()
                .like(Student::getNum, studentDto.getName()));
        List<StudentVo> studentVoList = studentDao.selectListPage(page, studentQueryWrapper);
        Integer count = studentDao.selectListPageCount(studentQueryWrapper);

        PageVo<StudentVo> studentVoPageVo = new PageVo<>();
        studentVoPageVo.setDataList(studentVoList);
        studentVoPageVo.setCount(count);
        return studentVoPageVo;

    }

    @Override
    public PageVo<CallNameVo> getListCallPage(CallNameDto callNameDto) {
        System.out.println("---\nlistCallDto = " + callNameDto);
        IPage<Student> page = new Page<>(callNameDto.getPage(), callNameDto.getPageSize());
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
//        Course course = courseDao.selectOne(new LambdaQueryWrapper<Course>().select(Course::getCourseName).eq(Course::getId, listCallDto.getCourseId()));
//        studentQueryWrapper.in(listCallDto.getClassList().length>0,"student.class_id",Arrays.asList(listCallDto.getClassList()))
//                .eq("re.course_name",course.getCourseName())
//                .eq(!StringUtils.isBlank(listCallDto.getGender()),"student.gender",listCallDto.getGender())
//                .like(!StringUtils.isBlank(listCallDto.getName()),"student.name",listCallDto.getName())
//                .in(listCallDto.getStateList().length>0,"re.status",Arrays.asList(listCallDto.getStateList()));
        studentQueryWrapper.eq("course.id", callNameDto.getCourseId())
                .eq(!StringUtils.isBlank(callNameDto.getGender()),"student.gender", callNameDto.getGender())
                .eq("student.deleted", 0)
                .in("class.id", Arrays.asList(callNameDto.getClassList()))
                .in(callNameDto.getStateList().length>0,"record.status", Arrays.asList(callNameDto.getStateList()))
                .and(!StringUtils.isBlank(callNameDto.getName()), qw -> qw
                        .like("student.stu_name", callNameDto.getName())
                        .or()
                        .like("student.stu_num", callNameDto.getName()));
        List<CallNameVo> listCallVoName = studentDao.getListCallPage(page, studentQueryWrapper);
        Integer count = studentDao.getListCallPageCount(studentQueryWrapper);

        PageVo<CallNameVo> callNameVoPageVo = new PageVo<>();
        callNameVoPageVo.setDataList(listCallVoName);
        callNameVoPageVo.setCount(count);
        return callNameVoPageVo;
    }

    @Override
    public StudentVo queryStudentById(Integer id) {
        StudentVo studentVo = studentDao.queryStudentById(id);
        return studentVo;
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateById(student);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void deleteStudent(Integer[] id) {
        studentDao.deleteBatchIds(Arrays.asList(id));
    }
}
