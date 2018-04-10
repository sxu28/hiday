package com.haier.m.service.order.facade;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.haier.common.ServiceResult;
import com.haier.m.ServiceItemConstants;
import com.haier.m.entity.order.OrderProductInfo;
import com.haier.m.entity.vo.OrderLimitConditionVo;
import com.haier.m.model.redis.SgRedisMode;
import com.haier.m.util.OrderLimitConditionUtil;
import com.haier.m.util.RedisConstants;

@Component
public class OrderLimitFacade {

    private Logger log = LoggerFactory.getLogger(OrderLimitFacade.class);
    
    //商品ID+任意2个条件达到限购条件，进行限购
    private static final Integer LIMIT_CONDITION_COUNT = 2;
    
    public ServiceResult<Boolean> getCheckLimitResult(ServiceResult<Boolean> result,OrderLimitConditionVo limitVo,
                                                 Map<String, String> conditionMap){
        
        String limitKey = OrderLimitConditionUtil.handleLimitKeyToNumNew(limitVo, conditionMap);
        Integer productId = limitVo.getProductId();
        Integer num = limitVo.getNumber();
        Integer limitNum = Integer.parseInt(conditionMap.get("number"));
        String[] field = limitKey.split(",");
        if (LIMIT_CONDITION_COUNT > field.length) {
            result.setResult(false);
            result.setMessage("商品下单限购配置错误，请联系客服");
            return result;
        }
        int groupNum = Integer.parseInt(StringUtils.leftPad("", field.length,'1'), 2);
        
        if (num != null && num <= limitNum) {
            
            for (int i = 1; i <= groupNum; i++) {
                StringBuffer sb = new StringBuffer(field.length+5);
                int indexTemp = 1;
                for (int j = 0; j < field.length; j++) {
                    int appendIndex = (i)&(indexTemp);//二进制存在值才进行组合
                    if (appendIndex > 0) {
                        sb.append(field[j]).append(",");
                    }
                    indexTemp = indexTemp<<1;//进行左位移，以便下次循环拼接
                }
                if (sb.toString().split(",").length == LIMIT_CONDITION_COUNT) {
                    String key = productId.toString() +":"+ sb;
                    Integer hasBuy = SgRedisMode.getRedisOrderLimit(RedisConstants.ORDER_LIMIT_KEY_NEW_NEW+key.toString());
                    log.info("下单数量限制[校验]key：[mobile:orderLimit:" + key + "]已买数量：" + hasBuy+ "，下单数量:"+num);
                    if (hasBuy != null) {
                        if (hasBuy + num > limitNum) {
                            result.setResult(false);
                            result.setMessage(ServiceItemConstants.ORDER_LIMIT_MESSAGE);
                            return result;
                        }
                    }
                }
            }
        } else {
            result.setResult(false);
            result.setMessage(ServiceItemConstants.ORDER_LIMIT_MESSAGE);
            return result;
        }
        result.setResult(true);
        return result;
    }
    
    
    public ServiceResult<Boolean> getRecordLimitResult(ServiceResult<Boolean> result,OrderLimitConditionVo limitVo,
                                                      Map<String, String> conditionMap){
             
         String limitKey = OrderLimitConditionUtil.handleLimitKeyToNumNew(limitVo, conditionMap);
         Integer productId = limitVo.getProductId();
         Integer num = limitVo.getNumber();
         Integer limitNum = Integer.parseInt(conditionMap.get("number"));
         String[] field = limitKey.split(",");
         int groupNum = Integer.parseInt(StringUtils.leftPad("", field.length,'1'), 2);
         if (num != null && num <= limitNum) {
             boolean recordR = false;
             
             for (int i = 1; i <= groupNum; i++) {
                 StringBuffer sb = new StringBuffer(field.length+5);
                 int indexTemp = 1;
                 for (int j = 0; j < field.length; j++) {
                     int appendIndex = (i)&(indexTemp);//二进制存在值才进行组合
                     if (appendIndex > 0) {
                         sb.append(field[j]).append(",");
                     }
                     indexTemp = indexTemp<<1;//进行左位移，以便下次循环拼接
                 }
                 if (sb.toString().split(",").length == LIMIT_CONDITION_COUNT) {
                     num = limitVo.getNumber();
                     String key = productId.toString() +":"+ sb;
                     Integer hasBuy = SgRedisMode.getRedisOrderLimit(RedisConstants.ORDER_LIMIT_KEY_NEW_NEW+key.toString());
                     log.info("下单数量限制[添加]key：[mobile:orderLimit:" + key + "]已购买数量：" + hasBuy + "，下单数量:"+num);
                     if (hasBuy != null) {
                         // 超过限制
                         if (hasBuy + num > limitNum) {
                             result.setResult(false);
                             result.setMessage(ServiceItemConstants.ORDER_LIMIT_MESSAGE);
                             return result;
                         } else {
                             num += hasBuy;
                         }
                     }
                     recordR = SgRedisMode.putRedisOrderLimit(RedisConstants.ORDER_LIMIT_KEY_NEW_NEW+key, num, getTimeOut());
                 }
             }
             result.setResult(recordR);
         } else {
             result.setResult(false);
             result.setMessage(ServiceItemConstants.ORDER_LIMIT_MESSAGE);
             return result;
         }
         return result;
     }
    
    
    
    public Boolean getClearLimitResult(OrderLimitConditionVo limitVo,
                                                       Map<String, String> conditionMap,OrderProductInfo orderProduct){
        String limitKey = OrderLimitConditionUtil.handleLimitKeyToNumNew(limitVo, conditionMap);
        Integer productId = limitVo.getProductId();
        String[] field = limitKey.split(",");
        int groupNum = Integer.parseInt(StringUtils.leftPad("", field.length,'1'), 2);
        boolean clearR = false;
        for (int i = 1; i <= groupNum; i++) {
            StringBuffer sb = new StringBuffer(field.length+5);
            int indexTemp = 1;
            for (int j = 0; j < field.length; j++) {
                int appendIndex = (i)&(indexTemp);//二进制存在值才进行组合
                if (appendIndex > 0) {
                    sb.append(field[j]).append(",");
                }
                indexTemp = indexTemp<<1;//进行左位移，以便下次循环拼接
            }
            if (sb.toString().split(",").length == LIMIT_CONDITION_COUNT) {
                String key = productId.toString() +":"+ sb;
                // 获取记录的数量
                Integer hasBuy = SgRedisMode.getRedisOrderLimit(RedisConstants.ORDER_LIMIT_KEY_NEW_NEW+key.toString());
                int num = orderProduct.getNumber();
                // 扣减取消的数量
                if (hasBuy != null) {
                    num = hasBuy - num;
                    if (num < 0) {
                        num = 0;
                    }
                    // 将减完的数量记录到redis
                    clearR = SgRedisMode.putRedisOrderLimit(RedisConstants.ORDER_LIMIT_KEY_NEW_NEW+key, num, getTimeOut());
                    log.info("取消订单释放下单限制,mobile:" + limitVo.getMobile() +"，hasBuy:"+hasBuy+"，limitKey:"+key);
                }
            }
        }
        return clearR;
    }
    
    
    /**
     * 获取到今日24时的秒数差
     * @return
     */
    private long getTimeOut() {
        long time = 60000L;
        Calendar cand = Calendar.getInstance();
        cand.setTime(new Date());
        cand.set(Calendar.HOUR_OF_DAY, 23);
        cand.set(Calendar.MINUTE, 59);
        cand.set(Calendar.SECOND, 59);
        long endTime = cand.getTime().getTime();
        time = (endTime - System.currentTimeMillis()) / 1000;
        return time;
    }
    
}
