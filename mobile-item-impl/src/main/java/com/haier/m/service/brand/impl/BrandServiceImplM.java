package com.haier.m.service.brand.impl;

import com.haier.common.ServiceResult;
import com.haier.m.entity.item.Brand;
import com.haier.m.entity.item.Products;
import com.haier.m.model.brand.BrandModelM;
import com.haier.m.model.item.ItemModelM;
import com.haier.m.service.brand.BrandServiceM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Version: 1.0
 * @Author: liguohua 李国华
 * @Email: liguohua@uming.net
 */

@Service("brandServiceM")
public class BrandServiceImplM implements BrandServiceM{

    private Logger log = LoggerFactory.getLogger(BrandServiceImplM.class);

    @Resource
    private BrandModelM brandModelM;

    @Override
    public ServiceResult<List<Brand>> getBrandList(){
        ServiceResult<List<Brand>> serviceResult = new ServiceResult<List<Brand>>();
        try {
            serviceResult.setResult(brandModelM.getBrandList());
        } catch (Exception e) {
            log.error("获取品牌列表时发生未知异常:", e);
            serviceResult.setSuccess(false);
            serviceResult.setMessage("获取品牌列表时发生未知异常");
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<Brand> getBrandById(int id){
        ServiceResult<Brand> brandServiceResult = new ServiceResult<Brand>();
        try {
            brandServiceResult.setResult(brandModelM.getBrandById(id));
        } catch (Exception e) {
            log.error("根据id获取品牌信息发生未知异常:", e);
            brandServiceResult.setSuccess(false);
            brandServiceResult.setMessage("根据id获取品牌信息发生未知异常");
        }
        return brandServiceResult;
    }
}
