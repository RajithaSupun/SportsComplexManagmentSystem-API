package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.ReservationDao;
import com.createvision.wijaya_sports.model.Reservation;
import com.createvision.wijaya_sports.service.ReservationService;
import com.createvision.wijaya_sports.valuesObject.ReservationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("reservation")
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationDao reservationDao;

    @Autowired
    CommonFunctionImpl commonFunction;


    @Override
    public List<ReservationVO> getAllReservation() throws Exception {
        try {
            List<ReservationVO> reservationVOList = new ArrayList<>();
            List<Reservation> reservations = reservationDao.getAll();

            for (Reservation res : reservations) {
                ReservationVO reservationVO = new ReservationVO();
                reservationVO.setFirstName(res.getFirstName());
                reservationVO.setReservationId(res.getId());
                reservationVO.setLastName(res.getLastName());
                reservationVO.setDate(commonFunction.convertDateToString(res.getDate()));
                reservationVO.setSport(res.getSport());
                reservationVOList.add(reservationVO);
                reservationVO.setContactNumber(res.getContactNumber());
                reservationVO.setTime(res.getTime());
            }
            return reservationVOList;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ReservationVO createReservation(ReservationVO reservationVO) throws Exception {
        try {
            Reservation reservation = new Reservation();

            reservation.setFirstName(reservationVO.getFirstName());
            reservation.setLastName(reservationVO.getLastName());
            reservation.setDate(commonFunction.getDateTimeByDateString(reservationVO.getDate()));
            reservation.setTime(reservationVO.getTime());
            reservation.setContactNumber(reservationVO.getContactNumber());
            reservation.setSport(reservationVO.getSport());
            reservationDao.save(reservation);

            return reservationVO;

        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public ReservationVO updateReservation(ReservationVO reservationVO) throws Exception {

        try {

            Reservation reservation = reservationDao.get(reservationVO.getReservationId());
            reservation.setSport(reservationVO.getSport());
            reservation.setDate(commonFunction.getDateTimeByDateString(reservationVO.getDate()));
            reservation.setFirstName(reservationVO.getFirstName());
            reservation.setLastName(reservationVO.getLastName());
            reservation.setTime(reservationVO.getTime());
            reservation.setContactNumber(reservationVO.getContactNumber());
            reservationDao.save(reservation);
            return reservationVO;

        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public void deleteReservation(Long reservationId) throws Exception {

        try {
            Reservation reservation =reservationDao.get(reservationId);
            reservationDao.delete(reservation);

        } catch (Exception e) {

        }
    }
}
