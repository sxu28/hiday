package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderVo implements Serializable {
    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 订单Id
     */
    private Long orderId;
    /**
     * 来源
     */
    private String source;
    /**
     * 订单号
     */
    private String orderSn;
    /**
     * 下单人
     */
    private Integer memberId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 支付状态
     */
    private Integer paymentStatus;
    /**
     * 商品金额
     */
    private BigDecimal productAmount;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 货到付款
     */
    private Integer isCod;
    /**
     * 支付状态
     */
    private String paymentCode;
    /**
     * 订单类型
     */
    private Integer orderType;
    /**
     * 关联订单号
     */
    private String relationOrderSn;
    /**
     * 街道Id
     */
    private Integer street;
    /**
     * 添加时间
     */
    private String addTime;
    /**
     * 添加时间戳
     */
    private Integer addTimeStamp;
    /**
     * 区域名称
     */
    private String regionName;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 下单微店主Id
     */
    private String ckCode;
    /**
     * 是否可删除
     */
    private boolean canDelete;
    /**
     * 是否可点击确认
     */
    private boolean canClickConfirm;
    /**
     * 微店是否可取消
     */
    private boolean mstoreCancel;
    /**
     * 是否线上支付
     */
    private boolean payOnline;
    /**
     * 是否可评价
     */
    private boolean goAssess;
    /**
     * 是否可退款退货
     */
    private boolean drawback;
    private Integer zActivityOrder;
    private boolean kjtpay;
    /**
     * 商品总数
     */
    private Integer productTotalNo;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 是否我的订单
     */
    private boolean isMyOrder = false;
    /**
     * 是否可确认
     */
    private boolean canConfirm = false;
    /**
     * 
     */
    private boolean isRelated = false;
    /**
     * 尾款单金额
     */
    private BigDecimal relationOrderAmount;
    /**
     * 尾款单是否可支付
     */
    private boolean payRelationOrder;
    /**
     * 尾款订单id
     */
    private Integer relationOrderId;
    /**
     * 是否已评价
     */
    private boolean assessed = false;
    /**
     * 是否可取消
     */
    private boolean canCancel = false;
    /**
     * 是否确认异常
     */
    private boolean confirmException = false;
    /**
     * 订单状态名称
     */
    private String orderStatusName;
    /**
     * 是否最终支付
     */
    private boolean finalPay = false;
    /**
     * 是否单网单
     */
    private boolean isSingle = false;
    /**
     * 是否退货单
     */
    private boolean isRightService = false;
    /**
     * 运费
     */
    private BigDecimal totalShippingFeeAmount;
    /**
     * 支付宝支付
     */
    private boolean alipay = false;
    /**
     * 是否微信支付
     */
    private boolean wxpay = false;
    /**
     * 是否支付
     */
    private boolean isPayCoupon = false;
    /**
     * 货到付款确认时间
     */
    private Integer codConfirmTime;
    /**
     * 
     */
    private boolean codOrder;
    
    /**
     * 
     */
    private Object zActivityStatus;
    
    /**
     * 
     */
    private BigDecimal orderCouponAmount;
    
    /**
     * 支付时间时间戳
     */
    private Integer payTimeStamp;
    
    /**
     * 网单列表
     */
    private List<OrderProductVo> orderProducts;

    /**
     * 订单业务类型
     */
    private Integer orderYwType;

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
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
    public BigDecimal getProductAmount() {
        return productAmount;
    }
    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }
    public String getConsignee() {
        return consignee;
    }
    public void setConsignee(String consignee) {
        this.consignee = consignee;
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
    public String getAddTime() {
        return addTime;
    }
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }
    public Integer getAddTimeStamp() {
        return addTimeStamp;
    }
    public void setAddTimeStamp(Integer addTimeStamp) {
        this.addTimeStamp = addTimeStamp;
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
    public String getCkCode() {
        return ckCode;
    }
    public void setCkCode(String ckCode) {
        this.ckCode = ckCode;
    }
    public boolean getCanDelete() {
        return canDelete;
    }
    public void setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
    }
    public boolean getCanClickConfirm() {
        return canClickConfirm;
    }
    public void setCanClickConfirm(boolean canClickConfirm) {
        this.canClickConfirm = canClickConfirm;
    }
    public boolean getMstoreCancel() {
        return mstoreCancel;
    }
    public void setMstoreCancel(boolean mstoreCancel) {
        this.mstoreCancel = mstoreCancel;
    }
    public boolean getPayOnline() {
        return payOnline;
    }
    public void setPayOnline(boolean payOnline) {
        this.payOnline = payOnline;
    }
    public boolean getGoAssess() {
        return goAssess;
    }
    public void setGoAssess(boolean goAssess) {
        this.goAssess = goAssess;
    }
    public boolean getDrawback() {
        return drawback;
    }
    public void setDrawback(boolean drawback) {
        this.drawback = drawback;
    }
    public Integer getzActivityOrder() {
        return zActivityOrder;
    }
    public void setzActivityOrder(Integer zActivityOrder) {
        this.zActivityOrder = zActivityOrder;
    }
    public boolean getKjtpay() {
        return kjtpay;
    }
    public void setKjtpay(boolean kjtpay) {
        this.kjtpay = kjtpay;
    }
    public Integer getProductTotalNo() {
        return productTotalNo;
    }
    public void setProductTotalNo(Integer productTotalNo) {
        this.productTotalNo = productTotalNo;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public boolean getIsMyOrder() {
        return isMyOrder;
    }
    public void setIsMyOrder(boolean isMyOrder) {
        this.isMyOrder = isMyOrder;
    }
    public boolean getCanConfirm() {
        return canConfirm;
    }
    public void setCanConfirm(boolean canConfirm) {
        this.canConfirm = canConfirm;
    }
    public boolean getIsRelated() {
        return isRelated;
    }
    public void setIsRelated(boolean isRelated) {
        this.isRelated = isRelated;
    }
    public BigDecimal getRelationOrderAmount() {
        return relationOrderAmount;
    }
    public void setRelationOrderAmount(BigDecimal relationOrderAmount) {
        this.relationOrderAmount = relationOrderAmount;
    }
    public boolean getPayRelationOrder() {
        return payRelationOrder;
    }
    public void setPayRelationOrder(boolean payRelationOrder) {
        this.payRelationOrder = payRelationOrder;
    }
    public boolean getAssessed() {
        return assessed;
    }
    public void setAssessed(boolean assessed) {
        this.assessed = assessed;
    }
    public boolean getCanCancel() {
        return canCancel;
    }
    public void setCanCancel(boolean canCancel) {
        this.canCancel = canCancel;
    }
    public boolean getConfirmException() {
        return confirmException;
    }
    public void setConfirmException(boolean confirmException) {
        this.confirmException = confirmException;
    }
    public String getOrderStatusName() {
        return orderStatusName;
    }
    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }
    public boolean getFinalPay() {
        return finalPay;
    }
    public void setFinalPay(boolean finalPay) {
        this.finalPay = finalPay;
    }
    public boolean getIsSingle() {
        return isSingle;
    }
    public void setIsSingle(boolean isSingle) {
        this.isSingle = isSingle;
    }
    public boolean getIsRightService() {
        return isRightService;
    }
    public void setIsRightService(boolean isRightService) {
        this.isRightService = isRightService;
    }
    public BigDecimal getTotalShippingFeeAmount() {
        return totalShippingFeeAmount;
    }
    public void setTotalShippingFeeAmount(BigDecimal totalShippingFeeAmount) {
        this.totalShippingFeeAmount = totalShippingFeeAmount;
    }
    public boolean getAlipay() {
        return alipay;
    }
    public void setAlipay(boolean alipay) {
        this.alipay = alipay;
    }
    public boolean getWxpay() {
        return wxpay;
    }
    public void setWxpay(boolean wxpay) {
        this.wxpay = wxpay;
    }
    public boolean getIsPayCoupon() {
        return isPayCoupon;
    }
    public void setIsPayCoupon(boolean isPayCoupon) {
        this.isPayCoupon = isPayCoupon;
    }
    public Integer getCodConfirmTime() {
        return codConfirmTime;
    }
    public void setCodConfirmTime(Integer codConfirmTime) {
        this.codConfirmTime = codConfirmTime;
    }
    public boolean getCodOrder() {
        return codOrder;
    }
    public void setCodOrder(boolean codOrder) {
        this.codOrder = codOrder;
    }
    public List<OrderProductVo> getOrderProducts() {
        return orderProducts;
    }
    public void setOrderProducts(List<OrderProductVo> orderProducts) {
	this.orderProducts = orderProducts;
    }
    public Integer getRelationOrderId() {
        return relationOrderId;
    }
    public void setRelationOrderId(Integer relationOrderId) {
        this.relationOrderId = relationOrderId;
    }
    public Object getzActivityStatus() {
        return zActivityStatus;
    }
    public void setzActivityStatus(Object zActivityStatus) {
        this.zActivityStatus = zActivityStatus;
    }
    public BigDecimal getOrderCouponAmount() {
        return orderCouponAmount;
    }
    public void setOrderCouponAmount(BigDecimal orderCouponAmount) {
        this.orderCouponAmount = orderCouponAmount;
    }
    public Integer getPayTimeStamp() {
        return payTimeStamp;
    }
    public void setPayTimeStamp(Integer payTimeStamp) {
        this.payTimeStamp = payTimeStamp;
    }

    public Integer getOrderYwType() {
        return orderYwType;
    }

    public void setOrderYwType(Integer orderYwType) {
        this.orderYwType = orderYwType;
    }
}
