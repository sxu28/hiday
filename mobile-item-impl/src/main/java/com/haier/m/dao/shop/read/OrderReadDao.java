package com.haier.m.dao.shop.read;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.haier.m.entity.order.OrderInfo;
import com.haier.m.entity.order.OrderQueryParam;
import com.haier.m.entity.order.OrderVo;
import com.haier.m.entity.order.RelationOrder;

public interface OrderReadDao {

    /**
     * 根据条件查询订单数量
     * @param map
     * @return
     */
    Integer getOrderCountsByConditions(Map<String, Object> map);

    /**
     * 根据条件查询订单列表
     * @param map
     * @return
     */
    List<OrderInfo> getOrderListByConditions(Map<String, Object> map);
    
    /**
     * 根据id获取订单信息
     * @param orderId
     * @return
     */
    OrderInfo getOrderById(Integer orderId);
    
    /**
     * 根据订单号获取订单信息
     * @param orderSn
     * @return
     */
    OrderInfo getOrderByOrderSn (String orderSn);
    /**
     * 根据orderId获取最新的换机单的订单信息
     */
    OrderInfo getSwitchOrderSnByOrderId(String orderSn);

    /**
     * 查询某一用户的付款订单
     * @param memberId
     * @return
     */
    Integer hasOrder(Integer memberId);
    
    /**
     * 根据登录用户和订单状态获取订单数量
     * @param memberId
     * @param orderStatus
     * @return
     */
    List<Integer> getOrderCount(@Param("memberId")Integer memberId,
	    @Param("orderStatus")Integer orderStatus, 
	    @Param("assessOrderProductId")List<Integer> assessedIds,
	    @Param("outDateTimeStamp") Integer outDateTimeStamp);
    
    /**
     * 根据筛选条件获取订单列表
     * @param param
     * @return
     */
    List<OrderVo> getOrderListByParam(OrderQueryParam param);
    
    /**
     * 根据筛选条件获取订单数量
     * @param param
     * @return
     */
    Integer getOrderCountByParam(OrderQueryParam param);

    /**
     * 根据筛选条件获取订单ID列表
     * @param param
     * @return
     */
    List<Integer> getOrderIDListByParam(OrderQueryParam param);

    /**
     * 根据订单IDList获取订单列表信息
     * @param idList
     * @return
     */
    List<OrderVo> getOrderListByIDList(@Param("idList") List<Integer> idList);
    
    /**
     * 关联订单支付时间和优惠券
     * @param orderSn
     * @return
     */
    RelationOrder getRelationOrder(String orderSn);
    
    /**
     * 获取待付款订单的订单Id
     * @param param
     * @return
     */
    List<Integer> getOrderIDListWaitPay(OrderQueryParam param);
}
