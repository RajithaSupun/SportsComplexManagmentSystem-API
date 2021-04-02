package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.valuesObject.MemberVO;

public interface MemberService {
    MemberVO createNewMember (MemberVO memberVO) throws Exception;
    public void deleteMember(Long memberId) throws Exception;
    public MemberVO updateMember(MemberVO memberVO)throws Exception;


}
