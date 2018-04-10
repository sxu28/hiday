package com.haier.m.entity.order;

import java.io.Serializable;

/**
 * 物流信息
 *
 * @author 纪祥
 * @date 2016-01-11
 * @email
 */
public class ExpressInfo implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2788227923747792958L;

    //ID
    private Integer id;
    //添加时间
    private String addTime;
    //订单ID
    private Integer orderId;
    //网单ID
    private Integer orderProductId;
    //网单编号
    private String cOrderSn;
    //快递公司 EMS|SF
    private String expressCompany;
    //快递单号
    private String expressNumber;

    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
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

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
