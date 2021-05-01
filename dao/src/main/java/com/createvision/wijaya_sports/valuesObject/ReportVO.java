package com.createvision.wijaya_sports.valuesObject;

import java.util.List;

public class ReportVO {
    private String todate;
    private String fromdate;
    private String type;
    private List<PaymentVO> paymentVOList;


    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<PaymentVO> getPaymentVOList() {
        return paymentVOList;
    }

    public void setPaymentVOList(List<PaymentVO> paymentVOList) {
        this.paymentVOList = paymentVOList;
    }
}
