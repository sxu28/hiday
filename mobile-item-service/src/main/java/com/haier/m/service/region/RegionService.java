package com.haier.m.service.region;

import com.haier.common.ServiceResult;
import com.haier.m.entity.region.PcrsRegion;
import com.haier.m.entity.region.Region;
import com.haier.m.entity.region.RegionRedis;

import java.util.List;
import java.util.Map;

public interface RegionService {

    /**
     * 获取所有省市区地址
     * 
     * @return
     */
    ServiceResult<List<Region>> getAllRegions();


    /**
     * 获取所有区和街道地址
     *
     * @return
     */
    ServiceResult<Map<Integer,String>> getAllRegionsAndStreet();

    /**
     * 获取所有省市区地址
     *
     * @return
     */
    ServiceResult<List<Region>> getAllRegionsNotContainStreet();


    /**
     * 根据地区Id获取省市区名称
     * @param id
     * @return
     */
    ServiceResult<Region> getRegionNameById(Integer id);

    /**
     * 根据地区Id获取省市区名称
     * @param id
     * @return
     */
    ServiceResult<Map<Integer,String>> getRegionNameByIds(List<Integer> ids);

    /**
     * 根据地区Ids获取region对象
     * @param ids
     * @return
     */
    ServiceResult<List<RegionRedis>> getRegionByIds(List<Integer> ids);


    /**
     * 据父节点获取地区信息
     */
    ServiceResult<List<Region>> getRegionByPid(String pId);

    /**
     * 据父节点获取地区信息(redis)
     */
    ServiceResult<List<RegionRedis>> getRegionByParentId(String parentId);


    /**
     * 据父节点获取地区信息(redis)  优化后的方法
     */
    ServiceResult<List<RegionRedis>> getRegionByParentIdAndRegionType(String parentId,Integer regionType);

    /**
     * 据父节点获取地区信息(redis)
     */
    void removeRedisRegionsParentId(String key);


    /**
     * 根据区国标码和街道名称获取省市区街道Id
     * @param code
     * @param streetName
     * @return
     */
    ServiceResult<PcrsRegion> getStreetByNameAndCode(String code, String streetName);
    
    /**
     * 根据上级id和名称获取街道Id
     * @param streetName
     * @param pId
     * @return
     */
    ServiceResult<Integer> getStreetByNameAndParentId(String streetName, Integer pId);
}
