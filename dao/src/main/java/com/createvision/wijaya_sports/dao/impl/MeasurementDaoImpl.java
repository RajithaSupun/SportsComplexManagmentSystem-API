package com.createvision.wijaya_sports.dao.impl;

import com.createvision.wijaya_sports.dao.MeasurementDao;
import com.createvision.wijaya_sports.model.Measurement;
import org.springframework.stereotype.Repository;

@Repository("measurementDao")
public class MeasurementDaoImpl extends AbstractDaoImpl<Measurement, Long> implements MeasurementDao {
}
