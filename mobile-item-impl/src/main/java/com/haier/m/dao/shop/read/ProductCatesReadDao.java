package com.haier.m.dao.shop.read;

import com.haier.common.ServiceResult;
import org.apache.ibatis.annotations.Param;

import com.haier.m.entity.item.ProductCates;

import java.util.List;

public interface ProductCatesReadDao {

    public ProductCates findById(@Param("id") Integer id);

    List<ProductCates> findInProductCateIds(@Param("list") List<String> list);
}
