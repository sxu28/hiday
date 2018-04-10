package com.haier.m.util;

import java.util.Date;
import com.haier.m.entity.vo.OrderDetailVo;
import com.haier.sg.constants.OrderConstants;

public class OrderUtil {
    public static void dealOrderTime(OrderDetailVo detailVo) {
    	if (detailVo.getAddTime() != null) {
    		detailVo.setCreateTime(DateUtils.convertDateToStr(detailVo.getAddTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    	}
    	
    	if (detailVo.getcPayTime() != null) {
    		detailVo.setPayTime(DateUtils.convertDateToStr(detailVo.getAddTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    	}
    	
    	if (detailVo.getOrderType() != null && detailVo.getOrderType() == 1 && detailVo.getRelationOrderSn() != null) {
    		
    	}
    	
    	if (detailVo.getLessShipTime() != null) {
    		detailVo.setPayTime(DateUtils.convertDateToStr(detailVo.getLessShipTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    	}
    	
    	
    	if (detailVo.getCloseTime() != null && detailVo.getCloseTime() != 0) {
    		detailVo.setPayTime(DateUtils.convertDateToStr(detailVo.getCloseTime() * 1000L, DateUtils.DEFAULT_LONG_TIME_FORMAT));
    		if (detailVo.getCloseTime()+5*24*60*60*1000L<new Date().getTime()) {
    			detailVo.setIsTimeoutFree(0);
    		}
    	}
    }
    
    public static void dealOrdereStatus (OrderDetailVo detailVo) {
    	if (detailVo.getPaymentStatus().equals(100) && detailVo.getIsCod().equals(0)
                && detailVo.getOrderStatus().equals(200)) {
    		detailVo.setOrderStatusName("待付款");
    		detailVo.setIconName("im-wfm.png");
    	} else if ((detailVo.getOrderStatus().equals(200) && detailVo.getPaymentStatus().equals(101))
                       || (detailVo.getIsCod().equals(1) && detailVo.getOrderStatus().equals(200))) {
    		detailVo.setOrderStatusName("待确认");
    		detailVo.setIconName("im-wait.png");
    	} else if (detailVo.getOrderStatus().equals(201)) {
    		detailVo.setOrderStatusName("已确认");
    		detailVo.setIconName("im-delivery.png");
    	} else if (detailVo.getOrderStatus().equals(203)) {
    		detailVo.setOrderStatusName("交易完成");
    		detailVo.setIconName("im-ok.png");
    	} else if (detailVo.getOrderStatus().equals(202)) {
    		detailVo.setOrderStatusName("已取消");
    		detailVo.setIconName("im-close.png");
    	} else if (detailVo.getPaymentStatus().equals(102)
                       || detailVo.getPaymentStatus().equals(103)) {
    		detailVo.setOrderStatusName("售后服务");
    		detailVo.setIconName("im-ganga.png");
    	}
    }
    
    public static boolean canRepaier(OrderDetailVo detailVo) {
    	boolean canRepair = true;
    	if (detailVo.getcPaymentStatus().equals(206)
    			|| detailVo.getcPaymentStatus().equals(207)) {
                canRepair = false;
        }
    	if (detailVo.getStatus().equals(110)) {
    		canRepair = false;
    	}
    	if (detailVo.getIsCod().equals(0)
    			&& detailVo.getcPaymentStatus().equals(200)) {
    		canRepair = false;
    	}
    	if (detailVo.getIsCod().equals(1)
    			&& detailVo.getOrderStatus().equals(200)) {
    		canRepair = false;
    	}
        return canRepair;
    }
    
    public static boolean  checkConfirm(OrderDetailVo orderProduct) {

        if (orderProduct != null) {
            // O2O自有库存
            if (OrderConstants.STOCKTYPE_O2O.equals(orderProduct.getStockType())) {
                // 若网单状态是待交付 70 时可确认收货
                if (OrderConstants.ORDERPRODUCT_STATUS_WAITRECIEVE
                    .equals(orderProduct.getStatus())) {
                    return true;
                }
            }
            // Store库存
            else if (OrderConstants.STOCKTYPE_STORE.equals(orderProduct.getStockType())) {
                // 若网单状态为待交付和待发货可确认收货
                if (OrderConstants.ORDERPRODUCT_STATUS_WAITRECIEVE
                    .equals(orderProduct.getStatus())) {
                    return true;
                }
            }
            // WA库存
            else if (OrderConstants.STOCKTYPE_WA.equals(orderProduct.getStockType())) {
                // 物流模式是B2B2C是网单待收货时可确认收货
                if (OrderConstants.SHIPPINGMODE_B2B2C.equals(orderProduct.getShippingMode())) {
                    if (OrderConstants.ORDERPRODUCT_STATUS_WAITRECIEVE
                        .equals(orderProduct.getStatus())) {
                        return true;
                    }
                }
                // 物流模式是B2C时网单状态是待审核时可确认收货
                else if (OrderConstants.SHIPPINGMODE_B2C.equals(orderProduct.getShippingMode())) {
                    if (OrderConstants.ORDERPRODUCT_STATUS_AUDIT.equals(orderProduct.getStatus())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
