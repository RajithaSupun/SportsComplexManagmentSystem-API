package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.MemberDao;
import com.createvision.wijaya_sports.dao.PaymentDao;
import com.createvision.wijaya_sports.model.Payment;
import com.createvision.wijaya_sports.service.ReportService;
import com.createvision.wijaya_sports.valuesObject.PaymentVO;
import com.createvision.wijaya_sports.valuesObject.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    CommonFunctionImpl commonFunction;

    @Autowired
    MemberDao memberDao;

    @Override
    public ReportVO getReportByReportType(String fromDate,String toDate,String reportType) throws Exception {

        Date FromDate = commonFunction.getDateTimeByDateString(fromDate);
        Date ToDate = commonFunction.getDateTimeByDateString(toDate);

        List<PaymentVO> paymentVOList =new ArrayList<>();

        ReportVO reportVO =new ReportVO();
            if(reportType.equals("payment_report")){
                List<Object[]> paymentList =paymentDao.getPaymentDetailsByDateRange(FromDate,ToDate);
                for (Object[] payment:paymentList) {
                    PaymentVO paymentVO =new PaymentVO();
                    paymentVO.setAmount(Double.parseDouble(payment[1].toString()));
                    paymentVO.setDate(payment[0].toString());
                    paymentVO.setName(memberDao.get(Long.parseLong(payment[2].toString())).getFirstName());
                    paymentVO.setStatus(payment[3].toString());
                    paymentVOList.add(paymentVO);
                }
                reportVO.setPaymentVOList(paymentVOList);
            }
            else{

            }


        return reportVO;
    }
}
