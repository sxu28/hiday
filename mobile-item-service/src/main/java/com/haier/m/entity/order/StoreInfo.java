package com.haier.m.entity.order;

import java.io.Serializable;

public class StoreInfo implements Serializable {

    /**
     * 版本号
     */
    private static final long serialVersionUID = 1L;
    
    private String ownerId;
    
    private String storeName;

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
