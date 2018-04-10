package com.haier.m.entity.order;

import java.io.Serializable;
import java.util.List;

public class OrderQueryParam implements Serializable {

    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;
    
    private Integer memberId;
    
    private Integer loginMemberId;
    
    private List<Integer> memberList;
    
    private List<Integer> includeOrderProductId;
    
    private List<Integer> excludeOrderProductId;
    
    private List<Integer> assessOrderProductId;
    
    private String ckCode;
    
    private String key;
    
    private Integer orderStatus;
    
    private Integer pageBeg;
    
    private Integer pageNum;
    
    private int outDateTimeStamp = (int)(System.currentTimeMillis()/1000 - 90 * 24 * 3600);
    
    /**
     * 订单列表来源 0：微店主订单，1：用户订单
     */
    private Integer ordersFlag;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getLoginMemberId() {
        return loginMemberId;
    }

    public void setLoginMemberId(Integer loginMemberId) {
        this.loginMemberId = loginMemberId;
    }

    public List<Integer> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Integer> memberList) {
        this.memberList = memberList;
    }

    public String getCkCode() {
        return ckCode;
    }

    public void setCkCode(String ckCode) {
        this.ckCode = ckCode;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPageBeg() {
        return pageBeg;
    }

    public void setPageBeg(Integer pageBeg) {
        this.pageBeg = pageBeg;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List<Integer> getIncludeOrderProductId() {
        return includeOrderProductId;
    }

    public void setIncludeOrderProductId(List<Integer> includeOrderProductId) {
        this.includeOrderProductId = includeOrderProductId;
    }
    
    public List<Integer> getExcludeOrderProductId() {
        return excludeOrderProductId;
    }

    public void setExcludeOrderProductId(List<Integer> excludeOrderProductId) {
        this.excludeOrderProductId = excludeOrderProductId;
    }

    public List<Integer> getAssessOrderProductId() {
        return assessOrderProductId;
    }

    public void setAssessOrderProductId(List<Integer> assessOrderProductId) {
        this.assessOrderProductId = assessOrderProductId;
    }

    public Integer getOrdersFlag() {
        return ordersFlag;
    }

    public void setOrdersFlag(Integer ordersFlag) {
        this.ordersFlag = ordersFlag;
    }

    public int getOutDateTimeStamp() {
        return outDateTimeStamp;
    }

    public void setOutDateTimeStamp(int outDateTimeStamp) {
        this.outDateTimeStamp = outDateTimeStamp;
    }    
}
