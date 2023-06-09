package com.tuuli.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tuuli.dao.StudentDao;
import com.tuuli.domain.Record;
import com.tuuli.dao.RecordDao;
import com.tuuli.domain.Student;
import com.tuuli.dto.CallNameDto;
import com.tuuli.dto.ListAttendanceDto;
import com.tuuli.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tuuli.vo.CallNameVo;
import com.tuuli.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
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
public class RecordServiceImpl extends ServiceImpl<RecordDao, Record> implements IRecordService {

    @Autowired
    private RecordDao recordDao;
    @Autowired
    private StudentDao studentDao;

    @Override
    public void markAttendance(ListAttendanceDto listAttendanceDto) {
        //System.out.println("listAttendanceVo = " + listAttendanceDto);
        Record newRecord = new Record();
        for (int i = 0; i < listAttendanceDto.getIds().length; i++) {
            Integer studentId = listAttendanceDto.getIds()[i];
            newRecord.setStuId(studentId);
            newRecord.setCourseId(listAttendanceDto.getCourseId());
            newRecord.setStatus(listAttendanceDto.getStatus());
            newRecord.setTime(new Timestamp(new Date().getTime()));
            LambdaQueryWrapper<Record> eq = new QueryWrapper<Record>().lambda().
                    eq(Record::getStuId, studentId).eq(Record::getCourseId, listAttendanceDto.getCourseId());
            Record oldRecord = recordDao.selectOne(eq);
            if (oldRecord == null)
                recordDao.insert(newRecord);
            else
                recordDao.update(newRecord, eq);


        }
    }

    @Override
    public List<CallNameVo> randomAttendance(CallNameDto callNameDto) {
        //System.out.println("callNameDto = " + callNameDto);
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.in("class.id", Arrays.asList(callNameDto.getClassList()))
                .eq("course.id", callNameDto.getCourseId())
                .eq("student.deleted", 0);
        List<CallNameVo> callNameVoList = studentDao.getRandomStuList(studentQueryWrapper);
        //System.out.println("callNameVoList = " + callNameVoList);
        //查询0号学生的点名状态
        LambdaQueryWrapper<Record> recordLambdaQueryWrapper = new LambdaQueryWrapper<>();
        recordLambdaQueryWrapper.select(Record::getStatus)
                .eq(Record::getStuId, callNameVoList.get(0).getId())
                .eq(Record::getCourseId, callNameDto.getCourseId());
        Record record = recordDao.selectOne(recordLambdaQueryWrapper);
        callNameVoList.get(0).setStatus(record==null?null:record.getStatus());
        //System.out.println("callNameVoList = " + callNameVoList);
        return callNameVoList;
    }
}
