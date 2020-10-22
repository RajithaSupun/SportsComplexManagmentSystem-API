package com.createvision.wijaya_sports.service.impl;

import com.createvision.wijaya_sports.dao.GenderDao;
import com.createvision.wijaya_sports.dao.MemberDao;
import com.createvision.wijaya_sports.model.Gender;
import com.createvision.wijaya_sports.model.Member;
import com.createvision.wijaya_sports.model.Sports;
import com.createvision.wijaya_sports.service.MemberService;
import com.createvision.wijaya_sports.valuesObject.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.PublicKey;
@Service("memberService")
@Transactional

public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberDao memberDao;

    @Autowired
    CommonFunctionImpl commonFunction;

    @Autowired
    GenderDao genderDao;

    @Override
    public MemberVO createNewMember(MemberVO memberVO) throws Exception {
        try {
            Member member=new Member();
            Gender gender = genderDao.get(memberVO.getGenderId());
            member.setFirstName(memberVO.getFirstName());
            member.setLastName(memberVO.getLastName());
            member.setAddress(memberVO.getAddress());
            member.setNic(memberVO.getNic());
            member.setDateOfBirth(commonFunction.getDateTimeByDateString(memberVO.getDateOfBirth()));
            member.setGender(gender);
            member.setJoinDate(commonFunction.getDateTimeByDateString(memberVO.getJoinedDate()));
            if (memberVO.getSportsId() == 1) {
                member.setSports(Sports.BADMINTON);
            }
            else if (memberVO.getSportsId() == 2){
                member.setSports(Sports.SWIMMING);
            }
            else {member.setSports(Sports.GYM);
            }
            return memberVO;
        }catch (Exception e)
        {
            throw e;
        }
    }
}
