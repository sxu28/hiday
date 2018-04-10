package com.haier.m.dao.shop.read;


import com.haier.m.entity.order.MemberInvoicesInfo;

public interface MemberInvoiceReadDao {

    /**
     * 根据发票Id查询
     * @param memberInvoiceId
     * @return
     */
    MemberInvoicesInfo getInvoiceByMemberInvoiceId(Integer memberInvoiceId);
    
    MemberInvoicesInfo getMemberInvoiceByOrderId(Integer orderId);
    
}
