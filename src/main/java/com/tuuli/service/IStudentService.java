package com.tuuli.service;

import com.tuuli.domain.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuuli.dto.CallNameDto;
import com.tuuli.dto.StudentDto;
import com.tuuli.vo.CallNameVo;
import com.tuuli.vo.PageVo;
import com.tuuli.vo.StudentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
public interface IStudentService extends IService<Student> {
    PageVo<StudentVo> getStudentPage(StudentDto studentDto);

    PageVo<CallNameVo> getListCallPage(CallNameDto callNameDto);

    StudentVo queryStudentById(Integer id);

    void updateStudent(Student student);

    void addStudent(Student student);

    void deleteStudent(Integer[] id);
}
