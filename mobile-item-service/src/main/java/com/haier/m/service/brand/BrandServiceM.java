package com.haier.m.service.brand;

import com.haier.common.ServiceResult;
import com.haier.m.entity.item.Brand;

import java.util.List;

/**
 * @Version: 1.0
 * @Author: liguohua 李国华
 * @Email: liguohua@uming.net
 */
public interface BrandServiceM {

    /**
     * 查询所有品牌列表
     * @param
     * @return
     */
    public ServiceResult<List<Brand>> getBrandList();

    /**
     * 根据ID查询品牌信息
     * @param id
     * @return
     */
    public ServiceResult<Brand> getBrandById(int id);
}
