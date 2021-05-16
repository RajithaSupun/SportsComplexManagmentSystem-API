package com.createvision.wijaya_sports.dao;

import com.createvision.wijaya_sports.model.Payment;

import java.util.Date;
import java.util.List;

public interface PaymentDao extends AbstractDao<Payment,Long>{
    List<Object[]> getPaymentDetailsByDateRange(Date fromDate, Date toDate)throws Exception;
    List<Payment> getPaymentByNic(String nic) throws Exception;
}
