package com.createvision.wijaya_sports.dao;


import com.createvision.wijaya_sports.model.GuestPayment;

import java.util.Date;
import java.util.List;

public interface GuestPaymentDao extends AbstractDao<GuestPayment,Long>{
    List<GuestPayment> getGuestPaymentsByDateRange(String fromDate, String toDate);
}
