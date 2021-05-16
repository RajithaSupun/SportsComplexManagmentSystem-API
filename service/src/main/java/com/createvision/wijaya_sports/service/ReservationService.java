package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.valuesObject.ReservationVO;

import java.util.List;

public interface ReservationService {
   public List<ReservationVO> getAllReservation() throws Exception;
   public ReservationVO createReservation(ReservationVO reservationVO)throws Exception;
   public ReservationVO updateReservation(ReservationVO reservationVO)throws Exception;
   public void deleteReservation(Long reservationId)throws Exception;



}
