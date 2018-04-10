package com.haier.m.entity.order;

import java.io.Serializable;
import java.util.Date;

public class OrderLimitCondition implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String limitCondition;
    private Integer isLimitValue;
    private Date modifyTime;
    private String modifyUser;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLimitCondition() {
        return limitCondition;
    }
    public void setLimitCondition(String limitCondition) {
        this.limitCondition = limitCondition;
    }
    public Integer getIsLimitValue() {
        return isLimitValue;
    }
    public void setIsLimitValue(Integer isLimitValue) {
        this.isLimitValue = isLimitValue;
    }
    public Date getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    public String getModifyUser() {
        return modifyUser;
    }
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
    
    
    
}
