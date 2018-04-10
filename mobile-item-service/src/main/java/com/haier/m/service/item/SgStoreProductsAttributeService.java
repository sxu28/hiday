package com.haier.m.service.item;

import com.haier.common.ServiceResult;
import com.haier.m.entity.item.AttrStockVo;
import com.haier.m.entity.item.SgStoreProductsAttribute;

import java.util.List;
import java.util.Map;

public interface SgStoreProductsAttributeService {

	/**
     * 根据map取得店铺商品属性组合表
     * @param  queryMap
     * @return
     */
    ServiceResult<List<SgStoreProductsAttribute>> getSgStoreAttributeByProductId(Map<String,Object> queryMap);
	/**
     * 根据skkuList取得店铺商品属性组合表
     * @param  list
     * @return
     */
    ServiceResult<List<SgStoreProductsAttribute>> getSgStoreAttributeBySkkus(List<String> list);
    /**
     * 根据list[attr_value_ids]取得店铺商品属性组合表
     * @param  queryMap
     * @return
     */
    ServiceResult<List<String>> getSgStoreAttributeInSet(Map<String,Object> queryMap,String attrIdArr);
    /**
     * 根据storeId,skku取得店铺商品详情（价格，图片）
     * @param  storeId
     * @param  skku
     * @return
     */
    ServiceResult<SgStoreProductsAttribute> getAttrBySkku(String skku,String storeId);
    /**
     * 根据storeId,productId判断是否配置属性
     * @param  queryMap
     * @return
     */
    ServiceResult<Boolean> isShowAttr(Map<String, Object> queryMap);
}