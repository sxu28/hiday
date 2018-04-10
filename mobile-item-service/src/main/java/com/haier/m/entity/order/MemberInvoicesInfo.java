package com.haier.m.entity.order;

import java.io.Serializable;

/**
 * 发票
 * @author 纪祥
 * @date 2015-11-24
 * @email
 */
public class MemberInvoicesInfo implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2788227923747792958L;

    //主键
    private Integer id;
    //发票类型1-增票,2-普票
    private Integer invoiceType;
    //会员ID
    private Integer memberId;
    //会员名称
    private String memberName;
    //发票抬头
    private String invoiceTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

}
