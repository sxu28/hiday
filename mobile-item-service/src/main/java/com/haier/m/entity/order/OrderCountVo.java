package com.haier.m.entity.order;

import java.io.Serializable;

public class OrderCountVo implements Serializable {

    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;

    private Integer waitPay = 0;

    private Integer waitShipping = 0;

    private Integer waitReceipt = 0;

    private Integer waitComment = 0;

    private Integer rightService = 0;

    public Integer getWaitPay() {
	return waitPay;
    }

    public void setWaitPay(Integer waitPay) {
	this.waitPay = waitPay;
    }

    public Integer getWaitShipping() {
	return waitShipping;
    }

    public void setWaitShipping(Integer waitShipping) {
	this.waitShipping = waitShipping;
    }

    public Integer getWaitReceipt() {
	return waitReceipt;
    }

    public void setWaitReceipt(Integer waitReceipt) {
	this.waitReceipt = waitReceipt;
    }

    public Integer getWaitComment() {
	return waitComment;
    }

    public void setWaitComment(Integer waitComment) {
	this.waitComment = waitComment;
    }

    public Integer getRightService() {
	return rightService;
    }

    public void setRightService(Integer rightService) {
	this.rightService = rightService;
    }

}
