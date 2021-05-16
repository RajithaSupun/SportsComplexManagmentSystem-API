package com.createvision.wijaya_sports.dao.impl;


import com.createvision.wijaya_sports.dao.PaymentDao;
import com.createvision.wijaya_sports.dao.ReservationDao;
import com.createvision.wijaya_sports.model.Payment;
import com.createvision.wijaya_sports.model.Reservation;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("paymenrDao")
public class PaymentDaoImpl extends AbstractDaoImpl<Payment, Long> implements PaymentDao {

    public List<Object[]> getPaymentDetailsByDateRange(Date fromDate, Date toDate) throws Exception {
        Query query = getSession().createSQLQuery("CALL getPaymentDetailsByDate(?,?)");
        query.setParameter(0,fromDate);
        query.setParameter(1,toDate);
        List<Object[]> result = query.list();
        return result;
    }

    @Override
    public List<Payment> getPaymentByNic(String nic) throws Exception {
        Query query = getSession().createSQLQuery("SELECT * FROM payment WHERE ");
//        query.setParameter(0,fromDate);
//        query.setParameter(1,toDate);
        List<Object[]> result = query.list();
        return null;
    }
}
