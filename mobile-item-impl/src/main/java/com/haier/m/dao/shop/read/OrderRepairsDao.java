package com.haier.m.dao.shop.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.m.entity.order.OrderRepairsInfo;


public interface OrderRepairsDao {

    public List<OrderRepairsInfo> getOrderRepairsIdByOrderIds(@Param("ids") List<Integer> ids);

    public List<OrderRepairsInfo> getOrderRepairsByOrderProductId(Integer orderProductId);
    
    public List<OrderRepairsInfo> getOrderRepairsDetailByOrderProductId(Integer orderProductId);
    

    /**
     * 通过网单ID查询退货单详情
     * @param cOrderSn
     * @return
     */
    OrderRepairsInfo getOrderRepairsByCOrderSn(@Param("cOrderSn") String cOrderSn);
    /**
     * 根据网单Id获取网点信息
     * @param orderProductId
     * @return
     */
    OrderRepairsInfo getNetpointsByOrderProductId(Integer orderProductId);
    
    /**
     * 获取退货单数量
     * @param memberId
     * @return
     */
    List<Integer> getOrerRepairsCountByMemberId(Integer memberId);

}
