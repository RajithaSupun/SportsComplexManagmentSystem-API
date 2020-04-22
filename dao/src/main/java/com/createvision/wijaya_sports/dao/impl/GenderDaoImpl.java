package com.createvision.wijaya_sports.dao.impl;

import com.createvision.wijaya_sports.dao.GenderDao;
import com.createvision.wijaya_sports.model.Gender;
import org.springframework.stereotype.Repository;

@Repository("genderDao")
public class GenderDaoImpl extends AbstractDaoImpl<Gender, Long> implements GenderDao {
}
