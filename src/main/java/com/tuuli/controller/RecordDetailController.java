package com.tuuli.controller;


import com.tuuli.common.R;
import com.tuuli.domain.RecordDetail;
import com.tuuli.dto.RecordDto;
import com.tuuli.service.IRecordDetailService;
import com.tuuli.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * VIEW 前端控制器
 * </p>
 *
 * @author tuuli
 * @since 2023-05-22
 */
@CrossOrigin(origins = "http://localhost:8089", methods = {RequestMethod.POST}, allowCredentials = "true")
@RestController
@RequestMapping("/record_detail")
public class RecordDetailController {
    @Autowired
    private IRecordDetailService recordDetailService;

    @PostMapping("/getRecordPage")
    public R<PageVo<RecordDetail>> getRecordPage(@RequestBody RecordDto recordDto){
        PageVo<RecordDetail> recordDetailList = recordDetailService.getRecordPage(recordDto);
        return R.success(recordDetailList);
    }
}

