package com.tuuli.service;

import com.tuuli.domain.College;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuuli.dto.CollegeDto;
import com.tuuli.vo.CollegeAndClassAndCourseVo;
import com.tuuli.vo.CollegeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
public interface ICollegeService extends IService<College> {
    List<CollegeAndClassAndCourseVo> getAllCollege();

    List<CollegeVo> getCollegePage(CollegeDto collegeDto);

    void addCollege(College college);

    College queryClassById(Integer id);

    void updateCollege(College college);
}
