package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.valuesObject.ReservationVO;

import java.util.List;

public interface ReservationService {
    List<ReservationVO> getAllReservation() throws Exception;
    ReservationVO createReservation(ReservationVO reservationVO)throws Exception;
}
