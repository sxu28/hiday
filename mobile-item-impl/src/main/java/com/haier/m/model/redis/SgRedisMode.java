package com.haier.m.model.redis;

import com.haier.m.entity.item.Brand;
import com.haier.m.entity.order.OpAttribute;
import com.haier.m.entity.region.Region;
import com.haier.m.entity.region.RegionRedis;
import com.haier.m.tiemredis.Cache;
import com.haier.m.tiemredis.CacheFactory;
import com.haier.m.util.RedisConstants;
import com.haier.sg.enums.RedisKeysEnums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import org.springframework.stereotype.Component;
/**
 * 
 * @author 11150221050074
 *
 */

@Component
public class SgRedisMode {
    private static Logger log= LoggerFactory.getLogger(SgRedisMode.class);
    private static Cache  cache = CacheFactory.getCache("redis");

    /**
     * 缓存省市区街道信息
     * @param regions
     * @return
     */
    public static boolean addRedisRegions(List<Region> regions){
    	return cache.putObject(RedisConstants.SGREGIONS+RedisConstants.REDIONS, regions, RedisConstants.TIME_OUT);
    }
    /**
     * 获取省市区街道信息 为空返回null
     * @return
     */
    public static List<Region> getRedisRegions(){
    	Object obj=cache.getObject(RedisConstants.SGREGIONS+RedisConstants.REDIONS);
    	if(obj!=null){
    		List<Region> list= (List<Region>) obj;
    		return list;
    	}else{
    		return null;
    	}
    }



    /**
     * 缓存省市区街道信息 (不带街道)
     * @param regions
     * @return
     */
    public static boolean addRedisRegionsNotContainStreet(List<Region> regions){
        return cache.putObject(RedisConstants.SGREGIONS+RedisConstants.REDIONS_NO_STREET, regions, RedisConstants.TIME_OUT);
    }

    /**
     * 获取省市区街道信息 为空返回null  (不带街道)
     * @return
     */
    public static List<Region> getRedisRegionsNotContainStreet(){
        Object obj=cache.getObject(RedisConstants.SGREGIONS+RedisConstants.REDIONS_NO_STREET);
        if(obj!=null){
            List<Region> list= (List<Region>) obj;
            return list;
        }else{
            return null;
        }
    }


    /**
     * 缓存省市区街道信息
     * @param ids
     * @return
     */
    public static boolean addRedisSet(Set<Integer> ids,String flag){
        return cache.putObject(RedisConstants.SGREGIONS+"SET"+flag, ids, RedisConstants.TIME_OUT);
    }
    /**
     * 获取省市区街道信息 为空返回null
     * @return
     */
    public static Set<Integer> getRedisSet(String flag){
        Object obj=cache.getObject(RedisConstants.SGREGIONS+"SET"+flag);
        if(obj!=null){
            Set<Integer> set= (Set<Integer>) obj;
            return set;
        }else{
            return null;
        }
    }


    /**
     * 缓存省市区街道信息
     * @param ids
     * @return
     */
    public static boolean addRedisList(List<Region> ids,String flag){
        return cache.putObject(RedisConstants.SGREGIONS+"LIST"+flag, ids, RedisConstants.TIME_OUT);
    }
    /**
     * 获取省市区街道信息 为空返回null
     * @return
     */
    public static List<Region> getRedisList(String flag){
        Object obj=cache.getObject(RedisConstants.SGREGIONS+"LIST"+flag);
        if(obj!=null){
            List<Region> list= (List<Region>) obj;
            return list;
        }else{
            return null;
        }
    }



    /**
     * 缓存父节点查询地区信息信息(存入redis)
     * @param key
     * @param regionsRedis
     * @return
     */
    public static boolean addRedisRegions(String key,List<RegionRedis> regionsRedis){
        return cache.putObject(RedisConstants.SGREGIONS+key, regionsRedis, RedisConstants.TIME_OUT);
    }

    /**
     * 获取缓存父节点查询地区信息信息 为空返回null
     * @return
     */
    public static List<RegionRedis> getRedisRegionsParentId(String key){
        Object obj=cache.getObject(RedisConstants.SGREGIONS+key);
        if(obj!=null){
            List<RegionRedis> list= (List<RegionRedis>) obj;
            return list;
        }else{
            return null;
        }
    }


    /**
     * 缓存父节点查询地区信息信息(存入redis)  优化后的方法
     * @param key
     * @param regionsRedis
     * @return
     */
    public static boolean addRedisParentRegionsList(String key,List<RegionRedis> regionsRedis){
        return cache.putObject(RedisConstants.SGPARENTREGIONS+key, regionsRedis, RedisConstants.TIME_OUT);
    }

    /**
     * 获取缓存父节点查询地区信息信息 为空返回null  优化后的方法
     * @return
     */
    public static List<RegionRedis> getRedisParentRegionsList(String key){
        Object obj=cache.getObject(RedisConstants.SGPARENTREGIONS+key);
        if(obj!=null){
            List<RegionRedis> list= (List<RegionRedis>) obj;
            return list;
        }else{
            return null;
        }
    }





    /**
     * 缓存父节点查询地区信息信息(存入redis，存入之前的Regions)
     * @param key
     * @param regionsRedis
     * @return
     */
    public static boolean addReRegions(String key,List<Region> regionsRedis){
        return cache.putObject(RedisConstants.SGREGIONS+RedisConstants.PREREGIONS+key, regionsRedis, RedisConstants.TIME_OUT);
    }


    /**
     * 获取缓存父节点查询地区信息信息 为空返回null  存入之前的Regions
     * @return
     */
    public static List<Region> getReRegionsParentId(String key){
        Object obj=cache.getObject(RedisConstants.SGREGIONS+RedisConstants.PREREGIONS+key);
        if(obj!=null){
            List<Region> list= (List<Region>) obj;
            return list;
        }else{
            return null;
        }
    }




    /**
     * 缓存品牌查询信息(存入redis)
     * @param brandRedis
     * @return
     */
    public static boolean addRedisBrand(List<Brand> brandRedis){
        return cache.putObject(RedisConstants.SGREGIONS+RedisConstants.ALLBRAND, brandRedis, RedisConstants.TIME_OUT);
    }

    /**
     * 获取缓存父节点查询地区信息信息 为空返回null
     * @return
     */
    public static List<Brand> getRedisBrand(){
        Object obj=cache.getObject(RedisConstants.SGREGIONS+RedisConstants.ALLBRAND);
        if(obj!=null){
            List<Brand> list= (List<Brand>) obj;
            return list;
        }else{
            return null;
        }
    }



    /**
     * 缓存省市区街道信息
     * @param regions
     * @return
     */
    public static boolean addRedisIdsSet(Set<Integer> ids){
        cache.removeObject(RedisConstants.SGREGIONS+RedisConstants.REIDS);
        return cache.putObject(RedisConstants.SGREGIONS+RedisConstants.REIDS, ids, RedisConstants.TIME_OUT);
    }
    /**
     * 获取省市区街道信息 为空返回null
     * @return
     */
    public static Set<Integer> getRedisIdsSet(){
        Object obj=cache.getObject(RedisConstants.SGREGIONS+RedisConstants.REIDS);
        if(obj!=null){
            Set<Integer> list= (Set<Integer>) obj;
            return list;
        }else{
            return null;
        }
    }


    /**
     * 获取省市区街道信息 为空返回null
     * @return
     */
    public static Map<Integer,String> getRedisRegionsMap(){
        Set<Map.Entry<Object,Object>> obj=cache.getAllFromMap(RedisConstants.SGREGIONSMAP);
        if(obj!=null){
            Map<Integer,String> map0=new HashMap<Integer, String>();
            for(Map.Entry<Object,Object> map01:obj){
                map0.put(Integer.parseInt((String)map01.getKey()),(String)map01.getValue());
            }
            return map0;
        }else{
            return null;
        }
    }

    /**
     * 缓存省市区街道信息
     * @param regions
     * @return
     */
    public static boolean addRedisRegionMap(List<RegionRedis> regionRedisAddList){
        Boolean flag=true;
        for(RegionRedis regionRedis:regionRedisAddList){
            String id=Integer.valueOf(regionRedis.getId()).toString();
            if(null==cache.getObjectFromMap(RedisConstants.SGREGIONSMAP,id)){
                flag=cache.putObjectToMap(RedisConstants.SGREGIONSMAP,id,regionRedis.getRegionName(),RedisConstants.TIME_OUT);
            }
        }
        return flag;
    }


    /**
     * 获取省市区街道list key为省市区街道key的拼接
     * @return
     */
    public static List<RegionRedis> getRedisRegionsByIds(String key){
        Object obj=cache.getObject(key);
        if(obj!=null){
            List<RegionRedis> list= (List<RegionRedis>) obj;
            return list;
        }else{
            return null;
        }
    }

    /**
     * 缓存省市区街道信息list key为省市区街道key的拼接
     * @param key
     * @param regionRedisAddList
     * @return
     */
    public static boolean addRedisRegionListMap(String key,List<RegionRedis> regionRedisAddList){
        Boolean flag=false;
        try {
            flag = cache.putObject(key, regionRedisAddList, RedisKeysEnums.REDIS_CACHE_NEVER_EXPIRE);
        } catch (Exception e) {
            log.error("缓存中放入街道信息list异常：", e);
        }
        return flag;
    }









    /**
     * 获取区和街道信息 为空返回null
     * @return
     */
    public static Map<Integer,String> getRedisRegionAndStreetMap(){
        Set<Map.Entry<Object,Object>> obj=cache.getAllFromMap(RedisConstants.SGREGIONSSTREETMAP);
        if(obj!=null){
            Map<Integer,String> map0=new HashMap<Integer, String>();
            for(Map.Entry<Object,Object> map01:obj){
                map0.put(Integer.parseInt((String)map01.getKey()),(String)map01.getValue());
            }
            return map0;
        }else{
            return null;
        }
    }

    /**
     * 缓存区和街道信息
     * @param regions
     * @return
     */
    public static boolean addRedisRegionAndStreetMap(List<Region> regionAddList){
        Boolean flag=true;
        for(Region region:regionAddList){
            String id=Integer.valueOf(region.getId()).toString();
            if(null==cache.getObjectFromMap(RedisConstants.SGREGIONSSTREETMAP,id)){
                flag=cache.putObjectToMap(RedisConstants.SGREGIONSSTREETMAP,id,region.getRegionName(),RedisConstants.TIME_OUT);
            }
        }
        return flag;
    }



    /**
     * 清除缓存父节点查询地区信息信息
     * 2017-11-13 模糊查询改为key准确删除
     * @return
     */
    public static void removeRedisRegionsParentId(String key){
        boolean removeObject = cache.removeObject(key);
        log.info("81redis的key:【"+key+"】，删除结果："+removeObject);
    }
    
    /**
     * 获取redis中存放的订单限制
     * @param key
     * @return
     */
    public static Integer getRedisOrderLimit(String key) {
    	Integer buyNum = null;
    	Object redisObject = cache.getObject(key);
    	if (redisObject != null) {
    		if (redisObject instanceof Integer) {
    			buyNum = (Integer) redisObject;
    		}
    	}
    	return buyNum;
    }
    
    /**
     * 更新缓存中用户在街道商品购买数量
     * @param key
     * @param num
     * @param timeOut
     * @return
     */
    public static boolean putRedisOrderLimit(String key, Integer num, long timeOut) {
    	return cache.putObject(key, num, timeOut);
    }
    
    
    /**
     * 更新缓存中商品限购数量的条件key
     * @param key
     * @param num
     * @param timeOut
     * @return
     */
    public static boolean putRedisOrderLimitCondition(String key, String condition, long timeOut) {
        return cache.putObject(key, condition, timeOut);
    }
    
    /**
     * 获取缓存中商品限购数量的条件key
     * @param key
     * @param num
     * @param timeOut
     * @return
     */
    public static String getRedisOrderLimitCondition(String key) {
        String condition = null;
        Object redisObject = cache.getObject(key);
        if (redisObject != null) {
            if (redisObject instanceof String) {
                condition = (String) redisObject;
            }
        }
        return condition;
    }

    public static OpAttribute getRedisOpAttribute(String key) {
    	OpAttribute attr = null;
    	try {
	    	Object redisObject = cache.getObject(key);
	    	if (redisObject != null && redisObject instanceof OpAttribute) {
	    		attr = (OpAttribute) attr;
	    	}
    	} catch (Exception e) {
    		log.error("从缓存中获取网单扩展属性异常：", e);
    	}
    	return attr;
    }
    
    public static void putRedisOpAttribute(String key, OpAttribute attr) {
    	try {
    		cache.putObject(key, attr, RedisKeysEnums.REDIS_CACHE_DEFAULT_MISS_TIME);
    	} catch (Exception e) {
    		log.error("缓存中放入网单扩展属性异常：", e);
    	}
    }
    public Object getSgStoreAttribute(String key) {
        Object sgStoreAttributeList = null;
        try {
            Object redisObject = cache.getObject(key);
            if (redisObject != null) {
                sgStoreAttributeList =  redisObject;
            }
        } catch (Exception e) {
            log.error("从缓存中获取商品属性组合属性异常：", e);
        }
        return sgStoreAttributeList;
    }

    public  void putSgStoreAttribute(String key, Object sgStoreAttributeList) {
        try {
            cache.putObject(key, sgStoreAttributeList, RedisKeysEnums.REDIS_CACHE_DEFAULT_MISS_TIME);
        } catch (Exception e) {
            log.error("缓存中放入商品属性组合属性异常：", e);
        }
    }
    public Boolean removeSgStoreAttribute(String key) {
        Boolean result = false;
        try {
            result = cache.removeObject(key);
        } catch (Exception e) {
            log.error("清除缓存中商品属性组合属性异常：", e);
        }
        return result;
    }
}
