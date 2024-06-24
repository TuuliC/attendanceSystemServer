package com.tuuli.dao;

import com.tuuli.domain.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Mapper
public interface RecordDao extends BaseMapper<Record> {
    @Select("SELECT course_name FROM tb_student LEFT JOIN tb_cc on tb_student.class_id=tb_cc.class_id " +
            "LEFT JOIN tb_course on tb_cc.course_id = tb_course.id where tb_student.id=#{studentId} and `status`=0 LIMIT 1")
    String getAttendanceCourseName(Integer studentId);
}
