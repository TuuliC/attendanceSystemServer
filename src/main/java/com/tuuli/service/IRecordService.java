package com.tuuli.service;

import com.tuuli.domain.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuuli.dto.CallNameDto;
import com.tuuli.dto.ListAttendanceDto;
import com.tuuli.vo.CallNameVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
public interface IRecordService extends IService<Record> {

    void markAttendance(ListAttendanceDto listAttendanceDto, boolean isEnd);

    List<CallNameVo> randomAttendance(CallNameDto callNameDto);

    /**
     * 获取学生班级课程当前签到状态，正在签到返回对应的课程名称，否则返回null
     * @return
     */
    Map<String,String> getAttendanceStatus(Integer stuId);
}
