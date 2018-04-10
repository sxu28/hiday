package com.haier.m.service.item.impl;

import com.haier.common.BusinessException;
import com.haier.common.ServiceResult;
import com.haier.common.util.StringUtil;
import com.haier.m.entity.item.AttrStockVo;
import com.haier.m.entity.item.SgStoreProductsAttribute;
import com.haier.m.model.item.SgStoreProductsAttributeModel;
import com.haier.m.service.item.SgStoreProductsAttributeService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "sgStoreProductsAttributeService")
public class SgStoreProductsAttributeServiceImpl implements SgStoreProductsAttributeService {
    private static Logger      log = LogManager.getLogger(SgStoreProductsAttributeServiceImpl.class);

    @Resource
    private SgStoreProductsAttributeModel sgStoreProductsAttributeModel;

    /**
     * 根据queryMap取得店铺商品属性组合
     * @param  queryMap
     * @return
     */
    @Override
    public ServiceResult<List<SgStoreProductsAttribute>> getSgStoreAttributeByProductId(Map<String,Object> queryMap) {
        ServiceResult<List<SgStoreProductsAttribute>> result = new ServiceResult<List<SgStoreProductsAttribute>>();
        try {
            result.setResult(sgStoreProductsAttributeModel.getSgStoreAttributeByProductId(queryMap));
        } catch (BusinessException e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            log.error("[SgStoreProductsAttributeService][getSgStoreProductsAttributeById]根据queryMap["+queryMap.toString()+"]取得店铺商品属性组合表时出现未知异常：" + e.getMessage());
        } catch (Exception e) {
            log.error("[SgStoreProductsAttributeService][getSgStoreProductsAttributeById]根据queryMap["+queryMap.toString()+"]取得店铺商品属性组合表时出现未知异常：",
                    e);
        }
        return result;
    }

    @Override
    public ServiceResult<List<SgStoreProductsAttribute>> getSgStoreAttributeBySkkus(List<String> list) {
        ServiceResult<List<SgStoreProductsAttribute>> result = new ServiceResult<List<SgStoreProductsAttribute>>();
        try {
            result.setResult(sgStoreProductsAttributeModel.getSgStoreAttributeBySkkus(list));
        } catch (BusinessException e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            log.error("[SgStoreProductsAttributeService][getSgStoreAttributeBySkkus]根据list["+list.toString()+"]取得店铺商品属性组合表时出现未知异常：" + e.getMessage());
        } catch (Exception e) {
            log.error("[SgStoreProductsAttributeService][getSgStoreAttributeBySkkus]根据list["+list.toString()+"]取得店铺商品属性组合表时出现未知异常：",
                    e);
        }
        return result;
    }

    @Override
    public ServiceResult<List<String>> getSgStoreAttributeInSet(Map<String,Object> queryMap,String attrIdArr) {
        ServiceResult<List<String>> result = new ServiceResult<List<String>>();
        try {
            Map<String,Object> map = new HashMap<String, Object>();
            Object obj = queryMap.get("attrValueIds");
            String[] idArr = attrIdArr.split(",");
            if(obj!=null){
                String attrValueIds = (String) obj;
                if(!StringUtil.isEmpty(attrValueIds)){
                    String[] valueIdArr = attrValueIds.split(",");
                    for (int i = 0; i<valueIdArr.length;i++){
                        queryMap.put("value",valueIdArr[i]);
                        List<SgStoreProductsAttribute> sgStoreProductsAttributeList= sgStoreProductsAttributeModel.getSgStoreAttributeInSet(queryMap);
                        List<String> list = new ArrayList<String>();
                        for (SgStoreProductsAttribute sgStoreProductsAttribute :sgStoreProductsAttributeList) {
                            String[] temp = sgStoreProductsAttribute.getAttrValueIds().split(",");
                            for (String value:temp) {
                                if(!list.contains(value)){
                                    list.add(value);
                                }
                            }
                        }
                        String listName = "list"+i;
                        map.put(listName,list);
                    }
                    for (int i = 0; i<idArr.length;i++){
                        String listCode= "code"+i;
                        map.put(listCode, queryMap.get(idArr[i]));
                    }
                    List<String> list0 = new ArrayList<String>();
                    List<String> list1;
                    for (int i =0;i<valueIdArr.length;i++){
                        String listName = "list"+i;
                        String listCode = "code"+i;
                        List<String> oriList= (List<String>) map.get(listName);
                        List<String> addList= (List<String>) map.get(listCode);
                        oriList.removeAll(addList);
                        oriList.addAll(addList);
                        if(listName.equals("list0")){
                            list0 = oriList;
                        }else{
                            list1 = oriList;
                            if(list1!=null && list1.size()>0){
                                if(list0!=null && list0.size()>0){
                                    list0.retainAll(list1);
                                }
                            }
                        }
                    }
                    result.setResult(list0);
                }
            }
        } catch (BusinessException e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            log.error("[SgStoreProductsAttributeService][getSgStoreAttributeInSet]根据queryMap["+queryMap.toString()+"]取得店铺商品属性组合表时出现未知异常：" + e.getMessage());
        } catch (Exception e) {
            log.error("[SgStoreProductsAttributeService][getSgStoreAttributeInSet]根据queryMap["+queryMap.toString()+"]取得店铺商品属性组合表时出现未知异常：",
                    e);
        }
        return result;
    }

    @Override
    public ServiceResult<SgStoreProductsAttribute> getAttrBySkku(String skku, String storeId) {
        ServiceResult<SgStoreProductsAttribute> result = new ServiceResult<SgStoreProductsAttribute>();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if(skku!=null && !"".equals(skku)){
                map.put("skku",skku);
            }
            if(storeId!=null && !"".equals(storeId)){
                map.put("storeId",storeId);
            }
            result.setResult(sgStoreProductsAttributeModel.getAttrBySkku(map));
        } catch (BusinessException e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            log.error("[SgStoreProductsAttributeService][getAttrBySkku]根据skku,storeId["+map.toString()+"]查询店铺是否配置属性时出现未知异常：" + e.getMessage());
        } catch (Exception e) {
            log.error("[SgStoreProductsAttributeService][getAttrBySkku]根据skku,storeId["+map.toString()+"]查询店铺是否配置属性时出现未知异常：",
                    e);
        }
        return result;
    }

    @Override
    public ServiceResult<Boolean> isShowAttr(Map<String, Object> map) {
        ServiceResult<Boolean> result = new ServiceResult<Boolean>();
        try {
            result.setResult(sgStoreProductsAttributeModel.isShowAttr(map));
        } catch (BusinessException e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            log.error("[SgStoreProductsAttributeService][isShowAttr]根据isShowAttr["+map.toString()+"]查询店铺是否配置属性时出现未知异常：" + e.getMessage());
        } catch (Exception e) {
            log.error("[SgStoreProductsAttributeService][isShowAttr]根据isShowAttr["+map.toString()+"]查询店铺是否配置属性时出现未知异常：",
                    e);
        }
        return result;
    }

}