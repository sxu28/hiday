package com.haier.m.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemConstants {
    public static final Integer HAIER_BRAND    = 297;
    public static final Integer TONGHUAI_BRAND = 299;
    public static final Integer KASADI_BRAND   = 298;

    public static final String SHIPPING_MODE_BBC = "B2B2C";

    public static final List<Integer>       CHECK_BRAND       = new ArrayList<Integer>();
    //快递公司
    public static final Map<String, String> MUNICIPALITY_MAPS = new HashMap<String, String>();

    static {
        MUNICIPALITY_MAPS.put("2", "北京");
        MUNICIPALITY_MAPS.put("23", "重庆");
        MUNICIPALITY_MAPS.put("10", "上海");
        MUNICIPALITY_MAPS.put("3", "天津");
        CHECK_BRAND.add(297);
        CHECK_BRAND.add(299);
        CHECK_BRAND.add(298);
        CHECK_BRAND.add(305);
        CHECK_BRAND.add(307);
    }
}
