package com.haier.m.dao.shop.read;

import com.haier.m.entity.order.ExpressInfo;


public interface ExpressInfoReadDao {

    public ExpressInfo getExpressInfoBycOrderSn(String cOrderSn);

}
