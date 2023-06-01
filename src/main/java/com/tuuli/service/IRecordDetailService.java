package com.tuuli.service;

import com.tuuli.domain.RecordDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tuuli.dto.RecordDto;

import java.util.List;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
public interface IRecordDetailService extends IService<RecordDetail> {

    List<RecordDetail> getRecordPage(RecordDto recordDto);
}
