package com.haier.m.entity.item;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * projectName mobile-item-group
 * Created by dongchang'an on 2016/1/29 16:10.
 * description
 */
public class O2OPrdStoreProducts implements Serializable {
    private int        storeProductId;
    private int        storeId;
    private String     storeCode;
    private String     sku;
    private int        stockNum;         //非实时的库存数
    private int        onSale;
    private int        createUserId;
    private Date       createTime;
    private int        lastUpdateUserId;
    private Date       lastUpdateTime;
    private BigDecimal limitPrice;       //最低售价
    private BigDecimal brokeragePrice;  //佣金金额

    public int getStoreProductId() {
        return storeProductId;
    }

    public void setStoreProductId(int storeProductId) {
        this.storeProductId = storeProductId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    public int getOnSale() {
        return onSale;
    }

    public void setOnSale(int onSale) {
        this.onSale = onSale;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(int lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(BigDecimal limitPrice) {
        this.limitPrice = limitPrice;
    }

    public BigDecimal getBrokeragePrice() {
        return brokeragePrice;
    }

    public void setBrokeragePrice(BigDecimal brokeragePrice) {
        this.brokeragePrice = brokeragePrice;
    }
}
