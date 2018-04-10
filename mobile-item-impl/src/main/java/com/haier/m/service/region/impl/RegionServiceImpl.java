package com.haier.m.service.region.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.haier.common.BusinessException;
import com.haier.common.ServiceResult;
import com.haier.m.entity.region.PcrsRegion;
import com.haier.m.entity.region.Region;
import com.haier.m.entity.region.RegionRedis;
import com.haier.m.model.region.RegionModel;
import com.haier.m.service.region.RegionService;

@Service("regionService")
public class RegionServiceImpl implements RegionService {

    private static Logger log = LoggerFactory.getLogger(RegionServiceImpl.class);

    @Resource
    private RegionModel   regionModel;

    @Override
    public ServiceResult<List<Region>> getAllRegions() {
        ServiceResult<List<Region>> result = new ServiceResult<List<Region>>();
        try {
            result.setResult(regionModel.getAllRegions());
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("获取省市区列表发生异常！，" + e.getMessage());
            log.error("获取省市区列表发生异常", e);
        }
        return result;
    }

    @Override
    public ServiceResult<Map<Integer,String>> getAllRegionsAndStreet() {
        ServiceResult<Map<Integer,String>> result = new ServiceResult<Map<Integer,String>>();
        try {
            result.setResult(regionModel.getAllRegionAndStreet());
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("获取省市区列表发生异常！，" + e.getMessage());
            log.error("获取省市区列表发生异常", e);
        }
        return result;
    }



    @Override
    public ServiceResult<List<Region>> getAllRegionsNotContainStreet() {
        ServiceResult<List<Region>> result = new ServiceResult<List<Region>>();
        try {
            result.setResult(regionModel.getAllRegionsNoContainStreet());
        } catch (BusinessException be) {
            result.setSuccess(false);
            result.setMessage(be.getMessage());
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("获取省市区列表(不包含街道信息)发生异常！，" + e.getMessage());
            log.error("获取省市区列表(不包含街道信息)发生异常", e);
        }
        return result;
    }

    @Override
    public ServiceResult<Region> getRegionNameById(Integer id) {
        ServiceResult<Region> serviceResult = new ServiceResult<Region>();
        try {
            serviceResult.setResult(regionModel.getRegionNameById(id));
        } catch (Exception e) {
            log.error("根据地区Id获取省市区名称异常", e);
            serviceResult.setMessage("根据地区Id获取省市区名称异常");
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }


    @Override
    public ServiceResult<Map<Integer,String>> getRegionNameByIds(List<Integer> ids) {
        ServiceResult<Map<Integer,String>> serviceResult = new ServiceResult<Map<Integer,String>>();
        try {
            serviceResult.setResult(regionModel.getRedisRegionNameByIds(ids));
        } catch (Exception e) {
            log.error("根据地区Id批量获取地区名称异常", e);
            serviceResult.setMessage("根据地区Id批量获取地区名称异常");
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<RegionRedis>> getRegionByIds(List<Integer> ids) {
        ServiceResult<List<RegionRedis>> serviceResult = new ServiceResult<List<RegionRedis>>();
        try {
            serviceResult.setResult(regionModel.getRedisRegionByIds(ids));
        } catch (Exception e) {
            log.error("根据地区Id批量获取地区名称异常", e);
            serviceResult.setMessage("根据地区Id批量获取地区名称异常");
            serviceResult.setSuccess(false);
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<List<Region>> getRegionByPid(String pId) {
        ServiceResult<List<Region>> result = new ServiceResult<List<Region>>();
        try {
            result.setResult(regionModel.getRegionByPid(pId));
        } catch (Exception e) {
            log.error("根据父节点获取地区信息异常", e);
        }
        return result;
    }

    @Override
    public ServiceResult<List<RegionRedis>> getRegionByParentId(String parentId) {
        ServiceResult<List<RegionRedis>> result = new ServiceResult<List<RegionRedis>>();
        try {
            result.setResult(regionModel.getRegionByParentId(parentId));
        } catch (Exception e) {
            log.error("根据父节点获取地区信息异常", e);
        }
        return result;
    }


    @Override
    public ServiceResult<List<RegionRedis>> getRegionByParentIdAndRegionType(String parentId,Integer regionType) {
        ServiceResult<List<RegionRedis>> result = new ServiceResult<List<RegionRedis>>();
        try {
            result.setResult(regionModel.getRegionByParentIdAndRegionType(parentId,regionType));
        } catch (Exception e) {
            log.error("根据父节点获取地区信息异常", e);
        }
        return result;
    }



    @Override
    public void removeRedisRegionsParentId(String key) {
         regionModel.removeRegionByParentId(key);
    }

    /**
     * 根据区国标码和街道名称获取省市区街道Id
     * @param code
     * @param streetName
     * @return
     */
    @Override
    public ServiceResult<PcrsRegion> getStreetByNameAndCode(String code, String streetName) {
        ServiceResult<PcrsRegion> result = new ServiceResult<PcrsRegion>();
        try {
            result.setResult(regionModel.getStreetByNameAndCode(code, streetName));
        } catch (Exception e) {
            log.error("根据区国标码和街道名称获取省市区街道Id异常", e);
            result.setSuccess(false);
            result.setMessage("根据区国标码和街道名称获取省市区街道Id异常");
        }
        return result;
    }

	@Override
	public ServiceResult<Integer> getStreetByNameAndParentId(String streetName,
			Integer pId) {
		ServiceResult<Integer> result = new ServiceResult<Integer>();
        try {
            result.setResult(regionModel.getStreetByNameAndPid(pId, streetName));
        } catch (Exception e) {
            log.error("根据区id和街道名称获取省市区街道Id异常", e);
            result.setSuccess(false);
            result.setMessage("根据区id和街道名称获取省市区街道Id异常");
        }
        return result;
	}
}
