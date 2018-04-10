package com.haier.m.dao.shop.read;

import com.haier.m.entity.order.OrdersAttributes ;

/**
 * 订单扩展属性表
 */
public interface OrdersAttributesReadDao {

    OrdersAttributes get(Integer id);
    
    OrdersAttributes getByOrderId(Integer orderId);
    
    OrdersAttributes getByLbx(String lbx);
    
    OrdersAttributes getBySourceOrderSn(String sourceOrderSn);
}
