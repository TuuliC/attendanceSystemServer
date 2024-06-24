package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tuuli.dao.CCDao;
import com.tuuli.dao.CourseDao;
import com.tuuli.dao.StudentDao;
import com.tuuli.domain.Course;
import com.tuuli.domain.Record;
import com.tuuli.dao.RecordDao;
import com.tuuli.domain.Student;
import com.tuuli.dto.CallNameDto;
import com.tuuli.dto.ListAttendanceDto;
import com.tuuli.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.CallNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordDao, Record> implements IRecordService {

    @Autowired
    private RecordDao recordDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CCDao ccDao;
    @Autowired
    private CourseDao courseDao;

    @Override
    public void markAttendance(ListAttendanceDto listAttendanceDto, boolean isEnd) {
        Record newRecord = new Record();
        for (int i = 0; i < listAttendanceDto.getIds().length; i++) {
            Integer studentId = listAttendanceDto.getIds()[i];
            newRecord.setStuId(studentId);
            newRecord.setCourseId(listAttendanceDto.getCourseId());
            newRecord.setStatus(listAttendanceDto.getStatus());
            newRecord.setTime(new Timestamp(new Date().getTime()));
            //查询该学生是否已点名，若已点名，则更新记录，若未点名，则添加记录
            LambdaQueryWrapper<Record> eq = new QueryWrapper<Record>().lambda().
                    eq(Record::getStuId, studentId).eq(Record::getCourseId, listAttendanceDto.getCourseId());
            Record oldRecord = recordDao.selectOne(eq);
            if (isEnd) {
                if (oldRecord.getStatus().equals("no"))
                    //结束签到，将未签到的学生状态改为缺勤
                    recordDao.update(newRecord, eq);
            } else {
                if (oldRecord == null)
                    recordDao.insert(newRecord);
                else
                    recordDao.update(newRecord, eq);
            }
        }
    }

    @Override
    public List<CallNameVo> randomAttendance(CallNameDto callNameDto) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.in("class.id", Arrays.asList(callNameDto.getClassList()))
                .eq("course.id", callNameDto.getCourseId())
                .eq("student.deleted", 0);
        List<CallNameVo> callNameVoList = studentDao.getRandomStuList(studentQueryWrapper);
        //查询0号学生的点名状态
        LambdaQueryWrapper<Record> recordLambdaQueryWrapper = new LambdaQueryWrapper<>();
        recordLambdaQueryWrapper.select(Record::getStatus)
                .eq(Record::getStuId, callNameVoList.get(0).getId())
                .eq(Record::getCourseId, callNameDto.getCourseId());
        Record record = recordDao.selectOne(recordLambdaQueryWrapper);
        callNameVoList.get(0).setStatus(record == null ? null : record.getStatus());
        return callNameVoList;
    }

    @Override
    public Map<String, String> getAttendanceStatus(Integer stuId) {
        Map<String, String> map = new HashMap<>();
        final List<Record> recordList = recordDao.selectList(new LambdaQueryWrapper<Record>().eq(Record::getStuId, stuId).orderByDesc(Record::getTime));
        if (recordList == null || recordList.size() == 0) {
            return null;
        }
        Record record = recordList.get(0);
        if (record != null && Objects.equals(record.getStatus(), "no")) {
            final Course course = courseDao.selectById(record.getCourseId());
            map.put("courseName", course.getCourseName());
            map.put("courseId", String.valueOf(course.getId()));
            return map;
//            return recordDao.getAttendanceCourseName(stuId);
        }
        return null;
    }

}
