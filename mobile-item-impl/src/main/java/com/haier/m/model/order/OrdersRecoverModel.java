package com.haier.m.model.order;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.haier.m.dao.shop.write.OrdersRecoverWriteDao;
import com.haier.m.entity.order.OrdersRecover;

@Component
public class OrdersRecoverModel {

    private static org.apache.log4j.Logger log = org.apache.log4j.LogManager
            .getLogger(OrdersRecoverModel.class);

    @Resource
    private OrdersRecoverWriteDao          ordersRecoverWriteDao;

    /**
     * 根据id取得orders_recover对象
     * @param  ordersRecoverId
     * @return
     */
    public OrdersRecover getOrdersRecoverById(Integer ordersRecoverId) {
        return ordersRecoverWriteDao.get(ordersRecoverId);
    }

    /**
     * 保存orders_recover对象
     * @param  ordersRecover
     * @return
     */
    public Integer saveOrdersRecover(OrdersRecover ordersRecover) {
        return ordersRecoverWriteDao.insert(ordersRecover);
    }

    /**
     * 更新orders_recover对象
     * @param  ordersRecover
     * @return
     */
    public Integer updateOrdersRecover(OrdersRecover ordersRecover) {
        return ordersRecoverWriteDao.update(ordersRecover);
    }

    /**
     * 批量保存orders_recover对象
     * @param  ordersRecover
     * @return
     */
    public Integer saveOrdersListRecover(List<OrdersRecover> orderRecoverList) {

        return ordersRecoverWriteDao.insertOrdersList(orderRecoverList);
    }

}