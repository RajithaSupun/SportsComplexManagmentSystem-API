package com.createvision.wijaya_sports.dao.impl;

import com.createvision.wijaya_sports.dao.RegistrationFreeDao;
import com.createvision.wijaya_sports.model.RegistrationFee;
import org.springframework.stereotype.Repository;

@Repository("RegistrationFree")
public class RegistrationFreeDaoImpl extends AbstractDaoImpl<RegistrationFee, Long> implements RegistrationFreeDao {
}
