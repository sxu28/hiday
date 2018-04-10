package com.haier.m.model.brand;

import com.haier.m.dao.shop.read.BrandReadDao;
import com.haier.m.entity.item.Brand;
import com.haier.m.entity.region.RegionRedis;
import com.haier.m.model.redis.SgRedisMode;
import com.haier.m.model.region.RegionModel;
import com.haier.m.service.brand.BrandServiceM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Version: 1.0
 * @Author: liguohua 李国华
 * @Email: liguohua@uming.net
 */

@Component
public class BrandModelM {
    private Logger log = LoggerFactory.getLogger(BrandModelM.class);
    @Resource
    private BrandReadDao brandReadDao;

    public List<Brand> getBrandList(){
//        long startTime = System.currentTimeMillis();
//        List<Brand> brandRedisList= null;
//        try {
//            brandRedisList = SgRedisMode.getRedisBrand();
//            if(brandRedisList!=null&&!brandRedisList.isEmpty()){
//                log.info("从redis里面取出缓存的所有的品牌成功，直接返回,总耗时："+(System.currentTimeMillis()-startTime));
//                return brandRedisList;
//            }
//            log.info("从redis里面取出缓存的所有品牌失败，准备开始从数据库读取并存储,总耗时："+(System.currentTimeMillis()-startTime));
//            brandRedisList=brandReadDao.getBrandList();
//            log.info("从redis里面取出缓存的所有品牌失败，从数据库读取成功,总耗时："+(System.currentTimeMillis()-startTime));
//            SgRedisMode.addRedisBrand(brandRedisList);
//            log.info("从redis里面取出缓存的所有品牌失败，存储到redis成功,总耗时："+(System.currentTimeMillis()-startTime));
//        } catch (Exception e) {
//           log.error("从redis里面取出缓存的所有品牌异常，e"+e);
//            brandRedisList=brandReadDao.getBrandList();
//            log.info("从redis里面取出缓存的所有品牌异常，从数据库读取成功,总耗时："+(System.currentTimeMillis()-startTime));
//        }
//        return brandRedisList;
        return brandReadDao.getBrandList();
    }

    public Brand getBrandById(int id){

        return brandReadDao.getBrandById(id);

    }
}
