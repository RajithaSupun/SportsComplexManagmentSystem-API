package com.createvision.wijaya_sports.dao.impl;

import com.createvision.wijaya_sports.dao.ItemDetailDao;
import com.createvision.wijaya_sports.model.ItemDetail;
import org.springframework.stereotype.Repository;

@Repository("itemDetailDao")
public class ItemDetailDaoImpl extends AbstractDaoImpl<ItemDetail, Long> implements ItemDetailDao {
}
