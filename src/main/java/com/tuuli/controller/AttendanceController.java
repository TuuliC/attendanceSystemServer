package com.tuuli.controller;

import com.tuuli.common.R;
import com.tuuli.dao.StudentDao;
import com.tuuli.dto.CallNameDto;
import com.tuuli.dto.ListAttendanceDto;
import com.tuuli.service.ICCService;
import com.tuuli.service.IRecordService;
import com.tuuli.vo.CallNameVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author tuuli
 * @time Created in 2023/6/7 20:52
 * @description
 */
@CrossOrigin(origins = "http://localhost:8089", methods = {RequestMethod.POST, RequestMethod.GET}, allowCredentials = "true")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private IRecordService recordService;
    @Autowired
    private ICCService ccService;
    @Autowired
    private StudentDao studentDao;

    @PostMapping("/listAttendance")
    @PreAuthorize("hasAnyRole('1','2')")
    public R<String> listAttendance(@RequestBody ListAttendanceDto listAttendanceDto) {
        //System.out.println("listAttendanceVo = " + listAttendanceDto);
        recordService.markAttendance(listAttendanceDto, false);
        return R.success("success");
    }

    @PreAuthorize("hasAnyRole('1')")
    @PostMapping("/randomAttendance")
    public R<List<CallNameVo>> randomAttendance(@RequestBody CallNameDto callNameDto) {
        List<CallNameVo> studentVoList = recordService.randomAttendance(callNameDto);
        return R.success(studentVoList);
    }

    @PreAuthorize("hasAnyRole('1')")
    @PostMapping("/startAttendance")
    public R<String> startAttendance(@RequestBody ListAttendanceDto listAttendanceDto) {
        System.out.println("listAttendanceDto = " + listAttendanceDto);
        List<Integer> list = studentDao.selectIdByClassId(listAttendanceDto.getClasssId());
        listAttendanceDto.setIds(list.toArray(new Integer[0]));
        listAttendanceDto.setStatus("no");
        recordService.markAttendance(listAttendanceDto, false);
        ccService.setCCStatus(listAttendanceDto.getCourseId(), listAttendanceDto.getClasssId(), 1);
        return R.success("success");
    }

    @PreAuthorize("hasAnyRole('1')")
    @PostMapping("/endAttendance")
    public R<String> endAttendance(@RequestBody ListAttendanceDto listAttendanceDto) {
        System.out.println("listAttendanceDto = " + listAttendanceDto);
        List<Integer> list = studentDao.selectIdByClassId(listAttendanceDto.getClasssId());
        System.out.println("list.toArray(new Integer[0]) = " + Arrays.toString(list.toArray(new Integer[0])));
        listAttendanceDto.setIds(list.toArray(new Integer[0]));
        listAttendanceDto.setStatus("absent");
        recordService.markAttendance(listAttendanceDto, true);
        ccService.setCCStatus(listAttendanceDto.getCourseId(), listAttendanceDto.getClasssId(), 0);
        return R.success("success");
    }

    @PreAuthorize("hasAnyRole('2')")
    @GetMapping("/getAttendanceStatus/{id}")
    public R<Map<String, String>> getAttendanceStatus(@PathVariable("id") Integer stuId) {
        return R.success(recordService.getAttendanceStatus(stuId));
    }

}
