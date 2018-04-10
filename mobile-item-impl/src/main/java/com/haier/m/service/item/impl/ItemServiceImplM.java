package com.haier.m.service.item.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.haier.common.PagerInfo;
import com.haier.common.ServiceResult;
import com.haier.m.entity.item.O2OPrdStoreProducts;
import com.haier.m.entity.item.ProductCates;
import com.haier.m.entity.item.ProductImages;
import com.haier.m.entity.item.Products;
import com.haier.m.model.item.ItemModelM;
import com.haier.m.service.item.ItemServiceM;

@Service("itemServiceM")
public class ItemServiceImplM implements ItemServiceM {

    private Logger     log = LoggerFactory.getLogger(ItemServiceImplM.class);
    @Resource
    private ItemModelM itemModelM;

    @Override
    public ServiceResult<Products> getItemById(Integer id) {
        ServiceResult<Products> serviceResult = new ServiceResult<Products>();
        try {
            serviceResult.setResult(itemModelM.getItemById(id));
        } catch (Exception e) {
            log.error("获取商品信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<Products> getItemBySku(String sku) {
        ServiceResult<Products> serviceResult = new ServiceResult<Products>();
        try {
            serviceResult.setResult(itemModelM.getItemBySku(sku));
        } catch (Exception e) {
            log.error("根据SKU获取商品信息时发生未知异常:"+ e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("根据SKU获取商品信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<Products>> getItemBySKUs(List<String> skuList) {
        ServiceResult<List<Products>> serviceResult = new ServiceResult<List<Products>>();
        try {
            serviceResult.setResult(itemModelM.getItemBySKUs(skuList));
        } catch (Exception e) {
            log.error("获取商品集合信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品集合信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<String>> getRandomItemSKUByLimitNum(Integer limitNum) {
        ServiceResult<List<String>> serviceResult = new ServiceResult<List<String>>();
        try {
            serviceResult.setResult(itemModelM.getRandomItemSKUByLimitNum(limitNum));
        } catch (Exception e) {
            log.error("随机获取商品信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("随机获取商品信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<ProductImages>> getProductImageByProductIdAndPlatform(Integer productId,
                                                                                    Integer platform) {
        ServiceResult<List<ProductImages>> serviceResult = new ServiceResult<List<ProductImages>>();
        try {
            serviceResult.setResult(itemModelM.getByProductIdAndPlatform(productId, platform));
        } catch (Exception e) {
            log.error("获取商品集合信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品集合信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<Map<String, Object>>> getItemForListPage(Integer productCateId, String sortColumn,Integer priceArea,
                                                                       Integer brandId, PagerInfo pager) {
        ServiceResult<List<Map<String, Object>>> serviceResult = new ServiceResult<List<Map<String, Object>>>();
        try {
            serviceResult
                .setResult(itemModelM.getItemForListPage(productCateId, sortColumn, priceArea, brandId, pager, null));
        } catch (Exception e) {
            log.error("获取商品信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<Map<String, Object>>> getItemForListPage(Integer productCateId, String sortColumn,Integer priceArea,
                                                                       Integer brandId, PagerInfo pager, String keyword) {
        ServiceResult<List<Map<String, Object>>> serviceResult = new ServiceResult<List<Map<String, Object>>>();
        try {
            serviceResult.setResult(itemModelM.getItemListPage(productCateId, sortColumn, priceArea,
                    brandId, pager, keyword));
        } catch (Exception e) {
            log.error("获取商品信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品信息时发生未知异常");
        }
        return serviceResult;
    }

    public ServiceResult<ProductCates> findById(Integer brandId) {
        ServiceResult<ProductCates> result = new ServiceResult<ProductCates>();
        try {
            result.setResult(itemModelM.findById(brandId));
        } catch (Exception e) {
            log.error("获取品牌信息时发生未知异常:", e);
            result.setSuccess(false);
            result.setMessage("获取品牌信息时发生未知异常");
        }
        return result;
    }

    @Override
    public ServiceResult<List<Products>> getItemBySKUsProductCateId(List<String> skuList, Integer productCateId, PagerInfo pager,
                                                                    String sortColumn, Integer priceArea, Integer brandId) {
        ServiceResult<List<Products>> serviceResult = new ServiceResult<List<Products>>();
        try {
            serviceResult.setResult(itemModelM.getItemBySKUsProductCateId(skuList, productCateId, pager, sortColumn, priceArea, brandId));
        } catch (Exception e) {
            log.error("获取商品集合信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品集合信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<String>> getShopSkusBySkusAndPrductCate(List<String> skuList, Integer productCateId) {
        ServiceResult<List<String>> serviceResult = new ServiceResult<List<String>>();
        try {
            serviceResult.setResult(itemModelM.getSkusByPrductCate(skuList, productCateId));
        } catch (Exception e) {
            log.error("获取shop商品SKU集合信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取shop商品SKU集合信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<Products> isItemExisits(String sku){
        ServiceResult<Products> serviceResult = new ServiceResult<Products>();
        try {
            serviceResult.setResult(itemModelM.getMShopItemBySku(sku));
        } catch (Exception e) {
            log.error("获取mshop商品信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取mshop商品信息时发生未知异常");
        }
        return serviceResult;
    }
	
	public ServiceResult<List<String>> getSensitiveWords() {
        ServiceResult<List<String>> serviceResult = new ServiceResult<List<String>>();
        try {
            List<String> sensitiveWords = new ArrayList<String>();
            serviceResult.setResult(sensitiveWords);
        } catch (Exception e) {
            log.error("获取敏感词库发生异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取敏感词库发生异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<String>> getDiscoverSku() {
        ServiceResult<List<String>> serviceResult = new ServiceResult<List<String>>();
        try {
             serviceResult.setResult(new ArrayList<String>());
        } catch (Exception e) {
            log.error("获取发现发生异常:", e);
            serviceResult.setMessage("获取发现发生异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<Map<String, Object>>> getItemBySkuList(Integer productCateId, String sortColumn, Integer priceArea,
                                                                     Integer brandId, PagerInfo pager, String keyword,
                                                                     List<String> skuList) {
        ServiceResult<List<Map<String, Object>>> serviceResult = new ServiceResult<List<Map<String, Object>>>();
        try {
            serviceResult
                    .setResult(itemModelM.getItemBySkuList(productCateId, sortColumn, priceArea, brandId, pager, keyword, skuList));
        } catch (Exception e) {
            log.error("获取商品信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<Products>> searchProducts(PagerInfo pagerInfo, String keyword, List<String> skuList) {
        ServiceResult<List<Products>> serviceResult = new ServiceResult<List<Products>>();
        try {
            serviceResult.setResult(itemModelM.searchProducts(pagerInfo, keyword, skuList));
        } catch (Exception e) {
            log.error("搜索商品信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<String>> getAllSkus(){
        ServiceResult<List<String>> serviceResult = new ServiceResult<List<String>>();
        try {
            serviceResult.setResult(itemModelM.getAllSkus());
        } catch (Exception e) {
            log.error("搜索商品信息时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品信息时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<Integer> getO2OStockNum(Map<String, Object> map) {
        ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
        serviceResult.setSuccess(false);
        try {
            serviceResult.setResult(itemModelM.getO2OStockNum(map));
            serviceResult.setSuccess(true);
        } catch (Exception e) {
            log.error("查询O20商品库存发生未知异常:", e);
            serviceResult.setMessage("查询O20商品库存发生未知异常"+e.toString());
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<O2OPrdStoreProducts> getO2OProduct(String sku, String storeCode) {
        Map<String,Object> map = new HashMap<String,Object>();
        ServiceResult<O2OPrdStoreProducts> serviceResult = new ServiceResult<O2OPrdStoreProducts>();
        serviceResult.setSuccess(false);
        try {
            map.put("sku",sku);
            map.put("storeCode",storeCode);
            serviceResult.setResult(itemModelM.getO2OProducts(map));
            serviceResult.setSuccess(true);
        } catch (Exception e) {
            log.error("查询O2O商品出现异常"+e.toString());
            serviceResult.setMessage("查询O2O商品出现异常"+e.toString());
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<String> findInProductCateIds(List<String> list) {
        ServiceResult<String> serviceResult = new ServiceResult<String>();
        try {
            String productCateName="";
            List<ProductCates> productCatesList = itemModelM.findInProductCateIds(list);
            if(productCatesList!=null &&productCatesList.size()>0){
                for (ProductCates productCates: productCatesList) {
                    productCateName += productCates.getCateName()+"|";
                }
            }
            serviceResult.setResult(productCateName.substring(0,productCateName.length()-1));
        } catch (Exception e) {
            log.error("获取商品类目名称时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取商品类目名称时发生未知异常");
        }
        return serviceResult;
    }


}
