package com.haier.m.dao.shop.read;

import com.haier.m.entity.item.SgAttribute;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SgAttributeReadDao {
 
	SgAttribute get(Integer id);

    List<SgAttribute> getSgAttributeByMap(Map<String, Object> queryMap);
}