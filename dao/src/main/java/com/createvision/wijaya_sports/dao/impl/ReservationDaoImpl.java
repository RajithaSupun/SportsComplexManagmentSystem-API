package com.createvision.wijaya_sports.dao.impl;

import com.createvision.wijaya_sports.dao.ReservationDao;
import com.createvision.wijaya_sports.model.Reservation;
import org.springframework.stereotype.Repository;

@Repository("reservationDao")
public class ReservationDaoImpl extends AbstractDaoImpl<Reservation, Long> implements ReservationDao {
}
