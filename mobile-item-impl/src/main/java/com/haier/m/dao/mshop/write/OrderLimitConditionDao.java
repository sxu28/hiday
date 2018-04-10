package com.haier.m.dao.mshop.write;

import org.apache.ibatis.annotations.Param;

public interface OrderLimitConditionDao {

    /**
     * 更新限购条件
     * @param limitCondition 限购条件
     * @param isLimitValue 限制是否启用
     * @return
     */
    public Integer updateCondition(@Param("limitCondition") String limitCondition,
                                   @Param("isLimitValue") Integer isLimitValue,
                                   @Param("modifyUser") String modifyUser);
    
}
