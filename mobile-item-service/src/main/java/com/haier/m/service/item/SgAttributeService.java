package com.haier.m.service.item;

import com.haier.common.ServiceResult;
import com.haier.m.entity.item.AttributeVo;
import com.haier.m.entity.item.SgAttribute;

import java.util.List;
import java.util.Map;

public interface SgAttributeService {

    /**
     * 根据queryMap取得店铺商品属性表
     * @param  queryMap
     * @return
     */
    ServiceResult<List<SgAttribute>> getSgAttributeListByMap(Map<String, Object> queryMap);
    /**
     * 根据map批量获取得店铺商品属性名称
     * @param  queryMap
     * @return
     */
    ServiceResult<Map<String, Object>> getSgAttributeByMap(Map<String, Object> queryMap);

    /**
     * 清除商品属性缓存
     * @param productId
     * @param storeId
     * @return
     */
    ServiceResult<Boolean> removeKey(Integer productId,Integer storeId);
}