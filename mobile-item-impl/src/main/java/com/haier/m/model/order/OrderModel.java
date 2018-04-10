package com.haier.m.model.order;

import java.math.BigDecimal;
import java.util.*;

import javax.annotation.Resource;

import com.haier.m.dao.shop.read.*;
import com.haier.m.entity.order.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.haier.common.BusinessException;
import com.haier.common.PagerInfo;
import com.haier.m.ServiceItemConstants;
import com.haier.m.dao.mshop.write.OrderLimitConditionDao;
import com.haier.m.dao.shop.write.OrdersRecoverWriteDao;
import com.haier.m.entity.vo.OrderDetailVo;
import com.haier.m.model.redis.SgRedisMode;
import com.haier.m.util.DateUtils;
import com.haier.m.util.OrderUtil;
import com.haier.sg.constants.OrderConstants;
import com.haier.sg.enums.OrderKeysEnum;

@Component
public class OrderModel {

    private Logger log = LoggerFactory.getLogger(OrderModel.class);

    @Resource
    private OrderReadDao         orderReadDao;
    @Resource
    private OrderProductReadDao  orderProductReadDao;
    @Resource
    private MemberInvoiceReadDao memberInvoiceReadDao;
    @Resource
    private InvoiceReadDao       invoiceReadDao;
    @Resource
    private OrderRepairsDao      orderRepairsDao;
    @Resource
    private ExpressInfoReadDao   expressInfoReadDao;
    @Resource
    private OrdersRecoverWriteDao ordersRecoverWriteDao;
    @Resource
    private OrderLimitConditionDao orderLimitConditionDao;
    @Resource
    private OrdersAttributesReadDao ordersAttributesReadDao;

    public Integer getOrderCountsByConditions(Map<String, Object> map) {

        Integer memberId = (Integer) map.get("memberId");
        //获取已删除订单
        List<Integer> deletedOrderIds = ordersRecoverWriteDao.getOrderListByMemberId(memberId);
        map.put("orderIds", deletedOrderIds);
        return orderReadDao.getOrderCountsByConditions(map);
    }

    public List<OrderInfo> getOrderListByConditions(Map<String, Object> map, PagerInfo pager,
                                                    Boolean isPaging) {
        Integer memberId = (Integer) map.get("memberId");
        //获取已删除订单
        List<Integer> deletedOrderIds = ordersRecoverWriteDao.getOrderListByMemberId(memberId);
        map.put("orderIds", deletedOrderIds);
        Integer pageBeg = 0, pageNum = 5;
        if (isPaging) {
            if (pager != null&& pager.getPageIndex()>=0) {
                pageBeg = pager.getPageIndex() * 5;
            }
            map.put("pageBeg", pageBeg);
            map.put("pageNum", pageNum);
        }else{
            map.put("pageBeg", null);
            map.put("pageNum", null);
        }

        List<OrderInfo> orderList = orderReadDao.getOrderListByConditions(map);
        return orderList;

    }


    /*---待改造查询总数方法*/
    public List<OrderInfo> getAllOrderCountsByConditions(Map<String, Object> map, PagerInfo pager,
                                                    Boolean isPaging) {

        List<OrderInfo> orderList = orderReadDao.getOrderListByConditions(map);
//        log.info("Shop库查到订单数量：" + orderList.size());
//        log.info("是否分页：" + isPaging);
        if (isPaging) {
            List<OrderInfo> resultOrderList = new ArrayList<OrderInfo>();
            List<Map<String, Object>> itemList = new ArrayList<Map<String, Object>>();
            if (pager == null) {//页面初始加载
                for (int i = 0; i < orderList.size()
                        && i < ServiceItemConstants.PRODUCTS_INITIALISE; i++) {
                    //                Map<String, Object> map = orderList.get(i);
                    //                Products product = productsReadDao.getItemById(((Long) map.get("id")).intValue());
                    //                if (product == null) {
                    //                    continue;
                    //                }
                    map.put("order", orderList.get(i));
                    resultOrderList.add(orderList.get(i));
                    itemList.add(map);
                }
            } else {//页面下拉
                Integer pageBeg = (pager.getPageIndex() - 1) * pager.getPageSize()
                        + ServiceItemConstants.PRODUCTS_INITIALISE;
                Integer pageNum = pager.getPageIndex() * pager.getPageSize()
                        + ServiceItemConstants.PRODUCTS_INITIALISE;
                for (int i = pageBeg; i < orderList.size() && i < pageNum; i++) {
                    map.put("order", orderList.get(i));
                    resultOrderList.add(orderList.get(i));
                    itemList.add(map);
                }
            }
//            log.info("最终返回产品数量：" + itemList.size());
            return resultOrderList;
        } else {
//            log.info("最终返回产品数量：" + orderList.size());
            return orderList;
        }

    }


    public OrderProductInfo getOrderProductBycOrderSn(String cOrderSn) {
        return orderProductReadDao.getOrderProductBycOrderSn(cOrderSn);
    }

    public MemberInvoicesInfo getInvoiceByMemberInvoiceId(Integer memberInvoiceId) {
        return memberInvoiceReadDao.getInvoiceByMemberInvoiceId(memberInvoiceId);
    }
    
    public MemberInvoicesInfo getMemberInvoiceByOrderId(Integer orderId) {
        return memberInvoiceReadDao.getMemberInvoiceByOrderId(orderId);
    }

    public List<OrderRepairsInfo> getOrderRepairsIdByOrderIds(List<Integer> ids) {
        return orderRepairsDao.getOrderRepairsIdByOrderIds(ids);
    }

    public List<OrderRepairsInfo> getOrderRepairsByOrderProductId(Integer orderProductId) {
        return orderRepairsDao.getOrderRepairsByOrderProductId(orderProductId);
    }
    
    public List<OrderRepairsInfo> getOrderRepairsDetailByOrderProductId(Integer orderProductId) {
        return orderRepairsDao.getOrderRepairsDetailByOrderProductId(orderProductId);
    }

    public InvoicesInfo getInvoiceBycOrderSn(String cOrderSn) {
        return invoiceReadDao.getInvoiceBycOrderSn(cOrderSn);
    }

    public ExpressInfo getExpressInfoBycOrderSn(String cOrderSn) {
        return expressInfoReadDao.getExpressInfoBycOrderSn(cOrderSn);
    }
    
    /**
     * 根据订单ID获取网单列表
     * @param orderId 订单ID
     * @return
     */
    public List<OrderProductInfo> getOrderProductsByOrderId(Integer orderId) {
    	return orderProductReadDao.getOrderProductsByOrderId(orderId);
    }
    
    /**
     * 根据订单ID获取订单信息
     * @param orderId
     * @return
     */
    public OrderInfo getOrdersById(Integer orderId) {
    	return orderReadDao.getOrderById(orderId);
    }


    public OrderRepairsInfo getOrderRepairsByCOrderSn(String cOrderSn) {
        return orderRepairsDao.getOrderRepairsByCOrderSn(cOrderSn);
    }
    
    /**
     * 根据orderId获取换机单的订单信息
     */
    public OrderInfo getSwitchOrderSnByOrderId(String orderSn) {
	return orderReadDao.getSwitchOrderSnByOrderId(orderSn);
    }
    /**
     * 根据网单Id获取网点信息
     */
    public OrderRepairsInfo getNetpointsByOrderProductId(Integer orderProductId) {
    	return orderRepairsDao.getNetpointsByOrderProductId(orderProductId);
    }
    /**
     * 根据订单ID获取网单列表
     * @param memberId 用户
     * @return
     */
    public Integer hasOrder(Integer memberId) {
        return orderReadDao.hasOrder(memberId);
    }
    
    public OrderCountVo getOrderCountByMemberId(Integer memberId, List<Integer> assessedId) {
    	OrderCountVo orderCount = new OrderCountVo();
    	if (memberId == null ) {
    		return orderCount;
    	}
    	int outDateTimeStamp = (int)(System.currentTimeMillis()/1000 - 90 * 24 * 3600);
    	orderCount.setWaitPay(orderReadDao.getOrderCount(memberId, 1, null, outDateTimeStamp).size());
    	orderCount.setWaitShipping(orderReadDao.getOrderCount(memberId, 2, null, outDateTimeStamp).size());
    	orderCount.setWaitReceipt(orderReadDao.getOrderCount(memberId, 3, null, outDateTimeStamp).size());
    	List<Integer> waitCommentList = orderReadDao.getOrderCount(memberId, 4, assessedId, outDateTimeStamp);
    	orderCount.setRightService(orderRepairsDao.getOrerRepairsCountByMemberId(memberId).size());
    	if (memberId != null) {
    		List<Integer> deletedOrderIds = ordersRecoverWriteDao.getOrderListByMemberId(memberId);
    		if (deletedOrderIds.size() > 0 && waitCommentList.size() > 0) {
    			waitCommentList.removeAll(deletedOrderIds);
    		}
    	}
    	orderCount.setWaitComment(waitCommentList.size());
    	return orderCount;
    }
    
    /**
     * 订单列表数量
     * @param param
     * @return
     */
    public Integer getOrderCountByCondition(OrderQueryParam param) {
		// 若按照用户id查询，则获取已删除订单
		if (param.getMemberId() != null) {
		    List<Integer> deletedOrderIds = ordersRecoverWriteDao.getOrderListByMemberId(param.getMemberId());
		    if (deletedOrderIds.size() > 0) {
			param.setExcludeOrderProductId(deletedOrderIds);
		    }
		}
		return orderReadDao.getOrderCountByParam(param);
    }
    
    /**
     * 获取订单列表
     * @param param
     * @return
     */
    public List<OrderVo> getOrderListByCondition(OrderQueryParam param) {
		// 若按照用户id查询，则获取已删除订单
		if (param.getMemberId() != null) {
		    List<Integer> deletedOrderIds = ordersRecoverWriteDao.getOrderListByMemberId(param.getMemberId());
		    if (deletedOrderIds.size() > 0) {
			param.setExcludeOrderProductId(deletedOrderIds);
		    }
		}
	
		// 单页订单IDList取得
		List<Integer> idList;
		if (ServiceItemConstants.ORDER_WAITPAY.equals(param.getOrderStatus())) {
			idList = orderReadDao.getOrderIDListWaitPay(param);
		} else {
			idList = orderReadDao.getOrderIDListByParam(param);
		}
		// 订单及网单详细信息取得
		List<OrderVo> orders = null;
		if (idList.size() > 0) {
			orders = orderReadDao.getOrderListByIDList(idList);
		} else {
			orders = new ArrayList<OrderVo>();
		}
        // 赠品订单金额
        BigDecimal giftOrderAmount = new BigDecimal("0.01");
		//List<OrderVo> orders = orderReadDao.getOrderListByParam(param);
        Iterator<OrderVo> ordersIterator = orders.iterator();
        while (ordersIterator.hasNext()) {
            OrderVo order = ordersIterator.next();

            // 查询订单扩展信息。当前业务中只需要赠品订单需要查询订单扩展属性，并且赠品订单的金额为0.01
            if(giftOrderAmount.compareTo(order.getOrderAmount()) == 0) {
                OrdersAttributes ordersAttributes = ordersAttributesReadDao.getByOrderId(order.getOrderId().intValue());
                if (null != ordersAttributes && null != ordersAttributes.getOrderYwType()) {
                    order.setOrderYwType(ordersAttributes.getOrderYwType());
                }
            }

            // 赠品订单从待评价列表里删除
            if (null != param.getOrderStatus() && 4 == param.getOrderStatus() && null != order.getOrderYwType() && 1 == order.getOrderYwType()) {
                ordersIterator.remove();
                continue;
            }

            BigDecimal totalAmount = BigDecimal.ZERO;
            BigDecimal totalShippingFeeAmount = BigDecimal.ZERO;
            Integer productTotalNo = 0;

            // 1、判断是否自己的订单，若是自己的订单则判断是否可删除
            if (order.getMemberId().equals(param.getLoginMemberId())) {
                order.setIsMyOrder(true);
                if (order.getOrderStatus() == 202 || order.getOrderStatus() == 203) {
                    order.setCanDelete(true);
                }
            }

            if (order.getAddTimeStamp() != null) {
                order.setAddTime(DateUtils.convertDateToStr(order.getAddTimeStamp() * 1000L, DateUtils.DEFAULT_SPLIT_PAY_FORMAT));
            }


            // 2、判断是否在线支付，若在线支付则可取消
            if (order.getPaymentStatus() == 100 && order.getIsCod() == 0
                    && order.getOrderStatus() == 200) {
                order.setPayOnline(true);
                // 赠品订单不可取消
                if (null != order.getOrderYwType() && 1 == order.getOrderYwType()) {
                    order.setCanCancel(false);
                } else {
                    order.setCanCancel(true);
                }
                if (order.getPaymentCode().equals("wxpay")) {
                    order.setWxpay(true);
                }
                if (order.getPaymentCode().equals("alipaymobile")) {
                    order.setAlipay(true);
                }
                if (order.getPaymentCode().equals("kjtpay")) {
                    order.setKjtpay(true);
                }
                if (param.getOrdersFlag() != null && param.getOrdersFlag() == 0) {
                    order.setMstoreCancel(true);
                }
            }

            // 2.5、货到付款是否可取消
            if (order.getCodConfirmTime() == 0 && order.getIsCod() == 1
                    && order.getOrderStatus() == 200) {
                order.setCodOrder(true);
                if (param.getOrdersFlag() != null && param.getOrdersFlag() == 0) {
                    order.setMstoreCancel(true);
                }
            }

            // 3、是否定金尾款订单
            Integer orderType = order.getOrderType();
            if (orderType == 1) {
                order.setFinalPay(true);
                // 判断是否生成尾款订单
                if (!order.getRelationOrderSn().isEmpty()) {
                    order.setIsRelated(true);
                    // 获取尾款订单
                    OrderInfo relationOrder = orderReadDao.getOrderByOrderSn(order.getRelationOrderSn());
                    //关联的尾款订单是否已支付
                    Boolean payRelationOrder = false;
                    // 若未支付尾款订单
                    if (null != orders && null != relationOrder.getPaymentStatus()
                            && null != relationOrder.getOrderStatus()) {
                        if (relationOrder.getPaymentStatus().equals(100)
                                && relationOrder.getOrderStatus() == 200) {
                            order.setIsPayCoupon(true);
                            payRelationOrder = true;
                            order.setPayOnline(true);
                            if (order.getPaymentCode().equals("wxpay")) {
                                order.setWxpay(true);
                            }
                            if (order.getPaymentCode().equals("alipaymobile")) {
                                order.setAlipay(true);
                            }
                            if (order.getPaymentCode().equals("kjtpay")) {
                                order.setKjtpay(true);
                            }
                            if (param.getOrdersFlag() != null && param.getOrdersFlag() == 0) {
                                order.setMstoreCancel(true);
                            }
                            List<OrderProductInfo> info = orderProductReadDao.getOrderProductsByOrderId(relationOrder.getId());
                            if (info.size() > 0 ) {
                                OrderProductInfo relationProduct = info.get(0);
                                if (relationProduct.getCouponLogId() != null && relationProduct.getCouponLogId() > 0) {
                                    order.setIsPayCoupon(false);
                                }
                            }
                        }
                        order.setPayRelationOrder(payRelationOrder);
                        order.setRelationOrderAmount(BigDecimal.valueOf(relationOrder.getOrderAmount()));
                        order.setRelationOrderId(relationOrder.getId());
                    }

                }
            }


            // 4、获取该订单当前状态
            if (order.getPaymentStatus().equals(100) && order.getIsCod().equals(0)
                    && order.getOrderStatus().equals(200)) {
                order.setOrderStatusName("待付款");
            } else if ((order.getOrderStatus().equals(200)
                    && order.getPaymentStatus().equals(101))
                    || (order.getIsCod().equals(1) && order.getOrderStatus().equals(200))) {
                order.setOrderStatusName("待确认");
            } else if (order.getOrderStatus().equals(201)) {
                order.setOrderStatusName("已确认");
            } else if (order.getOrderStatus().equals(203)) {
                order.setOrderStatusName("已签收");
            }  else if (order.getOrderStatus().equals(202)) {
                order.setOrderStatusName("已取消");
            }


            // 5、是否可退款
            if ((order.getIsCod() == 1
                    && (order.getOrderStatus() == 201 || order.getOrderStatus() == 203))
                    || (order.getIsCod() == 0 && order.getPaymentStatus() != 100
                    && order.getOrderStatus() != 110)) {
                order.setDrawback(true);
            }

            // 7、网单处理
            // 是否单个网单
            boolean isSingle = false;
            if (order.getOrderProducts() != null) {
                isSingle = order.getOrderProducts().size() > 1 ? false : true;
                order.setIsSingle(isSingle);

                for (OrderProductVo orderProduct : order.getOrderProducts()) {

                    if (checkConfirm(orderProduct)) {
                        // 赠品订单隐藏确认收货按钮
                        if (null != order.getOrderYwType() && 1 == order.getOrderYwType()) {
                            order.setCanConfirm(false);
                        } else {
                            order.setCanConfirm(true);
                        }
                    }

                    // 优惠券处理，原来顺逛优惠券存储在couponCodeValue字段，现在迁到couponAmount字段，为了兼容性将俩个合并
                    orderProduct.setCouponCodeValue(orderProduct.getCouponCodeValue().add(orderProduct.getCouponAmount()));
                    orderProduct.setCouponAmount(BigDecimal.ZERO);

                    // 下单立减
                    if (BigDecimal.ZERO
                            .compareTo(orderProduct.getOrderPromotionAmount()) == 0) {
                        orderProduct.setOrderPromotionAmount(null);
                    }

                    //是否查看退款详情
                    if (orderProduct.getOrderRepairId() != null) {
                        order.setIsRightService(true);
                        order.setOrderStatusName("售后处理");
                    }
                    if (orderProduct.getShippingFee() != null) {
                        totalShippingFeeAmount = totalShippingFeeAmount
                                .add(orderProduct.getShippingFee());//计算总运费
                        totalAmount = totalAmount.add(totalShippingFeeAmount);
                    }
                    totalAmount = totalAmount.add(orderProduct.getProductAmount());//订单总额=商品金额+运费-卡券金额
                    productTotalNo = productTotalNo + orderProduct.getNumber();
                    if (orderProduct.getOrderPromotionAmount() != null) {
                        orderProduct.setPrice(
                                orderProduct.getPrice().add(
                                        orderProduct.getOrderPromotionAmount().divide(
                                                new BigDecimal(orderProduct.getNumber()), 2, BigDecimal.ROUND_HALF_DOWN))
                        );
                    }
                    // 赠品订单去除预定标识
                    if (null != order.getOrderYwType() && 1 == order.getOrderYwType()) {
                        orderProduct.setIsBook(0);
                    }
                }
                order.setProductTotalNo(productTotalNo);
                order.setOrderAmount(totalAmount);
                order.setTotalAmount(order.getOrderAmount());
                order.setTotalShippingFeeAmount(totalShippingFeeAmount);
            }
            // 赠品订单付款状态设置为101
            if (null != order.getOrderYwType() && 1 == order.getOrderYwType()) {
                order.setPaymentStatus(101);
            }
        }
	    return orders;
    }
    /**
     * 确定是否可以确认收货
     * WA商品B2B2C网单状态为待交付70，WA商品B2C待审核状态10
     * STORE网单状态是代发货、待交付
     * O2O是待交付
     * @param orderProduct
     * @return
     */
    private boolean checkConfirm(OrderProductVo orderProduct) {

        if (orderProduct != null) {
            // O2O自有库存
            if (ServiceItemConstants.STOCKTYPE_O2O.equals(orderProduct.getStockType())) {
                // 若网单状态是待交付 70 时可确认收货
                if (ServiceItemConstants.ORDERPRODUCT_STATUS_WAITRECIEVE
                    .equals(orderProduct.getStatus())) {
                    return true;
                }
            }
            // Store库存
            else if (ServiceItemConstants.STOCKTYPE_STORE.equals(orderProduct.getStockType())) {
                // 若网单状态为待交付和待发货可确认收货
                if (ServiceItemConstants.ORDERPRODUCT_STATUS_WAITRECIEVE
                    .equals(orderProduct.getStatus())) {
                    return true;
                }
            }
            // WA库存
            else if (ServiceItemConstants.STOCKTYPE_WA.equals(orderProduct.getStockType())) {
                // 物流模式是B2B2C是网单待收货时可确认收货
                if (ServiceItemConstants.SHIPPINGMODE_B2B2C.equals(orderProduct.getShippingMode())) {
                    if (ServiceItemConstants.ORDERPRODUCT_STATUS_WAITRECIEVE
                        .equals(orderProduct.getStatus())) {
                        return true;
                    }
                }
                // 物流模式是B2C时网单状态是待审核时可确认收货
                else if (ServiceItemConstants.SHIPPINGMODE_B2C.equals(orderProduct.getShippingMode())) {
                    if (ServiceItemConstants.ORDERPRODUCT_STATUS_AUDIT.equals(orderProduct.getStatus())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    
    /**
     * 更新限购条件
     * @param map
     */
    public void updateLimitCondition(Map<String, Integer> map,String modifyUser) {
        for (String key : map.keySet()) {
            Integer flag = orderLimitConditionDao.updateCondition(key,map.get(key),modifyUser);
            if (flag == 0) {
                log.error("限购条件设置，condition:"+key+",未更新成功");
            }
        }
    }
    
    public OrderDetailVo getOrderProductDetail(String cOrderSn, Integer cOrderId) {
    	if (cOrderSn == null && cOrderId == null) {
    		throw new BusinessException("参数为空");
    	}
    	OrderDetailVo detailVo = orderProductReadDao.getOrderProductDetail(cOrderSn, cOrderId);
    	
    	if (detailVo == null) {
    		throw new BusinessException("未查询到网单");
    	}
    	
    	detailVo.setOpProductAmount(detailVo.getPrice().multiply(new BigDecimal(detailVo.getNumber())).add(detailVo.getOrderPromotionAmount()));

    	// 查询订单扩展属性。当前业务中只有赠品订单需要查询订单扩展属性，并且赠品商品的金额为0.01
        BigDecimal giftProductAmount = new BigDecimal("0.01");
        if (giftProductAmount.compareTo(detailVo.getTotalAmount()) == 0) {
            OrdersAttributes ordersAttributes = ordersAttributesReadDao.getByOrderId(detailVo.getOrderId());
            if (null != ordersAttributes && null != ordersAttributes.getOrderYwType()) {
                detailVo.setOrderYwType(ordersAttributes.getOrderYwType());
            }
        }

    	// 时间处理
    	dealOrderTime(detailVo);
    	// 订单状态
    	OrderUtil.dealOrdereStatus(detailVo);
    	// 是否可售后维权
    	detailVo.setCanRepair(OrderUtil.canRepaier(detailVo));
    	// 赠品订单不可售后维权
        if (null != detailVo.getOrderYwType() && 1 == detailVo.getOrderYwType()) {
            detailVo.setCanRepair(false);
        }
        // 发票处理
    	MemberInvoicesInfo memberInvoices = memberInvoiceReadDao.getInvoiceByMemberInvoiceId(detailVo.getMemberInvoiceId());
    	if (memberInvoices != null) {
    		detailVo.setInvoiceTitle(memberInvoices.getInvoiceTitle());
    		detailVo.setInvoiceTypeName(OrderConstants.parseInvoiceType(memberInvoices.getInvoiceType()));
    		if (memberInvoices.getInvoiceType() == 2) {
    			detailVo.setInvoicesUrl(invoiceReadDao.selectInvoiceElectricByCOrderSn(detailVo.getcOrderSn()));
    		}
    	}
    	InvoicesInfo invoices =  invoiceReadDao.getInvoiceBycOrderSn(detailVo.getcOrderSn());
    	if (invoices != null) {
    		detailVo.setInvViewUrl(invoices.geteInvViewUrl());	
    	}
    	
    	if (detailVo.getOrderRepaierId() != null) {
    		detailVo.setOrderRepairs(true);
    	}
    	
    	detailVo.setCanConfirm(OrderUtil.checkConfirm(detailVo));
    	
    	OpAttribute attri = getOrderProductAttribute(detailVo.getOrderProductId());
    	if (attri != null) {
    		detailVo.setInsuranceAmt(attri.getInsuranceAmt());
    		detailVo.setDiamondAmt(attri.getDiamondAmt());
    		detailVo.setSeashellAmt(attri.getSeashellAmt());
    		detailVo.setBankBenefit(attri.getBankBenefit());
            if(attri.getAttrPic()!=null && !"".equals(attri.getAttrPic())){
                detailVo.setAttrPic(attri.getAttrPic());
            }
            if(attri.getAttrName()!=null && !"".equals(attri.getAttrName())){
                detailVo.setAttrName(attri.getAttrName());
            }
    	}
    	return detailVo;
    }
    
    private void dealOrderTime(OrderDetailVo detailVo) {
    	if (detailVo.getAddTime() != null && detailVo.getAddTime() > 0) {
    		detailVo.setCreateTime(DateUtils.convertDateToStr(detailVo.getAddTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    	}
    	
    	if (detailVo.getcPayTime() != null && detailVo.getcPayTime() > 0) {
    		detailVo.setPayTime(DateUtils.convertDateToStr(detailVo.getcPayTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    	}
    	
    	if (detailVo.getOrderType() != null && detailVo.getOrderType() == 1 && detailVo.getRelationOrderSn() != null) {
    		RelationOrder  order = orderReadDao.getRelationOrder(detailVo.getRelationOrderSn());
    		if (order != null) {
    			detailVo.setWkPayTime(DateUtils.convertDateToStr(order.getcPayTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    			detailVo.setCouponAmount(order.getCouponAmount());
    			detailVo.setOpProductAmount(detailVo.getTotalAmount().add(detailVo.getCouponAmount()));
    			detailVo.setPrice(detailVo.getOpProductAmount().divide(BigDecimal.valueOf(detailVo.getNumber()), 2, BigDecimal.ROUND_HALF_UP));
    		}
    	}
    	
    	if (detailVo.getLessShipTime() != null && detailVo.getLessShipTime() > 0) {
    		detailVo.setShippingTime(DateUtils.convertDateToStr(detailVo.getLessShipTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    	}
    	
    	
    	if (detailVo.getCloseTime() != null && detailVo.getCloseTime() != 0) {
    		detailVo.setReceiptOrRejectTime(DateUtils.convertDateToStr(detailVo.getCloseTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    		if (detailVo.getCloseTime()+5*24*60*60*1000L<new Date().getTime()) {
    			detailVo.setIsTimeoutFree(0);
    		}
    	}
    }
    
    private OpAttribute getOrderProductAttribute(Integer opId) {
    	String attrKey = OrderKeysEnum.opAttribute.getKey() + String.valueOf(opId);
    	OpAttribute attri = SgRedisMode.getRedisOpAttribute(attrKey);
    	if (attri == null) {
    		attri = orderProductReadDao.getOpAttributeByOrderProductId(opId);
    	}
    	if (attri != null) {
    		SgRedisMode.putRedisOpAttribute(attrKey, attri);
    	}
    	return attri;
    }

}
