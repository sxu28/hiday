package com.haier.m.entity.order;

import java.io.Serializable;

public class InvoiceElectric implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 编号
     */
    private Integer id;
    /**
     * 增加时间
     */
    private Integer addTime;
    /**
     * 订单Id
     */
    private Integer orderId;
    /**
     * 网单Id
     */
    private Integer orderProductId;
    /**
     * 网单编号
     */
    private String  cOrderSn;
    /**
     * 订单来源
     */
    private String  orderSource;
    /**
     * 发票号
     */
    private String  invoiceNumber;
    /**
     * 税控码
     */
    private String  fiscalCode;
    /**
     * 查看地址
     */
    private String  viewUrl;
    /**
     * 下载地址
     */
    private String  downloadUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

}
