package com.haier.m.dao.shop.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.m.entity.order.OpAttribute;
import com.haier.m.entity.order.OrderProductInfo;
import com.haier.m.entity.vo.OrderDetailVo;


public interface OrderProductReadDao {

    /**
     * 根据网单号查询网单
     * @param cOrderSn
     * @return
     */
    OrderProductInfo getOrderProductBycOrderSn(String cOrderSn);
    
    /**
     * 根据订单ID获取网单列表
     * @param orderId 订单ID
     * @return
     */
    List<OrderProductInfo> getOrderProductsByOrderId(Integer orderId);
    
    /**
     * 根据网单号或者网单ID获取网单详情基本信息
     * @param cOrderSn
     * @param orderProductId
     * @return
     */
    OrderDetailVo getOrderProductDetail(@Param("cOrderSn")String cOrderSn, @Param("orderProductId")Integer orderProductId);
    
    /**
     * 根据网单ID获取网单扩展属性
     * @param opId
     * @return
     */
    OpAttribute getOpAttributeByOrderProductId(Integer opId);

}
