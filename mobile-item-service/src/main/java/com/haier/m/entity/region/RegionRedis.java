package com.haier.m.entity.region;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RegionRedis implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String regionName;

    private  int code;

    private int regionType;

    private int visible;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getRegionType() {
        return regionType;
    }

    public void setRegionType(int regionType) {
        this.regionType = regionType;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "RegionRedis{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", code=" + code +
                ", regionType=" + regionType +
                ", visible=" + visible +
                '}';
    }
}
