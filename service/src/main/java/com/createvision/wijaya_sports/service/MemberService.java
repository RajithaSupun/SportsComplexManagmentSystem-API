package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.valuesObject.MemberVO;
import com.createvision.wijaya_sports.valuesObject.UserDetailVO;

import java.util.List;

public interface MemberService {
    MemberVO createNewMember (MemberVO memberVO) throws Exception;
    public void deleteMember(Long memberId) throws Exception;
    public MemberVO updateMember(MemberVO memberVO)throws Exception;
    public List<MemberVO> getAllMember() throws Exception;
    public List<MemberVO> getAllMemberDetails() throws Exception;
    public MemberVO getMemberById(Long memberId) throws Exception;
    public UserDetailVO userLogin(UserDetailVO userDetailVO)throws Exception;
//    public MemberVO getMemberByNIC(String nic) throws Exception;



}
