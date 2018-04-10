package com.haier.m.model.item;

import com.haier.m.dao.shop.read.SgStoreProductsAttributeReadDao;
import com.haier.m.entity.item.SgStoreProductsAttribute;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class SgStoreProductsAttributeModel {

	private static org.apache.log4j.Logger log = org.apache.log4j.LogManager
                                                   .getLogger(SgStoreProductsAttributeModel.class);
    
    @Resource
    private SgStoreProductsAttributeReadDao sgStoreProductsAttributeReadDao;
    

    public List<SgStoreProductsAttribute> getSgStoreAttributeByProductId(Map<String,Object> queryMap) {
        return sgStoreProductsAttributeReadDao.getSgStoreAttributeByProductId(queryMap);
    }

    public List<SgStoreProductsAttribute> getSgStoreAttributeBySkkus(List<String> list) {
        return sgStoreProductsAttributeReadDao.getSgStoreAttributeBySkkus(list);
    }

    public List<SgStoreProductsAttribute> getSgStoreAttributeInSet(Map<String,Object> queryMap) {
        return sgStoreProductsAttributeReadDao.getSgStoreAttributeInSet(queryMap);
    }

    public Boolean isShowAttr(Map<String, Object> map) {
        boolean f = false;
        Integer count = sgStoreProductsAttributeReadDao.isShowAttr(map);
        if(count>0){
            f =true;
        }
        return f;
    }

    public SgStoreProductsAttribute getAttrBySkku(Map<String, Object> map) {
        return sgStoreProductsAttributeReadDao.getAttrBySkku(map);
    }
}