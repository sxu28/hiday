package com.haier.m.dao.shop.read;

import com.haier.m.entity.item.SgStoreProductsAttribute;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SgStoreProductsAttributeReadDao {
 
    List<SgStoreProductsAttribute> getSgStoreAttributeByProductId(Map<String, Object> queryMap);

    List<SgStoreProductsAttribute> getSgStoreAttributeBySkkus(List<String> list);

    List<SgStoreProductsAttribute> getSgStoreAttributeInSet(Map<String, Object> queryMap);

    Integer isShowAttr(Map<String, Object> map);

    SgStoreProductsAttribute getAttrBySkku(Map<String, Object> map);
}