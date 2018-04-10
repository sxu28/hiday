package com.haier.m.service.order.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.haier.common.BusinessException;
import com.haier.common.PagerInfo;
import com.haier.common.ServiceResult;
import com.haier.common.util.StringUtil;
import com.haier.m.entity.item.Products;
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
import com.haier.m.model.item.ItemModelM;
import com.haier.m.model.order.OrderModel;
import com.haier.m.model.order.OrdersRecoverModel;
import com.haier.m.model.redis.SgRedisMode;
import com.haier.m.service.order.ReOrderServiceM;
import com.haier.m.service.order.facade.OrderLimitFacade;
import com.haier.m.util.ItemConstants;
import com.haier.m.util.OrderLimitConditionUtil;
import com.haier.m.util.RedisConstants;

@Service("reOrderServiceM")
public class OrderServiceImpl implements ReOrderServiceM {

    private static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Resource
    private OrderModel orderModel;

    @Resource
    private ItemModelM itemModel;

    @Resource
    private OrdersRecoverModel ordersRecoverModel;
    
    @Resource
    private OrderLimitFacade orderLimitFacade;

    public ServiceResult<Integer> getOrderCountsByConditions(Map<String, Object> map) {
        ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result.setResult(orderModel.getOrderCountsByConditions(map));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据条件获取订单数量发生异常！，" + e.getMessage());
            log.error("根据条件获取订单数量发生异常", e);
        }
        return result;
    }

    public ServiceResult<List<OrderInfo>> getOrderListByConditions(Map<String, Object> map,
                                                                   PagerInfo pager,
                                                                   Boolean isPaging) {
        ServiceResult<List<OrderInfo>> serviceResult = new ServiceResult<List<OrderInfo>>();
        try {
            serviceResult.setResult(orderModel.getOrderListByConditions(map, pager, isPaging));
        } catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setMessage("根据条件获取订单列表发生异常！，" + e.getMessage());
            log.error("根据条件获取订单列表发生异常", e);
        }
        return serviceResult;
    }

    public ServiceResult<List<OrderRepairsInfo>> getOrderRepairsIdByOrderIds(List<Integer> ids) {
        ServiceResult<List<OrderRepairsInfo>> result = new ServiceResult<List<OrderRepairsInfo>>();
        try {
            result.setResult(orderModel.getOrderRepairsIdByOrderIds(ids));
        } catch (Exception e) {
            log.error("查询退换货信息时发生未知异常:", e);
            result.setSuccess(false);
            result.setMessage("查询退换货信息时发生未知异常");
        }
        return result;
    }

    public ServiceResult<List<OrderRepairsInfo>> getOrderRepairsDetailByOrderProductId(Integer orderProductId) {
        ServiceResult<List<OrderRepairsInfo>> result = new ServiceResult<List<OrderRepairsInfo>>();
        try {
            result.setResult(orderModel.getOrderRepairsDetailByOrderProductId(orderProductId));
        } catch (Exception e) {
            log.error("查询退换货详情时发生未知异常:", e);
            result.setSuccess(false);
            result.setMessage("查询退换货详情时发生未知异常");
        }
        return result;
    }

    public ServiceResult<MemberInvoicesInfo> getInvoiceByMemberInvoiceId(Integer memberInvoiceId) {
        ServiceResult<MemberInvoicesInfo> result = new ServiceResult<MemberInvoicesInfo>();
        try {
            result.setResult(orderModel.getInvoiceByMemberInvoiceId(memberInvoiceId));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据发票id获取发票发生异常！，" + e.getMessage());
            log.error("根据发票id获取发票发生异常！", e);
        }
        return result;
    }

    public ServiceResult<List<OrderRepairsInfo>> getOrderRepairsByOrderProductId(Integer orderProductId) {
        ServiceResult<List<OrderRepairsInfo>> result = new ServiceResult<List<OrderRepairsInfo>>();
        try {
            result.setResult(orderModel.getOrderRepairsByOrderProductId(orderProductId));
        } catch (Exception e) {
            log.error("查询退换货详情时发生未知异常:", e);
            result.setSuccess(false);
            result.setMessage("查询退换货详情时发生未知异常");
        }
        return result;
    }

    public ServiceResult<InvoicesInfo> getInvoiceBycOrderSn(String orderProductId) {
        ServiceResult<InvoicesInfo> result = new ServiceResult<InvoicesInfo>();
        try {
            result.setResult(orderModel.getInvoiceBycOrderSn(orderProductId));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据网单id获取发票发生异常！，" + e.getMessage());
            log.error("根据网单id获取发票发生异常！", e);
        }
        return result;
    }

    public ServiceResult<ExpressInfo> getExpressInfoBycOrderSn(String cOrderSn) {
        ServiceResult<ExpressInfo> result = new ServiceResult<ExpressInfo>();
        try {
            result.setResult(orderModel.getExpressInfoBycOrderSn(cOrderSn));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据网单号获取物流信息发生异常！，" + e.getMessage());
            log.error("根据网单号获取物流信息发生异常！", e);
        }
        return result;
    }

    /**
     * 根据订单ID获取网单列表
     */
    @Override
    public ServiceResult<List<OrderProductInfo>> getOrderProductsByOrderId(Integer orderId) {
        ServiceResult<List<OrderProductInfo>> result = new ServiceResult<List<OrderProductInfo>>();
        try {
            result.setResult(orderModel.getOrderProductsByOrderId(orderId));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据订单ID获取网单列表！" + e.getMessage());
            log.error("根据订单ID获取网单列表！", e);
        }
        return result;
    }


    private boolean checkTodayOrder(Integer addTime) {
        boolean isToday = true;
        Calendar cand = Calendar.getInstance();
        cand.setTime(new Date());
        cand.set(Calendar.HOUR_OF_DAY, 0);
        cand.set(Calendar.MINUTE, 0);
        cand.set(Calendar.SECOND, 0);
        int startTime = (int) (cand.getTime().getTime() / 1000);
        if ((addTime - startTime) < 0) {
            isToday = false;
        }
        return isToday;
    }


    /**
     * 插入订单删除记录表
     */
    @Override
    public ServiceResult<Boolean> insertOrderToDelete(OrdersRecover ordersRecover) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result.setResult(ordersRecoverModel.saveOrdersRecover(ordersRecover) > 0);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("插入订单删除记录表异常！" + e.getMessage());
            log.error("插入订单删除记录表异常！", e);
        }
        return result;
    }


    /**
     * 根据网单ID获取退货退款单
     */
    @Override
    public ServiceResult<OrderRepairsInfo> getOrderRepairsByCOrderSn(String cOrderSn) {
        ServiceResult<OrderRepairsInfo> result = new ServiceResult<OrderRepairsInfo>();
        try {
            result.setResult(orderModel.getOrderRepairsByCOrderSn(cOrderSn));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据网单ID获取退货退款单！" + e.getMessage());
            log.error("根据网单ID获取退货退款单！", e);
        }
        return result;
    }

    private boolean checkLimit(Integer productId) {
        boolean check = false;
        Products pro = itemModel.getProductByProductId(productId);
//        if (pro != null && ItemConstants.CHECK_BRAND.contains(pro.getBrandId())
//            && ItemConstants.SHIPPING_MODE_BBC.equalsIgnoreCase(pro.getShippingMode())) {
        if (pro != null && (StringUtil.isEmpty(pro.getShippingMode()) || ItemConstants.SHIPPING_MODE_BBC.equalsIgnoreCase(pro.getShippingMode()))) {
            check = true;
        }
        return check;
    }

    /**
     * 根据orderId获取换机单的订单信息
     */
    @Override
    public ServiceResult<OrderInfo> getSwitchOrderSnByOrderId(String orderSn) {
        ServiceResult<OrderInfo> result = new ServiceResult<OrderInfo>();
        try {
            result.setResult(orderModel.getSwitchOrderSnByOrderId(orderSn));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据orderId获取换机单信息失败" + e.getMessage());
            log.error("根据orderId获取换机单信息失败", e);
        }
        return result;
    }

    /**
     * 批量插入订单删除记录表
     */
    @Override
    public ServiceResult<Boolean> insertOrderListToDelete(List<OrdersRecover> orderList) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result.setResult(ordersRecoverModel.saveOrdersListRecover(orderList) > 0);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("批量插入订单删除记录表异常！" + e.getMessage());
            log.error("批量插入订单删除记录表异常！", e);
        }
        return result;
    }

    public ServiceResult<OrderProductInfo> getOrderProductBycOrderSn(String cOrderSn) {
        ServiceResult<OrderProductInfo> result = new ServiceResult<OrderProductInfo>();
        try {
            result.setResult(orderModel.getOrderProductBycOrderSn(cOrderSn));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据网单号获取网单发生异常！，" + e.getMessage());
            log.error("根据网单号获取网单发生异常！", e);
        }
        return result;
    }

    @Override
    public ServiceResult<OrderRepairsInfo> getNetpointsByOrderProductId(Integer orderPorductId) {
        ServiceResult<OrderRepairsInfo> result = new ServiceResult<OrderRepairsInfo>();
        try {
            result.setResult(orderModel.getNetpointsByOrderProductId(orderPorductId));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据网单号获取网点信息发生异常！，" + e.getMessage());
            log.error("根据网单号获取网点信息发生异常！", e);
        }
        return result;
    }

    /**
     * 获取某一个用户是否下过单（付款成功的）
     */
    @Override
    public ServiceResult<Boolean> hasOrder(Integer memberId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result.setResult(orderModel.hasOrder(memberId) > 0);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("批量插入订单删除记录表异常！" + e.getMessage());
            log.error("批量插入订单删除记录表异常！", e);
        }
        return result;
    }

    /**
     * 获取各类订单数量
     */
    @Override
    public ServiceResult<OrderCountVo> getOrderCountByMemberId(Integer memberId, List<Integer> assessedIds) {
	ServiceResult<OrderCountVo> result = new ServiceResult<OrderCountVo>();
        try {
            result.setResult(orderModel.getOrderCountByMemberId(memberId, assessedIds));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("获取登录人各类别订单数量异常！" + e.getMessage());
            log.error("获取登录人各类别订单数量异常！", e);
        }
        return result;
    }

    @Override
    public ServiceResult<List<OrderVo>> getOrderListByParam(
	    OrderQueryParam param) {
	ServiceResult<List<OrderVo>> result = new ServiceResult<List<OrderVo>>();
        try {
            result.setResult(orderModel.getOrderListByCondition(param));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("获取订单列表异常！" + e.getMessage());
            log.error("获取订单列表异常！", e);
        }
        return result;
    }

    @Override
    public ServiceResult<Integer> getOrderCountByParam(OrderQueryParam param) {
	ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result.setResult(orderModel.getOrderCountByCondition(param));
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("获取订单数量异常！" + e.getMessage());
            log.error("获取订单数量异常！", e);
        }
        return result;
    }

    //后台配置限购条件
    @Override
    public ServiceResult<Boolean> updateLimitCondition(Map<String, Integer> map,String modifyUser) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            orderModel.updateLimitCondition(map,modifyUser);
            //判断限购条件，设置redis的组合条件key
            String condition = OrderLimitConditionUtil.handleCondition(map);
            boolean putConditionToRedis = SgRedisMode
                    .putRedisOrderLimitCondition(RedisConstants.ORDER_LIMTI_CONDITION_MANAGE_KEY, condition, -1);
            result.setResult(putConditionToRedis);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("更新限购条件异常！" + e.getMessage());
            log.error("更新限购条件异常！", e);
        }
        return result;
    }
    
    //顺逛PC统一限购校验 2017-9-28
    @Override
    public ServiceResult<Boolean> checkOrderLimitByMobileNew(OrderLimitConditionVo limitVo) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            // 取出所限制条件
            Map<String, String> conditionMap = this.getOrderLimitCondition().getResult();
            if("0".equals(conditionMap.get("shippingMode"))){
                if (!this.checkLimit(limitVo.getProductId())) {
                    result.setResult(true);
                    return result;
                }
            }
            return orderLimitFacade.getCheckLimitResult(result, limitVo, conditionMap);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("下单限购校验异常！" + e.getMessage());
            log.error("下单限购校验异常！", e);
            return result;
        }
    }
    
    /**
     * 顺逛PC统一限购数存储 2017-9-28
     */
    @Override
    public ServiceResult<Boolean> recordOrderLimitByMobileNew(OrderLimitConditionVo limitVo) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            // 取出所配置的限制条件
            Map<String, String> conditionMap = this.getOrderLimitCondition().getResult();
            if("0".equals(conditionMap.get("shippingMode"))){
                if (!this.checkLimit(limitVo.getProductId())) {
                    result.setResult(true);
                    return result;
                }
            }
            return orderLimitFacade.getRecordLimitResult(result, limitVo, conditionMap);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("将用户在指定街道执行商品的下单数量记录到redis出现异常" + e.getMessage());
            log.error("将用户在指定街道执行商品的下单数量记录到redis出现异常", e);
            return result;
        }
    }

    /**
     * 取出配置的限制条件
     */
    @Override
    public ServiceResult<Map<String,String>> getOrderLimitCondition() {
        ServiceResult<Map<String,String>> result = new ServiceResult<Map<String,String>>();
        try{
            String limitCondition = SgRedisMode.getRedisOrderLimitCondition(RedisConstants.ORDER_LIMTI_CONDITION_MANAGE_KEY);
            if (StringUtils.isBlank(limitCondition)) {
                limitCondition = "1,1,0,1,1,0,1,5";
            }
            Map<String, String> conditionMap = OrderLimitConditionUtil.getCondition(limitCondition);
            result.setResult(conditionMap);
        }catch(Exception e){
            result.setSuccess(false);
            result.setMessage("redis获取下单限购条件异常！" + e.getMessage());
            log.error("redis获取下单限购条件异常！", e); 
        }
        return result;
    }
    
    /**
     * 取消订单清除记下单录数
     */
    @Override
    public ServiceResult<Boolean> clearOrderLimitNew(Integer orderId,Integer region) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
       
        try {
            if (orderId == null) {
                log.debug("取消订单释放下单限制,参数为空");
                result.setResult(false);
                result.setMessage("参数为空");
                return result;
            }
            // 获取订单信息
            OrderInfo order = orderModel.getOrdersById(orderId);
            if (order == null) {
                log.debug("取消订单释放下单限制,未查询到订单");
                result.setResult(false);
                result.setMessage("未查询到订单");
                return result;
            }
            // 校验订单是否是今天的订单
            if (order.getAddTime() != null
                && !this.checkTodayOrder(Integer.parseInt(order.getAddTime()))) {
                result.setMessage("非今日订单无需释放");
                return result;
            }
            // 取出所配置的限制条件
            Map<String, String> conditionMap = this.getOrderLimitCondition().getResult();
            OrderLimitConditionVo limitVo = new OrderLimitConditionVo();
            MemberInvoicesInfo memberInvoice = orderModel.getMemberInvoiceByOrderId(orderId);
            if (memberInvoice == null) {
                log.error("未查询到发票信息:orderId="+orderId);
                result.setResult(false);
                result.setMessage("未查询到发票信息");
                return result;
            }
            limitVo.setConsignee(order.getConsignee());
            limitVo.setMobile(order.getMobile());
            limitVo.setRegion(region);
            limitVo.setStreet(order.getStreet());
            if(memberInvoice.getInvoiceType() == 1){
                limitVo.setBillCompany(order.getConsignee());
            }else if(memberInvoice.getInvoiceType() == 2){
                limitVo.setBillCompany(memberInvoice.getInvoiceTitle());
            }
            // 获取取消订单对应的网单
            List<OrderProductInfo> productList = orderModel.getOrderProductsByOrderId(orderId);
            if (productList != null) {
                for (OrderProductInfo orderProduct : productList) {
                    // 拼装KEY
                    limitVo.setShippingMode(orderProduct.getShippingMode());
                    limitVo.setProductId(orderProduct.getProductId());
                    limitVo.setNumber(orderProduct.getNumber());
                    result.setResult(orderLimitFacade.getClearLimitResult(limitVo, conditionMap,orderProduct));
                }
            }
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("根据订单ID获取网单列表！" + e.getMessage());
            log.error("根据订单ID获取网单列表！", e);
        }
        return result;
    }

	@Override
	public ServiceResult<OrderDetailVo> getOrderDetail(String cOrderSn,
			Integer orderProductId) {
		ServiceResult<OrderDetailVo> result = new ServiceResult<OrderDetailVo>();
		try {
			result.setResult(orderModel.getOrderProductDetail(cOrderSn, orderProductId));
		} catch (BusinessException e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
			log.error("根据获取网单详情异常！", e);
		} catch (Exception e) {
			result.setSuccess(false);
            result.setMessage("根据获取网单详情异常");
            log.error("根据获取网单详情异常！", e);
		}
		return result;
	}
    
    
}
