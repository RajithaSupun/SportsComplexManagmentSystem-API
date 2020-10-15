package com.createvision.wijaya_sports.dao.impl;


import com.createvision.wijaya_sports.dao.MemberDao;
import com.createvision.wijaya_sports.model.Member;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl extends AbstractDaoImpl<Member, Long> implements MemberDao {
}
