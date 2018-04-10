package com.haier.m.model.item;

import com.haier.m.dao.shop.read.SgAttributeReadDao;
import com.haier.m.entity.item.SgAttribute;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Component
public class SgAttributeModel {

	private static org.apache.log4j.Logger log = org.apache.log4j.LogManager
                                                   .getLogger(SgAttributeModel.class);
    
    @Resource
    private SgAttributeReadDao sgAttributeReadDao;
    
    /**
     * 根据id取得店铺商品属性表
     * @param  sgAttributeId
     * @return
     */
    public SgAttribute getSgAttributeById(Integer sgAttributeId) {
    	return sgAttributeReadDao.get(sgAttributeId);
    }
    /**
     * 根据map批量查询店铺商品属性表
     * @param  queryMap
     * @return
     */
    public List<SgAttribute> getSgAttributeByMap(Map<String, Object> queryMap) {
        return  sgAttributeReadDao.getSgAttributeByMap(queryMap);
    }

}