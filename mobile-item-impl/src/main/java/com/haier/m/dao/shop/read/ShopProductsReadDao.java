package com.haier.m.dao.shop.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.haier.m.entity.item.O2OPrdStoreProducts;
import com.haier.m.entity.item.Products;

/**
 * Created by chennsh on 2015/8/19.
 */
public interface ShopProductsReadDao {
    /**
     * 根据分类id，排序字段查询已上架商品信息
     * @param map 排序字段使用销量排序
     * @return
     */
    List<Map<String, Object>> getItemForMiniStoreList(Map<String, Object> map);

    /**
     * 根据skus，查询线上商品
     * @param map
     * @return
     */
    List<String> getOnlineProducts(Map<String, Object> map);

    /**
     * 根据sku查询商品信息
     * @param sku
     * @return
     */
    Products getItemBySku(String sku);

    /**
     * 根据类别查询商品skus
     * @param skuList
     * @param productCateId
     * @return
     */
    List<String> getShopSkusBySkusAndPrductCate(@Param("skuList") List<String> skuList,
                                                @Param("productCateId") Integer productCateId);

    /**
     * 搜索商品
     * @param map
     * @return
     */
    List<Products> getProductsByKeywords(Map<String, Object> map);

    /**
     * 根据storeCode（88码）和sku查询库存数量
     * @param map
     * @return
     */
    Integer getO2OStockNum(Map<String, Object> map);

    /**
     * 根据sku和storeCode查询o2o商品
     * @param map
     * @return
     */
    public O2OPrdStoreProducts getO2OProduct(Map<String, Object> map);

    /**
     * 根据商品Id获取商品信息
     * @param productId
     * @return
     */
    public Products getItemById(Integer productId);
}
