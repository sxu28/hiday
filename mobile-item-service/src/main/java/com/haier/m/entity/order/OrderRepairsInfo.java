package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 网单退换货。
 *
 * <p>Table: <strong>OrderRepairs</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *     <th nowrap>属性名</th><th nowrap>属性类型</th><th nowrap>字段名</th><th nowrap>字段类型</th><th nowrap>说明</th>
 *   </tr>
 *   <tr><td>id</td><td>{@link Integer}</td><td>id</td><td>int</td><td>ID</td></tr>
 *   <tr><td>siteId</td><td>{@link Integer}</td><td>siteId</td><td>int</td><td>&nbsp;</td></tr>
 *   <tr><td>addTime</td><td>{@link Integer}</td><td>addTime</td><td>int</td><td>资源名称</td></tr>
 *   <tr><td>memberId</td><td>{@link Integer}</td><td>memberId</td><td>int</td><td>会员ID</td></tr>
 *   <tr><td>orderId</td><td>{@link Integer}</td><td>orderId</td><td>int</td><td>订单ID</td></tr>
 *   <tr><td>orderProductId</td><td>{@link Integer}</td><td>orderProductId</td><td>int</td><td>订单商品(网单)ID</td></tr>
 *   <tr><td>paymentStatus</td><td>{@link Integer}</td><td>paymentStatus</td><td>int</td><td>退款处理状态</td></tr>
 *   <tr><td>paymentTime</td><td>{@link Integer}</td><td>paymentTime</td><td>int</td><td>退款时间</td></tr>
 *   <tr><td>paymentName</td><td>{@link String}</td><td>paymentName</td><td>varchar</td><td>退款方式</td></tr>
 *   <tr><td>receiptStatus</td><td>{@link Integer}</td><td>receiptStatus</td><td>int</td><td>冲票状态</td></tr>
 *   <tr><td>receiptTime</td><td>{@link Integer}</td><td>receiptTime</td><td>int</td><td>冲票时间</td></tr>
 *   <tr><td>storageStatus</td><td>{@link Integer}</td><td>storageStatus</td><td>int</td><td>入库状态</td></tr>
 *   <tr><td>storageTime</td><td>{@link Integer}</td><td>storageTime</td><td>int</td><td>入库时间</td></tr>
 *   <tr><td>typeExpect</td><td>{@link Integer}</td><td>typeExpect</td><td>int</td><td>期望处理方式(预留字段)</td></tr>
 *   <tr><td>typeActual</td><td>{@link Integer}</td><td>typeActual</td><td>int</td><td>实际处理方式(预留字段)</td></tr>
 *   <tr><td>reason</td><td>{@link String}</td><td>reason</td><td>varchar</td><td>退款原因</td></tr>
 *   <tr><td>description</td><td>{@link String}</td><td>description</td><td>varchar</td><td>描述</td></tr>
 *   <tr><td>contactName</td><td>{@link String}</td><td>contactName</td><td>varchar</td><td>联系人姓名</td></tr>
 *   <tr><td>contactMobile</td><td>{@link String}</td><td>contactMobile</td><td>varchar</td><td>联系人手机</td></tr>
 *   <tr><td>handleStatus</td><td>{@link Integer}</td><td>handleStatus</td><td>int</td><td>处理状态(展现给客户)</td></tr>
 *   <tr><td>handleTime</td><td>{@link Integer}</td><td>handleTime</td><td>int</td><td>审核时间</td></tr>
 *   <tr><td>handleRemark</td><td>{@link String}</td><td>handleRemark</td><td>varchar</td><td>受理备注，如取消原因等</td></tr>
 *   <tr><td>repairSn</td><td>{@link String}</td><td>repairSn</td><td>varchar</td><td>退货单号</td></tr>
 *   <tr><td>count</td><td>{@link Integer}</td><td>count</td><td>int</td><td>退货数量</td></tr>
 *   <tr><td>requestServiceRemark</td><td>{@link String}</td><td>requestServiceRemark</td><td>varchar</td><td>要求描述</td></tr>
 *   <tr><td>requestServiceDate</td><td>{@link Integer}</td><td>requestServiceDate</td><td>int</td><td>要求服务时间</td></tr>
 *   <tr><td>offlineFlag</td><td>{@link Integer}</td><td>offlineFlag</td><td>int</td><td>是否线下退款</td></tr>
 *   <tr><td>offlineReason</td><td>{@link String}</td><td>offlineReason</td><td>varchar</td><td>&nbsp;</td></tr>
 *   <tr><td>offlineAmount</td><td>{@link BigDecimal}</td><td>offlineAmount</td><td>decimal</td><td>退款金额</td></tr>
 *   <tr><td>offlineRemark</td><td>{@link BigDecimal}</td><td>offlineRemark</td><td>decimal</td><td>退款金额备注</td></tr>
 *   <tr><td>offlineConfirmFlag</td><td>{@link Integer}</td><td>offlineConfirmFlag</td><td>int</td><td>线下退款标识</td></tr>
 *   <tr><td>hpFirstAddTime</td><td>{@link Integer}</td><td>hpFirstAddTime</td><td>int</td><td>HP一次质检推送时间</td></tr>
 *   <tr><td>hpSecondAddTime</td><td>{@link Integer}</td><td>hpSecondAddTime</td><td>int</td><td>HP二次质检推送时间</td></tr>
 *   <tr><td>modified</td><td>{@link Date}</td><td>modified</td><td>timestamp/date</td><td>最后更新时间</td></tr>
 *   <tr><td>finishTime</td><td>{@link Integer}</td><td>finishTime</td><td>int</td><td>完成时间</td></tr>
 *   <tr><td>refundAmount</td><td>{@link BigDecimal}</td><td>refundAmount</td><td>decimal</td><td>退款金额</td></tr>
 * </table>
 *
 * @author 纪祥
 * @date 2015-12-15
 * @email jixaing@astroway.net
 */
public class OrderRepairsInfo implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 8963463571267956294L;

    private Integer           id;
    private Integer        isCod;
    
    private Integer        cPaymentStatus;
    private String orderSn;
    
    public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	public Integer getcPaymentStatus() {
		return cPaymentStatus;
	}

	public void setcPaymentStatus(Integer cPaymentStatus) {
		this.cPaymentStatus = cPaymentStatus;
	}

	public Integer getIsCod() {
		return isCod;
	}

	public void setIsCod(Integer isCod) {
		this.isCod = isCod;
	}

	/**
     * 获取 ID。
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 ID。
     *
     * @param value 属性值
     */
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

    private String addTime;
    //最后修改时间
    private String modifiedTime;
    //质检表记录创建时间
    private String orraddTime;
    //质检不通过原因
    private String woId;
    
    
    public String getWoId() {
		return woId;
	}

	public void setWoId(String woId) {
		this.woId = woId;
	}

	public String getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	public String getOrraddTime() {
		return orraddTime;
	}

	public void setOrraddTime(String orraddTime) {
		this.orraddTime = orraddTime;
	}

	/**
     * 获取 资源名称。
     */
    public String getAddTime() {
        return this.addTime;
    }

    /**
     * 设置 资源名称。
     *
     * @param value 属性值
     */
    public void setAddTime(String value) {
        this.addTime = value;
    }

    private Integer memberId;

    /**
     * 获取 会员ID。
     */
    public Integer getMemberId() {
        return this.memberId;
    }

    /**
     * 设置 会员ID。
     *
     * @param value 属性值
     */
    public void setMemberId(Integer value) {
        this.memberId = value;
    }

    private Integer orderId;

    /**
     * 获取 订单ID。
     */
    public Integer getOrderId() {
        return this.orderId;
    }

    /**
     * 设置 订单ID。
     *
     * @param value 属性值
     */
    public void setOrderId(Integer value) {
        this.orderId = value;
    }

    private Integer orderProductId;

    /**
     * 获取 订单商品(网单)ID。
     */
    public Integer getOrderProductId() {
        return this.orderProductId;
    }

    /**
     * 设置 订单商品(网单)ID。
     *
     * @param value 属性值
     */
    public void setOrderProductId(Integer value) {
        this.orderProductId = value;
    }

    private Integer paymentStatus;

    /**
     * 获取 退款处理状态。
     */
    public Integer getPaymentStatus() {
        return this.paymentStatus;
    }

    /**
     * 设置 退款处理状态。
     *
     * @param value 属性值
     */
    public void setPaymentStatus(Integer value) {
        this.paymentStatus = value;
    }

    private String paymentTime;

    /**
     * 获取 退款时间。
     */
    public String getPaymentTime() {
        return this.paymentTime;
    }

    /**
     * 设置 退款时间。
     *
     * @param value 属性值
     */
    public void setPaymentTime(String value) {
        this.paymentTime = value;
    }

    private String paymentName;

    /**
     * 获取 退款方式。
     */
    public String getPaymentName() {
        return this.paymentName;
    }

    /**
     * 设置 退款方式。
     *
     * @param value 属性值
     */
    public void setPaymentName(String value) {
        this.paymentName = value;
    }

    private Integer receiptStatus;

    /**
     * 获取 冲票状态。
     */
    public Integer getReceiptStatus() {
        return this.receiptStatus;
    }

    /**
     * 设置 冲票状态。
     *
     * @param value 属性值
     */
    public void setReceiptStatus(Integer value) {
        this.receiptStatus = value;
    }

    private Integer receiptTime;

    /**
     * 获取 冲票时间。
     */
    public Integer getReceiptTime() {
        return this.receiptTime;
    }

    /**
     * 设置 冲票时间。
     *
     * @param value 属性值
     */
    public void setReceiptTime(Integer value) {
        this.receiptTime = value;
    }

    private Integer storageStatus;

    /**
     * 获取 入库状态。
     */
    public Integer getStorageStatus() {
        return this.storageStatus;
    }

    /**
     * 设置 入库状态。
     *
     * @param value 属性值
     */
    public void setStorageStatus(Integer value) {
        this.storageStatus = value;
    }

    private Integer storageTime;

    /**
     * 获取 入库时间。
     */
    public Integer getStorageTime() {
        return this.storageTime;
    }

    /**
     * 设置 入库时间。
     *
     * @param value 属性值
     */
    public void setStorageTime(Integer value) {
        this.storageTime = value;
    }

    private Integer typeExpect;

    /**
     * 获取 期望处理方式(预留字段)。
     */
    public Integer getTypeExpect() {
        return this.typeExpect;
    }

    /**
     * 设置 期望处理方式(预留字段)。
     *
     * @param value 属性值
     */
    public void setTypeExpect(Integer value) {
        this.typeExpect = value;
    }

    private Integer typeActual;

    /**
     * 获取 实际处理方式(预留字段)。
     */
    public Integer getTypeActual() {
        return this.typeActual;
    }

    /**
     * 设置 实际处理方式(预留字段)。
     *
     * @param value 属性值
     */
    public void setTypeActual(Integer value) {
        this.typeActual = value;
    }

    private String reason;

    /**
     * 获取 退款原因。
     */
    public String getReason() {
        return this.reason;
    }

    /**
     * 设置 退款原因。
     *
     * @param value 属性值
     */
    public void setReason(String value) {
        this.reason = value;
    }

    private String description;

    /**
     * 获取 描述。
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 设置 描述。
     *
     * @param value 属性值
     */
    public void setDescription(String value) {
        this.description = value;
    }

    private String contactName;

    /**
     * 获取 联系人姓名。
     */
    public String getContactName() {
        return this.contactName;
    }

    /**
     * 设置 联系人姓名。
     *
     * @param value 属性值
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    private String contactMobile;

    /**
     * 获取 联系人手机。
     */
    public String getContactMobile() {
        return this.contactMobile;
    }

    /**
     * 设置 联系人手机。
     *
     * @param value 属性值
     */
    public void setContactMobile(String value) {
        this.contactMobile = value;
    }

    private Integer handleStatus;

    /**
     * 获取 处理状态(展现给客户)。
     */
    public Integer getHandleStatus() {
        return this.handleStatus;
    }

    /**
     * 设置 处理状态(展现给客户)。
     *
     * @param value 属性值
     */
    public void setHandleStatus(Integer value) {
        this.handleStatus = value;
    }

    private String handleTime;

    /**
     * 获取 审核时间。
     */
    public String getHandleTime() {
        return this.handleTime;
    }

    /**
     * 设置 审核时间。
     *
     * @param value 属性值
     */
    public void setHandleTime(String value) {
        this.handleTime = value;
    }

    private String handleRemark;

    /**
     * 获取 受理备注，如取消原因等。
     */
    public String getHandleRemark() {
        return this.handleRemark;
    }

    /**
     * 设置 受理备注，如取消原因等。
     *
     * @param value 属性值
     */
    public void setHandleRemark(String value) {
        this.handleRemark = value;
    }

    private String repairSn;

    /**
     * 获取 退货单号。
     */
    public String getRepairSn() {
        return this.repairSn;
    }

    /**
     * 设置 退货单号。
     *
     * @param value 属性值
     */
    public void setRepairSn(String value) {
        this.repairSn = value;
    }

    private Integer count;

    /**
     * 获取 退货数量。
     */
    public Integer getCount() {
        return this.count;
    }

    /**
     * 设置 退货数量。
     *
     * @param value 属性值
     */
    public void setCount(Integer value) {
        this.count = value;
    }

    private String requestServiceRemark;

    /**
     * 获取 要求描述。
     */
    public String getRequestServiceRemark() {
        return this.requestServiceRemark;
    }

    /**
     * 设置 要求描述。
     *
     * @param value 属性值
     */
    public void setRequestServiceRemark(String value) {
        this.requestServiceRemark = value;
    }

    private Integer requestServiceDate;

    /**
     * 获取 要求服务时间。
     */
    public Integer getRequestServiceDate() {
        return this.requestServiceDate;
    }

    /**
     * 设置 要求服务时间。
     *
     * @param value 属性值
     */
    public void setRequestServiceDate(Integer value) {
        this.requestServiceDate = value;
    }

    private Integer offlineFlag;

    /**
     * 获取 是否线下退款。
     */
    public Integer getOfflineFlag() {
        return this.offlineFlag;
    }

    /**
     * 设置 是否线下退款。
     *
     * @param value 属性值
     */
    public void setOfflineFlag(Integer value) {
        this.offlineFlag = value;
    }

    private String offlineReason;

    public String getOfflineReason() {
        return this.offlineReason;
    }

    public void setOfflineReason(String value) {
        this.offlineReason = value;
    }

    private BigDecimal offlineAmount;

    /**
     * 获取 退款金额。
     */
    public BigDecimal getOfflineAmount() {
        return this.offlineAmount;
    }

    /**
     * 设置 退款金额。
     *
     * @param value 属性值
     */
    public void setOfflineAmount(BigDecimal value) {
        this.offlineAmount = value;
    }

    private String offlineRemark;

    /**
     * 获取 退款金额备注。
     */
    public String getOfflineRemark() {
        return this.offlineRemark;
    }

    /**
     * 设置 退款金额备注。
     *
     * @param value 属性值
     */
    public void setOfflineRemark(String value) {
        this.offlineRemark = value;
    }

    private Integer offlineConfirmFlag;

    /**
     * 获取 线下退款标识。
     */
    public Integer getOfflineConfirmFlag() {
        return this.offlineConfirmFlag;
    }

    /**
     * 设置 线下退款标识。
     *
     * @param value 属性值
     */
    public void setOfflineConfirmFlag(Integer value) {
        this.offlineConfirmFlag = value;
    }

    private Integer hpFirstAddTime;

    /**
     * 获取 HP一次质检推送时间。
     */
    public Integer getHpFirstAddTime() {
        return this.hpFirstAddTime;
    }

    /**
     * 设置 HP一次质检推送时间。
     *
     * @param value 属性值
     */
    public void setHpFirstAddTime(Integer value) {
        this.hpFirstAddTime = value;
    }

    private Integer hpSecondAddTime;

    /**
     * 获取 HP二次质检推送时间。
     */
    public Integer getHpSecondAddTime() {
        return this.hpSecondAddTime;
    }

    /**
     * 设置 HP二次质检推送时间。
     *
     * @param value 属性值
     */
    public void setHpSecondAddTime(Integer value) {
        this.hpSecondAddTime = value;
    }

    private Date modified;

    /**
     * 获取 最后更新时间。
     */
    public Date getModified() {
        return this.modified;
    }

    /**
     * 设置 最后更新时间。
     *
     * @param value 属性值
     */
    public void setModified(Date value) {
        this.modified = value;
    }

    private Integer finishTime;

    /**
     * 获取 完成时间。
     */
    public Integer getFinishTime() {
        return this.finishTime;
    }

    /**
     * 设置 完成时间。
     *
     * @param value 属性值
     */
    public void setFinishTime(Integer value) {
        this.finishTime = value;
    }

    private BigDecimal refundAmount;

    /**
     * 获取 退款金额。
     */
    public BigDecimal getRefundAmount() {
        return this.refundAmount;
    }

    /**
     * 设置 退款金额。
     *
     * @param value 属性值
     */
    public void setRefundAmount(BigDecimal value) {
        this.refundAmount = value;
    }

    //质检类型
    private Integer checkType;
    //质检结果（类型1）
    private Integer quality;
    //质检结果（类型2）
    private Integer packResult;
    
    //检验结果，符合条件；不符合条件
    private Integer checkResult;
    //质检时间
    private String inspectTime;
    
    //质检网点名称
    private String netPointName;
    //质检网点电话
    private String phoneNumber;
    private String proId;
    private String cPayTime;
    private String shippingMode;
    private String stockType;
    private Integer o2oType;
    
    public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public Integer getO2oType() {
		return o2oType;
	}

	public void setO2oType(Integer o2oType) {
		this.o2oType = o2oType;
	}

	public String getProId() {
		return proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getcPayTime() {
		return cPayTime;
	}

	public void setcPayTime(String cPayTime) {
		this.cPayTime = cPayTime;
	}

	public String getShippingMode() {
		return shippingMode;
	}

	public void setShippingMode(String shippingMode) {
		this.shippingMode = shippingMode;
	}

	public String getNetPointName() {
		return netPointName;
	}

	public void setNetPointName(String netPointName) {
		this.netPointName = netPointName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public String getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(String inspectTime) {
        this.inspectTime = inspectTime;
    }

    public Integer getPackResult() {
        return packResult;
    }

    public void setPackResult(Integer packResult) {
        this.packResult = packResult;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

	public Integer getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(Integer checkResult) {
		this.checkResult = checkResult;
	}
    
}
