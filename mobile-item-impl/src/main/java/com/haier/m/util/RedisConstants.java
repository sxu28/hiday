package com.haier.m.util;

public class RedisConstants {
    /**
     * 设置缓存超时时间：不超时
     */
    public static final Integer TIME_OUT = -1;

    /**
     * 省市区街道对应关系
     */
    public static final String REDIONS = "rediods";

    /**
     * 省市区街道对应关系(不带街道)
     */
    public static final String REDIONS_NO_STREET = "regNoStreet";

    /**
     * 父节点查询地区信息信息 后缀
     */
    public static final String SGREGIONS = "sgRedis";

    /**
     * 父节点查询地区信息信息 后缀   优化后的
     */
    public static final String SGPARENTREGIONS = "sgParentRegionRedis";

    /**
     * 父节点查询地区信息信息存入之前的 后缀
     */
    public static final String PREREGIONS = "preRegions";

    /**
     *  省 后缀
     */
    public static final String REGION_PROVINCE = "PROVINCE";

    /**
     *  市 后缀
     */
    public static final String REGION_CITY = "CITY";

    /**
     *  区 后缀
     */
    public static final String REGION_REGION = "REGION";

    /**
     * 品牌信息 后缀
     */
    public static final String ALLBRAND = "allBrand";

    /**
     * 省市区街道批量查询ids
     */
    public static final String REIDS = "regionIds";

    /**
     * 父节点查询地区信息信息 后缀
     */
    public static final String SGREGIONSMAP = "sgRedisMap";

    /**
     * 父节点查询地区信息信息 后缀
     */
    public static final String SGREGIONSSTREETMAP = "sgRedisStreetMap";

    /**
     * 每个用户在一个街道同一商品购买数量记录key模板,{0}用户ID，{1}街道ID，{2}商品ID
     */
    public static final String ORDER_LIMIT_KEY = "orderLimit:{0}#{1}#{2}";

    /**
    * 每个用户同一商品购买数量记录key新模板,{0}用户手机号，{1}商品ID
    */
    public static final String ORDER_LIMIT_KEY_NEW = "orderLimit:{0}#{1}";
    
    
    //-----------------------order limit new 2017-9-28-----------------
    
    /**
     * 存储条件为：限购数量为限购数，其他若选择条件为1，未选择条件为0，
     * 条件顺序：收货人，收货人手机号，订单区县，订单街道，发票抬头，物流模式，商品id，限购数量
     */
    public static final String ORDER_LIMTI_CONDITION_MANAGE_KEY = "mobile:order:limit:condition:";
    
    public static final String ORDER_LIMIT_KEY_NEW_NEW = "mobile:orderLimit:";
    
    //-----------------------order limit end 2017-9-28-----------------

}
