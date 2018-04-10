package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

public class OpAttribute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 钻石数量
     */
    private BigDecimal diamondCount = BigDecimal.ZERO;
    /**
     * 钻石金额
     */
    private BigDecimal diamondAmt = BigDecimal.ZERO;
    /**
     * 钻石是否结算佣金
     */
    private String diamondCommiSettle = "0";
    /**
     * 钻石是否结算货款
     */
    private String diamondPaymentSettle = "0";
    /**
     * 钻石是否开票
     */
    private String diamondBilling = "0";
    /**
     * 海贝数量
     */
    private BigDecimal seashellCount = BigDecimal.ZERO;
    /**
     * 海贝金额
     */
    private BigDecimal seashellAmt = BigDecimal.ZERO;
    /**
     * 海贝是否结算佣金
     */
    private String seashellCommiSettle = "0";
    /**
     * 海贝是否结算货款
     */
    private String seashellPaymentSettle = "0";
    /**
     * 海贝是否开票
     */
    private String seashellBilling = "0";
    /**
     * 保险积分数量
     */
    private BigDecimal insuranceCount = BigDecimal.ZERO;
    /**
     * 保险积分金额
     */
    private BigDecimal insuranceAmt = BigDecimal.ZERO;
    /**
     * 保险积分佣金是否结算
     */
    private String insuranceCommiSettle = "0";
    /**
     * 保险积分货款是否结算
     */
    private String insurancePaymentSettle = "0";
    /**
     * 保险积分是否开票
     */
    private String insuranceBilling = "0";
    /**
     * 银行优惠
     */
    private BigDecimal bankBenefit;
	/**
	 * 属性图片
	 */
	private String attrPic;
	/**
	 * 属性名称
	 */
	private String attrName;
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

	public String getAttrPic() {
		return attrPic;
	}

	public void setAttrPic(String attrPic) {
		this.attrPic = attrPic;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
}
