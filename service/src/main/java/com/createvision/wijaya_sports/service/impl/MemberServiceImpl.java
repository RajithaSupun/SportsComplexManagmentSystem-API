package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.GenderDao;
import com.createvision.wijaya_sports.dao.MeasurementDao;
import com.createvision.wijaya_sports.dao.MemberDao;
import com.createvision.wijaya_sports.dao.RegistrationFreeDao;
import com.createvision.wijaya_sports.model.*;
import com.createvision.wijaya_sports.service.MemberService;
import com.createvision.wijaya_sports.valuesObject.EmployeeVO;
import com.createvision.wijaya_sports.valuesObject.MeasurementVO;
import com.createvision.wijaya_sports.valuesObject.MemberVO;
import com.createvision.wijaya_sports.valuesObject.RegistrationFeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Service("memberService")
@Transactional

public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao memberDao;

    @Autowired
    CommonFunctionImpl commonFunction;

    @Autowired
    GenderDao genderDao;

    @Autowired
    MeasurementDao measurementDao;

    @Autowired
    RegistrationFreeDao registrationFreeDao;

    @Override
    public MemberVO createNewMember(MemberVO memberVO) throws Exception {
        try {
            Member member = new Member();
            Gender gender = genderDao.get(memberVO.getGenderId());
            member.setFirstName(memberVO.getFirstName());
            member.setLastName(memberVO.getLastName());
            member.setAddress(memberVO.getAddress());
            member.setNic(memberVO.getNic());
            member.setDateOfBirth(commonFunction.getDateTimeByDateString(memberVO.getDateOfBirth()));
            member.setGender(gender);
            member.setJoinDate(commonFunction.getDateTimeByDateString(memberVO.getJoinedDate()));
            member.setSports(Sports.GYM);
            Measurement saveMeasurement = new Measurement();
            for (MeasurementVO measurementVO : memberVO.getMeasurement()) {
                Measurement measurement = new Measurement();
                measurement.setAbdomen(Double.toString(measurementVO.getAbdomen()) != null ? Double.toString(measurementVO.getAbdomen()) : "");
                measurement.setChest(Double.toString(measurementVO.getChest()) != null ? Double.toString(measurementVO.getChest()) : "");
                measurement.setHips(Double.toString(measurementVO.getHips()) != null ? Double.toString(measurementVO.getHips()) : "");
                measurement.setLeftCalf(Double.toString(measurementVO.getLeft_calf()) != null ? Double.toString(measurementVO.getLeft_calf()) : "");
                measurement.setRightCalf(Double.toString(measurementVO.getRight_calf()) != null ? Double.toString(measurementVO.getRight_calf()) : "");
                measurement.setLeftThigh(Double.toString(measurementVO.getLeft_thigh()) != null ? Double.toString(measurementVO.getLeft_thigh()) : "");
                measurement.setWrist(Double.toString(measurementVO.getWrist()) != null ? Double.toString(measurementVO.getWrist()) : "");
                Long saveId = measurementDao.save(measurement);
                saveMeasurement = measurementDao.get(saveId);

            }
            member.setMeasurement(saveMeasurement);
            RegistrationFee saveRegistrationFee = new RegistrationFee();
            for (RegistrationFeeVO rgis : memberVO.getRegistrationFee()) {
                RegistrationFee registrationFee = new RegistrationFee();
                registrationFee.setAmount(rgis.getAmount());
                registrationFee.setDescription(rgis.getDescription());
                //  registrationFee.setDate(commonFunction.getDateTimeByDateString(rgis.getDate()));
                Long saveId = registrationFreeDao.save(registrationFee);
                saveRegistrationFee = registrationFreeDao.get(saveId);
            }

            member.setRegistrationFee(saveRegistrationFee);


            if (memberVO.getSportId() == 1) {
                member.setSports(Sports.BADMINTON);
            } else if (memberVO.getSportId() == 2) {
                member.setSports(Sports.SWIMMING);
            } else {
                member.setSports(Sports.GYM);
            }
            System.out.println("Come to this");
            memberDao.save(member);

        } catch (Exception e) {
            throw e;
        }
        return memberVO;
    }

    @Override
    public void deleteMember(Long memberId) throws Exception {
        try {
            Member member = memberDao.get(memberId);
            memberDao.delete(member);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public MemberVO updateMember(MemberVO memberVO) throws Exception {

        try {
            Member member = memberDao.get(memberVO.getMemberId());
            member.setAddress(memberVO.getAddress());
            member.setGender(genderDao.get(memberVO.getGenderId()));
            member.setFirstName(memberVO.getFirstName());
            member.setLastName(memberVO.getLastName());
            member.setDateOfBirth(commonFunction.getCurrentDateAndTimeByTimeZone(memberVO.getDateOfBirth()));
            member.setNic(memberVO.getNic());
            member.setMobileNumber(memberVO.getMobileNumber());
            memberDao.save(member);
            return memberVO;
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public List<MemberVO> getAllMember() throws Exception {
        List<MemberVO> memberVOList = new ArrayList<>();
        try {
            List<Member> memberList = memberDao.getAll();
            for (Member member : memberList) {
                MemberVO memberVO = new MemberVO();
                memberVO.setMemberId(member.getId());
                memberVO.setFirstName(member.getFirstName());
                memberVO.setLastName(member.getLastName());
                memberVO.setAddress(member.getAddress());
                memberVO.setDateOfBirth(commonFunction.convertDateToString(member.getDateOfBirth()));
                memberVO.setNic(member.getNic());
                memberVO.setJoinedDate(commonFunction.convertDateToString(member.getJoinDate()));
                memberVO.setMobileNumber(member.getMobileNumber());
                memberVO.setSportName(member.getSports().name());
                Gender gender = genderDao.get(member.getGender().getId());
                memberVO.setGenderId(gender.getId());
                memberVOList.add(memberVO);

            }
            return memberVOList;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<MemberVO> getAllMemberDetails() throws Exception {
        List<MemberVO> memberVOList = new ArrayList<>();

        try {
            List<Member> memberList = memberDao.getAll();
            for (Member member : memberList) {
                MemberVO memberVO = new MemberVO();
                memberVO.setMemberId(member.getId());
                memberVO.setFirstName(member.getFirstName());
                memberVO.setLastName(member.getLastName());
                memberVO.setAddress(member.getAddress());
                memberVO.setDateOfBirth(commonFunction.convertDateToString(member.getDateOfBirth()));
                memberVO.setNic(member.getNic());
                memberVO.setJoinedDate(commonFunction.convertDateToString(member.getJoinDate()));
                memberVO.setMobileNumber(member.getMobileNumber());
                memberVO.setSportName(member.getSports().name());
                Gender gender = genderDao.get(member.getGender().getId());


                //   measurementVO.setRight_arm(Double.parseDouble(member.getMeasurement().getRightArm()));

                if (member.getMeasurement() != null) {
                    List<MeasurementVO> measurementVOList = new ArrayList<>();
                    MeasurementVO measurementVO = new MeasurementVO();
                    measurementVO.setAbdomen(Double.parseDouble(member.getMeasurement().getAbdomen()!=null?member.getMeasurement().getAbdomen():"0.00"));
                    measurementVO.setChest(Double.parseDouble(member.getMeasurement().getChest()!=null?member.getMeasurement().getChest():"0.00"));
                    measurementVO.setHips(Double.parseDouble(member.getMeasurement().getHips()!=null?member.getMeasurement().getHips():"0.00"));
                    measurementVO.setLeft_calf(Double.parseDouble(member.getMeasurement().getLeftCalf()!=null?member.getMeasurement().getLeftCalf():"0.00"));
                    measurementVO.setLeft_thigh(Double.parseDouble(member.getMeasurement().getLeftThigh()!=null?member.getMeasurement().getLeftThigh():"0.00"));
                    measurementVO.setRight_calf(Double.parseDouble(member.getMeasurement().getRightCalf()!=null?member.getMeasurement().getRightCalf():"0.00"));
                    measurementVO.setWrist(Double.parseDouble(member.getMeasurement().getWrist()!=null?member.getMeasurement().getWrist():"0.00"));
                    measurementVOList.add(measurementVO);
                    memberVO.setMeasurement(measurementVOList);
                }

                if (member.getRegistrationFee() != null) {
                    List<RegistrationFeeVO> registrationFeeVOList = new ArrayList<>();
                    RegistrationFeeVO registrationFeeVO = new RegistrationFeeVO();
                    registrationFeeVO.setAmount(Double.toString(member.getRegistrationFee().getAmount())!=null?member.getRegistrationFee().getAmount():0.00);
                    registrationFeeVO.setDescription(member.getRegistrationFee().getDescription()!=null?member.getRegistrationFee().getDescription():"");
                    registrationFeeVOList.add(registrationFeeVO);
                    memberVO.setRegistrationFee(registrationFeeVOList);
                }


                memberVO.setGenderId(gender.getId());
                memberVOList.add(memberVO);

            }

            return memberVOList;
        } catch (Exception e) {

            throw e;
        }

    }
}
