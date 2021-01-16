package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.PaymentDao;
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


    @Override
    public List<PaymentVO> getAllPayment() throws Exception {
        try {
           List<PaymentVO> paymentVOList = new ArrayList<>();
           List<Payment> paymentList =paymentDao.getAll();

            for (Payment pay : paymentList) {
                PaymentVO paymentVO =new PaymentVO();
                paymentVO.setAmount(pay.getAmount());
                paymentVO.setDate(commonFunction.convertDateToString(pay.getDate()));
                paymentVO.setMemberId(pay.getMember().getId());
                paymentVO.setStatus(pay.getStatus());

                paymentVOList.add(paymentVO);
            }

            return paymentVOList;
        }catch (Exception e){
          throw e;
        }

    }

    @Override
    public PaymentVO createReservation(PaymentVO paymentVO) throws Exception {
        try {
            return null;
        }catch (Exception e){
            throw e;
        }
    }
}
