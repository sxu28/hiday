package com.haier.m.dao.shop.write;

import java.util.List;

import com.haier.m.entity.order.OrdersRecover;

public interface OrdersRecoverWriteDao {

	OrdersRecover get(java.lang.Integer id);

	Integer insert(OrdersRecover ordersRecover);

	Integer update(OrdersRecover ordersRecover);

	List<Integer> getOrderListByMemberId(Integer memberId);

	Integer insertOrdersList(List<OrdersRecover> orderRecoverList);
}