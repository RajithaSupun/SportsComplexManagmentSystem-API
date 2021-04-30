package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.valuesObject.PaymentVO;

import java.util.List;

public interface PaymentService {
    List<PaymentVO> getAllPayment() throws Exception;
    PaymentVO createPayment(PaymentVO paymentVO)throws Exception;
    PaymentVO updatePayment(PaymentVO paymentVO)throws Exception;
    public void deletePayment(Long paymentId) throws Exception;
    public PaymentVO createGuestPayment(PaymentVO paymentVO) throws Exception;

}
