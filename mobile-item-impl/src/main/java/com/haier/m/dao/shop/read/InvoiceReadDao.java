package com.haier.m.dao.shop.read;

import com.haier.m.entity.order.InvoicesInfo;


public interface InvoiceReadDao {

    public InvoicesInfo getInvoiceBycOrderSn(String cOrderSn);
    
    public String selectInvoiceElectricByCOrderSn(String cOrderSn);

}
