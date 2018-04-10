package com.haier.m.model.item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.haier.common.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.haier.common.PagerInfo;
import com.haier.m.ServiceItemConstants;
import com.haier.m.dao.mshop.read.ProductImagesReadDao;
import com.haier.m.dao.mshop.read.ProductsReadDao;
import com.haier.m.dao.shop.read.ProductCatesReadDao;
import com.haier.m.dao.shop.read.ShopProductsReadDao;
import com.haier.m.entity.item.O2OPrdStoreProducts;
import com.haier.m.entity.item.ProductCates;
import com.haier.m.entity.item.ProductImages;
import com.haier.m.entity.item.Products;

@Component
public class ItemModelM {

    private Logger log = LoggerFactory.getLogger(ItemModelM.class);

    @Resource
    private ProductsReadDao      productsReadDao;
    @Resource
    private ShopProductsReadDao  shopProductsReadDao;
    @Resource
    private ProductImagesReadDao productImagesReadDao;
    @Resource
    private ProductCatesReadDao  productCatesReadDao;

    public Products getItemById(Integer id) {
        Products product = productsReadDao.getItemById(id);
        if (product != null) {
            product.setSaleGuidePrice(getPrice(product));// 如果移动价格在有效期内，则读取移动端价格，否则读取同步的pc端价格
            Products shopProduct = shopProductsReadDao.getItemBySku(product.getSku());
            if(null != shopProduct) {
                product.setProductO2OType(shopProduct.getProductO2OType());
            }
        }
        return product;
    }

    private BigDecimal getPrice(Products product) {
        // 如果移动价格在有效期内，则读取移动端价格，否则读取同步的pc端价格
        int curTime = (int) (System.currentTimeMillis() / 1000);
        if (curTime > product.getStartTime() && curTime < product.getEndTime()) {
            return product.getMobilePrice();
        }
        return product.getSaleGuidePrice();
    }

    /**
     * 根据SKU查询商城商品信息
     * **/
    public Products getItemBySku(String sku) {
        Products products = shopProductsReadDao.getItemBySku(sku);
        return products;
    }

    public List<Products> getItemBySKUs(List<String> skuList) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("skuList", skuList);
        List<Map<String, Object>> shopResult = shopProductsReadDao.getItemForMiniStoreList(params);

        if(null == shopResult){
            return new ArrayList<Products>();
        }

        List<String> shopSkuList = new ArrayList<String>();
        Map<String,Integer> o2oMap = new HashMap<String,Integer>();
        for(Map<String,Object> map : shopResult){
            String sku = (String)map.get("sku");
            shopSkuList.add(sku);
            o2oMap.put(sku, (Integer) map.get("productO2OType"));
        }
        List<Products> productsList = productsReadDao.getItemBySKUs(shopSkuList);
        if (productsList != null && productsList.size() > 0) {
            for (Products p : productsList) {
                if (p != null) {
                    p.setSaleGuidePrice(getPrice(p));// 如果移动价格在有效期内，则读取移动端价格，否则读取同步的pc端价格
                    this.splitProductName(p);//将商品全称分开
                    Integer productO2OType = o2oMap.get(p.getSku());
                    p.setProductO2OType(productO2OType);
                }
            }
            return productsList;
        } else
            return new ArrayList<Products>();
    }

    public List<String> getRandomItemSKUByLimitNum(Integer limitNum) {
        List<String> mshoplist = productsReadDao.getRandomItemSKUByLimitNum(limitNum);
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("skuList", mshoplist);
        List<String> shopList = shopProductsReadDao.getOnlineProducts(paramMap);
        //若果默认的产品都已下架，随机取上架的产品
        if (shopList == null || shopList.isEmpty()) {
            mshoplist = productsReadDao.getRandomItemSKUByLimitNum(limitNum);
            Map<String, Object> paramMapTmp = new HashMap<String, Object>();
            paramMap.put("skuList", mshoplist);
            shopList = shopProductsReadDao.getOnlineProducts(paramMapTmp);
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < ServiceItemConstants.PRODUCTS_INDEX_NUM && i < shopList.size(); i++) {
                list.add(shopList.get(i));
            }
            return list;
        }
        return shopList;

    }

    public List<ProductImages> getByProductIdAndPlatform(Integer productId, Integer platform) {
        return productImagesReadDao.getByProductIdAndPlatform(productId, platform);
    }

    /**
     * 此方法是pager 不为null时是从第二页开始，建议用{@link ItemModelM#getItemForListPage(Integer, String, Integer, Integer, PagerInfo, String)} ()}
     * 根据商品分类查询商品列表
     * @param productCateId 商品分类id
     * @param sortColumn 排序字段，包含5种：销量降序saleDesc、价格升序priceDesc、价格降序priceAsc、评价降序commentDesc、新品降序newDesc
     * @param priceArea 价格区间(下限,间距1000)
     * @param brandId   品牌
     * @param pager 分页信息
     * @param keyword
     * @return
     */
    public List<Map<String, Object>> getItemForListPage(Integer productCateId, String sortColumn,Integer priceArea,
                                                        Integer brandId,PagerInfo pager, String keyword) {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("productCateId", productCateId);
        paramMap.put("sortColumn",sortColumn);
        paramMap.put("priceArea", priceArea);
        paramMap.put("brandId",brandId);
        List<Map<String, Object>> productsList = shopProductsReadDao
            .getItemForMiniStoreList(paramMap);
        if (null == productsList || productsList.isEmpty()) {
            return null;
        }
        List<String> skuList = new ArrayList<String>();
        Map<String,Integer> productO2OTypeMap = new HashMap<String,Integer>();
        for (Map<String, Object> map : productsList) {
            String sku = (String) map.get("sku");
            skuList.add(sku);
            productO2OTypeMap.put(sku, (Integer)map.get("productO2OType"));
        }
        paramMap.put("skuList", skuList);
        paramMap.put("keyword", keyword);
        List<String> pIdList = productsReadDao.getMshopItemForMiniStoreList(paramMap);
        Iterator<Map<String, Object>> pIdIterator = productsList.iterator();
        while (pIdIterator.hasNext()) {
            Map<String, Object> map = pIdIterator.next();
            //移动端没上架，移除
            if (!pIdList.contains(map.get("sku"))) {
                pIdIterator.remove();
                continue;
            }
        }
        List<Map<String, Object>> itemList = new ArrayList<Map<String, Object>>();
        if (pager == null) {//页面初始加载
            for (int i = 0; i < productsList.size() && i < ServiceItemConstants.PRODUCTS_INITIALISE; i++) {
                Map<String, Object> map = productsList.get(i);
                Products product = productsReadDao.getItemById(((Long) map.get("id")).intValue());
                if (product == null) {
                    continue;
                }else { //写入O2OType
                    Integer productO2OType = productO2OTypeMap.get(product.getSku());
                    product.setProductO2OType(productO2OType);
                }

                this.splitProductName(product);//将商品全称分开
                map.put("product", product);
                itemList.add(map);
            }
        } else {//页面下拉
            Integer pageBeg = (pager.getPageIndex() - 1) * pager.getPageSize()
                              + ServiceItemConstants.PRODUCTS_INITIALISE;
            Integer pageNum = pager.getPageIndex() * pager.getPageSize()
                              + ServiceItemConstants.PRODUCTS_INITIALISE;
            for (int i = pageBeg; i < productsList.size() && i < pageNum; i++) {
                Map<String, Object> map = productsList.get(i);
                Products product = productsReadDao.getItemById(((Long) map.get("id")).intValue());
                if (product == null) {
                    continue;
                }else { //写入O2OType
                    Integer productO2OType = productO2OTypeMap.get(product.getSku());
                    product.setProductO2OType(productO2OType);
                }
                this.splitProductName(product);//将商品全称分开
                map.put("product", product);
                itemList.add(map);
            }
        }
        return itemList;
    }

    /**
     * 根据商品分类查询商品列表
     * @param productCateId 商品分类id
     * @param sortColumn 排序字段，包含5种：销量降序saleDesc、价格升序priceDesc、价格降序priceAsc、评价降序commentDesc、新品降序newDesc
     * @param priceArea 价格区间
     * @param brandId   品牌
     * @param pager 分页信息
     * @param keyword
     * @return
     */
    public List<Map<String, Object>> getItemListPage(Integer productCateId, String sortColumn,
                                                     Integer priceArea, Integer brandId,
                                                     PagerInfo pager, String keyword) {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("productCateId", productCateId);
        paramMap.put("sortColumn",sortColumn);
        paramMap.put("priceArea", priceArea);
        paramMap.put("brandId",brandId);
        List<Map<String, Object>> productsList = shopProductsReadDao
                .getItemForMiniStoreList(paramMap);
        if (productsList == null || productsList.isEmpty()) {
            return null;
        }
        List<String> skuList = new ArrayList<String>();
        for (Map<String, Object> map : productsList) {
            skuList.add((String) map.get("sku"));
        }
        paramMap.put("skuList", skuList);
        paramMap.put("keyword", keyword);
        List<String> pIdList = productsReadDao.getMshopItemForMiniStoreList(paramMap);
        Iterator<Map<String, Object>> pIdIterator = productsList.iterator();
        while (pIdIterator.hasNext()) {
            Map<String, Object> map = pIdIterator.next();
            //移动端没上架，移除
            if (!pIdList.contains(map.get("sku"))) {
                pIdIterator.remove();
                continue;
            }
        }
        List<Map<String, Object>> itemList = new ArrayList<Map<String, Object>>();
        Integer pageBeg = (pager.getPageIndex() - 1) * pager.getPageSize();
        Integer pageNum = pager.getPageIndex() * pager.getPageSize();
        for (int i = pageBeg; i < productsList.size() && i < pageNum; i++) {
            Map<String, Object> map = productsList.get(i);
            Products product = productsReadDao.getItemById(((Long) map.get("id")).intValue());
            if (product == null) {
                continue;
            }
            this.splitProductName(product);//将商品全称分开
            map.put("product", product);
            itemList.add(map);
        }
        return itemList;
    }

    /**
     * 根据id查询品牌信息
     * @param brandId
     * @return
     */
    public ProductCates findById(Integer brandId) {
        return productCatesReadDao.findById(brandId);
    }

    /**
     * 将商品全称分成名称+型号
     * 例：
     * 海尔 滚筒洗衣机
     *  XQG60-1000J
     * @param p
     * @return
     */
    private void splitProductName(Products p) {
        if (StringUtils.isNotEmpty(p.getProductFullName())) {//将商品全称分开
            String[] productTitles = p.getProductFullName().split(" ");
            List<String> stringList = new ArrayList<String>();
            for (int i = 0; i < productTitles.length; i++) {
                if (StringUtils.isNotEmpty(productTitles[i])) {
                    stringList.add(productTitles[i]);
                }
            }
            if (stringList.size() > 3) {
                String strTemp = "";
                for (int i = 2; i < stringList.size(); i++) {
                    strTemp += stringList.get(i) + " ";
                }
                stringList.set(2, strTemp.substring(0, strTemp.length() - 1));
            }
            if (stringList.size() >= 2 && stringList.get(0) != null && stringList.get(1) != null) {
                p.setProductFirstName(stringList.get(0) + " " + stringList.get(1));
            } else if (stringList.size() == 1 && stringList.get(0) != null) {
                p.setProductFirstName(stringList.get(0));
            } else {
                p.setProductFirstName("");
            }
            if (stringList.size() >= 3 && stringList.get(2) != null) {
                p.setProductSecondName(stringList.get(2));
            } else {
                p.setProductSecondName("");
            }
        }
    }

    public List<Products> getItemBySKUsProductCateId(List<String> skuList, Integer productCateId, PagerInfo pager,
                                                     String sortColumn, Integer priceArea, Integer brandId) {
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("skuList", skuList);
        params.put("sortColumn",sortColumn);
        params.put("priceArea", priceArea);
        params.put("brandId", brandId);
        params.put("productCateId", productCateId);
        List<Map<String,Object>> shopList = shopProductsReadDao.getItemForMiniStoreList(params);
        if(null == shopList){
            return new ArrayList<Products>();
        }

        List<String> shopSkuList = new ArrayList<String>();
        Map<String,Integer> o2oMap = new HashMap<String,Integer>();
        for(Map<String,Object> map : shopList) {
            String sku = (String)map.get("sku");
            shopSkuList.add(sku);
            Integer o2oType = (Integer)map.get("productO2OType");
            o2oMap.put(sku, o2oType);
        }

        ArrayList<Products> itemList = new ArrayList<Products>();
        if(shopSkuList.size() > 0) {
            Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("skuList", shopSkuList);
            List<String> pIdList = productsReadDao.getMshopItemForMiniStoreList(paramMap);

            Iterator<Map<String, Object>> iterator = shopList.iterator();
            while (iterator.hasNext()) {
                Map<String, Object> map = iterator.next();
                //移动端没上架，移除
                if (!pIdList.contains(map.get("sku"))) {
                    iterator.remove();
                    continue;
                }
            }

            if (shopList != null && shopList.size() > 0) {
                Integer start = 0;
                Integer offset = shopList.size();
                if(pager != null){
                    start = (pager.getPageIndex() - 1) * pager.getPageSize();
                    offset = start + pager.getPageSize();
                }
                for (int i=start;i<shopList.size() && i<offset;i++) {
                    Map<String, Object> map = shopList.get(i);
                    Products product = productsReadDao.getItemById(((Long) map.get("id")).intValue());
                    if (product == null) {
                        continue;
                    }
                    this.splitProductName(product);//将商品全称分开
                    Integer o2oType = o2oMap.get(product.getSku());
                    product.setProductO2OType(o2oType);
                    itemList.add(product);
                }
            }
        }

        return itemList;
    }

    /**
     * 根据productCateId获取SKU
     *
     **/
    public List<String> getSkusByPrductCate(List<String> skuList, Integer productCateId) {
        List<String> shopSkus = shopProductsReadDao.getShopSkusBySkusAndPrductCate(skuList, productCateId);
        if (shopSkus != null && shopSkus.size() > 0) {
            return shopSkus;
        } else
            return new ArrayList<String>();
    }


    /**
     * 根据sku查询上架商品数
     *
     **/
    public Products getMShopItemBySku(String sku) {
        Products products = productsReadDao.getMShopItemBySku(sku);
        return products;
    }

/**
     * 此方法是pager 不为null时是从第二页开始，建议用{@link ItemModelM#getItemListPage(Integer, String, Integer, Integer, PagerInfo, String)} ()}
     * 根据商品分类查询商品列表
     * @param productCateId 商品分类id
     * @param sortColumn 排序字段，包含5种：销量降序saleDesc、价格升序priceDesc、价格降序priceAsc、评价降序commentDesc、新品降序newDesc
     * @param priceArea 价格区间（上限(例如2000则查询区间为1001-2000)，间隔1000）
     * @param brandId 品牌ID
     * @param pager 分页信息
     * @param keyword
     * @return
     */
    public List<Map<String, Object>> getItemBySkuList(Integer productCateId, String sortColumn,Integer priceArea,
                                                      Integer brandId, PagerInfo pager, String keyword,List<String> skuList) {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("productCateId", productCateId);
        paramMap.put("sortColumn",sortColumn);
        paramMap.put("priceArea", priceArea);
        paramMap.put("brandId", brandId);
        List<Map<String, Object>> productsList = shopProductsReadDao
                .getItemForMiniStoreList(paramMap);
        if (productsList == null || productsList.isEmpty()) {
            return null;
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("skuList", skuList);
        params.put("keyword", keyword);
        List<String> pIdList = productsReadDao.getMshopItemForMiniStoreList(params);
        Map<String,Integer> o2oMap = new HashMap<String,Integer>();
        Iterator<Map<String, Object>> pIdIterator = productsList.iterator();
        while (pIdIterator.hasNext()) {
            Map<String, Object> map = pIdIterator.next();
            String sku = (String)map.get("sku");
            //移动端没上架，移除
            if (!pIdList.contains(sku)) {
                pIdIterator.remove();
                continue;
            }else {
                Integer o2oType = (Integer) map.get("productO2OType");
                o2oMap.put(sku, o2oType);
            }
        }
        List<Map<String, Object>> itemList = new ArrayList<Map<String, Object>>();
        if (pager == null) {//页面初始加载
            for (int i = 0; i < productsList.size() && i < ServiceItemConstants.PRODUCTS_INITIALISE; i++) {
                Map<String, Object> map = productsList.get(i);
                Products product = productsReadDao.getItemById(((Long) map.get("id")).intValue());
                if (product == null) {
                    continue;
                }
                this.splitProductName(product);//将商品全称分开
                Integer o2oType = o2oMap.get(product.getSku());
                product.setProductO2OType(o2oType);
                map.put("product", product);
                itemList.add(map);
            }
        } else {//页面下拉
            Integer pageBeg = (pager.getPageIndex() - 1) * pager.getPageSize()
                    + ServiceItemConstants.PRODUCTS_INITIALISE;
            Integer pageNum = pager.getPageIndex() * pager.getPageSize()
                    + ServiceItemConstants.PRODUCTS_INITIALISE;
            for (int i = pageBeg; i < productsList.size() && i < pageNum; i++) {
                Map<String, Object> map = productsList.get(i);
                Products product = productsReadDao.getItemById(((Long) map.get("id")).intValue());
                if (product == null) {
                    continue;
                }
                this.splitProductName(product);//将商品全称分开
                Integer o2oType = o2oMap.get(product.getSku());
                product.setProductO2OType(o2oType);
                map.put("product", product);
                itemList.add(map);
            }
        }
        return itemList;
    }

    public List<Products> searchProducts(PagerInfo pager, String keyword, List<String> skuList){

        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("skuList", skuList);
        List<Products> productsList = shopProductsReadDao.getProductsByKeywords(paramMap);
        if (productsList == null || productsList.isEmpty()) {
            return null;
        }

        paramMap.put("keyword", keyword);
        List<String> mShopSkuList = productsReadDao.getMshopItemForMiniStoreList(paramMap);
        Iterator<Products> pIdIterator = productsList.iterator();
        while (pIdIterator.hasNext()) {
            Products p = pIdIterator.next();
            String sku = p.getSku();
//            Products mShopItem = productsReadDao.getMShopItemBySku(sku);
//            //移动端没上架，移除
//            if (null == mShopItem) {
//                log.info("m_shop库未上架：sku = " + p.getSku());
//                pIdIterator.remove();
//                continue;
//            }
            if(!mShopSkuList.contains(sku)){
                pIdIterator.remove();
                continue;
            }
        }

        List<Products> itemList = new ArrayList<Products>();
        if (pager == null) {//页面初始加载
            for (int i = 0; i < productsList.size() && i < ServiceItemConstants.PRODUCTS_INITIALISE; i++) {
                Products product = productsList.get(i);
                this.splitProductName(product);//将商品全称分开
                itemList.add(product);
            }
        } else {//页面下拉
            Integer pageBeg = (pager.getPageIndex() - 1) * pager.getPageSize()
                    + ServiceItemConstants.PRODUCTS_INITIALISE;
            Integer pageNum = pager.getPageIndex() * pager.getPageSize()
                    + ServiceItemConstants.PRODUCTS_INITIALISE;
            for (int i = pageBeg; i < productsList.size() && i < pageNum; i++) {
                Products product = productsList.get(i);
                this.splitProductName(product);//将商品全称分开
                itemList.add(product);
            }
        }
        return itemList;
    }

    public List<String> getAllSkus(){
        return productsReadDao.getAllSkus();
    }

    /**
     * 根据sku和88查询O2O商品库存数量
     * @param map
     * @return
     */
    public Integer getO2OStockNum(Map<String, Object> map) {
        return shopProductsReadDao.getO2OStockNum(map);
    }

    /**
     * 根据sku和88查询O2O商品
     * @param map
     * @return
     */
    public O2OPrdStoreProducts getO2OProducts(Map<String, Object> map){
        return shopProductsReadDao.getO2OProduct(map);
    }
    
    public Products getProductByProductId(Integer proId) {
    	return shopProductsReadDao.getItemById(proId);
    }

    public List<ProductCates> findInProductCateIds(List<String> list) {
        return productCatesReadDao.findInProductCateIds(list);
    }
}
