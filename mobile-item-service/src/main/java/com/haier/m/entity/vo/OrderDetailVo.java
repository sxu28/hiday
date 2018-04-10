package com.haier.m.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetailVo implements Serializable {

	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;
	/* 网单基本信息部分 */
	/**
	 * 网单ID
	 */
	private Integer orderProductId;
	/**
	 * 网单号
	 */
	private String cOrderSn;
	/**
	 * 网单支付时间
	 */
	private Integer cPayTime;
	
	private Integer cPaymentStatus;
	/**
	 * 库存类型WA、STORE、O2O
	 */
	private String stockType;
	/**
	 * 网单状态
	 */
	private Integer status;
	/**
	 * 是否o2o订单
	 */
	private boolean isO2o;
	/**
	 * o2o店铺ID
	 */
	private Integer o2oStoreId;
	/**
	 * o2o店铺名称
	 */
	private String o2oStoreName;
	/**
	 * o2o店铺码
	 */
	private String storeCode;
	
	private String shippingMode;
	
	private Integer lessShipTime;
	
	private Integer closeTime;
	/* 网单状态部分 */
	/**
	 * 是否可提交退货
	 */
	private boolean canSubmitRepaier;
	/**
	 * 是否可退货
	 */
	private boolean canRepair;
	/**
	 * 是否可确认
	 */
	private boolean canConfirm;
	/**
	 * 是否可点击确认
	 */
	private boolean canClickConfirm;
	/**
	 * 是否可评价
	 */
	private boolean canAssess;
	/**
	 * 是否评价确认异常
	 */
	private boolean confirmException;
	/**
	 * 是否已评价
	 */
	private boolean assessed;
	/**
	 * 是否已退货
	 */
	private boolean orderRepairs;
    /**
     * 退款处理状态
     */
    private Integer orderRepairPaymentStatus;

	/* 订单流程部分  */
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 付款时间
	 */
	private String payTime;
	/**
	 * 尾款支付时间
	 */
	private String wkPayTime;
	/**
	 * 发货时间
	 */
	private String shippingTime;
	/**
	 * 签收时间或取消时间
	 */
	private String receiptOrRejectTime;
	/* 发票相关	 */
	private String invoicesUrl;
	private String invViewUrl;
	private String invoiceTypeName;
	private String invoiceTitle;
	private Integer memberInvoiceId;
	
	/* 优惠金额相关 */
	private BigDecimal opProductAmount;
	private BigDecimal seashellAmt;
	private BigDecimal diamondAmt;
	private BigDecimal insuranceAmt;
	private BigDecimal bankBenefit;
	private BigDecimal itemShareAmount;
	private BigDecimal totalAmount;
	private String couponCode;
	private BigDecimal couponAmount;
	private BigDecimal orderPromotionAmount;
	private BigDecimal shippingFee;
	private BigDecimal price;
	private Integer number;
	
	/* 订单想断 */
	private String consignee;
	private String regionName;
	private String address;
	private String mobile;
	private String phoneNumber;
	private Integer userlevel;
	private Integer loginMemberId;
	private String orderStatusName;
	private String iconName;
	
	private Integer orderId;
	private Integer isBook;
	private Integer isCod;
	private String orderSn;
	private String relationOrderSn;
	private Integer memberId;
	private Integer addTime;
	private Integer orderStatus;
	private Integer paymentStatus;
	private Integer confirmTime;
	private String source;
	private Integer onedayLimit;
	private Integer zActivityOrder;
	private Integer isTimeoutFree;
	private String activityDate;
	private Integer orderType;
	private Integer orderRepaierId;
	private String orderTypeShow;
	private boolean pcProductFlag;
	private Integer isProduceDaily;
	private Integer ckCode;
    private Integer orderYwType;
	
	/* 商品相关 */
	private String productFullName;
	private String productName;
	private String defaultImageUrl;
	private Integer productId;
	private boolean isActivityProduct;
	
	/* 众筹 */
	private Integer zActivityStatus;
	private Integer zActivityId;
	private String attrPic;
	private String attrName;
	public Integer getOrderProductId() {
		return orderProductId;
	}
	public void setOrderProductId(Integer orderProductId) {
		this.orderProductId = orderProductId;
	}
	public String getcOrderSn() {
		return cOrderSn;
	}
	public void setcOrderSn(String cOrderSn) {
		this.cOrderSn = cOrderSn;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public boolean getIsO2o() {
		return isO2o;
	}
	public void setIsO2o(boolean isO2o) {
		this.isO2o = isO2o;
	}
	public Integer getO2oStoreId() {
		return o2oStoreId;
	}
	public void setO2oStoreId(Integer o2oStoreId) {
		this.o2oStoreId = o2oStoreId;
	}
	public String getO2oStoreName() {
		return o2oStoreName;
	}
	public void setO2oStoreName(String o2oStoreName) {
		this.o2oStoreName = o2oStoreName;
	}
	public boolean getCanSubmitRepaier() {
		return canSubmitRepaier;
	}
	public void setCanSubmitRepaier(boolean canSubmitRepaier) {
		this.canSubmitRepaier = canSubmitRepaier;
	}
	public boolean getCanRepair() {
		return canRepair;
	}
	public void setCanRepair(boolean canRepair) {
		this.canRepair = canRepair;
	}
	public boolean getCanConfirm() {
		return canConfirm;
	}
	public void setCanConfirm(boolean canConfirm) {
		this.canConfirm = canConfirm;
	}
	public boolean getCanClickConfirm() {
		return canClickConfirm;
	}
	public void setCanClickConfirm(boolean canClickConfirm) {
		this.canClickConfirm = canClickConfirm;
	}
	public boolean getCanAssess() {
		return canAssess;
	}
	public void setCanAssess(boolean canAssess) {
		this.canAssess = canAssess;
	}
	public boolean getConfirmException() {
		return confirmException;
	}
	public void setConfirmException(boolean confirmException) {
		this.confirmException = confirmException;
	}
	public boolean getAssessed() {
		return assessed;
	}
	public void setAssessed(boolean assessed) {
		this.assessed = assessed;
	}
	public boolean getOrderRepairs() {
		return orderRepairs;
	}
	public void setOrderRepairs(boolean orderRepairs) {
		this.orderRepairs = orderRepairs;
	}
    public Integer getOrderRepairPaymentStatus() {
        return orderRepairPaymentStatus;
    }
    public void setOrderRepairPaymentStatus(Integer orderRepairPaymentStatus) {
        this.orderRepairPaymentStatus = orderRepairPaymentStatus;
    }
    public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getWkPayTime() {
		return wkPayTime;
	}
	public void setWkPayTime(String wkPayTime) {
		this.wkPayTime = wkPayTime;
	}
	public String getShippingTime() {
		return shippingTime;
	}
	public void setShippingTime(String shippingTime) {
		this.shippingTime = shippingTime;
	}
	public String getReceiptOrRejectTime() {
		return receiptOrRejectTime;
	}
	public void setReceiptOrRejectTime(String receiptOrRejectTime) {
		this.receiptOrRejectTime = receiptOrRejectTime;
	}
	public String getInvoicesUrl() {
		return invoicesUrl;
	}
	public void setInvoicesUrl(String invoicesUrl) {
		this.invoicesUrl = invoicesUrl;
	}
	public String getInvViewUrl() {
		return invViewUrl;
	}
	public void setInvViewUrl(String invViewUrl) {
		this.invViewUrl = invViewUrl;
	}
	public String getInvoiceTypeName() {
		return invoiceTypeName;
	}
	public void setInvoiceTypeName(String invoiceTypeName) {
		this.invoiceTypeName = invoiceTypeName;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	public BigDecimal getOpProductAmount() {
		return opProductAmount;
	}
	public void setOpProductAmount(BigDecimal opProductAmount) {
		this.opProductAmount = opProductAmount;
	}
	public BigDecimal getSeashellAmt() {
		return seashellAmt;
	}
	public void setSeashellAmt(BigDecimal seashellAmt) {
		this.seashellAmt = seashellAmt;
	}
	public BigDecimal getDiamondAmt() {
		return diamondAmt;
	}
	public void setDiamondAmt(BigDecimal diamondAmt) {
		this.diamondAmt = diamondAmt;
	}
	public BigDecimal getInsuranceAmt() {
		return insuranceAmt;
	}
	public void setInsuranceAmt(BigDecimal insuranceAmt) {
		this.insuranceAmt = insuranceAmt;
	}
	public BigDecimal getItemShareAmount() {
		return itemShareAmount;
	}
	public void setItemShareAmount(BigDecimal itemShareAmount) {
		this.itemShareAmount = itemShareAmount;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(Integer userlevel) {
		this.userlevel = userlevel;
	}
	public Integer getLoginMemberId() {
		return loginMemberId;
	}
	public void setLoginMemberId(Integer loginMemberId) {
		this.loginMemberId = loginMemberId;
	}
	public String getOrderStatusName() {
		return orderStatusName;
	}
	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}
	public String getIconName() {
		return iconName;
	}
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}
	public String getProductFullName() {
		return productFullName;
	}
	public void setProductFullName(String productFullName) {
		this.productFullName = productFullName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDefaultImageUrl() {
		return defaultImageUrl;
	}
	public void setDefaultImageUrl(String defaultImageUrl) {
		this.defaultImageUrl = defaultImageUrl;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public boolean getIsActivityProduct() {
		return isActivityProduct;
	}
	public void setIsActivityProduct(boolean isActivityProduct) {
		this.isActivityProduct = isActivityProduct;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public BigDecimal getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getIsBook() {
		return isBook;
	}
	public void setIsBook(Integer isBook) {
		this.isBook = isBook;
	}
	public Integer getIsCod() {
		return isCod;
	}
	public void setIsCod(Integer isCod) {
		this.isCod = isCod;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public String getRelationOrderSn() {
		return relationOrderSn;
	}
	public void setRelationOrderSn(String relationOrderSn) {
		this.relationOrderSn = relationOrderSn;
	}
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	public Integer getAddTime() {
		return addTime;
	}
	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(Integer confirmTime) {
		this.confirmTime = confirmTime;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Integer getOnedayLimit() {
		return onedayLimit;
	}
	public void setOnedayLimit(Integer onedayLimit) {
		this.onedayLimit = onedayLimit;
	}
	public Integer getzActivityOrder() {
		return zActivityOrder;
	}
	public void setzActivityOrder(Integer zActivityOrder) {
		this.zActivityOrder = zActivityOrder;
	}
	public Integer getIsTimeoutFree() {
		return isTimeoutFree;
	}
	public void setIsTimeoutFree(Integer isTimeoutFree) {
		this.isTimeoutFree = isTimeoutFree;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public BigDecimal getOrderPromotionAmount() {
		return orderPromotionAmount;
	}
	public void setOrderPromotionAmount(BigDecimal orderPromotionAmount) {
		this.orderPromotionAmount = orderPromotionAmount;
	}
	public BigDecimal getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}
	public Integer getcPayTime() {
		return cPayTime;
	}
	public void setcPayTime(Integer cPayTime) {
		this.cPayTime = cPayTime;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getOrderRepaierId() {
		return orderRepaierId;
	}
	public void setOrderRepaierId(Integer orderRepaierId) {
		this.orderRepaierId = orderRepaierId;
	}
	public Integer getMemberInvoiceId() {
		return memberInvoiceId;
	}
	public void setMemberInvoiceId(Integer memberInvoiceId) {
		this.memberInvoiceId = memberInvoiceId;
	}
	public Integer getLessShipTime() {
		return lessShipTime;
	}
	public void setLessShipTime(Integer lessShipTime) {
		this.lessShipTime = lessShipTime;
	}
	public Integer getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Integer closeTime) {
		this.closeTime = closeTime;
	}
	public String getOrderTypeShow() {
		return orderTypeShow;
	}
	public void setOrderTypeShow(String orderTypeShow) {
		this.orderTypeShow = orderTypeShow;
	}
	public Integer getcPaymentStatus() {
		return cPaymentStatus;
	}
	public void setcPaymentStatus(Integer cPaymentStatus) {
		this.cPaymentStatus = cPaymentStatus;
	}
	public String getShippingMode() {
		return shippingMode;
	}
	public void setShippingMode(String shippingMode) {
		this.shippingMode = shippingMode;
	}
	public BigDecimal getBankBenefit() {
		return bankBenefit;
	}
	public void setBankBenefit(BigDecimal bankBenefit) {
		this.bankBenefit = bankBenefit;
	}
	public boolean isPcProductFlag() {
		return pcProductFlag;
	}
	public void setPcProductFlag(boolean pcProductFlag) {
		this.pcProductFlag = pcProductFlag;
	}
	public Integer getIsProduceDaily() {
		return isProduceDaily;
	}
	public void setIsProduceDaily(Integer isProduceDaily) {
		this.isProduceDaily = isProduceDaily;
	}
	public Integer getCkCode() {
		return ckCode;
	}
	public void setCkCode(Integer ckCode) {
		this.ckCode = ckCode;
	}
	public Integer getzActivityStatus() {
		return zActivityStatus;
	}
	public void setzActivityStatus(Integer zActivityStatus) {
		this.zActivityStatus = zActivityStatus;
	}
	public Integer getzActivityId() {
		return zActivityId;
	}
	public void setzActivityId(Integer zActivityId) {
		this.zActivityId = zActivityId;
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

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

    public Integer getOrderYwType() {
        return orderYwType;
    }

    public void setOrderYwType(Integer orderYwType) {
        this.orderYwType = orderYwType;
    }
}
