/**
 * Copyright (c) haier.com 2013 All Rights Reserved.
 */
package com.haier.m.dao.mshop.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.m.entity.item.ProductImages;

public interface ProductImagesReadDao {

    /**
     * 前台使用-根据商品id和平台来源获取商品图片
     * @param productId
     * @param platform
     * @return
     */
    public List<ProductImages> getByProductIdAndPlatform(@Param("productId") Integer productId,
                                                         @Param("platform") Integer platform);
}
