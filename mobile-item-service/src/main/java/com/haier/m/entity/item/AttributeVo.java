package com.haier.m.entity.item;

import java.io.Serializable;

/**
 * Created by wxy on 2017/11/22.
 */
public class AttributeVo implements Serializable {
    private String  attrName;
    private SgAttribute sgAttribute;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public SgAttribute getSgAttribute() {
        return sgAttribute;
    }

    public void setSgAttribute(SgAttribute sgAttribute) {
        this.sgAttribute = sgAttribute;
    }
}
