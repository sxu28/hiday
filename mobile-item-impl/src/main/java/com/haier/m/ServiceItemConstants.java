package com.haier.m;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chennsh on 2015/8/20.
 */
public class ServiceItemConstants {
    public static final Integer PRODUCTS_INITIALISE = 5; //微店商品上架页面初始化条数
    public static final Integer PRODUCTS_INDEX_NUM = 8; //微店商品审核初始化商品数量
    
    public static final int ORDER_LIMIT_NUM = 5;
    
    public static final String ORDER_LIMIT_MESSAGE = "您当天购买此商品的数量已经超过上限，请选择其他商品哦~ 感谢您选择顺逛商城！";
    

    /**
     * 发票类型
     */
    public static final int INVOICE_TYPE_ZZS   = 1;
    public static final int INVOICE_TYPE_PUDZ  = 2;
    public static final int INVOICE_TYPE_PUZZS = 3;

    public static String parseInvoiceType(int key) {
        switch (key) {
            case INVOICE_TYPE_ZZS:
                return "增值税发票";
            case INVOICE_TYPE_PUDZ:
                return "普通发票";
            case INVOICE_TYPE_PUZZS:
                return "增值税发票";
        }
        return "";
    }

    /**
     * 退款类型
     */
    public static final int TYPE_ACTUAL_THTK  = 1;
    public static final int TYPE_ACTUAL_THBTK = 2;

    public static String parseTypeActual(int key) {
        switch (key) {
            case TYPE_ACTUAL_THTK:
                return "退货退款";
            case TYPE_ACTUAL_THBTK:
                return "退货不退款";
        }
        return "";
    }

    //快递公司
    public static final Map<String, String> EXPRESS_MAPS = new HashMap<String, String>();

    static {
        EXPRESS_MAPS.put("EMS", "EMS");
        EXPRESS_MAPS.put("SF", "顺丰");
    }
    
    /**
     * 初始状态
     */
    public static final Integer ORDERPRODUCT_STATUS_INIT = 0;
    
    /**
     * 网单占库
     */
    public static final Integer ORDERPRODUCT_STATUS_CONFIRM = 1;
    /**
     * 同步HP
     */
    public static final Integer ORDERPRODUCT_STATUS_HP = 2;
    /**
     * 同步EC
     */
    public static final Integer ORDERPRODUCT_STATUS_EC = 3;
    /**
     * 已分配到网点
     */
    public static final Integer ORDERPRODUCT_STATUS_NETPOINT = 4;
    /**
     * LES开提单，待出库
     */
    public static final Integer ORDERPRODUCT_STATUS_LES = 8;
    /**
     * 待审核
     */
    public static final Integer ORDERPRODUCT_STATUS_AUDIT = 10;
    /**
     * 待转运入库
     */
    public static final Integer ORDERPRODUCT_STATUS_INSTOCK = 11;
    /**
     * 待转运出库
     */
    public static final Integer ORDERPRODUCT_STATUS_OUTSTOCK = 12;
    /**
     * 待发货
     */
    public static final Integer ORDERPRODUCT_STATUS_WAITOUT = 40;
    /**
     * 待收货
     */
    public static final Integer ORDERPRODUCT_STATUS_WAITRECIEVE = 70;
    /**
     * 取消关闭
     */
    public static final Integer ORDERPRODUCT_STATUS_CANCAL = 110;
    /**
     * 完成关闭
     */
    public static final Integer ORDERPRODUCT_STATUS_FINISH = 130;
    /**
     * 用户签收
     */
    public static final Integer ORDERPRODUCT_STATUS_USERSIGN = 140;
    /**
     * 用户拒单
     */
    public static final Integer ORDERPRODUCT_STATUS_USERREORDER = 150;
    /**
     * 用户拒收
     */
    public static final Integer ORDERPRODUCT_STATUS_USERREFUSE = 160;
    /**
     * 用户取消
     */
    public static final Integer ORDERPRODUCT_STATUS_USERCANCAL = 170;
    /**
     * 无法执行订单
     */
    public static final Integer ORDERPRODUCT_STATUS_INVALID = 180;
    /**
     * 库存类型：o2o
     */
    public static final String STOCKTYPE_O2O = "O2O";
    /**
     * 库存类型STORE
     */
    public static final String STOCKTYPE_STORE = "STORE";
    /**
     * 库存类型WA
     */
    public static final String STOCKTYPE_WA = "WA";
    /**
     * 物流类型b2b2c
     */
    public static final String SHIPPINGMODE_B2B2C = "B2B2C";
    /**
     * 物流类型b2c
     */
    public static final String SHIPPINGMODE_B2C = "B2C";

    /**
     * 订单状态待支付
     */
    public static final Integer ORDER_WAITPAY = 1;
}
