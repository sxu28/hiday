package com.haier.m.entity.region;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Region implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String regionName;

    private int parentId;

    private String code;

    private String cityName;

    private String provinceName;

    private String parentPath;

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    private List<Region> childs = new ArrayList<Region>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Region> getChilds() {
        return childs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setChilds(List<Region> childs) {
        this.childs = childs;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "Region [id=" + id + ", regionName=" + regionName + ", parentId=" + parentId + ", childs=" + childs
                + "]";
    }

}
