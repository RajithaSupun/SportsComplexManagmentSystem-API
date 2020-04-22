package com.createvision.wijaya_sports.valuesObject;

import com.createvision.wijaya_sports.model.InvoiceItemDetail;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvoiceVO {
    private double totalAmount;
    private double advanceAmount;
    private Date delivaryDate;
    private Date invoiceDate;
    private double balanceAmount;
    private String invoiceNumber;
    private Set<InvoiceItemDetail> invoiceItemDetails = new HashSet<InvoiceItemDetail>(0);
    private Long userId;
    private List<ItemVO> itemList;
    private Long id;

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getAdvanceAmount() { return advanceAmount; }
    public void setAdvanceAmount(double advanceAmount) { this.advanceAmount = advanceAmount; }

    public Date getDelivaryDate() { return delivaryDate; }
    public void setDelivaryDate(Date delivaryDate) { this.delivaryDate = delivaryDate; }

    public Date getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(Date invoiceDate) { this.invoiceDate = invoiceDate; }

    public double getBalanceAmount() { return balanceAmount; }
    public void setBalanceAmount(double balanceAmount) { this.balanceAmount = balanceAmount; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public Set<InvoiceItemDetail> getInvoiceItemDetails() { return invoiceItemDetails; }
    public void setInvoiceItemDetails(Set<InvoiceItemDetail> invoiceItemDetails) { this.invoiceItemDetails = invoiceItemDetails;}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public List<ItemVO> getItemList() { return itemList; }
    public void setItemList(List<ItemVO> itemList) { this.itemList = itemList; }

    public Long getId() {return id;}
    public void setId(Long id) { this.id = id; }
}