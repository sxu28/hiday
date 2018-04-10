package com.haier.m.entity.item;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * Table: <strong>products</strong>
 * <p>
 * <table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 * <tr style="background-color:#ddd;Text-align:Left;">
 * <th nowrap>属性名</th>
 * <th nowrap>属性类型</th>
 * <th nowrap>字段名</th>
 * <th nowrap>字段类型</th>
 * <th nowrap>说明</th>
 * </tr>
 * <tr>
 * <td>id</td>
 * <td>{@link Integer}</td>
 * <td>id</td>
 * <td>int</td>
 * <td>&nbsp;</td>
 * </tr>
 * <tr>
 * <td>productId</td>
 * <td>{@link Integer}</td>
 * <td>product_id</td>
 * <td>int</td>
 * <td>&nbsp;</td>
 * </tr>
 * <tr>
 * <td>productName</td>
 * <td>{@link String}</td>
 * <td>product_name</td>
 * <td>varchar</td>
 * <td>商品名称</td>
 * </tr>
 * <tr>
 * <td>productActivityInfo</td>
 * <td>{@link String}</td>
 * <td>product_activity_info</td>
 * <td>varchar</td>
 * <td>商品活动信息 用于商品详情页显示在商品名称后面</td>
 * </tr>
 * <tr>
 * <td>productTitle</td>
 * <td>{@link String}</td>
 * <td>product_title</td>
 * <td>varchar</td>
 * <td>商品标题，商品在前台展示时显示在名称后面的描述信息</td>
 * </tr>
 * <tr>
 * <td>brandId</td>
 * <td>{@link Integer}</td>
 * <td>brand_id</td>
 * <td>int</td>
 * <td>品牌id</td>
 * </tr>
 * <tr>
 * <td>productTypeId</td>
 * <td>{@link Integer}</td>
 * <td>product_type_id</td>
 * <td>int</td>
 * <td>商品类型id</td>
 * </tr>
 * <tr>
 * <td>sellingPoint</td>
 * <td>{@link String}</td>
 * <td>selling_point</td>
 * <td>text</td>
 * <td>产品卖点，序列化数据</td>
 * </tr>
 * <tr>
 * <td>productDetail</td>
 * <td>{@link String}</td>
 * <td>product_detail</td>
 * <td>text</td>
 * <td>商品详细描述</td>
 * </tr>
 * <tr>
 * <td>productBlockDetail</td>
 * <td>{@link String}</td>
 * <td>product_block_detail</td>
 * <td>text</td>
 * <td>带版式商品详情</td>
 * </tr>
 * <tr>
 * <td>productCateId</td>
 * <td>{@link Integer}</td>
 * <td>product_cate_id</td>
 * <td>int</td>
 * <td>商品类目id</td>
 * </tr>
 * <tr>
 * <td>productCatePath</td>
 * <td>{@link String}</td>
 * <td>product_cate_path</td>
 * <td>varchar</td>
 * <td>商品分类路径（存储格式：/1/2/3/），搜索时可以like用索引</td>
 * </tr>
 * <tr>
 * <td>onSale</td>
 * <td>{@link Integer}</td>
 * <td>on_sale</td>
 * <td>tinyint</td>
 * <td>1上架0下架</td>
 * </tr>
 * <tr>
 * <td>isHot</td>
 * <td>{@link Integer}</td>
 * <td>is_hot</td>
 * <td>tinyint</td>
 * <td>热卖</td>
 * </tr>
 * <tr>
 * <td>isBest</td>
 * <td>{@link Integer}</td>
 * <td>is_best</td>
 * <td>tinyint</td>
 * <td>精品</td>
 * </tr>
 * <tr>
 * <td>isNew</td>
 * <td>{@link Integer}</td>
 * <td>is_new</td>
 * <td>tinyint</td>
 * <td>新品</td>
 * </tr>
 * <tr>
 * <td>isSpecial</td>
 * <td>{@link Integer}</td>
 * <td>is_special</td>
 * <td>tinyint</td>
 * <td>是否特殊商品 0普通商品 1特殊商品</td>
 * </tr>
 * <tr>
 * <td>isDelete</td>
 * <td>{@link Integer}</td>
 * <td>is_delete</td>
 * <td>tinyint</td>
 * <td>是否为删除状态,1-已删除,0-未删除</td>
 * </tr>
 * <tr>
 * <td>supplyPrice</td>
 * <td>{@link BigDecimal}</td>
 * <td>supply_price</td>
 * <td>decimal</td>
 * <td>商品供货价格</td>
 * </tr>
 * <tr>
 * <td>packagePrice</td>
 * <td>{@link BigDecimal}</td>
 * <td>package_price</td>
 * <td>decimal</td>
 * <td>套装价</td>
 * </tr>
 * <tr>
 * <td>saleGuidePrice</td>
 * <td>{@link BigDecimal}</td>
 * <td>sale_guide_price</td>
 * <td>decimal</td>
 * <td>参考价格,销售指导价格</td>
 * </tr>
 * <tr>
 * <td>rankPrice</td>
 * <td>{@link BigDecimal}</td>
 * <td>rank_price</td>
 * <td>decimal</td>
 * <td>会员组会员价</td>
 * </tr>
 * <tr>
 * <td>sku</td>
 * <td>{@link String}</td>
 * <td>sku</td>
 * <td>varchar</td>
 * <td>物料编码</td>
 * </tr>
 * <tr>
 * <td>shippingMode</td>
 * <td>{@link String}</td>
 * <td>shipping_mode</td>
 * <td>varchar</td>
 * <td>物流模式</td>
 * </tr>
 * <tr>
 * <td>packageId</td>
 * <td>{@link Integer}</td>
 * <td>package_id</td>
 * <td>int</td>
 * <td>套装ID，用于商城套装销售</td>
 * </tr>
 * <tr>
 * <td>isNotConfirm</td>
 * <td>{@link Integer}</td>
 * <td>is_not_confirm</td>
 * <td>tinyint</td>
 * <td>是否无需确认</td>
 * </tr>
 * <tr>
 * <td>isNoLimitStockProduct</td>
 * <td>{@link Integer}</td>
 * <td>is_no_limit_stock_product</td>
 * <td>tinyint</td>
 * <td>是否是无库存销售</td>
 * </tr>
 * <tr>
 * <td>productFullName</td>
 * <td>{@link String}</td>
 * <td>product_full_name</td>
 * <td>varchar</td>
 * <td>商品全名，如海尔冰箱 X234</td>
 * </tr>
 * <tr>
 * <td>defaultImageUrl</td>
 * <td>{@link String}</td>
 * <td>default_image_url</td>
 * <td>varchar</td>
 * <td>商品默认图片，用于购物车、我的订单、我的收藏等</td>
 * </tr>
 * <tr>
 * <td>indexImageUrl</td>
 * <td>{@link String}</td>
 * <td>index_image_url</td>
 * <td>varchar</td>
 * <td>商品主图，用于首页、列表页</td>
 * </tr>
 * <tr>
 * <td>productSource</td>
 * <td>{@link Integer}</td>
 * <td>product_source</td>
 * <td>tinyint</td>
 * <td>商品来源，0移动商品1pc商品</td>
 * </tr>
 * <tr>
 * <td>mobilePrice</td>
 * <td>{@link BigDecimal}</td>
 * <td>mobilePrice</td>
 * <td>decimal</td>
 * <td>移动价格</td>
 * </tr>
 * <tr>
 * <td>startTime</td>
 * <td>{@link Integer}</td>
 * <td>start_time</td>
 * <td>int</td>
 * <td>移动商城价格生效开始时间</td>
 * </tr>
 * <tr>
 * <td>endTime</td>
 * <td>{@link Integer}</td>
 * <td>end_time</td>
 * <td>int</td>
 * <td>移动商城价格生效结束时间</td>
 * </tr>
 * <tr>
 * <td>addTime</td>
 * <td>{@link Integer}</td>
 * <td>add_time</td>
 * <td>int</td>
 * <td>添加时间</td>
 * </tr>
 * <tr>
 * <td>addUser</td>
 * <td>{@link String}</td>
 * <td>add_user</td>
 * <td>varchar</td>
 * <td>添加人</td>
 * </tr>
 * <tr>
 * <td>modifyTime</td>
 * <td>{@link Integer}</td>
 * <td>modify_time</td>
 * <td>int</td>
 * <td>最后一次更新时间</td>
 * </tr>
 * <tr>
 * <td>modifyUser</td>
 * <td>{@link String}</td>
 * <td>modify_user</td>
 * <td>varchar</td>
 * <td>最后一个更新人</td>
 * </tr>
 * </table>
 *
 * @author 刘志斌
 * @date 2014-5-29
 * @email yudi@sina.com
 */
public class Products implements Serializable {
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    private Integer productId;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer value) {
        this.productId = value;
    }

    private String productName;

    /**
     * 获取 商品名称。
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 设置 商品名称。
     *
     * @param value
     *            属性值
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    private String productActivityInfo;

    /**
     * 获取 商品活动信息 用于商品详情页显示在商品名称后面。
     */
    public String getProductActivityInfo() {
        return this.productActivityInfo;
    }

    /**
     * 设置 商品活动信息 用于商品详情页显示在商品名称后面。
     *
     * @param value
     *            属性值
     */
    public void setProductActivityInfo(String value) {
        this.productActivityInfo = value;
    }

    private String productTitle;

    /**
     * 获取 商品标题，商品在前台展示时显示在名称后面的描述信息。
     */
    public String getProductTitle() {
        return this.productTitle;
    }

    /**
     * 设置 商品标题，商品在前台展示时显示在名称后面的描述信息。
     *
     * @param value
     *            属性值
     */
    public void setProductTitle(String value) {
        this.productTitle = value;
    }

    private Integer brandId;

    /**
     * 获取 品牌id。
     */
    public Integer getBrandId() {
        return this.brandId;
    }

    /**
     * 设置 品牌id。
     *
     * @param value
     *            属性值
     */
    public void setBrandId(Integer value) {
        this.brandId = value;
    }

    private Integer productTypeId;

    /**
     * 获取 商品类型id。
     */
    public Integer getProductTypeId() {
        return this.productTypeId;
    }

    /**
     * 设置 商品类型id。
     *
     * @param value
     *            属性值
     */
    public void setProductTypeId(Integer value) {
        this.productTypeId = value;
    }

    private String sellingPoint;

    /**
     * 获取 产品卖点，序列化数据。
     */
    public String getSellingPoint() {
        return this.sellingPoint;
    }

    /**
     * 设置 产品卖点，序列化数据。
     *
     * @param value
     *            属性值
     */
    public void setSellingPoint(String value) {
        this.sellingPoint = value;
    }

    private String productDetail;

    /**
     * 获取 商品详细描述。
     */
    public String getProductDetail() {
        return this.productDetail;
    }

    /**
     * 设置 商品详细描述。
     *
     * @param value
     *            属性值
     */
    public void setProductDetail(String value) {
        this.productDetail = value;
    }

    private String productBlockDetail;

    /**
     * 获取 带版式商品详情。
     */
    public String getProductBlockDetail() {
        return this.productBlockDetail;
    }

    /**
     * 设置 带版式商品详情。
     *
     * @param value
     *            属性值
     */
    public void setProductBlockDetail(String value) {
        this.productBlockDetail = value;
    }

    private Integer productCateId;

    /**
     * 获取 商品类目id。
     */
    public Integer getProductCateId() {
        return this.productCateId;
    }

    /**
     * 设置 商品类目id。
     *
     * @param value
     *            属性值
     */
    public void setProductCateId(Integer value) {
        this.productCateId = value;
    }

    private String productCatePath;

    /**
     * 获取 商品分类路径（存储格式：/1/2/3/），搜索时可以like用索引。
     */
    public String getProductCatePath() {
        return this.productCatePath;
    }

    /**
     * 设置 商品分类路径（存储格式：/1/2/3/），搜索时可以like用索引。
     *
     * @param value
     *            属性值
     */
    public void setProductCatePath(String value) {
        this.productCatePath = value;
    }

    private Integer onSale;

    /**
     * 获取 1上架0下架。
     */
    public Integer getOnSale() {
        return this.onSale;
    }

    /**
     * 设置 1上架0下架。
     *
     * @param value
     *            属性值
     */
    public void setOnSale(Integer value) {
        this.onSale = value;
    }

    private Integer isHot;

    /**
     * 获取 热卖。
     */
    public Integer getIsHot() {
        return this.isHot;
    }

    /**
     * 设置 热卖。
     *
     * @param value
     *            属性值
     */
    public void setIsHot(Integer value) {
        this.isHot = value;
    }

    private Integer isBest;

    /**
     * 获取 精品。
     */
    public Integer getIsBest() {
        return this.isBest;
    }

    /**
     * 设置 精品。
     *
     * @param value
     *            属性值
     */
    public void setIsBest(Integer value) {
        this.isBest = value;
    }

    private Integer isNew;

    /**
     * 获取 新品。
     */
    public Integer getIsNew() {
        return this.isNew;
    }

    /**
     * 设置 新品。
     *
     * @param value
     *            属性值
     */
    public void setIsNew(Integer value) {
        this.isNew = value;
    }

    private Integer isSpecial;

    /**
     * 获取 是否特殊商品 0普通商品 1特殊商品。
     */
    public Integer getIsSpecial() {
        return this.isSpecial;
    }

    /**
     * 设置 是否特殊商品 0普通商品 1特殊商品。
     *
     * @param value
     *            属性值
     */
    public void setIsSpecial(Integer value) {
        this.isSpecial = value;
    }

    private Integer isDelete;

    /**
     * 获取 是否为删除状态,1-已删除,0-未删除。
     */
    public Integer getIsDelete() {
        return this.isDelete;
    }

    /**
     * 设置 是否为删除状态,1-已删除,0-未删除。
     *
     * @param value
     *            属性值
     */
    public void setIsDelete(Integer value) {
        this.isDelete = value;
    }

    private BigDecimal supplyPrice;

    /**
     * 获取 商品供货价格。
     */
    public BigDecimal getSupplyPrice() {
        return this.supplyPrice;
    }

    /**
     * 设置 商品供货价格。
     *
     * @param value
     *            属性值
     */
    public void setSupplyPrice(BigDecimal value) {
        this.supplyPrice = value;
    }

    private BigDecimal packagePrice;

    /**
     * 获取 套装价。
     */
    public BigDecimal getPackagePrice() {
        return this.packagePrice;
    }

    /**
     * 设置 套装价。
     *
     * @param value
     *            属性值
     */
    public void setPackagePrice(BigDecimal value) {
        this.packagePrice = value;
    }

    private BigDecimal saleGuidePrice;

    /**
     * 获取 参考价格,销售指导价格。
     */
    public BigDecimal getSaleGuidePrice() {
        return this.saleGuidePrice;
    }

    /**
     * 设置 参考价格,销售指导价格。
     *
     * @param value
     *            属性值
     */
    public void setSaleGuidePrice(BigDecimal value) {
        this.saleGuidePrice = value;
    }

    private BigDecimal rankPrice;

    /**
     * 获取 会员组会员价。
     */
    public BigDecimal getRankPrice() {
        return this.rankPrice;
    }

    /**
     * 设置 会员组会员价。
     *
     * @param value
     *            属性值
     */
    public void setRankPrice(BigDecimal value) {
        this.rankPrice = value;
    }

    private String sku;

    /**
     * 获取 物料编码。
     */
    public String getSku() {
        return this.sku;
    }

    /**
     * 设置 物料编码。
     *
     * @param value
     *            属性值
     */
    public void setSku(String value) {
        this.sku = value;
    }

    private String shippingMode;

    /**
     * 获取 物流模式。
     */
    public String getShippingMode() {
        return this.shippingMode;
    }

    /**
     * 设置 物流模式。
     *
     * @param value
     *            属性值
     */
    public void setShippingMode(String value) {
        this.shippingMode = value;
    }

    private Integer packageId;

    /**
     * 获取 套装ID，用于商城套装销售。
     */
    public Integer getPackageId() {
        return this.packageId;
    }

    /**
     * 设置 套装ID，用于商城套装销售。
     *
     * @param value
     *            属性值
     */
    public void setPackageId(Integer value) {
        this.packageId = value;
    }

    private Integer isNotConfirm;

    /**
     * 获取 是否无需确认。
     */
    public Integer getIsNotConfirm() {
        return this.isNotConfirm;
    }

    /**
     * 设置 是否无需确认。
     *
     * @param value
     *            属性值
     */
    public void setIsNotConfirm(Integer value) {
        this.isNotConfirm = value;
    }

    private Integer isNoLimitStockProduct;

    /**
     * 获取 是否是无库存销售。
     */
    public Integer getIsNoLimitStockProduct() {
        return this.isNoLimitStockProduct;
    }

    /**
     * 设置 是否是无库存销售。
     *
     * @param value
     *            属性值
     */
    public void setIsNoLimitStockProduct(Integer value) {
        this.isNoLimitStockProduct = value;
    }

    private String productFullName;

    /**
     * 获取 商品全名，如海尔冰箱 X234。
     */
    public String getProductFullName() {
        return this.productFullName;
    }

    /**
     * 设置 商品全名，如海尔冰箱 X234。
     *
     * @param value
     *            属性值
     */
    public void setProductFullName(String value) {
        this.productFullName = value;
    }

    private String defaultImageUrl;

    /**
     * 获取 商品默认图片，用于购物车、我的订单、我的收藏等。
     */
    public String getDefaultImageUrl() {
        return this.defaultImageUrl;
    }

    /**
     * 设置 商品默认图片，用于购物车、我的订单、我的收藏等。
     *
     * @param value
     *            属性值
     */
    public void setDefaultImageUrl(String value) {
        this.defaultImageUrl = value;
    }

    private String indexImageUrl;

    /**
     * 获取 商品主图，用于首页、列表页。
     */
    public String getIndexImageUrl() {
        return this.indexImageUrl;
    }

    /**
     * 设置 商品主图，用于首页、列表页。
     *
     * @param value
     *            属性值
     */
    public void setIndexImageUrl(String value) {
        this.indexImageUrl = value;
    }

    /**
     * 商品视频播放地址
     */
    private String videoUrl;

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    private Integer productSource;

    /**
     * 获取 商品来源，0移动商品1pc商品。
     */
    public Integer getProductSource() {
        return this.productSource;
    }

    /**
     * 设置 商品来源，0移动商品1pc商品。
     *
     * @param value
     *            属性值
     */
    public void setProductSource(Integer value) {
        this.productSource = value;
    }

    private BigDecimal mobilePrice;

    /**
     * 获取 移动价格。
     */
    public BigDecimal getMobilePrice() {
        return this.mobilePrice;
    }

    /**
     * 设置 移动价格。
     *
     * @param value
     *            属性值
     */
    public void setMobilePrice(BigDecimal value) {
        this.mobilePrice = value;
    }

    private Integer startTime;

    /**
     * 获取 移动商城价格生效开始时间。
     */
    public Integer getStartTime() {
        return this.startTime;
    }

    /**
     * 设置 移动商城价格生效开始时间。
     *
     * @param value
     *            属性值
     */
    public void setStartTime(Integer value) {
        this.startTime = value;
    }

    private Integer endTime;

    /**
     * 获取 移动商城价格生效结束时间。
     */
    public Integer getEndTime() {
        return this.endTime;
    }

    /**
     * 设置 移动商城价格生效结束时间。
     *
     * @param value
     *            属性值
     */
    public void setEndTime(Integer value) {
        this.endTime = value;
    }

    private Integer addTime;

    /**
     * 获取 添加时间。
     */
    public Integer getAddTime() {
        return this.addTime;
    }

    /**
     * 设置 添加时间。
     *
     * @param value
     *            属性值
     */
    public void setAddTime(Integer value) {
        this.addTime = value;
    }

    private String addUser;

    /**
     * 获取 添加人。
     */
    public String getAddUser() {
        return this.addUser;
    }

    /**
     * 设置 添加人。
     *
     * @param value
     *            属性值
     */
    public void setAddUser(String value) {
        this.addUser = value;
    }

    private Integer modifyTime;

    /**
     * 获取 最后一次更新时间。
     */
    public Integer getModifyTime() {
        return this.modifyTime;
    }

    /**
     * 设置 最后一次更新时间。
     *
     * @param value
     *            属性值
     */
    public void setModifyTime(Integer value) {
        this.modifyTime = value;
    }

    private String modifyUser;

    /**
     * 获取 最后一个更新人。
     */
    public String getModifyUser() {
        return this.modifyUser;
    }

    /**
     * 设置 最后一个更新人。
     *
     * @param value
     *            属性值
     */
    public void setModifyUser(String value) {
        this.modifyUser = value;
    }

    /**
     * 商品o2o类型:1.商城专供型号2.O2O共享型号3.OTO引流型号
     */
    private Integer productO2OType;

    public Integer getProductO2OType() {
        return productO2OType;
    }

    public void setProductO2OType(Integer productO2OType) {
        this.productO2OType = productO2OType;
    }

    private String productFirstName;//第一名称
    private String productSecondName;//第二名称

    public String getProductFirstName() {
        return productFirstName;
    }

    public void setProductFirstName(String productFirstName) {
        this.productFirstName = productFirstName;
    }

    public String getProductSecondName() {
        return productSecondName;
    }

    public void setProductSecondName(String productSecondName) {
        this.productSecondName = productSecondName;
    }

    /**
     * keywords 页面关键字，用户搜索引擎优化
     */
    private String keywords;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}