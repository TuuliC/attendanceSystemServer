package com.tuuli.service.impl;

import com.tuuli.domain.College;
import com.tuuli.dao.CollegeDao;
import com.tuuli.service.ICollegeService;
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
public class CollegeServiceImpl extends ServiceImpl<CollegeDao, College> implements ICollegeService {

}
