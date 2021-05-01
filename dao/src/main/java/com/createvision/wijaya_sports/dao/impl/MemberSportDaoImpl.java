package com.createvision.wijaya_sports.dao.impl;


import com.createvision.wijaya_sports.dao.MemberSportDao;
import com.createvision.wijaya_sports.model.MemberSport;
import org.springframework.stereotype.Repository;

@Repository("memberSportDao")
public class MemberSportDaoImpl extends AbstractDaoImpl<MemberSport, Long> implements MemberSportDao {
}
