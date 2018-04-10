package com.haier.m.dao.shop.read;

import java.util.List;
import java.util.Set;

import com.haier.m.entity.region.PcrsRegion;
import com.haier.m.entity.region.Region;

import com.haier.m.entity.region.RegionRedis;
import org.apache.ibatis.annotations.Param;

public interface RegionReadDao {

    /**
     * 获取所有省份
     * 
     * @return
     */
    List<Region> getProvinces();


    /**
     * 获取所有区和街道
     *
     * @return
     */
    List<Region> getAllRegionAndStreet();

    /**
     * 根据省份获取所有市信息
     * 
     * @param provinceIds
     * @return
     */
    List<Region> getCities(@Param("set") Set<Integer> provinceIds);

    /**
     * 根据省份获取所有市信息
     * 
     * @param cityIds
     * @return
     */
    List<Region> getRegions(@Param("set") Set<Integer> cityIds);

    /**
     * 根据地区Id获取省市区名称
     * @param id
     * @return
     */
    Region getRegionNameById(Integer id);


    /**
     * 根据地区Id批量获取地区名称
     * @param id
     * @return
     */
    List<RegionRedis> getRegionNameByIds(@Param("ids") Set<Integer> ids);

    /**
     * 根据父节点获取地区信息
     */
    List<Region> getRegionByPid(String pId);


    /**
     * 根据父节点获取地区信息(redis)  用于直接查全部省 以及区查街道
     */
    List<RegionRedis> getRegionByParentId(String pId);


    /**
     * 根据父节点获取地区信息(redis) 二层嵌套 用于市查区
     */
    List<RegionRedis> getRegionByParentIdAndSecond(String pId);


    /**
     * 根据父节点获取地区信息(redis) 三层嵌套  用于省查市
     */
    List<RegionRedis> getRegionByParentIdAndThird(String pId);


    /**
     * 获取所有地址信息
     * 
     * @return
     */
    List<Region> getRegionsAll();

    /**
     *  根据国标码获取区域信息
     *
     * @return
     */
    PcrsRegion getRegionByCode(@Param("code") String code);

    /**
     * 根据区域名称获取区域信息
     * @param name
     * @return
     */
    List<Region> getRegionByName(@Param("name") String name,
                                 @Param("regionId") String regionId);



}
