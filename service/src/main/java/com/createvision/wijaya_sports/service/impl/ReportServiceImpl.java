package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.GuestPaymentDao;
import com.createvision.wijaya_sports.dao.MemberDao;
import com.createvision.wijaya_sports.dao.PaymentDao;
import com.createvision.wijaya_sports.dao.impl.GuestPaymentDaoImpl;
import com.createvision.wijaya_sports.model.Member;
import com.createvision.wijaya_sports.model.Payment;
import com.createvision.wijaya_sports.model.GuestPayment;
import com.createvision.wijaya_sports.service.ReportService;
import com.createvision.wijaya_sports.valuesObject.PaymentVO;
import com.createvision.wijaya_sports.valuesObject.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.From;
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
    GuestPaymentDao guestPaymentDao;

    @Autowired
    CommonFunctionImpl commonFunction;

    @Autowired
    MemberDao memberDao;


    @Override
    public ReportVO getReportByReportType(String fromDate,String toDate,String reportType) throws Exception {

        Date FromDate = commonFunction.getDateTimeByDateString(fromDate);
        Date ToDate = commonFunction.getDateTimeByDateString(toDate);
//        Date from = commonFunction.getDateTimeByDateString(fromDate);
//        Date to = commonFunction.getDateTimeByDateString(toDate);

        List<PaymentVO> paymentVOList =new ArrayList<>();

        ReportVO reportVO =new ReportVO();
            if(reportType.equals("payment_report")){
                List<Object[]> paymentList =paymentDao.getPaymentDetailsByDateRange(FromDate,ToDate);
                for (Object[] payment:paymentList) {
                    Member member = memberDao.get(Long.parseLong(payment[2].toString()));
                    PaymentVO paymentVO =new PaymentVO();
                    paymentVO.setGuestMobile(member.getMobileNumber());
                    paymentVO.setGuestNIC(member.getNic());
                    paymentVO.setAmount(Double.parseDouble(payment[1].toString()));
                    paymentVO.setDate(payment[0].toString());
                    paymentVO.setName(member.getFirstName());
                    paymentVO.setStatus(payment[3].toString());
                    paymentVO.setMemberId(member.getId());
                    paymentVOList.add(paymentVO);
                }

                List<GuestPayment> guestPaymentList = guestPaymentDao.getAll();

                for (GuestPayment guestPayment :  guestPaymentList) {
                    if (guestPayment.getDate().after(FromDate) &&
                            guestPayment.getDate().before(ToDate)) {
                        PaymentVO paymentVO =new PaymentVO();
                        paymentVO.setGuestMobile(guestPayment.getGuestMobile());
                        paymentVO.setGuestNIC(guestPayment.getGuestNIC());
                        paymentVO.setAmount(guestPayment.getAmount());
                        paymentVO.setDate(commonFunction.convertDateToString(guestPayment.getDate()));
                        paymentVO.setName(guestPayment.getName() + "-guest");
                        paymentVO.setStatus(guestPayment.getRemark());
                        paymentVO.setMemberId(0L);
                        paymentVOList.add(paymentVO);
                    }
                }

                reportVO.setPaymentVOList(paymentVOList);
            }
            else if(reportType.equals("member_report")) {
                List<Member> memberList = memberDao.getAll();

                for (Member member : memberList) {
                    if (member.getJoinDate().after(FromDate) &&
                            member.getJoinDate().before(ToDate)) {
                        PaymentVO paymentVO = new PaymentVO();
                        paymentVO.setGuestMobile(member.getMobileNumber());
                        paymentVO.setGuestNIC(member.getNic());

                        paymentVO.setDate(commonFunction.convertDateToString(member.getJoinDate()));
                        paymentVO.setName(member.getFirstName());
                        paymentVO.setAddress(member.getAddress());
                        paymentVO.setGender(member.getGender().getGenderName());
                        paymentVO.setMemberId(member.getId());
                        paymentVOList.add(paymentVO);
                    }
                    reportVO.setPaymentVOList(paymentVOList);
                }
            }

        return reportVO;
    }
}
