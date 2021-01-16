package com.createvision.wijaya_sports.dao.impl;


import com.createvision.wijaya_sports.dao.PaymentDao;
import com.createvision.wijaya_sports.dao.ReservationDao;
import com.createvision.wijaya_sports.model.Payment;
import com.createvision.wijaya_sports.model.Reservation;
import org.springframework.stereotype.Repository;

@Repository("paymenrDao")
public class PaymentDaoImpl extends AbstractDaoImpl<Payment, Long> implements PaymentDao {

}
