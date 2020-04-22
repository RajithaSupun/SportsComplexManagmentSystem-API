package com.createvision.wijaya_sports.service;

import com.createvision.wijaya_sports.model.Item;
import com.createvision.wijaya_sports.valuesObject.ItemVO;

import java.util.List;

public interface ItemService {

    List<ItemVO> getAllItems() throws Exception;

    Item getItemById(long id) throws Exception;

    void saveItem(Item item) throws Exception;

    void updateItem(long id, Item item) throws  Exception;

    void deleteItem(long id) throws Exception;
}
