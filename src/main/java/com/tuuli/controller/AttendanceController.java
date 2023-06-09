package com.tuuli.controller;

import com.tuuli.common.R;
import com.tuuli.dto.CallNameDto;
import com.tuuli.dto.ListAttendanceDto;
import com.tuuli.service.IRecordService;
import com.tuuli.vo.CallNameVo;
import com.tuuli.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tuuli
 * @time Created in 2023/6/7 20:52
 * @description
 */
@CrossOrigin(origins = "http://localhost:8089", methods = {RequestMethod.POST,RequestMethod.GET}, allowCredentials = "true")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private IRecordService recordService;

    @PostMapping("/listAttendance")
    public R<String> listAttendance(@RequestBody ListAttendanceDto listAttendanceDto){
        //System.out.println("listAttendanceVo = " + listAttendanceDto);
        recordService.markAttendance(listAttendanceDto);
        return R.success("success");
    }

    @PostMapping("/randomAttendance")
    public R<List<CallNameVo>> randomAttendance(@RequestBody CallNameDto callNameDto){
        List<CallNameVo> studentVoList = recordService.randomAttendance(callNameDto);
        return R.success(studentVoList);
    }

}
