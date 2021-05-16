package com.createvision.wijaya_sports.dao.impl;

import com.createvision.wijaya_sports.dao.GuestPaymentDao;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import com.createvision.wijaya_sports.model.GuestPayment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("guestPaymentDaoImpl")
public class GuestPaymentDaoImpl extends AbstractDaoImpl<GuestPayment, Long> implements GuestPaymentDao, Serializable {

    @Override
    public List<GuestPayment> getGuestPaymentsByDateRange(String fromDate, String toDate) {
        List<GuestPayment> guestPaymentList = new ArrayList<>();
        String queryString = "SELECT * FROM guest_payment WHERE date BETWEEN date = :from AND date = :to";
        Query query = getSession().createSQLQuery(queryString);

        query.setParameter("from", fromDate);
        query.setParameter("to", toDate);
        List results = query.list();

        for (Object result: results) {
            guestPaymentList.add((GuestPayment) result);
        }

        return  guestPaymentList;
    }
}
