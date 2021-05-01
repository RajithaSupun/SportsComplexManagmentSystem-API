package com.createvision.wijaya_sports.controller;


import com.createvision.wijaya_sports.service.ReportService;
import com.createvision.wijaya_sports.valuesObject.PaymentVO;
import com.createvision.wijaya_sports.valuesObject.ReportVO;
import com.createvision.wijaya_sports.valuesObject.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "//fromdate/{fromDate}/todate/{toDate}/type/{type}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getAllPayment(@PathVariable("fromDate") String fromDate,@PathVariable("toDate") String toDate,@PathVariable("type") String reportType) throws Exception{

        ReturnVO returnVO = new ReturnVO();
        try {
            ReportVO reportVOList = reportService.getReportByReportType(fromDate,toDate,reportType);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(reportVOList);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }



}
