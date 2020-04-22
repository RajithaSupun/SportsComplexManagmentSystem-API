package com.createvision.wijaya_sports.valuesObject;

import java.util.Set;

public class ItemVO {
    Long id;
    Long itemId;
    String itemName;
    String description;
    Long categoryId;
    Long itemDetailId;
    double sellingQuantity;
    Set<ItemDetailsVO> itemDetailList;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id;}

    public Long getItemId() {return itemId;}
    public void setItemId(Long itemId) {this.itemId = itemId;}

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public Long getItemDetailId() { return itemDetailId; }
    public void setItemDetailId(Long itemDetailId) { this.itemDetailId = itemDetailId; }

    public double getSellingQuantity() { return sellingQuantity; }
    public void setSellingQuantity(double sellingQuantity) { this.sellingQuantity = sellingQuantity; }

    public Set<ItemDetailsVO> getItemDetailList() { return itemDetailList; }
    public void setItemDetailList(Set<ItemDetailsVO> itemDetailList) { this.itemDetailList = itemDetailList; }


}