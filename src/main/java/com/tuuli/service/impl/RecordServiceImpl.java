package com.tuuli.service.impl;

import com.tuuli.domain.Record;
import com.tuuli.dao.RecordDao;
import com.tuuli.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordDao, Record> implements IRecordService {

}
