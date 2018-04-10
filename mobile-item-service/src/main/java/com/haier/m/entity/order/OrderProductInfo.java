package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * * <p>Table: <strong>OrderProducts</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *     <th nowrap>属性名</th><th nowrap>属性类型</th><th nowrap>字段名</th><th nowrap>字段类型</th><th nowrap>说明</th>
 *   </tr>
 *   <tr><td>id</td><td>{@link Integer}</td><td>id</td><td>int</td><td>&nbsp;</td></tr>
 *   <tr><td>siteId</td><td>{@link Integer}</td><td>siteId</td><td>int</td><td>&nbsp;</td></tr>
 *   <tr><td>isTest</td><td>{@link Integer}</td><td>isTest</td><td>tinyint</td><td>是否是测试网单</td></tr>
 *   <tr><td>hasRead</td><td>{@link Integer}</td><td>hasRead</td><td>tinyint</td><td>是否已读,测试字段</td></tr>
 *   <tr><td>supportOneDayLimit</td><td>{@link Integer}</td><td>supportOneDayLimit</td><td>tinyint</td><td>是否支持24小时限时达</td></tr>
 *   <tr><td>orderId</td><td>{@link Integer}</td><td>orderId</td><td>int</td><td>&nbsp;</td></tr>
 *   <tr><td>cOrderSn</td><td>{@link String}</td><td>cOrderSn</td><td>varchar</td><td>child order sn 子订单编码 C0919293</td></tr>
 *   <tr><td>isBook</td><td>{@link Integer}</td><td>isBook</td><td>tinyint</td><td>是否是预订网单</td></tr>
 *   <tr><td>cPaymentStatus</td><td>{@link Integer}</td><td>cPaymentStatus</td><td>smallint</td><td>子订单付款状态</td></tr>
 *   <tr><td>cPayTime</td><td>{@link Long}</td><td>cPayTime</td><td>int</td><td>子订单付款时间</td></tr>
 *   <tr><td>productType</td><td>{@link Integer}</td><td>productType</td><td>int</td><td>商品类型</td></tr>
 *   <tr><td>productId</td><td>{@link Integer}</td><td>productId</td><td>int</td><td>抽象商品id（可能是商品规格，也可能是套装，由商品类型决定）</td></tr>
 *   <tr><td>productName</td><td>{@link String}</td><td>productName</td><td>varchar</td><td>商品名称：可能是商品名称加颜色规格，也可能是套装名称</td></tr>
 *   <tr><td>sku</td><td>{@link String}</td><td>sku</td><td>varchar</td><td>货号</td></tr>
 *   <tr><td>price</td><td>{@link BigDecimal}</td><td>price</td><td>decimal</td><td>商品单价</td></tr>
 *   <tr><td>number</td><td>{@link Integer}</td><td>number</td><td>smallint</td><td>数量</td></tr>
 *   <tr><td>lockedNumber</td><td>{@link Integer}</td><td>lockedNumber</td><td>int</td><td>曾经锁定的库存数量</td></tr>
 *   <tr><td>unlockedNumber</td><td>{@link Integer}</td><td>unlockedNumber</td><td>int</td><td>曾经解锁的库存数量</td></tr>
 *   <tr><td>productAmount</td><td>{@link BigDecimal}</td><td>productAmount</td><td>decimal</td><td>此字段专为同步外部订单而加，商品总金额=price*number+shippingFee-优惠金额，但优惠金额没在本系统存储</td></tr>
 *   <tr><td>balanceAmount</td><td>{@link BigDecimal}</td><td>balanceAmount</td><td>decimal</td><td>余额扣减</td></tr>
 *   <tr><td>couponAmount</td><td>{@link BigDecimal}</td><td>couponAmount</td><td>decimal</td><td>优惠券抵扣金额</td></tr>
 *   <tr><td>esAmount</td><td>{@link BigDecimal}</td><td>esAmount</td><td>decimal</td><td>节能补贴金额</td></tr>
 *   <tr><td>giftCardNumberId</td><td>{@link Integer}</td><td>giftCardNumberId</td><td>int</td><td>礼品卡号ID,关联GiftCardNumbers表的主键</td></tr>
 *   <tr><td>usedGiftCardAmount</td><td>{@link BigDecimal}</td><td>usedGiftCardAmount</td><td>decimal</td><td>礼品卡抵用的金额</td></tr>
 *   <tr><td>couponLogId</td><td>{@link Integer}</td><td>couponLogId</td><td>int</td><td>使用的优惠券记录ID</td></tr>
 *   <tr><td>activityPrice</td><td>{@link BigDecimal}</td><td>activityPrice</td><td>decimal</td><td>活动价，当有活动价时price的值来源于activityPrice</td></tr>
 *   <tr><td>activityId</td><td>{@link Integer}</td><td>activityId</td><td>int</td><td>活动ID</td></tr>
 *   <tr><td>cateId</td><td>{@link Integer}</td><td>cateId</td><td>int</td><td>分类ID</td></tr>
 *   <tr><td>brandId</td><td>{@link Integer}</td><td>brandId</td><td>int</td><td>品牌ID</td></tr>
 *   <tr><td>netPointId</td><td>{@link Integer}</td><td>netPointId</td><td>int</td><td>网点id</td></tr>
 *   <tr><td>shippingFee</td><td>{@link BigDecimal}</td><td>shippingFee</td><td>decimal</td><td>配送费用</td></tr>
 *   <tr><td>settlementStatus</td><td>{@link Integer}</td><td>settlementStatus</td><td>tinyint</td><td>结算状态0 未结算 1已结算 </td></tr>
 *   <tr><td>receiptOrRejectTime</td><td>{@link Long}</td><td>receiptOrRejectTime</td><td>int</td><td>确认收货时间或拒绝收货时间</td></tr>
 *   <tr><td>isWmsSku</td><td>{@link Integer}</td><td>isWmsSku</td><td>tinyint</td><td>是否淘宝小家电</td></tr>
 *   <tr><td>sCode</td><td>{@link String}</td><td>sCode</td><td>varchar</td><td>库位编码</td></tr>
 *   <tr><td>tsCode</td><td>{@link String}</td><td>tsCode</td><td>varchar</td><td>转运库房编码</td></tr>
 *   <tr><td>tsShippingTime</td><td>{@link Long}</td><td>tsShippingTime</td><td>int</td><td>转运时效（小时）</td></tr>
 *   <tr><td>status</td><td>{@link Integer}</td><td>status</td><td>smallint</td><td>状态</td></tr>
 *   <tr><td>productSn</td><td>{@link String}</td><td>productSn</td><td>varchar</td><td>商品条形码</td></tr>
 *   <tr><td>invoiceNumber</td><td>{@link String}</td><td>invoiceNumber</td><td>varchar</td><td>运单号</td></tr>
 *   <tr><td>expressName</td><td>{@link String}</td><td>expressName</td><td>varchar</td><td>快递公司</td></tr>
 *   <tr><td>invoiceExpressNumber</td><td>{@link String}</td><td>invoiceExpressNumber</td><td>varchar</td><td>发票快递单号</td></tr>
 *   <tr><td>postMan</td><td>{@link String}</td><td>postMan</td><td>varchar</td><td>送货人</td></tr>
 *   <tr><td>postManPhone</td><td>{@link String}</td><td>postManPhone</td><td>varchar</td><td>送货人电话</td></tr>
 *   <tr><td>isNotice</td><td>{@link Integer}</td><td>isNotice</td><td>smallint</td><td>是否开启预警</td></tr>
 *   <tr><td>noticeType</td><td>{@link Integer}</td><td>noticeType</td><td>smallint</td><td>&nbsp;</td></tr>
 *   <tr><td>noticeRemark</td><td>{@link String}</td><td>noticeRemark</td><td>varchar</td><td>&nbsp;</td></tr>
 *   <tr><td>noticeTime</td><td>{@link String}</td><td>noticeTime</td><td>varchar</td><td>预警时间</td></tr>
 *   <tr><td>shippingTime</td><td>{@link Long}</td><td>shippingTime</td><td>int</td><td>发货时间</td></tr>
 *   <tr><td>lessOrderSn</td><td>{@link String}</td><td>lessOrderSn</td><td>varchar</td><td>less 订单号</td></tr>
 *   <tr><td>waitGetLesShippingInfo</td><td>{@link Integer}</td><td>waitGetLesShippingInfo</td><td>tinyint</td><td>是否等待获取LES物流配送节点信息</td></tr>
 *   <tr><td>getLesShippingCount</td><td>{@link Integer}</td><td>getLesShippingCount</td><td>int</td><td>已获取LES配送节点信息的次数</td></tr>
 *   <tr><td>outping</td><td>{@link String}</td><td>outping</td><td>varchar</td><td>出库凭证</td></tr>
 *   <tr><td>lessShipTime</td><td>{@link Long}</td><td>lessShipTime</td><td>int</td><td>less出库时间</td></tr>
 *   <tr><td>closeTime</td><td>{@link Long}</td><td>closeTime</td><td>int</td><td>网单完成关闭或取消关闭时间</td></tr>
 *   <tr><td>isReceipt</td><td>{@link Integer}</td><td>isReceipt</td><td>int</td><td>是否需要发票</td></tr>
 *   <tr><td>isMakeReceipt</td><td>{@link Integer}</td><td>isMakeReceipt</td><td>int</td><td>开票状态</td></tr>
 *   <tr><td>receiptNum</td><td>{@link String}</td><td>receiptNum</td><td>text</td><td>发票号</td></tr>
 *   <tr><td>receiptAddTime</td><td>{@link String}</td><td>receiptAddTime</td><td>varchar</td><td>开票时间</td></tr>
 *   <tr><td>makeReceiptType</td><td>{@link Integer}</td><td>makeReceiptType</td><td>tinyint</td><td>开票类型 0 初始值 1 库房开票  2 共享开票</td></tr>
 *   <tr><td>shippingMode</td><td>{@link String}</td><td>shippingMode</td><td>varchar</td><td>物流模式,值为B2B2C或B2C</td></tr>
 *   <tr><td>lastTimeForShippingMode</td><td>{@link Long}</td><td>lastTimeForShippingMode</td><td>int</td><td>最后修改物流模式的时间</td></tr>
 *   <tr><td>lastEditorForShippingMode</td><td>{@link String}</td><td>lastEditorForShippingMode</td><td>varchar</td><td>最后修改物流模式的管理员</td></tr>
 *   <tr><td>systemRemark</td><td>{@link String}</td><td>systemRemark</td><td>text</td><td>系统备注，不给用户显示</td></tr>
 *   <tr><td>tongshuaiWorkId</td><td>{@link Integer}</td><td>tongshuaiWorkId</td><td>int</td><td>统帅定制作品ID</td></tr>
 *   <tr><td>orderPromotionId</td><td>{@link Integer}</td><td>orderPromotionId</td><td>int</td><td>下单立减活动ID</td></tr>
 *   <tr><td>orderPromotionAmount</td><td>{@link BigDecimal}</td><td>orderPromotionAmount</td><td>decimal</td><td>下单立减金额</td></tr>
 *   <tr><td>externalSaleSettingId</td><td>{@link Integer}</td><td>externalSaleSettingId</td><td>int</td><td>淘宝套装设置ID</td></tr>
 *   <tr><td>recommendationId</td><td>{@link Integer}</td><td>recommendationId</td><td>int</td><td>推荐购买ID</td></tr>
 *   <tr><td>hasSendAlertNum</td><td>{@link Integer}</td><td>hasSendAlertNum</td><td>tinyint</td><td>是否已发送了购买数据报警邮件(短信)</td></tr>
 *   <tr><td>isNoLimitStockProduct</td><td>{@link Integer}</td><td>isNoLimitStockProduct</td><td>tinyint</td><td>是否是无限制库存量的商品</td></tr>
 *   <tr><td>hpRegisterDate</td><td>{@link Integer}</td><td>hpRegisterDate</td><td>int</td><td>HP注册时间</td></tr>
 *   <tr><td>hpFailDate</td><td>{@link Integer}</td><td>hpFailDate</td><td>int</td><td>HP派工失败时间</td></tr>
 *   <tr><td>hpFinishDate</td><td>{@link Integer}</td><td>hpFinishDate</td><td>int</td><td>HP派工成功时间</td></tr>
 *   <tr><td>hpReservationDate</td><td>{@link Integer}</td><td>hpReservationDate</td><td>int</td><td>HP回传预约送货时间</td></tr>
 *   <tr><td>shippingOpporunity</td><td>{@link Integer}</td><td>shippingOpporunity</td><td>tinyint</td><td>活动订单发货时机，0定金发货 1尾款发货</td></tr>
 *   <tr><td>isTimeoutFree</td><td>{@link Integer}</td><td>isTimeoutFree</td><td>tinyint</td><td>是否超时免单 0未设置 1是 2否</td></tr>
 *   <tr><td>itemShareAmount</td><td>{@link BigDecimal}</td><td>itemShareAmount</td><td>decimal</td><td>订单优惠价格分摊</td></tr>
 *   <tr><td>lessShipTInTime</td><td>{@link Long}</td><td>lessShipTInTime</td><td>int</td><td>less转运入库时间</td></tr>
 *   <tr><td>cbsSecCode</td><td>{@link String}</td><td>cbsSecCode</td><td>string</td><td>less转运出库时间</td></tr>
 *   <tr><td>lessShipTOutTime</td><td>{@link Long}</td><td>lessShipTOutTime</td><td>varchar</td><td>cbs库位</td></tr>
 *   <tr><td>pdOrderStatus</td><td>{@link java.lang.Integer}</td><td>pdOrderStatus</td><td>int</td><td>日日单状态</td></tr>
 *   <tr><td>couponCode</td><td>{@link String}</td><td>couponCode</td><td>varchar</td><td>优惠码编码</td></tr>
 *   <tr><td>couponCodeValue</td><td>{@link BigDecimal}</td><td>couponCodeValue</td><td>decimal</td><td>优惠码优惠金额</td></tr>
 * </table
 *
 * @author 纪祥
 * @date 2015-11-24
 * @email
 */
public class OrderProductInfo implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2788227923747792958L;

    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    private Integer siteId;

    public Integer getSiteId() {
        return this.siteId;
    }

    public void setSiteId(Integer value) {
        this.siteId = value;
    }

    private Integer isTest;

    /**
     * 获取 是否是测试网单。
     */
    public Integer getIsTest() {
        return this.isTest;
    }

    /**
     * 设置 是否是测试网单。
     *
     * @param value 属性值
     */
    public void setIsTest(Integer value) {
        this.isTest = value;
    }

    private Integer hasRead = 0;

    /**
     * 获取 是否已读,测试字段。
     */
    public Integer getHasRead() {
        return this.hasRead;
    }

    /**
     * 设置 是否已读,测试字段。
     *
     * @param value 属性值
     */
    public void setHasRead(Integer value) {
        this.hasRead = value;
    }

    private Integer supportOneDayLimit;

    /**
     * 获取 是否支持24小时限时达。
     */
    public Integer getSupportOneDayLimit() {
        return this.supportOneDayLimit;
    }

    /**
     * 设置 是否支持24小时限时达。
     *
     * @param value 属性值
     */
    public void setSupportOneDayLimit(Integer value) {
        this.supportOneDayLimit = value;
    }

    private Integer orderId;

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer value) {
        this.orderId = value;
    }

    private String cOrderSn;

    /**
     * 获取 child order sn 子订单编码 C0919293。
     */
    public String getCOrderSn() {
        return this.cOrderSn;
    }

    /**
     * 设置 child order sn 子订单编码 C0919293。
     *
     * @param value 属性值
     */
    public void setCOrderSn(String value) {
        this.cOrderSn = value;
    }

    private Integer isBook = 0;

    /**
     * 获取 是否是预订网单。
     */
    public Integer getIsBook() {
        return this.isBook;
    }

    /**
     * 设置 是否是预订网单。
     *
     * @param value 属性值
     */
    public void setIsBook(Integer value) {
        this.isBook = value;
    }

    private Integer cPaymentStatus;

    /**
     * 获取 子订单付款状态。
     */
    public Integer getCPaymentStatus() {
        return this.cPaymentStatus;
    }

    /**
     * 设置 子订单付款状态。
     *
     * @param value 属性值
     */
    public void setCPaymentStatus(Integer value) {
        this.cPaymentStatus = value;
    }

    private Integer cPayTime;

    /**
     * 获取 子订单付款时间。
     */
    public Integer getCPayTime() {
        return this.cPayTime;
    }

    /**
     * 设置 子订单付款时间。
     *
     * @param value 属性值
     */
    public void setCPayTime(Integer value) {
        this.cPayTime = value;
    }

    private Integer productType;

    /**
     * 获取 商品类型。
     */
    public Integer getProductType() {
        return this.productType;
    }

    /**
     * 设置 商品类型。
     *
     * @param value 属性值
     */
    public void setProductType(Integer value) {
        this.productType = value;
    }

    private Integer productId;

    /**
     * 获取 抽象商品id（可能是商品规格，也可能是套装，由商品类型决定）。
     */
    public Integer getProductId() {
        return this.productId;
    }

    /**
     * 设置 抽象商品id（可能是商品规格，也可能是套装，由商品类型决定）。
     *
     * @param value 属性值
     */
    public void setProductId(Integer value) {
        this.productId = value;
    }

    private String productName;

    /**
     * 获取 商品名称：可能是商品名称加颜色规格，也可能是套装名称。
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 设置 商品名称：可能是商品名称加颜色规格，也可能是套装名称。
     *
     * @param value 属性值
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    private String sku;

    /**
     * 获取 货号。
     */
    public String getSku() {
        return this.sku;
    }

    /**
     * 设置 货号。
     *
     * @param value 属性值
     */
    public void setSku(String value) {
        this.sku = value;
    }

    private BigDecimal price;

    /**
     * 获取 商品单价。
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * 设置 商品单价。
     *
     * @param value 属性值
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    private Integer number;

    /**
     * 获取 数量。
     */
    public Integer getNumber() {
        return this.number;
    }

    /**
     * 设置 数量。
     *
     * @param value 属性值
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    private Integer lockedNumber;

    /**
     * 获取 曾经锁定的库存数量。
     */
    public Integer getLockedNumber() {
        return this.lockedNumber;
    }

    /**
     * 设置 曾经锁定的库存数量。
     *
     * @param value 属性值
     */
    public void setLockedNumber(Integer value) {
        this.lockedNumber = value;
    }

    private Integer unlockedNumber;

    /**
     * 获取 曾经解锁的库存数量。
     */
    public Integer getUnlockedNumber() {
        return this.unlockedNumber;
    }

    /**
     * 设置 曾经解锁的库存数量。
     *
     * @param value 属性值
     */
    public void setUnlockedNumber(Integer value) {
        this.unlockedNumber = value;
    }

    private BigDecimal productAmount;

    /**
     * 获取 此字段专为同步外部订单而加，商品总金额=price*number+shippingFee-优惠金额，但优惠金额没在本系统存储。
     */
    public BigDecimal getProductAmount() {
        return this.productAmount;
    }

    /**
     * 设置 此字段专为同步外部订单而加，商品总金额=price*number+shippingFee-优惠金额，但优惠金额没在本系统存储。
     *
     * @param value 属性值
     */
    public void setProductAmount(BigDecimal value) {
        this.productAmount = value;
    }

    private BigDecimal balanceAmount;

    /**
     * 获取 余额扣减。
     */
    public BigDecimal getBalanceAmount() {
        return this.balanceAmount;
    }

    /**
     * 设置 余额扣减。
     *
     * @param value 属性值
     */
    public void setBalanceAmount(BigDecimal value) {
        this.balanceAmount = value;
    }

    private BigDecimal couponAmount;

    /**
     * 获取 优惠券抵扣金额。
     */
    public BigDecimal getCouponAmount() {
        return this.couponAmount;
    }

    /**
     * 设置 优惠券抵扣金额。
     *
     * @param value 属性值
     */
    public void setCouponAmount(BigDecimal value) {
        this.couponAmount = value;
    }

    private BigDecimal esAmount;

    /**
     * 获取 节能补贴金额。
     */
    public BigDecimal getEsAmount() {
        return this.esAmount;
    }

    /**
     * 设置 节能补贴金额。
     *
     * @param value 属性值
     */
    public void setEsAmount(BigDecimal value) {
        this.esAmount = value;
    }

    private Integer giftCardNumberId;

    /**
     * 获取 礼品卡号ID,关联GiftCardNumbers表的主键。
     */
    public Integer getGiftCardNumberId() {
        return this.giftCardNumberId;
    }

    /**
     * 设置 礼品卡号ID,关联GiftCardNumbers表的主键。
     *
     * @param value 属性值
     */
    public void setGiftCardNumberId(Integer value) {
        this.giftCardNumberId = value;
    }

    private BigDecimal usedGiftCardAmount;

    /**
     * 获取 礼品卡抵用的金额。
     */
    public BigDecimal getUsedGiftCardAmount() {
        return this.usedGiftCardAmount;
    }

    /**
     * 设置 礼品卡抵用的金额。
     *
     * @param value 属性值
     */
    public void setUsedGiftCardAmount(BigDecimal value) {
        this.usedGiftCardAmount = value;
    }

    private Integer couponLogId;

    /**
     * 获取 使用的优惠券记录ID。
     */
    public Integer getCouponLogId() {
        return this.couponLogId;
    }

    /**
     * 设置 使用的优惠券记录ID。
     *
     * @param value 属性值
     */
    public void setCouponLogId(Integer value) {
        this.couponLogId = value;
    }

    private BigDecimal activityPrice;

    /**
     * 获取 活动价，当有活动价时price的值来源于activityPrice。
     */
    public BigDecimal getActivityPrice() {
        return this.activityPrice;
    }

    /**
     * 设置 活动价，当有活动价时price的值来源于activityPrice。
     *
     * @param value 属性值
     */
    public void setActivityPrice(BigDecimal value) {
        this.activityPrice = value;
    }

    private Integer activityId;

    /**
     * 获取 活动ID。
     */
    public Integer getActivityId() {
        return this.activityId;
    }

    /**
     * 设置 活动ID。
     *
     * @param value 属性值
     */
    public void setActivityId(Integer value) {
        this.activityId = value;
    }

    private Integer cateId;

    /**
     * 获取 分类ID。
     */
    public Integer getCateId() {
        return this.cateId;
    }

    /**
     * 设置 分类ID。
     *
     * @param value 属性值
     */
    public void setCateId(Integer value) {
        this.cateId = value;
    }

    private Integer brandId;

    /**
     * 获取 品牌ID。
     */
    public Integer getBrandId() {
        return this.brandId;
    }

    /**
     * 设置 品牌ID。
     *
     * @param value 属性值
     */
    public void setBrandId(Integer value) {
        this.brandId = value;
    }

    private Integer netPointId;

    /**
     * 获取 网点id。
     */
    public Integer getNetPointId() {
        return this.netPointId;
    }

    /**
     * 设置 网点id。
     *
     * @param value 属性值
     */
    public void setNetPointId(Integer value) {
        this.netPointId = value;
    }

    private BigDecimal shippingFee;

    /**
     * 获取 配送费用。
     */
    public BigDecimal getShippingFee() {
        return this.shippingFee;
    }

    /**
     * 设置 配送费用。
     *
     * @param value 属性值
     */
    public void setShippingFee(BigDecimal value) {
        this.shippingFee = value;
    }

    private Integer settlementStatus;

    /**
     * 获取 结算状态0 未结算 1已结算 。
     */
    public Integer getSettlementStatus() {
        return this.settlementStatus;
    }

    /**
     * 设置 结算状态0 未结算 1已结算 。
     *
     * @param value 属性值
     */
    public void setSettlementStatus(Integer value) {
        this.settlementStatus = value;
    }

    private Long receiptOrRejectTime;

    /**
     * 获取 确认收货时间或拒绝收货时间。
     */
    public Long getReceiptOrRejectTime() {
        return this.receiptOrRejectTime;
    }

    /**
     * 设置 确认收货时间或拒绝收货时间。
     *
     * @param value 属性值
     */
    public void setReceiptOrRejectTime(Long value) {
        this.receiptOrRejectTime = value;
    }

    private Integer isWmsSku;

    /**
     * 获取 是否淘宝小家电。
     */
    public Integer getIsWmsSku() {
        return this.isWmsSku;
    }

    /**
     * 设置 是否淘宝小家电。
     *
     * @param value 属性值
     */
    public void setIsWmsSku(Integer value) {
        this.isWmsSku = value;
    }

    private String sCode;

    /**
     * 获取 库位编码。
     */
    public String getSCode() {
        return this.sCode;
    }

    /**
     * 设置 库位编码。
     *
     * @param value 属性值
     */
    public void setSCode(String value) {
        this.sCode = value;
    }

    private String tsCode;

    /**
     * 获取 转运库房编码。
     */
    public String getTsCode() {
        return this.tsCode;
    }

    /**
     * 设置 转运库房编码。
     *
     * @param value 属性值
     */
    public void setTsCode(String value) {
        this.tsCode = value;
    }

    private Integer tsShippingTime = 0;

    /**
     * 获取 转运时效（小时）。
     */
    public Integer getTsShippingTime() {
        return this.tsShippingTime;
    }

    /**
     * 设置 转运时效（小时）。
     *
     * @param value 属性值
     */
    public void setTsShippingTime(Integer value) {
        this.tsShippingTime = value;
    }

    private Integer status;

    /**
     * 获取 状态。
     */
    public Integer getStatus() {
        return this.status;
    }

    /**
     * 设置 状态。
     *
     * @param value 属性值
     */
    public void setStatus(Integer value) {
        this.status = value;
    }

    private String productSn;

    /**
     * 获取 商品条形码。
     */
    public String getProductSn() {
        return this.productSn;
    }

    /**
     * 设置 商品条形码。
     *
     * @param value 属性值
     */
    public void setProductSn(String value) {
        this.productSn = value;
    }

    private String invoiceNumber;

    /**
     * 获取 运单号。
     */
    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    /**
     * 设置 运单号。
     *
     * @param value 属性值
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    private String expressName;

    /**
     * 获取 快递公司。
     */
    public String getExpressName() {
        return this.expressName;
    }

    /**
     * 设置 快递公司。
     *
     * @param value 属性值
     */
    public void setExpressName(String value) {
        this.expressName = value;
    }

    private String invoiceExpressNumber;

    /**
     * 获取 发票快递单号。
     */
    public String getInvoiceExpressNumber() {
        return this.invoiceExpressNumber;
    }

    /**
     * 设置 发票快递单号。
     *
     * @param value 属性值
     */
    public void setInvoiceExpressNumber(String value) {
        this.invoiceExpressNumber = value;
    }

    private String postMan;

    /**
     * 获取 送货人。
     */
    public String getPostMan() {
        return this.postMan;
    }

    /**
     * 设置 送货人。
     *
     * @param value 属性值
     */
    public void setPostMan(String value) {
        this.postMan = value;
    }

    private String postManPhone;

    /**
     * 获取 送货人电话。
     */
    public String getPostManPhone() {
        return this.postManPhone;
    }

    /**
     * 设置 送货人电话。
     *
     * @param value 属性值
     */
    public void setPostManPhone(String value) {
        this.postManPhone = value;
    }

    private Integer isNotice;

    /**
     * 获取 是否开启预警。
     */
    public Integer getIsNotice() {
        return this.isNotice;
    }

    /**
     * 设置 是否开启预警。
     *
     * @param value 属性值
     */
    public void setIsNotice(Integer value) {
        this.isNotice = value;
    }

    private Integer noticeType;

    public Integer getNoticeType() {
        return this.noticeType;
    }

    public void setNoticeType(Integer value) {
        this.noticeType = value;
    }

    private String noticeRemark;

    public String getNoticeRemark() {
        return this.noticeRemark;
    }

    public void setNoticeRemark(String value) {
        this.noticeRemark = value;
    }

    private String noticeTime;

    /**
     * 获取 预警时间。
     */
    public String getNoticeTime() {
        return this.noticeTime;
    }

    /**
     * 设置 预警时间。
     *
     * @param value 属性值
     */
    public void setNoticeTime(String value) {
        this.noticeTime = value;
    }

    private Long shippingTime;

    /**
     * 获取 发货时间。
     */
    public Long getShippingTime() {
        return this.shippingTime;
    }

    /**
     * 设置 发货时间。
     *
     * @param value 属性值
     */
    public void setShippingTime(Long value) {
        this.shippingTime = value;
    }

    private String lessOrderSn;

    /**
     * 获取 less 订单号。
     */
    public String getLessOrderSn() {
        return this.lessOrderSn;
    }

    /**
     * 设置 less 订单号。
     *
     * @param value 属性值
     */
    public void setLessOrderSn(String value) {
        this.lessOrderSn = value;
    }

    private Integer waitGetLesShippingInfo;

    /**
     * 获取 是否等待获取LES物流配送节点信息。
     */
    public Integer getWaitGetLesShippingInfo() {
        return this.waitGetLesShippingInfo;
    }

    /**
     * 设置 是否等待获取LES物流配送节点信息。
     *
     * @param value 属性值
     */
    public void setWaitGetLesShippingInfo(Integer value) {
        this.waitGetLesShippingInfo = value;
    }

    private Integer getLesShippingCount;

    /**
     * 获取 已获取LES配送节点信息的次数。
     */
    public Integer getGetLesShippingCount() {
        return this.getLesShippingCount;
    }

    /**
     * 设置 已获取LES配送节点信息的次数。
     *
     * @param value 属性值
     */
    public void setGetLesShippingCount(Integer value) {
        this.getLesShippingCount = value;
    }

    private String outping;

    /**
     * 获取 出库凭证。
     */
    public String getOutping() {
        return this.outping;
    }

    /**
     * 设置 出库凭证。
     *
     * @param value 属性值
     */
    public void setOutping(String value) {
        this.outping = value;
    }

    private Long lessShipTime;

    /**
     * 获取 less出库时间。
     */
    public Long getLessShipTime() {
        return this.lessShipTime;
    }

    /**
     * 设置 less出库时间。
     *
     * @param value 属性值
     */
    public void setLessShipTime(Long value) {
        this.lessShipTime = value;
    }

    private Long closeTime;

    /**
     * 获取 网单完成关闭或取消关闭时间。
     */
    public Long getCloseTime() {
        return this.closeTime;
    }

    /**
     * 设置 网单完成关闭或取消关闭时间。
     *
     * @param value 属性值
     */
    public void setCloseTime(Long value) {
        this.closeTime = value;
    }

    private Integer isReceipt = 0;

    /**
     * 获取 是否需要发票。
     */
    public Integer getIsReceipt() {
        return this.isReceipt;
    }

    /**
     * 设置 是否需要发票。
     *
     * @param value 属性值
     */
    public void setIsReceipt(Integer value) {
        this.isReceipt = value;
    }

    private Integer isMakeReceipt = 1;

    /**
     * 获取 开票状态。
     */
    public Integer getIsMakeReceipt() {
        return this.isMakeReceipt;
    }

    /**
     * 设置 开票状态。
     *
     * @param value 属性值
     */
    public void setIsMakeReceipt(Integer value) {
        this.isMakeReceipt = value;
    }

    private String receiptNum;

    /**
     * 获取 发票号。
     */
    public String getReceiptNum() {
        return this.receiptNum;
    }

    /**
     * 设置 发票号。
     *
     * @param value 属性值
     */
    public void setReceiptNum(String value) {
        this.receiptNum = value;
    }

    private String receiptAddTime;

    /**
     * 获取 开票时间。
     */
    public String getReceiptAddTime() {
        return this.receiptAddTime;
    }

    /**
     * 设置 开票时间。
     *
     * @param value 属性值
     */
    public void setReceiptAddTime(String value) {
        this.receiptAddTime = value;
    }

    private Integer makeReceiptType;

    /**
     * 获取 开票类型 0 初始值 1 库房开票  2 共享开票。
     */
    public Integer getMakeReceiptType() {
        return this.makeReceiptType;
    }

    /**
     * 设置 开票类型 0 初始值 1 库房开票  2 共享开票。
     *
     * @param value 属性值
     */
    public void setMakeReceiptType(Integer value) {
        this.makeReceiptType = value;
    }

    private String shippingMode;

    /**
     * 获取 物流模式,值为B2B2C或B2C。
     */
    public String getShippingMode() {
        return this.shippingMode;
    }

    /**
     * 设置 物流模式,值为B2B2C或B2C。
     *
     * @param value 属性值
     */
    public void setShippingMode(String value) {
        this.shippingMode = value;
    }

    private Long lastTimeForShippingMode;

    /**
     * 获取 最后修改物流模式的时间。
     */
    public Long getLastTimeForShippingMode() {
        return this.lastTimeForShippingMode;
    }

    /**
     * 设置 最后修改物流模式的时间。
     *
     * @param value 属性值
     */
    public void setLastTimeForShippingMode(Long value) {
        this.lastTimeForShippingMode = value;
    }

    private String lastEditorForShippingMode;

    /**
     * 获取 最后修改物流模式的管理员。
     */
    public String getLastEditorForShippingMode() {
        return this.lastEditorForShippingMode;
    }

    /**
     * 设置 最后修改物流模式的管理员。
     *
     * @param value 属性值
     */
    public void setLastEditorForShippingMode(String value) {
        this.lastEditorForShippingMode = value;
    }

    private String systemRemark;

    /**
     * 获取 系统备注，不给用户显示。
     */
    public String getSystemRemark() {
        return this.systemRemark;
    }

    /**
     * 设置 系统备注，不给用户显示。
     *
     * @param value 属性值
     */
    public void setSystemRemark(String value) {
        this.systemRemark = value;
    }

    private Integer tongshuaiWorkId = -1;

    /**
     * 获取 统帅定制作品ID。
     */
    public Integer getTongshuaiWorkId() {
        return this.tongshuaiWorkId;
    }

    /**
     * 设置 统帅定制作品ID。
     *
     * @param value 属性值
     */
    public void setTongshuaiWorkId(Integer value) {
        this.tongshuaiWorkId = value;
    }

    private Integer orderPromotionId;

    /**
     * 获取 下单立减活动ID。
     */
    public Integer getOrderPromotionId() {
        return this.orderPromotionId;
    }

    /**
     * 设置 下单立减活动ID。
     *
     * @param value 属性值
     */
    public void setOrderPromotionId(Integer value) {
        this.orderPromotionId = value;
    }

    private BigDecimal orderPromotionAmount;

    /**
     * 获取 下单立减金额。
     */
    public BigDecimal getOrderPromotionAmount() {
        return this.orderPromotionAmount;
    }

    /**
     * 设置 下单立减金额。
     *
     * @param value 属性值
     */
    public void setOrderPromotionAmount(BigDecimal value) {
        this.orderPromotionAmount = value;
    }

    private Integer externalSaleSettingId;

    /**
     * 获取 淘宝套装设置ID。
     */
    public Integer getExternalSaleSettingId() {
        return this.externalSaleSettingId;
    }

    /**
     * 设置 淘宝套装设置ID。
     *
     * @param value 属性值
     */
    public void setExternalSaleSettingId(Integer value) {
        this.externalSaleSettingId = value;
    }

    private Integer recommendationId;

    /**
     * 获取 推荐购买ID。
     */
    public Integer getRecommendationId() {
        return this.recommendationId;
    }

    /**
     * 设置 推荐购买ID。
     *
     * @param value 属性值
     */
    public void setRecommendationId(Integer value) {
        this.recommendationId = value;
    }

    private Integer hasSendAlertNum;

    /**
     * 获取 是否已发送了购买数据报警邮件(短信)。
     */
    public Integer getHasSendAlertNum() {
        return this.hasSendAlertNum;
    }

    /**
     * 设置 是否已发送了购买数据报警邮件(短信)。
     *
     * @param value 属性值
     */
    public void setHasSendAlertNum(Integer value) {
        this.hasSendAlertNum = value;
    }

    private Integer isNoLimitStockProduct;

    /**
     * 获取 是否是无限制库存量的商品。
     */
    public Integer getIsNoLimitStockProduct() {
        return this.isNoLimitStockProduct;
    }

    /**
     * 设置 是否是无限制库存量的商品。
     *
     * @param value 属性值
     */
    public void setIsNoLimitStockProduct(Integer value) {
        this.isNoLimitStockProduct = value;
    }

    private Integer hpRegisterDate = 0;

    /**
     * 获取 HP注册时间。
     */
    public Integer getHpRegisterDate() {
        return this.hpRegisterDate;
    }

    /**
     * 设置 HP注册时间。
     *
     * @param value 属性值
     */
    public void setHpRegisterDate(Integer value) {
        this.hpRegisterDate = value;
    }

    private Integer hpFailDate = 0;

    /**
     * 获取 HP派工失败时间。
     */
    public Integer getHpFailDate() {
        return this.hpFailDate;
    }

    /**
     * 设置 HP派工失败时间。
     *
     * @param value 属性值
     */
    public void setHpFailDate(Integer value) {
        this.hpFailDate = value;
    }

    private Integer hpFinishDate = 0;

    /**
     * 获取 HP派工成功时间。
     */
    public Integer getHpFinishDate() {
        return this.hpFinishDate;
    }

    /**
     * 设置 HP派工成功时间。
     *
     * @param value 属性值
     */
    public void setHpFinishDate(Integer value) {
        this.hpFinishDate = value;
    }

    private Integer hpReservationDate = 0;

    /**
     * 获取 HP回传预约送货时间。
     */
    public Integer getHpReservationDate() {
        return this.hpReservationDate;
    }

    /**
     * 设置 HP回传预约送货时间。
     *
     * @param value 属性值
     */
    public void setHpReservationDate(Integer value) {
        this.hpReservationDate = value;
    }

    private Integer shippingOpporunity = 0;

    /**
     * 获取 活动订单发货时机，0定金发货 1尾款发货。
     */
    public Integer getShippingOpporunity() {
        return this.shippingOpporunity;
    }

    /**
     * 设置 活动订单发货时机，0定金发货 1尾款发货。
     *
     * @param value 属性值
     */
    public void setShippingOpporunity(Integer value) {
        this.shippingOpporunity = value;
    }

    private Integer isTimeoutFree = 0;

    /**
     * 获取 是否超时免单 0未设置 1是 2否。
     */
    public Integer getIsTimeoutFree() {
        return this.isTimeoutFree;
    }

    /**
     * 设置 是否超时免单 0未设置 1是 2否。
     *
     * @param value 属性值
     */
    public void setIsTimeoutFree(Integer value) {
        this.isTimeoutFree = value;
    }

    private BigDecimal itemShareAmount = new BigDecimal("0.00");

    /**
     * 获取 订单优惠价格分摊。
     */
    public BigDecimal getItemShareAmount() {
        return this.itemShareAmount;
    }

    /**
     * 设置 订单优惠价格分摊。
     *
     * @param value 属性值
     */
    public void setItemShareAmount(BigDecimal value) {
        this.itemShareAmount = value;
    }

    private Long lessShipTInTime = 0L;

    /**
     * 获取 less转运入库时间。
     */
    public Long getLessShipTInTime() {
        return this.lessShipTInTime;
    }

    /**
     * 设置 less转运入库时间。
     *
     * @param value 属性值
     */
    public void setLessShipTInTime(Long value) {
        this.lessShipTInTime = value;
    }

    private Long lessShipTOutTime = 0L;

    /**
     * 获取 less转运出库时间。
     */
    public Long getLessShipTOutTime() {
        return this.lessShipTOutTime;
    }

    /**
     * 设置 less转运出库时间。
     *
     * @param value 属性值
     */
    public void setLessShipTOutTime(Long value) {
        this.lessShipTOutTime = value;
    }

    private String cbsSecCode;

    /**
     * 获取 cbs库位
     * @return
     */
    public String getCbsSecCode() {
        return cbsSecCode;
    }

    /**
     * 设置cbs 库位
     * @param cbsSecCode
     */
    public void setCbsSecCode(String cbsSecCode) {
        this.cbsSecCode = cbsSecCode;
    }

    private Integer points;

    /**
     * @return Returns the points
     */
    public final Integer getPoints() {
        return points;
    }

    /**
     * @param points
     * The points to set.
     */
    public final void setPoints(Integer points) {
        this.points = points;
    }

    private Date modified;

    /**
     * @return Returns the modified
     */
    public final Date getModified() {
        return modified;
    }

    /**
     * @param modified
     * The modified to set.
     */
    public final void setModified(Date modified) {
        this.modified = modified;
    }

    private Integer splitFlag;

    /**
     * @return Returns the splitFlag
     */
    public final Integer getSplitFlag() {
        return splitFlag;
    }

    /**
     * @param splitFlag
     * The splitFlag to set.
     */
    public final void setSplitFlag(Integer splitFlag) {
        this.splitFlag = splitFlag;
    }

    private String splitRelateCOrderSn;

    /**
     * @return Returns the splitRelateCOrderSn
     */
    public final String getSplitRelateCOrderSn() {
        return splitRelateCOrderSn;
    }

    /**
     * @param splitRelateCOrderSn
     * The splitRelateCOrderSn to set.
     */
    public final void setSplitRelateCOrderSn(String splitRelateCOrderSn) {
        this.splitRelateCOrderSn = splitRelateCOrderSn;
    }

    private Integer channelId;

    /**
     * @return Returns the channelId
     */
    public final Integer getChannelId() {
        return channelId;
    }

    /**
     * @param channelId
     * The channelId to set.
     */
    public final void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    private Integer activityId2;

    /**
     * @return Returns the cPaymentStatus
     */
    public final Integer getcPaymentStatus() {
        return cPaymentStatus;
    }

    /**
     * @param cPaymentStatus
     * The cPaymentStatus to set.
     */
    public final void setcPaymentStatus(Integer cPaymentStatus) {
        this.cPaymentStatus = cPaymentStatus;
    }

    /**
     * @return Returns the cPayTime
     */
    public final Integer getcPayTime() {
        return cPayTime;
    }

    /**
     * @param cPayTime
     * The cPayTime to set.
     */
    public final void setcPayTime(Integer cPayTime) {
        this.cPayTime = cPayTime;
    }

    /**
     * @return Returns the sCode
     */
    public final String getsCode() {
        return sCode;
    }

    /**
     * @param sCode
     * The sCode to set.
     */
    public final void setsCode(String sCode) {
        this.sCode = sCode;
    }

    /**
     * @return Returns the activityId2
     */
    public final Integer getActivityId2() {
        return activityId2;
    }

    /**
     * @param activityId2
     * The activityId2 to set.
     */
    public final void setActivityId2(Integer activityId2) {
        this.activityId2 = activityId2;
    }

    /**
     * 下单时间
     *Comment for <code>addTime</code>
     */
    private String addTime;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    private java.lang.Integer pdOrderStatus;

    /**
     * 获取日日单状态
     * @return
     */
    public java.lang.Integer getPdOrderStatus() {
        return pdOrderStatus;
    }

    /**
     * 设置日日单状态
     * @param pdOrderStatus
     */
    public void setPdOrderStatus(java.lang.Integer pdOrderStatus) {
        this.pdOrderStatus = pdOrderStatus;
    }

    /**
     * 优惠码编码
     */
    private String couponCode;

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    /**
     * 优惠码优惠金额
     */
    private BigDecimal couponCodeValue;

    public BigDecimal getCouponCodeValue() {
        return couponCodeValue;
    }

    public void setCouponCodeValue(BigDecimal couponCodeValue) {
        this.couponCodeValue = couponCodeValue;
    }

    /**
     * 店铺ID
     */
    private java.lang.Integer storeId;

    public java.lang.Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(java.lang.Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 店铺类型
     */
    private java.lang.Integer storeType;

    public java.lang.Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(java.lang.Integer storeType) {
        this.storeType = storeType;
    }

    /**
     * 库存类型
     */
    private String stockType;

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    /**
     * o2o网单类型
     * 值：意义
     * 1：非O2O网单
     * 2：线下用户分销商城
     * 3：商城分销旗舰店
     * 4：创客
     */
    private java.lang.Integer o2oType;

    /**
     * 佣金类别
     */
    private String brokerageType;

    public String getBrokerageType() {
        return brokerageType;
    }

    public void setBrokerageType(String brokerageType) {
        this.brokerageType = brokerageType;
    }

    public java.lang.Integer getO2oType() {
        return o2oType;
    }

    public void setO2oType(java.lang.Integer o2oType) {
        this.o2oType = o2oType;
    }

}
