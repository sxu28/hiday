package com.haier.m.service.item.impl;

import com.haier.common.BusinessException;
import com.haier.common.ServiceResult;
import com.haier.m.entity.item.AttributeVo;
import com.haier.m.entity.item.SgAttribute;
import com.haier.m.entity.item.SgStoreProductsAttribute;
import com.haier.m.model.item.SgAttributeModel;
import com.haier.m.model.redis.SgRedisMode;
import com.haier.m.service.item.SgAttributeService;
import com.haier.sg.constants.CmsConstant;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "sgAttributeService")
public class SgAttributeServiceImpl implements SgAttributeService {
    private static Logger      log = LogManager.getLogger(SgAttributeServiceImpl.class);

    @Resource
    private SgAttributeModel sgAttributeModel;
    @Resource
    private SgRedisMode sgRedisMode;

    /**
     * 根据id取得店铺商品属性表
     * @param  queryMap
     * @return
     */
    @Override
    public ServiceResult<List<SgAttribute>> getSgAttributeListByMap(Map<String, Object> queryMap) {
        ServiceResult<List<SgAttribute>> result = new ServiceResult<List<SgAttribute>>();
        try {
            result.setResult(sgAttributeModel.getSgAttributeByMap(queryMap));
        } catch (BusinessException e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            log.error("[ISgAttributeService][getSgAttributeListByMap]根据queryMap["+queryMap+"]取得店铺商品属性表时出现未知异常：" + e.getMessage());
        } catch (Exception e) {
            log.error("[ISgAttributeService][getSgAttributeListByMap]根据queryMap["+queryMap+"]取得店铺商品属性表时出现未知异常：",
                    e);
        }
        return result;
    }

    @Override
    public ServiceResult<Map<String, Object>> getSgAttributeByMap(Map<String, Object> queryMap) {
        ServiceResult<Map<String, Object>> result = new ServiceResult<Map<String, Object>>();
        try {
            Integer productId = (Integer) queryMap.get("productId");
            Integer storeId = (Integer) queryMap.get("storeId");
            String commonCacheKey = MessageFormat
                    .format(CmsConstant.SG_CACHE_KEY_O2OSINGLEATTRIBUTE,
                            String.valueOf(productId),String.valueOf(storeId));
            //获取缓存
            Object redisSgAttrList = sgRedisMode.getSgStoreAttribute(commonCacheKey);
            if(redisSgAttrList==null){
                List<SgAttribute> sgAttributeList = sgAttributeModel.getSgAttributeByMap(queryMap);
                if(sgAttributeList != null && sgAttributeList.size() > 0 ){
                    Map<String, Object> skuIdMap = new HashMap<String, Object>();
                    for (SgAttribute sgAttribute:sgAttributeList) {
                        List<AttributeVo> tempList = (List<AttributeVo>) skuIdMap.get(sgAttribute.getAttrCode());
                        AttributeVo attributeVo = new AttributeVo();
                    /*如果取不到数据,那么直接new一个空的ArrayList**/
                        if (tempList == null) {
                            tempList = new ArrayList<AttributeVo>();
                            attributeVo.setAttrName(sgAttribute.getAttrName());
                            attributeVo.setSgAttribute(sgAttribute);
                            tempList.add(attributeVo);
                            skuIdMap.put(sgAttribute.getAttrCode(), tempList);
                        }
                        else {
                        /*某个sku之前已经存放过了,则直接追加数据到原来的List里**/
                            attributeVo.setAttrName(sgAttribute.getAttrName());
                            attributeVo.setSgAttribute(sgAttribute);
                            tempList.add(attributeVo);
                        }
                    }
                    result.setResult(skuIdMap);
                    sgRedisMode.putSgStoreAttribute(commonCacheKey,skuIdMap);
                }
            }else{
                result.setResult((Map<String, Object>) redisSgAttrList);
            }
        } catch (BusinessException e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            log.error("[SgAttributeService][getSgAttributeByMap]根据map["+queryMap+"]取得店铺商品属性表时出现未知异常：" + e.getMessage());
        } catch (Exception e) {
            log.error("[SgAttributeService][getSgAttributeByMap]根据map["+queryMap+"]取得店铺商品属性表时出现未知异常：",
                    e);
        }
        return result;
    }

    @Override
    public ServiceResult<Boolean> removeKey(Integer productId,Integer storeId) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        String commonCacheKey = MessageFormat
                .format(CmsConstant.SG_CACHE_KEY_O2OSINGLEATTRIBUTE,
                        String.valueOf(productId),String.valueOf(storeId));
        try {
            result.setResult(sgRedisMode.removeSgStoreAttribute(commonCacheKey));
        } catch (BusinessException e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            log.error("[ISgAttributeService][removeKey]根据commonCacheKey["+commonCacheKey+"]清除商品属性缓存时出现未知异常：" + e.getMessage());
        } catch (Exception e) {
            log.error("[ISgAttributeService][removeKey]根据commonCacheKey["+commonCacheKey+"]清除商品属性缓存时出现未知异常：",
                    e);
        }
        return result;
    }

}