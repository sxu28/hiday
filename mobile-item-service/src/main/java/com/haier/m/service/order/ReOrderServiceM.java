package com.haier.m.service.order;

import java.util.List;
import java.util.Map;

import com.haier.common.PagerInfo;
import com.haier.common.ServiceResult;
import com.haier.m.entity.order.ExpressInfo;
import com.haier.m.entity.order.InvoicesInfo;
import com.haier.m.entity.order.MemberInvoicesInfo;
import com.haier.m.entity.order.OrderCountVo;
import com.haier.m.entity.order.OrderInfo;
import com.haier.m.entity.order.OrderProductInfo;
import com.haier.m.entity.order.OrderQueryParam;
import com.haier.m.entity.order.OrderRepairsInfo;
import com.haier.m.entity.order.OrderVo;
import com.haier.m.entity.order.OrdersRecover;
import com.haier.m.entity.vo.OrderDetailVo;
import com.haier.m.entity.vo.OrderLimitConditionVo;

public interface ReOrderServiceM {

    /**
     * 根据条件获取订单数量
     * @param map
     * @return
     */
    public ServiceResult<Integer> getOrderCountsByConditions(Map<String, Object> map);

    /**
     * 根据条件获取订单列表
     * @param map
     * @param pager 分页参数
     * @param isPaging 是否分页
     * @return
     */
    public ServiceResult<List<OrderInfo>> getOrderListByConditions(Map<String, Object> map,
                                                                   PagerInfo pager,
                                                                   Boolean isPaging);

    /**
     * 根据网单号查询网单
     * @param cOrderSn
     * @return
     */
    public ServiceResult<OrderProductInfo> getOrderProductBycOrderSn(String cOrderSn);

    /**
     * 根据发票Id查询
     * @param memberInvoiceId
     * @return
     */
    public ServiceResult<MemberInvoicesInfo> getInvoiceByMemberInvoiceId(Integer memberInvoiceId);

    /**
     * 根据所有订单号获取退换货订单id
     *
     * @param ids
     * @return
     */
    public ServiceResult<List<OrderRepairsInfo>> getOrderRepairsIdByOrderIds(List<Integer> ids);

    /**
     * 根据网单id获取退换货订单详情
     * @param orderProductId
     * @return
     */
    public ServiceResult<List<OrderRepairsInfo>> getOrderRepairsByOrderProductId(Integer orderProductId);
    /**
     * 根据网单id获取退换货订单详情
     * @param orderProductId
     * @return
     */
    public ServiceResult<List<OrderRepairsInfo>> getOrderRepairsDetailByOrderProductId(Integer orderProductId);
    

    /**
     * 根据网单号查询发票信息
     * @param cOrderSn
     * @return
     */
    public ServiceResult<InvoicesInfo> getInvoiceBycOrderSn(String cOrderSn);

    /**
     * 根据网单号查询物流信息
     * @param cOrderSn
     * @return
     */
    public ServiceResult<ExpressInfo> getExpressInfoBycOrderSn(String cOrderSn);

    /**
     * 根据订单ID获取网单列表
     * @param orderId 订单ID
     * @return
     */
    public ServiceResult<List<OrderProductInfo>> getOrderProductsByOrderId(Integer orderId);

    

    /**
     * 插入订单删除记录表
     * @param ordersRecover
     * @return
     */
    public ServiceResult<Boolean> insertOrderToDelete(OrdersRecover ordersRecover);

    

    /**
     * 根据网单ID获取退货退款单
     * @param cOrderSn
     * @return
     */
    public ServiceResult<OrderRepairsInfo> getOrderRepairsByCOrderSn(String cOrderSn);

    /**
     * <pre>deleteAllOrders(批量删除订单)
     * 创建人：wangxiaoyu
     * 创建时间：2017年5月10日 上午10:27:25
     * 修改人：wangxiaoyu
     * 修改时间：2017年5月10日 上午10:27:25
     * 修改备注：
     * @param orderIds
     * @return</pre>
     */
    public ServiceResult<Boolean> insertOrderListToDelete(List<OrdersRecover> orderList);
    
    public ServiceResult<OrderInfo> getSwitchOrderSnByOrderId(String orderSn);
	/**
	 * 根据网单Id获取网点信息
	 * @param orderPorductId
	 * @return
	 */
    public ServiceResult<OrderRepairsInfo> getNetpointsByOrderProductId(Integer orderPorductId);

    /**
     * 校验用户是否下过单
     * @param memberId
     * @return
     */
    ServiceResult<Boolean> hasOrder(Integer memberId);
    
    /**
     * 获取登录人各类别订单数量
     * @param memberId
     * @return
     */
    ServiceResult<OrderCountVo> getOrderCountByMemberId(Integer memberId, List<Integer> assessedIds);
    
    /**
     * 根据筛选条件获取订单列表
     * @param param
     * @return
     */
    ServiceResult<List<OrderVo>> getOrderListByParam(OrderQueryParam param);
    
    /**
     * 根据条件获取订单数量
     * @param param
     * @return
     */
    ServiceResult<Integer> getOrderCountByParam(OrderQueryParam param);
    
    
    /**
     * 设置限购条件
     */
    ServiceResult<Boolean> updateLimitCondition(Map<String,Integer> map,String modifyUser);

    
    /**
     * 校验收货人手机号在指定街道购买商品下单数量是否超限
     * @param map
     * @return
     */
    ServiceResult<Boolean> checkOrderLimitByMobileNew(OrderLimitConditionVo limitVo);

    /**
     * 根据限购条件将商品的下单数量记录到redis有效时间到24点，在原来基础上增加给定数量num
     * @param limitVo
     * @return
     */
    ServiceResult<Boolean> recordOrderLimitByMobileNew(OrderLimitConditionVo limitVo);

    /**
     * 从redis获取后台可编辑限购条件，用于回显
     */
    ServiceResult<Map<String,String>> getOrderLimitCondition();
    
    /**
     * 取消订单清除下单记录数
     * @param orderId
     * @return
     */
    ServiceResult<Boolean> clearOrderLimitNew(Integer orderId,Integer region);
    
    /**
     * 获取订单详情
     * @param cOrderSn
     * @param orderProductId
     * @return
     */
    ServiceResult<OrderDetailVo> getOrderDetail(String cOrderSn, Integer orderProductId);
}
