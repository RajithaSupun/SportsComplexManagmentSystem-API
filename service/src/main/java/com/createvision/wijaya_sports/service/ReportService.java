package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.valuesObject.ReportVO;

import java.util.List;

public interface ReportService {
    public ReportVO getReportByReportType(String fromDate,String toDate,String reportType) throws Exception;

}
