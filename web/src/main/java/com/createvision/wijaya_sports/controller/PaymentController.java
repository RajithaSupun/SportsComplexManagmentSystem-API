package com.createvision.wijaya_sports.controller;

import com.createvision.wijaya_sports.service.PaymentService;
import com.createvision.wijaya_sports.service.ReservationService;
import com.createvision.wijaya_sports.valuesObject.PaymentVO;
import com.createvision.wijaya_sports.valuesObject.ReservationVO;
import com.createvision.wijaya_sports.valuesObject.ReturnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getAllPayment() throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            List<PaymentVO> paymentVOList = paymentService.getAllPayment();
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(paymentVOList);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> createPayment(@RequestBody PaymentVO PaymentVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            PaymentVO paymentVO = paymentService.createPayment(PaymentVO);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(paymentVO);
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
    public ResponseEntity<Object> updatePayment(@RequestBody PaymentVO PaymentVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            PaymentVO paymentVO = paymentService.updatePayment(PaymentVO);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(paymentVO);
            return ResponseEntity.ok(returnVO);

        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }

    @RequestMapping(value = "/{paymentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Object> deletePayment(@PathVariable("paymentId") Long paymentId) throws Exception {

        ReturnVO returnVO = new ReturnVO();
        try {
            paymentService.deletePayment(paymentId);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            return ResponseEntity.ok(returnVO);
        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }

    @RequestMapping(value = "/guestPayment", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Object> createGuestPayment(@RequestBody PaymentVO PaymentVO) throws Exception {
        ReturnVO returnVO = new ReturnVO();
        try {
            PaymentVO paymentVO = paymentService.createPayment(PaymentVO);
            returnVO.setStatusCode(200);
            returnVO.setSuccess(true);
            returnVO.setResult(paymentVO);
            return ResponseEntity.ok(returnVO);

        } catch (Exception e) {
            returnVO.setResult(e);
            returnVO.setStatusCode(5001);
            returnVO.setSuccess(false);
            return ResponseEntity.ok(returnVO);
        }
    }


}
