package com.haier.m.dao.mshop.read;

import com.haier.m.entity.item.Products;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductsReadDao {
    /**
     * 根据id获取商品信息
     * 
     * @param id
     * @return
     */
    public Products getItemById(@Param("id") Integer id);

    /**
     * 根据SKU集合查询商品信息
     * @param skuList
     * @return
     */
    List<Products> getItemBySKUs(@Param("skuList") List<String> skuList);

    /**
     * 根据最少个数随机进行商品的获取
     * @param limitNum 最小获取个数
     * @return 返回查询的结果
     */
    List<String> getRandomItemSKUByLimitNum(@Param("limitNum") Integer limitNum);

    /**
     * 根据分类id，排序字段查询移动端已上架商品信息
     * @param map
     * @return
     */
    public List<String> getMshopItemForMiniStoreList(Map<String, Object> map);

    /**
     * 根据SKU集合，类目查询商品信息
     * @param skuList
     * @return
     */
    List<Products> getItemBySKUsProductCateId(@Param("skuList") List<String> skuList,
                                              @Param("productCateId") Integer productCateId);

    /**
     * 根据SKU查询商品信息
     * @param sku
     * @return
     */
    Products getMShopItemBySku(@Param("sku") String sku);


    /**
     * 根据skuList和关键字查询M_SHOP上架商品
     * @param map
     * @return
     */
    List<Products> getStoreItems(Map<String, Object> map);

    /**
     * 查询MSHOP库所有商品SKU
     * @return
     */
    List<String> getAllSkus();


}
