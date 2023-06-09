package com.tuuli.service;

import com.tuuli.domain.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuuli.dto.CallNameDto;
import com.tuuli.dto.ListAttendanceDto;
import com.tuuli.vo.CallNameVo;
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
public interface IRecordService extends IService<Record> {
    void markAttendance(ListAttendanceDto listAttendanceDto);

    List<CallNameVo> randomAttendance(CallNameDto callNameDto);
}
