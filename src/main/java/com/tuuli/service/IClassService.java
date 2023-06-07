package com.tuuli.service;

import com.tuuli.domain.Classs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuuli.dto.ClassDto;
import com.tuuli.vo.ClassVo;
import com.tuuli.vo.CollegeAndClassAndCourseVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
public interface IClassService extends IService<Classs> {
    List<CollegeAndClassAndCourseVo> getAllClass(Integer[] collegeId);

    List<ClassVo> getClassPage(ClassDto classDto);

    ClassVo queryClassById(Integer id);

    void updateClass(Classs classs);

    void addClass(Classs classs);

    void deleteClass(Integer[] id);
}
