package com.haier.m.model.region;

import com.haier.m.dao.shop.read.RegionReadDao;
import com.haier.m.entity.region.PcrsRegion;
import com.haier.m.entity.region.Region;
import com.haier.m.entity.region.RegionRedis;
import com.haier.m.model.redis.SgRedisMode;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

import static com.haier.m.util.ItemConstants.MUNICIPALITY_MAPS;

@Component
public class RegionModel {
	 private Logger                   log = LoggerFactory.getLogger(RegionModel.class);
	@Resource
	private RegionReadDao regionReadDao;

	public List<Region>  getAllRegions() {
		List<Region> allRegionTreeList = null;
		try {
			long startTime =System.currentTimeMillis();
			List<Region> redisRegionAllList = SgRedisMode.getRedisRegions();
			if(redisRegionAllList!=null){
//                log.info("从redis里面取出省市区嵌套树成功。直接返回,耗时："+(System.currentTimeMillis()-startTime));
                return redisRegionAllList;
            }
//			log.info("从redis里面取出省市区嵌套树失败，开始从数据库中读取并拼接。");
			// 加载所有省份信息
			List<Region> regionProviceList = regionReadDao.getProvinces();

			Set<Integer> provinceIds = getRegionIds(regionProviceList);

			// 加载所有的城市信息
			List<Region> regionCityList = regionReadDao.getCities(provinceIds);
			Set<Integer> cityIds = getRegionIds(regionCityList);

			// 加载所有区级信息
			List<Region> regionRegionList = regionReadDao.getRegions(cityIds);
			Set<Integer> regionIds = getRegionIds(regionRegionList);
			// 加载所有区级信息
			List<Region> regionStreetList = regionReadDao.getRegions(regionIds);

			// 构建省市区--(镇 标志性建筑) 树形结构
			allRegionTreeList = buildAllRegionTree(regionProviceList, regionCityList,
            regionRegionList,regionStreetList);
//			log.info("从redis里面取出省市区嵌套树成功。拼接完成,耗时："+(System.currentTimeMillis()-startTime));
			SgRedisMode.addRedisRegions(allRegionTreeList);
//			log.info("从redis里面取出省市区嵌套树成功。拼接后存储到redis完成,耗时："+(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("从redis里面取出省市区嵌套树报错：",e);
			// 加载所有省份信息
			List<Region> regionProviceList = regionReadDao.getProvinces();

			Set<Integer> provinceIds = getRegionIds(regionProviceList);

			// 加载所有的城市信息
			List<Region> regionCityList = regionReadDao.getCities(provinceIds);
			Set<Integer> cityIds = getRegionIds(regionCityList);

			// 加载所有区级信息
			List<Region> regionRegionList = regionReadDao.getRegions(cityIds);
			Set<Integer> regionIds = getRegionIds(regionRegionList);
			// 加载所有区级信息
			List<Region> regionStreetList = regionReadDao.getRegions(regionIds);

			// 构建省市区--(镇 标志性建筑) 树形结构
			allRegionTreeList = buildAllRegionTree(regionProviceList, regionCityList,
					regionRegionList,regionStreetList);

		}
		return allRegionTreeList;
	}

	public List<Region> getAllRegionsNoContainStreet() {
		List<Region> allRegionTreeList = null;
		try {
			long startTime= System.currentTimeMillis();
			List<Region> redisRegionAllList = SgRedisMode.getRedisRegionsNotContainStreet();
			if(redisRegionAllList!=null){
//                log.info("从redis里面取出省市区(不带街道的)成功，直接返回，耗时："+(System.currentTimeMillis()-startTime));
                return redisRegionAllList;
            }
			// 加载所有省份信息
			//		List<Region> regionProviceList = SgRedisMode.getRedisList(RedisConstants.REGION_PROVINCE);
			//		if(regionProviceList==null||regionProviceList.size()==0){
			//			regionProviceList=regionReadDao.getProvinces();
			//			SgRedisMode.addRedisList(regionProviceList,RedisConstants.REGION_PROVINCE);
			//		}
			//		Set<Integer> provinceIds = SgRedisMode.getRedisSet(RedisConstants.REGION_PROVINCE);
			//		if(provinceIds==null||provinceIds.size()==0){
			//			provinceIds=getRegionIds(regionProviceList);
			//			SgRedisMode.addRedisSet(provinceIds,RedisConstants.REGION_PROVINCE);
			//		}
			//
			//		// 加载所有的城市信息
			//		List<Region> regionCityList = SgRedisMode.getRedisList(RedisConstants.REGION_CITY);
			//		if(regionCityList==null||regionCityList.size()==0){
			//			regionCityList=regionReadDao.getCities(provinceIds);
			//			SgRedisMode.addRedisList(regionCityList,RedisConstants.REGION_CITY);
			//		}
			//
			//		Set<Integer> cityIds = SgRedisMode.getRedisSet(RedisConstants.REGION_CITY);
			//		if(cityIds==null||cityIds.size()==0){
			//			cityIds=getRegionIds(regionCityList);
			//			SgRedisMode.addRedisSet(cityIds,RedisConstants.REGION_PROVINCE);
			//		}
			//
			//
			//		// 加载所有区级信息
			//		List<Region> regionRegionList = SgRedisMode.getRedisList(RedisConstants.REGION_REGION);
			//		if(regionRegionList==null||regionRegionList.size()==0){
			//			regionRegionList=regionReadDao.getRegions(cityIds);
			//			SgRedisMode.addRedisList(regionRegionList,RedisConstants.REGION_REGION);
			//		}

//			log.info("从redis里面取出省市区(不带街道的)失败，开始从数据库中读取并拼接。");
			// 加载所有省份信息
			List<Region> regionProviceList = regionReadDao.getProvinces();

			Set<Integer> provinceIds = getRegionIds(regionProviceList);

			// 加载所有的城市信息
			List<Region> regionCityList = regionReadDao.getCities(provinceIds);
			Set<Integer> cityIds = getRegionIds(regionCityList);

			// 加载所有区级信息
			List<Region> regionRegionList = regionReadDao.getRegions(cityIds);

			// 构建省市区--(镇 标志性建筑) 树形结构
			allRegionTreeList = buildAllRegionTreeNotContainStreet(regionProviceList, regionCityList,
                    regionRegionList);
//			log.info("从redis里面取出省市区(不带街道的)失败后，拼接完成,耗时："+(System.currentTimeMillis()-startTime));
			SgRedisMode.addRedisRegionsNotContainStreet(allRegionTreeList);
//			log.info("从redis里面取出省市区(不带街道的)失败后。拼接后存储到redis完成,耗时："+(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("从redis里面取出省市区(不带街道的)报错：",e);
			// 加载所有省份信息
			List<Region> regionProviceList = regionReadDao.getProvinces();

			Set<Integer> provinceIds = getRegionIds(regionProviceList);

			// 加载所有的城市信息
			List<Region> regionCityList = regionReadDao.getCities(provinceIds);
			Set<Integer> cityIds = getRegionIds(regionCityList);

			// 加载所有区级信息
			List<Region> regionRegionList = regionReadDao.getRegions(cityIds);

			// 构建省市区--(镇 标志性建筑) 树形结构
			allRegionTreeList = buildAllRegionTreeNotContainStreet(regionProviceList, regionCityList,
					regionRegionList);
		}
		return allRegionTreeList;
	}


	private Set<Integer> getRegionIds(List<Region> regionList) {
		Set<Integer> ids = new HashSet<Integer>();
		if (regionList != null && regionList.size() > 0) {
			for (Region region : regionList) {
				ids.add(region.getId());
			}
		}
		return ids;
	}

	/**
	 * 构建省市区 || 镇 标志性建筑 地区树形
	 * 
	 * @param regionProviceList
	 * @param regionCityList
	 * @param regionRegionList
	 * @return
	 */
	private List<Region> buildAllRegionTree(List<Region> regionProviceList,
			List<Region> regionCityList, List<Region> regionRegionList,
			List<Region> regionStreetList) {
		if (regionProviceList == null)
			return new ArrayList<Region>(0);
		List<Region> allRegionTreeList = new ArrayList<Region>(
				regionProviceList.size());
		for (Region proviceRegion : regionProviceList) {
			Integer provinceId = proviceRegion.getId();
			List<Region> regionProvinceChildList = SgRedisMode.getReRegionsParentId(provinceId.toString());
			if(null==regionProvinceChildList||!(regionProvinceChildList.size()>0)){
				regionProvinceChildList=new ArrayList<Region>();
				for (int c = 0; c < regionCityList.size(); c++) {
					Region regionCity = regionCityList.get(c);
					if (regionCity.getParentId() != provinceId) {
						continue;
					}
					Integer cityId = regionCity.getId();// 市ID
//					List<Region> regionCityChildList = SgRedisMode.getReRegionsParentId(cityId.toString());
					List<Region> regionCityChildList =new ArrayList<Region>();
					if(null==regionCityChildList||!(regionCityChildList.size()>0)){
						regionCityChildList=new ArrayList<Region>();
						for (int r = 0; r < regionRegionList.size(); r++) {
							Region regionRegion = regionRegionList.get(r);
							if (regionRegion.getParentId() != cityId) {
								continue;
							}
							Integer regionId = regionRegion.getId();// 市ID
//							List<Region> regionRegionChildList = SgRedisMode.getReRegionsParentId(regionId.toString());
							List<Region> regionRegionChildList = new ArrayList<Region>();
							if(null==regionRegionChildList||!(regionRegionChildList.size()>0)){
								regionRegionChildList=new ArrayList<Region>();
								for (int i = 0; i < regionStreetList.size(); i++) {
									Region regionStreet = regionStreetList.get(i);
									if (regionStreet.getParentId() == regionId) {
										regionRegionChildList.add(regionStreet); // 组装市区
									}
//									SgRedisMode.addReRegions(regionId.toString(),regionRegionChildList);
								}
							}
							regionRegion.setChilds(regionRegionChildList);
							if (regionRegion.getParentId() == cityId) {
								regionCityChildList.add(regionRegion); // 组装市区
							}
						}
//						SgRedisMode.addReRegions(cityId.toString(),regionCityChildList);
					}


					regionCity.setChilds(regionCityChildList);
					if (regionCity.getParentId() == provinceId
						&& regionCityChildList.size() > 0) {// 当前市parent为该省ID,则组装
						regionProvinceChildList.add(regionCity);
					}
				}
//				SgRedisMode.addReRegions(provinceId.toString(),regionProvinceChildList);
			}

			proviceRegion.setChilds(regionProvinceChildList);
			if (regionProvinceChildList.size() > 0) {
				allRegionTreeList.add(proviceRegion);
			}
		}
		return allRegionTreeList;
	}



	/**
	 * 构建省市区 || 镇 标志性建筑 地区树形 不包含街道
	 *
	 * @param regionProviceList
	 * @param regionCityList
	 * @param regionRegionList
	 * @return
	 */
	private List<Region> buildAllRegionTreeNotContainStreet(List<Region> regionProviceList,
															List<Region> regionCityList, List<Region> regionRegionList) {
		if (regionProviceList == null)
			return new ArrayList<Region>(0);
		List<Region> allRegionTreeList = new ArrayList<Region>(
				regionProviceList.size());

		for (Region proviceRegion : regionProviceList) {
			Integer provinceId = proviceRegion.getId();
//			List<Region> regionProvinceChildList = SgRedisMode.getReRegionsParentId(RedisConstants.REDIONS_NO_STREET+provinceId.toString());
			List<Region> regionProvinceChildList = new ArrayList<Region>();
			if(null==regionProvinceChildList||!(regionProvinceChildList.size()>0)){
				regionProvinceChildList=new ArrayList<Region>();
				for (int c = 0; c < regionCityList.size(); c++) {
					Region regionCity = regionCityList.get(c);
					if (regionCity.getParentId() != provinceId) {
						continue;
					}
					Integer cityId = regionCity.getId();// 市ID
//					List<Region> regionCityChildList=SgRedisMode.getReRegionsParentId(RedisConstants.REDIONS_NO_STREET+cityId.toString());
					List<Region> regionCityChildList=new ArrayList<Region>();
					if(null==regionCityChildList||!(regionCityChildList.size()>0)){
						regionCityChildList = new ArrayList<Region>();
						for (int r = 0; r < regionRegionList.size(); r++) {
							Region regionRegion = regionRegionList.get(r);
							if (regionRegion.getParentId() != cityId) {
								continue;
							}
							regionCityChildList.add(regionRegion); // 组装市区
						}
//						SgRedisMode.addReRegions(RedisConstants.REDIONS_NO_STREET+cityId.toString(),regionCityChildList);
					}
					regionCity.setChilds(regionCityChildList);
					if (regionCity.getParentId() == provinceId
						&& regionCityChildList.size() > 0) {// 当前市parent为该省ID,则组装
						regionProvinceChildList.add(regionCity);
					}
				}
//				SgRedisMode.addReRegions(RedisConstants.REDIONS_NO_STREET+provinceId.toString(),regionProvinceChildList);
			}
			proviceRegion.setChilds(regionProvinceChildList);
			if (regionProvinceChildList.size() > 0) {
				allRegionTreeList.add(proviceRegion);
			}
		}
		return allRegionTreeList;
	}

	/**
	 * 根据地区Id获取省市区名称
	 *
	 * @param id
	 * @return
	 */
	public Region getRegionNameById(Integer id) {
		return regionReadDao.getRegionNameById(id);
	}


	/**
	 * 缓存所有的区和街道
	 *
	 * @return
	 */
	public Map<Integer,String> getAllRegionAndStreet() {
		Map<Integer,String> map= null;
		try {
			long startTime = System.currentTimeMillis();
			map = SgRedisMode.getRedisRegionAndStreetMap();
			if(null==map){
//                log.info("从redis里面取出缓存的所有的区和街道失败，准备开始从数据库读取并存储,总耗时："+(System.currentTimeMillis()-startTime));
                List<Region> list=regionReadDao.getAllRegionAndStreet();
//                log.info("从redis里面取出缓存的所有的区和街道失败，从数据库读取成功,总耗时："+(System.currentTimeMillis()-startTime));
                SgRedisMode.addRedisRegionAndStreetMap(list);
//                log.info("从redis里面取出缓存的所有的区和街道失败，存入redis成功,总耗时："+(System.currentTimeMillis()-startTime));
                map=SgRedisMode.getRedisRegionAndStreetMap();
//                log.info("从redis里面取出缓存的所有的区和街道失败，再从redis取出（直接取出Map类型）成功,总耗时："+(System.currentTimeMillis()-startTime));
            }
//            else{
//                log.info("从redis里面取出缓存的所有的区和街道成功，直接返回,总耗时："+(System.currentTimeMillis()-startTime));
//            }
		} catch (Exception e) {
			log.error("从redis里面取出缓存的所有的区和街道报错：",e);
			map = new HashMap<Integer, String>();
			List<Region> list=regionReadDao.getAllRegionAndStreet();
			for(Region region:list){
				map.put(region.getId(),region.getRegionName());
			}
		}
		return map;
	}


	/**
	 * 根据地区Id批量获取地区名称
	 *
	 * @param ids
	 * @return
	 */
	public Map<Integer,String> getRedisRegionNameByIds(List<Integer> ids) throws Exception {
        Map<Integer,String> map=null;
        if(null!=ids&&ids.size()>0){
			try {
				Set<Integer> idsSet =new HashSet<Integer>();
				idsSet.addAll(ids);
				Set<Integer> idRedisSet=SgRedisMode.getRedisIdsSet();
				if(null==idRedisSet){
                    SgRedisMode.addRedisIdsSet(idsSet);
                    map=new HashMap<Integer, String>();
                    List<RegionRedis> regionRedisList=regionReadDao.getRegionNameByIds(idsSet);
                    if ( null !=regionRedisList && regionRedisList.size() > 0) {
                        for (RegionRedis regionRedis : regionRedisList) {
                            if(!map.containsKey(regionRedis.getId())){
                                map.put(regionRedis.getId(),regionRedis.getRegionName());
                            }
                        }
                    }
                    SgRedisMode.addRedisRegionMap(regionRedisList);
                    return map;
                }else{
                    Map<Integer,String> map0= new HashMap<Integer, String>();
                    Set<Integer> in_redis = new HashSet<Integer>();
                    Set<Integer> not_in_idsSet = new HashSet<Integer>();

                    for(Integer id:idsSet){
                        if(idRedisSet.contains(id)){
                            in_redis.add(id);
                        }else{
                            not_in_idsSet.add(id);
                        }
                    }
                    map=SgRedisMode.getRedisRegionsMap();

                    if(in_redis.size()>0) {
                        for (Integer id : in_redis) {
                            map0.put(id, map.get(id));
                        }
                    }
                    if(not_in_idsSet.size()>0) {
                        //剩余的去查询出来并放到redis和返回结果集中
                        List<RegionRedis> regionRedisList = regionReadDao.getRegionNameByIds(not_in_idsSet);
                        SgRedisMode.addRedisRegionMap(regionRedisList);

                        if (null != regionRedisList && regionRedisList.size() > 0) {
                            for (RegionRedis regionRedis : regionRedisList) {
                                if (!map0.containsKey(regionRedis.getId())) {
                                    map0.put(regionRedis.getId(), regionRedis.getRegionName());
                                }
                            }
                        }

                    }
                    return map0;
                }
			} catch (Exception e) {
				throw new Exception("根据地区Id批量获取地区名称异常。",e);
			}
		}else{
            throw new Exception("根据地区Id批量获取地区名称异常，参数为空。");
        }
	}


	/**
	 * 根据地区Id批量获取地区对象
	 *
	 * @param ids
	 * @return
	 */
	public List<RegionRedis> getRedisRegionByIds(List<Integer> ids) throws Exception {
		List<RegionRedis> idRedisList =null;
		if(null!=ids&&ids.size()>0){
			try {
				Set<Integer> idsSet =new HashSet<Integer>();
				idsSet.addAll(ids);

				String key="";
				for (Integer id:idsSet){
					key+=id+"|";
				}
				if(key!=null&&!key.isEmpty()){
					key=key.substring(0,key.length()-1);
				}

				idRedisList=SgRedisMode.getRedisRegionsByIds(key);
				if(null==idRedisList){
					idRedisList=regionReadDao.getRegionNameByIds(idsSet);
					if ( null !=idRedisList && idRedisList.size() > 0) {
						SgRedisMode.addRedisRegions(key,idRedisList);
					}
				}
			} catch (Exception e) {
				throw new Exception("根据地区Id批量获取地区对象异常。",e);
			}
		}else{
			throw new Exception("根据地区Id批量获取地区对象异常，参数为空。");
		}
		return idRedisList;
	}


	/**
	 * 根据父节点获取地区信息
	 */
	public List<Region> getRegionByPid(String pId) {
		return regionReadDao.getRegionByPid(pId);
	}

	/**
	 * 清除redis根据父节点获取地区信息
	 */
	public void removeRegionByParentId(String key) {
		SgRedisMode.removeRedisRegionsParentId(key);
	}

	/**
	 * 根据父节点获取地区信息(redis)
	 */
	public List<RegionRedis> getRegionByParentId(String parentId) {
		List<RegionRedis> regionRedisList= null;
		try {
			long startTime =System.currentTimeMillis();
			regionRedisList = SgRedisMode.getRedisRegionsParentId(parentId);
			if(regionRedisList!=null&&!regionRedisList.isEmpty()){
//                log.info("从redis里面取出（根据父节点获取地区信息）成功,总耗时："+(System.currentTimeMillis()-startTime));
                return regionRedisList;
            }
			regionRedisList=regionReadDao.getRegionByParentId(parentId);
//			log.info("从redis里面取出（根据父节点获取地区信息）失败后从数据库读取成功,总耗时："+(System.currentTimeMillis()-startTime));
			SgRedisMode.addRedisRegions(parentId,regionRedisList);
//			log.info("从redis里面取出（根据父节点获取地区信息）失败后从数据库读取成功，存入redis成功,总耗时："+(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("从redis里面取出（根据父节点获取地区信息）异常，报错：",e);
			regionRedisList=regionReadDao.getRegionByParentId(parentId);
		}

		/*方便兼容之前的获取省市区方法*/
//		List<Region> regionList=new ArrayList<Region>();
//		for(RegionRedis regionRedis:regionRedisList){
//			Region region= new Region();
//			region.setId(regionRedis.getId());
//			region.setRegionName(regionRedis.getRegionName());
//			regionList.add(region);
//		}
//		SgRedisMode.addReRegions(parentId,regionList);

		return regionRedisList;
	}


	/**
	 * 根据父节点获取地区信息(redis)  优化后的方法
	 */
	public List<RegionRedis> getRegionByParentIdAndRegionType(String parentId,Integer regionType) {
		List<RegionRedis> regionRedisList= null;
		try {
			long startTime =System.currentTimeMillis();
			regionRedisList = SgRedisMode.getRedisParentRegionsList(parentId);
			if(regionRedisList!=null&&!regionRedisList.isEmpty()){
				//                log.info("从redis里面取出（根据父节点获取地区信息）成功,总耗时："+(System.currentTimeMillis()-startTime));
				return regionRedisList;
			}
			regionRedisList=selectParentRegionByType(parentId,regionType);
			//			log.info("从redis里面取出（根据父节点获取地区信息）失败后从数据库读取成功,总耗时："+(System.currentTimeMillis()-startTime));
			SgRedisMode.addRedisParentRegionsList(parentId,regionRedisList);
			//			log.info("从redis里面取出（根据父节点获取地区信息）失败后从数据库读取成功，存入redis成功,总耗时："+(System.currentTimeMillis()-startTime));
		} catch (Exception e) {
			log.error("从redis里面取出（根据父节点获取地区信息）优化后的方法异常，报错：",e);
			regionRedisList=selectParentRegionByType(parentId,regionType);
		}

		/*方便兼容之前的获取省市区方法*/
		//		List<Region> regionList=new ArrayList<Region>();
		//		for(RegionRedis regionRedis:regionRedisList){
		//			Region region= new Region();
		//			region.setId(regionRedis.getId());
		//			region.setRegionName(regionRedis.getRegionName());
		//			regionList.add(region);
		//		}
		//		SgRedisMode.addReRegions(parentId,regionList);

		return regionRedisList;
	}

	private List<RegionRedis> selectParentRegionByType(String parentId,Integer regionType){
		List<RegionRedis> list =new ArrayList<RegionRedis>();
		List<RegionRedis> municipalityCity =new ArrayList<RegionRedis>();
		List<RegionRedis> provinceCity =new ArrayList<RegionRedis>();
		if(regionType==0){
			//查所有省
			list=regionReadDao.getRegionByParentId(parentId);
			for(RegionRedis regionRedis:list){
				if(MUNICIPALITY_MAPS.containsValue(regionRedis.getRegionName())){
					municipalityCity.add(regionRedis);
				}else{
					provinceCity.add(regionRedis);
				}
			}
			municipalityCity.addAll(provinceCity);
			list=municipalityCity;
		}else if(regionType==1){
			//省查市
			list=regionReadDao.getRegionByParentIdAndThird(parentId);
		}else if(regionType==2){
			//市查区
			list=regionReadDao.getRegionByParentIdAndSecond(parentId);
		}else if(regionType==3){
			//区查街道
			list=regionReadDao.getRegionByParentId(parentId);
		}
		return list;
	}



	//	@PostConstruct
//    public void addRedisInit() {
//    	log.info("缓存省市区信息开始。");
//    	SgRedisMode.addRedisRegions(null);
//    	getAllRegions();
//    	log.info("缓存省市区信息结束!");
//    }

	/**
	 *
	 * @param code
	 * @param streetName
	 * @return
	 */
    public PcrsRegion getStreetByNameAndCode(String code, String streetName) {
		PcrsRegion region = regionReadDao.getRegionByCode(code);
		if (region != null) {
			if (streetName != null) {
				if (streetName.endsWith("镇")) {
					streetName = streetName.substring(0, streetName.indexOf("镇"));
				} else if (streetName.contains("街道")) {
					streetName = streetName.substring(0, streetName.indexOf("街道"));
				}
				List<Region> street = regionReadDao.getRegionByName(streetName, region.getRegionId());
				if (street.size() > 0) {
					region.setStreetId(String.valueOf(street.get(0).getId()));
				}
			}
		}
		return region;
	}

    /**
	 *
	 * @param code
	 * @param streetName
	 * @return
	 */
   public Integer getStreetByNameAndPid(Integer pid, String streetName) {
	   Integer streetId = null;
	   if (streetName != null) {
		   List<Region> street = regionReadDao.getRegionByName(streetName, String.valueOf(pid));
		   if (street.size() > 0) {
			   streetId = street.get(0).getId();
		   }
	   }
	   return streetId;
	}
}
