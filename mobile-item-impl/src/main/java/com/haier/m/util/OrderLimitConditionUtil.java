package com.haier.m.util;

import java.util.LinkedHashMap;
import java.util.Map;

import com.haier.m.entity.vo.OrderLimitConditionVo;

public class OrderLimitConditionUtil {

    /**
     * 拼接redis存储限购条件的value值
     * @param map
     * @return
     */
    public static String handleCondition(Map<String,Integer> map){
        String isLimitCondition = "";
        for (String key : map.keySet()) {
            String value = map.get(key) + ",";
            isLimitCondition += value;
        }
        
        return isLimitCondition;
    }
    
    /**
     * 解析redis存储限购条件的value值
     * @param isLimitCondtion
     * @return
     */
    public static Map<String,String> getCondition(String isLimitCondtion){
        String[] split = isLimitCondtion.split(",");
        Map<String,String> map = new LinkedHashMap<String, String>();
        map.put("consignee", split[0]);
        map.put("mobile", split[1]);
        map.put("region", split[2]);
        map.put("street", split[3]);
        map.put("billCompany", split[4]);
        map.put("shippingMode", split[5]);
        map.put("productId", split[6]);
        map.put("number", split[7]);
        return map;
    };
    
    
    /**
     * 根据选择的限购条件拼接记录限购数量的key
     * @param map
     * @param conditionMap
     * @return
     */
    /*public static String handleLimitKeyToNum(OrderLimitConditionVo limitVo,Map<String,String> conditionMap){
        String limitKey = "";
        if("1".equals(conditionMap.get("consignee"))){
            limitKey += limitVo.getConsignee();
        }
        if("1".equals(conditionMap.get("mobile"))){
            limitKey += limitVo.getMobile();
        }
        if("1".equals(conditionMap.get("region"))){
            limitKey += limitVo.getRegion();
        }
        if("1".equals(conditionMap.get("street"))){
            limitKey += limitVo.getStreet();
        }
        if("1".equals(conditionMap.get("billCompany"))){
            limitKey += limitVo.getBillCompany();
        }
        if("1".equals(conditionMap.get("shippingMode"))){
            if ("B2C".equals(limitVo.getShippingMode())) {
                limitKey+="B2C";
            }else{
                limitKey+="B2B2C";
            }
        }
        if("1".equals(conditionMap.get("productId"))){
            limitKey += limitVo.getProductId();
        }
        
        return limitKey;
    }*/
    
    /**
     * 根据选择的限购条件拼接记录限购数量的key--5中选任意3模式（商品ID+任意2种）
     * @param map
     * @param conditionMap
     * @return
     */
    public static String handleLimitKeyToNumNew(OrderLimitConditionVo limitVo,Map<String,String> conditionMap){
        String limitKey = "";
        if("1".equals(conditionMap.get("consignee"))){
            limitKey += ("name"+limitVo.getConsignee()+",");
        }
        if("1".equals(conditionMap.get("mobile"))){
            limitKey += limitVo.getMobile()+",";
        }
        if("1".equals(conditionMap.get("street"))){
            limitKey += limitVo.getStreet()+",";
        }
        if("1".equals(conditionMap.get("billCompany"))){
            limitKey += ("bill"+limitVo.getBillCompany()+",");
        }
        return limitKey;
    }
    
    
}
