package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.GuestPaymentDao;
import com.createvision.wijaya_sports.dao.MemberDao;
import com.createvision.wijaya_sports.dao.PaymentDao;
import com.createvision.wijaya_sports.dao.RegistrationFreeDao;
import com.createvision.wijaya_sports.model.GuestPayment;
import com.createvision.wijaya_sports.model.Member;
import com.createvision.wijaya_sports.model.Payment;
import com.createvision.wijaya_sports.model.RegistrationFee;
import com.createvision.wijaya_sports.service.PaymentService;
import com.createvision.wijaya_sports.valuesObject.PaymentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("payment")
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Autowired
    CommonFunctionImpl commonFunction;

    @Autowired
    MemberDao memberDao;

    @Autowired
    RegistrationFreeDao registrationFreeDao;

    @Autowired
    GuestPaymentDao guestPaymentDao;


    @Override
    public List<PaymentVO> getAllPayment() throws Exception {
        try {
            List<PaymentVO> paymentVOList = new ArrayList<>();
            List<Payment> paymentList = paymentDao.getAll();
            List<RegistrationFee> registrationFeesList =registrationFreeDao.getAll();
            List<GuestPayment>guestPaymentList =guestPaymentDao.getAll();
            int counter = 1;

            for (Payment pay : paymentList) {
                Member member = memberDao.get(pay.getMember().getId());
                PaymentVO paymentVO = new PaymentVO();
                paymentVO.setAmount(pay.getAmount());
                paymentVO.setDate(commonFunction.convertDateToString(pay.getDate()));
                paymentVO.setMemberId(pay.getMember().getId());
                paymentVO.setStatus(pay.getRemark());
                paymentVO.setId(pay.getId());
                paymentVO.setName(member.getFirstName());
                paymentVO.setGuestMobile(member.getMobileNumber());
                paymentVO.setGuestNIC(member.getNic());
                paymentVO.setPaymentCounter(counter);
                paymentVO.setTableID(1);
                counter++;

                paymentVOList.add(paymentVO);
            }

            for (RegistrationFee rg:registrationFeesList) {
                PaymentVO paymentVO = new PaymentVO();
                paymentVO.setAmount(rg.getAmount());
                paymentVO.setDate(commonFunction.convertDateToString(rg.getDate()));
                paymentVO.setMemberId(rg.getMember() !=null ? rg.getMember().getId():0);
                paymentVO.setStatus("");
                paymentVO.setPaymentCounter(counter);
                paymentVO.setTableID(2);
                counter++;

                paymentVOList.add(paymentVO);

            }

            for (GuestPayment guest:guestPaymentList) {
                PaymentVO paymentVO = new PaymentVO();
                paymentVO.setAmount(guest.getAmount());
                paymentVO.setDate(commonFunction.convertDateToString(guest.getDate()));
                paymentVO.setName(guest.getName());
                paymentVO.setStatus(guest.getRemark());
                paymentVO.setMemberId(0L);
                paymentVO.setGuestNIC(guest.getGuestNIC());
                paymentVO.setGuestMobile(guest.getGuestMobile());
                paymentVO.setId(guest.getId());
                paymentVO.setPaymentCounter(counter);
                paymentVO.setTableID(3);
                counter++;

                paymentVOList.add(paymentVO);
            }




            return paymentVOList;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public PaymentVO createPayment(PaymentVO paymentVO) throws Exception {
        try {

            if (paymentVO.getMemberId() == 0) {
                GuestPayment guestPayment = new GuestPayment();
                guestPayment.setGuestName(paymentVO.getGuestName());
                guestPayment.setName(paymentVO.getGuestName());
                guestPayment.setAmount(paymentVO.getAmount());
                guestPayment.setDate(commonFunction.getDateTimeByDateString(paymentVO.getDate()));
                guestPayment.setGuestMobile(paymentVO.getGuestMobile());
                guestPayment.setGuestNIC(paymentVO.getGuestNIC());
                guestPayment.setRemark(paymentVO.getStatus());
                guestPaymentDao.save(guestPayment);
            } else {
                Member member = memberDao.get(paymentVO.getMemberId());

                Payment payment =new Payment();
                payment.setAmount(paymentVO.getAmount());
                payment.setDate(commonFunction.getDateTimeByDateString(paymentVO.getDate()));
                payment.setMember(member);
                payment.setRemark(paymentVO.getStatus());
                paymentDao.save(payment);

            }


            return paymentVO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public PaymentVO updatePayment(PaymentVO paymentVO) throws Exception {
        try {
            Payment payment = paymentDao.get(paymentVO.getId());
            Member member = memberDao.get(paymentVO.getMemberId());
            payment.setMember(member);
            payment.setDate(commonFunction.getDateTimeByDateString(paymentVO.getDate()));
            payment.setAmount(paymentVO.getAmount());
            paymentDao.save(payment);
            return paymentVO;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deletePayment(Long paymentId ,int tableId) throws Exception {

        try {
            if(tableId ==1){
                Payment payment = paymentDao.get(paymentId);
                paymentDao.delete(payment);
            }else if(tableId ==2){
                RegistrationFee registrationFee =registrationFreeDao.get(paymentId);
                registrationFreeDao.delete(registrationFee);
            } else if(tableId ==3){
                GuestPayment guestPayment =guestPaymentDao.get(paymentId);
                guestPaymentDao.delete(guestPayment);
            }

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public PaymentVO createGuestPayment(PaymentVO paymentVO) throws Exception {

        try {


            GuestPayment guestPayment =new GuestPayment();
            guestPayment.setId(guestPayment.getId());
            guestPayment.setAmount(paymentVO.getAmount());
//            guestPayment.setName(paymentVO.getName());
            guestPayment.setDate(commonFunction.getDateTimeByDateString(paymentVO.getDate()));
            guestPayment.setRemark(paymentVO.getStatus());
            guestPayment.setGuestNIC(paymentVO.getGuestNIC());
            guestPayment.setGuestName(paymentVO.getGuestName());
            guestPayment.setGuestMobile(paymentVO.getGuestMobile());
            guestPaymentDao.save(guestPayment);


            return paymentVO;
        } catch (Exception e) {
            throw e;
        }
    }
}
