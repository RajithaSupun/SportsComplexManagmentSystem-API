package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.valuesObject.PaymentVO;

import java.util.List;

public interface PaymentService {
    List<PaymentVO> getAllPayment() throws Exception;
    PaymentVO createReservation(PaymentVO paymentVO)throws Exception;
}
