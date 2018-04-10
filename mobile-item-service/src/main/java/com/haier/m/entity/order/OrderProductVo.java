package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderProductVo implements Serializable {

    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;
    /**
     * 网单号
     */
    private String cOrderSn;
    /**
     * 网单Id
     */
    private Long orderProductId;
    /**
     * 预定
     */
    private Integer isBook;
    /**
     * 商品Id
     */
    private Integer productId;
    /**
     * 无聊编码
     */
    private String sku;
    /**
     * 商品主图
     */
    private String defaultImageUrl;
    /**
     * 商品全称
     */
    private String productFullName;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品数量
     */
    private Integer number;
    /**
     * 网单金额
     */
    private BigDecimal productAmount;
    /**
     * 优惠金额
     */
    private BigDecimal couponCodeValue;
    /**
     * 下单立减
     */
    private BigDecimal orderPromotionAmount;
    /**
     * 卡券金额
     */
    private BigDecimal couponAmount;
    
    /**
     * 是否活动
     */
    private Boolean bigActivity;
    /**
     * 超市免单
     */
    private Boolean freeOrder;
    /**
     * 半日达
     */
    private Boolean halfDay;
    /**
     * 24小时达
     */
    private Boolean oneDay;
    /**
     * 退货单Id
     */
    private Integer orderRepairId;
    /**
     * 库存类型
     */
    private String stockType;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 物流类型
     */
    private String shippingMode;
    
    private String couponCode;
    
    private BigDecimal shippingFee;
    /**
     * 属性名称
     */
    private String attrName;

    public String getcOrderSn() {
        return cOrderSn;
    }
    public void setCOrderSn(String cOrderSn) {
        this.cOrderSn = cOrderSn;
    }
    public Long getOrderProductId() {
        return orderProductId;
    }
    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }
    public Integer getIsBook() {
        return isBook;
    }
    public void setIsBook(Integer isBook) {
        this.isBook = isBook;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public String getDefaultImageUrl() {
        return defaultImageUrl;
    }
    public void setDefaultImageUrl(String defaultImageUrl) {
        this.defaultImageUrl = defaultImageUrl;
    }
    public String getProductFullName() {
        return productFullName;
    }
    public void setProductFullName(String productFullName) {
        this.productFullName = productFullName;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public BigDecimal getCouponCodeValue() {
        return couponCodeValue;
    }
    public void setCouponCodeValue(BigDecimal couponCodeValue) {
        this.couponCodeValue = couponCodeValue;
    }
    public BigDecimal getOrderPromotionAmount() {
        return orderPromotionAmount;
    }
    public void setOrderPromotionAmount(BigDecimal orderPromotionAmount) {
        this.orderPromotionAmount = orderPromotionAmount;
    }
    public BigDecimal getCouponAmount() {
        return couponAmount;
    }
    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }
    public Boolean getBigActivity() {
        return bigActivity;
    }
    public void setBigActivity(Boolean bigActivity) {
        this.bigActivity = bigActivity;
    }
    public Boolean getFreeOrder() {
        return freeOrder;
    }
    public void setFreeOrder(Boolean freeOrder) {
        this.freeOrder = freeOrder;
    }
    public Boolean getHalfDay() {
        return halfDay;
    }
    public void setHalfDay(Boolean halfDay) {
        this.halfDay = halfDay;
    }
    public Boolean getOneDay() {
        return oneDay;
    }
    public void setOneDay(Boolean oneDay) {
        this.oneDay = oneDay;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    public Integer getOrderRepairId() {
        return orderRepairId;
    }
    public void setOrderRepairId(Integer orderRepairId) {
        this.orderRepairId = orderRepairId;
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
    public String getShippingMode() {
        return shippingMode;
    }
    public void setShippingMode(String shippingMode) {
        this.shippingMode = shippingMode;
    }
    public String getCouponCode() {
        return couponCode;
    }
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }
    public BigDecimal getShippingFee() {
        return shippingFee;
    }
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }
    public BigDecimal getProductAmount() {
        return productAmount;
    }
    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
}
