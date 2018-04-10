package com.haier.m.entity.vo;

import java.io.Serializable;
/**
 * 限购条件VO实体
 * @author wang
 *
 */
public class OrderLimitConditionVo implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer productId;  //商品id
    private Integer number;     //下单数量
    private String consignee;   //收货人
    private String mobile;      //收货人手机号
    private String billCompany; //发票抬头
    private String shippingMode;//物流模式
    private Integer region;     //订单区县Id
    private Integer street;     //订单街道Id
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getConsignee() {
        return consignee;
    }
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getBillCompany() {
        return billCompany;
    }
    public void setBillCompany(String billCompany) {
        this.billCompany = billCompany;
    }
    public String getShippingMode() {
        return shippingMode;
    }
    public void setShippingMode(String shippingMode) {
        this.shippingMode = shippingMode;
    }
    public Integer getRegion() {
        return region;
    }
    public void setRegion(Integer region) {
        this.region = region;
    }
    public Integer getStreet() {
        return street;
    }
    public void setStreet(Integer street) {
        this.street = street;
    }
}
