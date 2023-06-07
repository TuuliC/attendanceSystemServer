package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tuuli.dao.ClassDao;
import com.tuuli.dao.CollegeDao;
import com.tuuli.dao.CourseDao;
import com.tuuli.domain.Course;
import com.tuuli.domain.Student;
import com.tuuli.dao.StudentDao;
import com.tuuli.dto.ListCallDto;
import com.tuuli.dto.StudentDto;
import com.tuuli.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.ListCallVo;
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
    public List<StudentVo> getStudentPage(StudentDto studentDto) {
        IPage<Student> page = new Page<>(studentDto.getPage(), studentDto.getPageSize());
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.in(studentDto.getCollegeList().length>0, "class.college_id", Arrays.asList(studentDto.getCollegeList()))
                .eq("student.deleted",0).eq("class.deleted",0).eq("college.deleted",0)
                .lambda().eq(!StringUtils.isBlank(studentDto.getGender()), Student::getGender, studentDto.getGender())
                .in(studentDto.getClassList().length>0, Student::getClassId, Arrays.asList(studentDto.getClassList()));

        studentQueryWrapper.and(!StringUtils.isBlank(studentDto.getName()), qw -> qw.lambda()
                .like(Student::getName, studentDto.getName())
                .or()
                .like(Student::getNum, studentDto.getName()));
        List<StudentVo> studentVoList = studentDao.selectListPage(page, studentQueryWrapper);

        return studentVoList;

    }

    @Override
    public List<ListCallVo> getListCallPage(ListCallDto listCallDto) {
        System.out.println("---\nlistCallDto = " + listCallDto);
        IPage<Student> page = new Page<>(listCallDto.getPage(), listCallDto.getPageSize());
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        Course course = courseDao.selectOne(new LambdaQueryWrapper<Course>().select(Course::getCourseName).eq(Course::getId, listCallDto.getCourseId()));
        studentQueryWrapper.in(listCallDto.getClassList().length>0,"student.class_id",Arrays.asList(listCallDto.getClassList()))
                .eq("re.course_name",course.getCourseName())
                .eq(!StringUtils.isBlank(listCallDto.getGender()),"student.gender",listCallDto.getGender())
                .like(!StringUtils.isBlank(listCallDto.getName()),"student.name",listCallDto.getName())
                .in(listCallDto.getStateList().length>0,"re.status",Arrays.asList(listCallDto.getStateList()));

        List<ListCallVo> listCallVoList= studentDao.getListCallPage(page,studentQueryWrapper);
        return listCallVoList;
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
