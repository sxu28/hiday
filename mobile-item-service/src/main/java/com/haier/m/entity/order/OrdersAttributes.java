package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单扩展属性表
 */
public class OrdersAttributes implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8407557697346276885L;

    private Integer           id;                                      //ID
    private Integer           iswww;                                   //是否3w订单
    private Integer           orderId;                                 //订单ID
    private String            lbx;                                     //菜鸟物流单号（lbx号）
    private String            sourceOrderSn;                           //外部订单号
    private Integer           orderYwType;                             //订单业务类型
    private java.util.Date    createTime;                              //添加数据时间
    private java.util.Date    updateTime;                              //数据更新时间

    private BigDecimal        diamondCount;                            //'钻石数量'
    private BigDecimal        diamondAmt;                              //'钻石金额'
    private String            diamondProportion;                       //兑换比例
    private String            diamondCommiSettle;                      //'钻石佣金结算(1:是 0:否)'
    private String            diamondPaymentSettle;                    //'钻石是否结算货款(1:是 0:否)'
    private String            diamondBilling;                          //'钻石是否开票(1:是 0:否)'

    private BigDecimal        seashellCount;                           //'海贝积分数量'
    private BigDecimal        seashellAmt;                             //'海贝积分金额'
    private String            seashellProportion;                      //兑换比例
    private String            seashellCommiSettle;                     //'海贝积分佣金结算(1:是 0:否)'
    private String            seashellPaymentSettle;                   //'海贝积分是否结算货款(1:是 0:否)'
    private String            seashellBilling;                         //'海贝积分是否开票(1:是 0:否)'

    private BigDecimal        insuranceCount;                          //'保险积分数量'
    private BigDecimal        insuranceAmt;                            //'保险积分金额'
    private String            insuranceProportion;                     //兑换比例
    private String            insuranceCommiSettle;                    //'保险积分佣金结算(1:是 0:否)'
    private String            insurancePaymentSettle;                  //'保险积分货款结算(1:是 0:否)'
    private String            insuranceBilling;                        //'保险积分是否开票(1:是 0:否)'
    private BigDecimal        bankBenefit;                             // 银行优惠金额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIswww() {
        return iswww;
    }

    public void setIswww(Integer iswww) {
        this.iswww = iswww;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getLbx() {
        return lbx;
    }

    public void setLbx(String lbx) {
        this.lbx = lbx;
    }

    public String getSourceOrderSn() {
        return sourceOrderSn;
    }

    public void setSourceOrderSn(String sourceOrderSn) {
        this.sourceOrderSn = sourceOrderSn;
    }

    public Integer getOrderYwType() {
        return orderYwType;
    }

    public void setOrderYwType(Integer orderYwType) {
        this.orderYwType = orderYwType;
    }

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getDiamondCount() {
        return diamondCount;
    }

    public void setDiamondCount(BigDecimal diamondCount) {
        this.diamondCount = diamondCount;
    }

    public BigDecimal getDiamondAmt() {
        return diamondAmt;
    }

    public void setDiamondAmt(BigDecimal diamondAmt) {
        this.diamondAmt = diamondAmt;
    }

    public String getDiamondProportion() {
        return diamondProportion;
    }

    public void setDiamondProportion(String diamondProportion) {
        this.diamondProportion = diamondProportion;
    }

    public String getDiamondCommiSettle() {
        return diamondCommiSettle;
    }

    public void setDiamondCommiSettle(String diamondCommiSettle) {
        this.diamondCommiSettle = diamondCommiSettle;
    }

    public String getDiamondPaymentSettle() {
        return diamondPaymentSettle;
    }

    public void setDiamondPaymentSettle(String diamondPaymentSettle) {
        this.diamondPaymentSettle = diamondPaymentSettle;
    }

    public String getDiamondBilling() {
        return diamondBilling;
    }

    public void setDiamondBilling(String diamondBilling) {
        this.diamondBilling = diamondBilling;
    }

    public BigDecimal getSeashellCount() {
        return seashellCount;
    }

    public void setSeashellCount(BigDecimal seashellCount) {
        this.seashellCount = seashellCount;
    }

    public BigDecimal getSeashellAmt() {
        return seashellAmt;
    }

    public void setSeashellAmt(BigDecimal seashellAmt) {
        this.seashellAmt = seashellAmt;
    }

    public String getSeashellProportion() {
        return seashellProportion;
    }

    public void setSeashellProportion(String seashellProportion) {
        this.seashellProportion = seashellProportion;
    }

    public String getSeashellCommiSettle() {
        return seashellCommiSettle;
    }

    public void setSeashellCommiSettle(String seashellCommiSettle) {
        this.seashellCommiSettle = seashellCommiSettle;
    }

    public String getSeashellPaymentSettle() {
        return seashellPaymentSettle;
    }

    public void setSeashellPaymentSettle(String seashellPaymentSettle) {
        this.seashellPaymentSettle = seashellPaymentSettle;
    }

    public String getSeashellBilling() {
        return seashellBilling;
    }

    public void setSeashellBilling(String seashellBilling) {
        this.seashellBilling = seashellBilling;
    }

    public BigDecimal getInsuranceCount() {
        return insuranceCount;
    }

    public void setInsuranceCount(BigDecimal insuranceCount) {
        this.insuranceCount = insuranceCount;
    }

    public BigDecimal getInsuranceAmt() {
        return insuranceAmt;
    }

    public void setInsuranceAmt(BigDecimal insuranceAmt) {
        this.insuranceAmt = insuranceAmt;
    }

    public String getInsuranceProportion() {
        return insuranceProportion;
    }

    public void setInsuranceProportion(String insuranceProportion) {
        this.insuranceProportion = insuranceProportion;
    }

    public String getInsuranceCommiSettle() {
        return insuranceCommiSettle;
    }

    public void setInsuranceCommiSettle(String insuranceCommiSettle) {
        this.insuranceCommiSettle = insuranceCommiSettle;
    }

    public String getInsurancePaymentSettle() {
        return insurancePaymentSettle;
    }

    public void setInsurancePaymentSettle(String insurancePaymentSettle) {
        this.insurancePaymentSettle = insurancePaymentSettle;
    }

    public String getInsuranceBilling() {
        return insuranceBilling;
    }

    public void setInsuranceBilling(String insuranceBilling) {
        this.insuranceBilling = insuranceBilling;
    }

    public BigDecimal getBankBenefit() {
        return bankBenefit;
    }

    public void setBankBenefit(BigDecimal bankBenefit) {
        this.bankBenefit = bankBenefit;
    }

}
