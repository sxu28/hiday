package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author 纪祥
 * @date 2015-11-24
 * @email
 */
public class OrderInfo implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2788227923747792958L;

    //订单Id
    private Integer id;
    //订单号
    private String orderSn;
    //下单人
    private Integer memberId;
    //添加时间
    private String addTime;
    //下单时间时间戳
    private Integer addTimeStamp;
    //订单状态
    private Integer orderStatus;
    //付款时间
    private String payTime;
    //支付时间时间戳
    private Integer payTimeStamp;
    //付款状态
    private Integer paymentStatus;
    //商品金额
    private Double productAmount;
    //订单总金额
    private Double orderAmount;
    //收货人
    private String consignee;
    //地区名称
    private String regionName;
    //详细地址
    private  String address;
    //收货人手机号
    private String mobile;
    //确认时间
    private String confirmTime;
    //首次确认时间
    private String firstConfirmTime;
    //微店主Id
    private Integer ckCode;
    //是否是货到付款订单
    private Integer isCod;
    //支付方式
    private String paymentCode;
    //货到付款确认时间
    private Integer codConfirmTime;
    //订单发票Id
    private Integer memberInvoiceId;
    //订单类型
    private Integer orderType;
    //关联订单号
    private String relationOrderSn;
    //街道
    private Integer street;
    //来源
    private String source;
    
    private String couponCode;
    
    private BigDecimal couponCodeValue;
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Integer getAddTimeStamp() {
		return addTimeStamp;
	}

	public void setAddTimeStamp(Integer addTimeStamp) {
		this.addTimeStamp = addTimeStamp;
	}

	public Integer getPayTimeStamp() {
		return payTimeStamp;
	}

	public void setPayTimeStamp(Integer payTimeStamp) {
		this.payTimeStamp = payTimeStamp;
	}

	public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Double getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Double productAmount) {
        this.productAmount = productAmount;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getFirstConfirmTime() {
        return firstConfirmTime;
    }

    public void setFirstConfirmTime(String firstConfirmTime) {
        this.firstConfirmTime = firstConfirmTime;
    }

    public Integer getCkCode() {
        return ckCode;
    }

    public void setCkCode(Integer ckCode) {
        this.ckCode = ckCode;
    }

    public Integer getIsCod() {
        return isCod;
    }

    public void setIsCod(Integer isCod) {
        this.isCod = isCod;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public Integer getCodConfirmTime() {
        return codConfirmTime;
    }

    public void setCodConfirmTime(Integer codConfirmTime) {
        this.codConfirmTime = codConfirmTime;
    }

    public Integer getMemberInvoiceId() {
        return memberInvoiceId;
    }

    public void setMemberInvoiceId(Integer memberInvoiceId) {
        this.memberInvoiceId = memberInvoiceId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getRelationOrderSn() {
        return relationOrderSn;
    }

    public void setRelationOrderSn(String relationOrderSn) {
        this.relationOrderSn = relationOrderSn;
    }

	public Integer getStreet() {
		return street;
	}

	public void setStreet(Integer street) {
		this.street = street;
	}

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public BigDecimal getCouponCodeValue() {
        return couponCodeValue;
    }

    public void setCouponCodeValue(BigDecimal couponCodeValue) {
        this.couponCodeValue = couponCodeValue;
    }
	
}
