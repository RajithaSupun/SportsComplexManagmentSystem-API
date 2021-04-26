package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.MemberDao;
import com.createvision.wijaya_sports.dao.PaymentDao;
import com.createvision.wijaya_sports.model.Member;
import com.createvision.wijaya_sports.model.Payment;
import com.createvision.wijaya_sports.service.PaymentService;
import com.createvision.wijaya_sports.valuesObject.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("payment")
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    CommonFunctionImpl commonFunction;

    @Autowired
    MemberDao memberDao;


    @Override
    public List<PaymentVO> getAllPayment() throws Exception {
        try {
            List<PaymentVO> paymentVOList = new ArrayList<>();
            List<Payment> paymentList = paymentDao.getAll();

            for (Payment pay : paymentList) {
                PaymentVO paymentVO = new PaymentVO();
                paymentVO.setAmount(pay.getAmount());
                paymentVO.setDate(commonFunction.convertDateToString(pay.getDate()));
                paymentVO.setMemberId(pay.getMember().getId());
                paymentVO.setStatus(pay.getRemark());

                paymentVOList.add(paymentVO);
            }

            return paymentVOList;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public PaymentVO createPayment(PaymentVO paymentVO) throws Exception {
        try {

            Member member =memberDao.get(paymentVO.getMemberId());
            Payment payment =new Payment();
            payment.setAmount(paymentVO.getAmount());
            payment.setDate(commonFunction.getDateTimeByDateString(paymentVO.getDate()));
            payment.setMember(member);
            payment.setRemark(paymentVO.getStatus());
            paymentDao.save(payment);

            return paymentVO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public PaymentVO updatePayment(PaymentVO paymentVO) throws Exception {
        try {
            Payment payment = paymentDao.get(paymentVO.getMemberId());
            Member member = memberDao.get(paymentVO.getMemberId());
            payment.setMember(member);
            payment.setDate(commonFunction.getDateTimeByDateString(paymentVO.getDate()));
            payment.setAmount(paymentVO.getAmount());
            paymentDao.save(payment);
            return paymentVO;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deletePayment(Long paymentId) throws Exception {

        try {
            Payment payment = paymentDao.get(paymentId);
            paymentDao.delete(payment);
        } catch (Exception e) {
            throw e;
        }
    }
}
