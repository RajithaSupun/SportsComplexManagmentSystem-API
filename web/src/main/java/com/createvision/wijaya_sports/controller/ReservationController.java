package com.createvision.wijaya_sports.controller;

import com.createvision.wijaya_sports.service.ReservationService;
import com.createvision.wijaya_sports.valuesObject.ReservationVO;
import com.createvision.wijaya_sports.valuesObject.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getAllReservation() throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            List<ReservationVO> reservationVOList = reservationService.getAllReservation();
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(reservationVOList);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }


    @RequestMapping(value = "/", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Object> updateReservation(@RequestBody ReservationVO reservationVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            ReservationVO updatedReservation = reservationService.updateReservation(reservationVO);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(updatedReservation);
            return ResponseEntity.ok(returnVO);

        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }

//    @RequestMapping(value = "/{paymentId}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public ResponseEntity<Object> deleteReservation(@PathVariable("reservationId") Long reservationId) throws Exception {
//
//        ReturnVO returnVO = new ReturnVO();
//        try {
//            paymentService.deletePayment(paymentId);
//            returnVO.setStatusCode(200);
//            returnVO.setSuccess(true);
//            return ResponseEntity.ok(returnVO);
//        } catch (Exception e) {
//            returnVO.setResult(e);
//            returnVO.setStatusCode(5001);
//            returnVO.setSuccess(false);
//            return ResponseEntity.ok(returnVO);
//        }
//    }
}
