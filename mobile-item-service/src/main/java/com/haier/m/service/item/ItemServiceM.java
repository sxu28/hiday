package com.haier.m.service.item;

import java.util.List;

import com.haier.common.PagerInfo;
import com.haier.common.ServiceResult;
import com.haier.m.entity.item.O2OPrdStoreProducts;
import com.haier.m.entity.item.ProductCates;
import com.haier.m.entity.item.ProductImages;
import com.haier.m.entity.item.Products;

import java.util.Map;

public interface ItemServiceM {
    /**
     * 获取商品信息
     * @param id
     * @return
     */
    public ServiceResult<Products> getItemById(Integer id);

    /**
     * 根据SKU获取商城商品信息
     * @param sku
     * @return
     */
    ServiceResult<Products> getItemBySku(String sku);

    /**
     * 根据SKU集合获取商品信息
     * @param skuList
     * @return
     */
    ServiceResult<List<Products>> getItemBySKUs(List<String> skuList);

    /**
     * 根据最少个数随机进行商品的获取
     * @param limitNum 最小获取个数
     * @return 返回查询的结果
     */
    ServiceResult<List<String>> getRandomItemSKUByLimitNum(Integer limitNum);

    /**
     * 根据商品id，平台来源获取商品图片
     * @param productId
     * @param platform
     * @return
     */
    public ServiceResult<List<ProductImages>> getProductImageByProductIdAndPlatform(Integer productId,
                                                                                    Integer platform);

    /**
     * 根据商品分类查询商品列表
     * @param productCateId 商品分类id
     * @param sortColumn 排序字段，包含5种：销量降序saleDesc、价格升序priceDesc、价格降序priceAsc、评价降序commentDesc、新品降序newDesc
     * @param priceArea  价格区间(下限，间距1000)
     * @param brandId   品牌ID
     * @param pager 分页信息
     * @return
     */
    ServiceResult<List<Map<String, Object>>> getItemForListPage(Integer productCateId,String sortColumn,
                                                                Integer priceArea, Integer brandId, PagerInfo pager);

    /**
     * 根据商品分类查询商品列表
     * @param productCateId 商品分类id
     * @param sortColumn 排序字段，包含5种：销量降序saleDesc、价格升序priceDesc、价格降序priceAsc、评价降序commentDesc、新品降序newDesc
     * @param priceArea  价格区间(下限，间距1000)
     * @param brandId   品牌ID
     * @param pager 分页信息
     * @param keyword 关键字
     * @return
     */
    ServiceResult<List<Map<String, Object>>> getItemForListPage(Integer productCateId, String sortColumn,
                                                                Integer priceArea, Integer brandId, PagerInfo pager,String keyword);

    /**
     * 根据brandId获取品牌对应信息
     * @param brandId
     * @return
     */
    public ServiceResult<ProductCates> findById(Integer brandId);

    /**
     * 根据SKU集合与类目信息获取商品信息
     * @param skuList
     * @return
     */
    ServiceResult<List<Products>> getItemBySKUsProductCateId(List<String> skuList, Integer productCateId, PagerInfo pager,
                                                             String sortColumn, Integer priceArea, Integer brandId);

    /**
     * 根据productCateId获取SKU
     * @param productCateId
     * @return
     */
    ServiceResult<List<String>> getShopSkusBySkusAndPrductCate(List<String> skuList,Integer productCateId);

    /**
     * 根据sku查询Mshop上架商品是否存在
     * @param sku
     * @return
     */
    ServiceResult<Products> isItemExisits(String sku);
	
	
	/**
     * 获取敏感词
     * @return
     */
    ServiceResult<List<String>> getSensitiveWords();

    /**
     * 获取发现skus
     * @return
     */
    ServiceResult<List<String>> getDiscoverSku();

    /**
     * 根据商品分类查询上架商品列表
     * @param productCateId 商品分类id
     * @param sortColumn 排序字段，包含5种：销量降序saleDesc、价格升序priceDesc、价格降序priceAsc、评价降序commentDesc、新品降序newDesc
     * @param priceArea  价格区间(下限，间距1000)
     * @param brandId   品牌ID
     * @param pager 分页信息
     * @return
     */
    public ServiceResult<List<Map<String, Object>>> getItemBySkuList(Integer productCateId, String sortColumn, Integer priceArea,
                                                              Integer brandId, PagerInfo pager, String keyword,List<String> skuList);

    /**
     * 根据关键字分页搜索商品信息
     * @param pagerInfo 分页
     * @param keyword 关键字
     * @param skuList
     * @return
     */
    public ServiceResult<List<Products>> searchProducts(PagerInfo pagerInfo, String keyword, List<String> skuList);

    /**
     * 查询所有MSHOP商品SKU
     * @return
     */
    public ServiceResult<List<String>> getAllSkus();

    /**
     * 根据sku和88码查询o2o商品库存数量
     * @param map
     * @return
     */
    public ServiceResult<Integer> getO2OStockNum(Map<String,Object> map);

    /**
     * 根据sku和88码查询o2o商品
     * @param sku 商品sku
     * @param storeCode 88码
     * @return
     */
    public  ServiceResult<O2OPrdStoreProducts> getO2OProduct(String sku, String storeCode);
    /**
     * 获取品类名称(品类ID转品类名称)
     * @param param
     * @return
     */
    ServiceResult<String> findInProductCateIds(List<String> list);
}
