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
            List<ReservationVO> reservationVOList =new ArrayList<>();
            List<Reservation> reservations =reservationDao.getAll();

            for (Reservation res: reservations) {
                ReservationVO reservationVO =new ReservationVO();
                reservationVO.setFirstName(res.getFirstName());
                reservationVO.setLastName(res.getLastName());
                reservationVO.setDate(commonFunction.convertDateToString(res.getDate()));
                reservationVO.setSport(res.getSport());
                reservationVOList.add(reservationVO);
            }
            return reservationVOList;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public ReservationVO createReservation(ReservationVO reservationVO) throws Exception {
        try {

            return reservationVO;
        }catch (Exception e){
            throw e;
        }
    }
}
