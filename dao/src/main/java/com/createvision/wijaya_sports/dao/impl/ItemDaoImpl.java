package com.createvision.wijaya_sports.dao.impl;

import com.createvision.wijaya_sports.dao.ItemDao;
import com.createvision.wijaya_sports.model.Item;
import org.springframework.stereotype.Repository;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDaoImpl<Item, Long> implements ItemDao {

}
