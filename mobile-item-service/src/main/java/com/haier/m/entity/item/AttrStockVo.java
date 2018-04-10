package com.haier.m.entity.item;

import java.io.Serializable;

/**
 * Created by wxy on 2017/12/1.
 */
public class AttrStockVo implements Serializable{
    private Integer stockNum;

    private boolean hasStock;

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public boolean getHasStock() {
        return hasStock;
    }

    public void setHasStock(boolean hasStock) {
        this.hasStock = hasStock;
    }
}
