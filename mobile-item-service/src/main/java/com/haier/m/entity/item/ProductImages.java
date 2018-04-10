package com.haier.m.entity.item;

import java.io.Serializable;

/**
 * 商品图片。
 * 
 * <p>
 * Table: <strong>ProductImages</strong>
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
 * <td>productId</td>
 * <td>int</td>
 * <td>商品ID</td>
 * </tr>
 * <tr>
 * <td>metaFileId</td>
 * <td>{@link String}</td>
 * <td>metaFileId</td>
 * <td>varchar</td>
 * <td>文件ID</td>
 * </tr>
 * <tr>
 * <td>imageType</td>
 * <td>{@link Integer}</td>
 * <td>imageType</td>
 * <td>tinyint</td>
 * <td>图片类型：<br />
 * 1、主图<br />
 * 2、附图<br />
 * 3、广告图</td>
 * </tr>
 * <tr>
 * <td>imageDesc</td>
 * <td>{@link String}</td>
 * <td>imageDesc</td>
 * <td>varchar</td>
 * <td>图片描述</td>
 * </tr>
 * <tr>
 * <td>sortNum</td>
 * <td>{@link Integer}</td>
 * <td>sortNum</td>
 * <td>tinyint</td>
 * <td>排序</td>
 * </tr>
 * <tr>
 * <td>platform</td>
 * <td>{@link Integer}</td>
 * <td>platform</td>
 * <td>tinyint</td>
 * <td>平台版本：<br />
 * 1、手机<br />
 * 2、pad</td>
 * </tr>
 * <tr>
 * <td>productFullName</td>
 * <td>{@link String}</td>
 * <td>productFullName</td>
 * <td>String</td>
 * <td>商品全名</td>
 * </tr>
 * </table>
 * 
 * @author 刘志斌
 * @date 2013-12-8
 * @email yudi@sina.com
 */
public class ProductImages implements Serializable {

    private static final long serialVersionUID = 2390346820404082039L;

    public final static int   PLATFORM_APP     = 1;

    public final static int   PLATFORM_PAD     = 2;

    /**
     * 主图
     */
    public final static int   IMAGE_TYPE_MAIN  = 1;

    /**
     * 附图
     */
    public final static int   IMAGE_TYPE_SUB   = 2;

    /**
     * 广告图
     */
    public final static int   IMAGE_TYPE_ADVER = 3;

    private Integer           id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    private Integer productId;

    /**
     * 获取 商品ID。
     */
    public Integer getProductId() {
        return this.productId;
    }

    /**
     * 设置 商品ID。
     * 
     * @param value
     *            属性值
     */
    public void setProductId(Integer value) {
        this.productId = value;
    }

    private String metaFileId;

    /**
     * 获取 文件ID。
     */
    public String getMetaFileId() {
        return this.metaFileId;
    }

    /**
     * 设置 文件ID。
     * 
     * @param value
     *            属性值
     */
    public void setMetaFileId(String value) {
        this.metaFileId = value;
    }

    private Integer imageType;

    /**
     * 获取 图片类型：。
     * 
     * <p>
     * 1、主图<br />
     * 2、附图<br />
     * 3、广告图
     */
    public Integer getImageType() {
        return this.imageType;
    }

    /**
     * 设置 图片类型：。
     * 
     * <p>
     * 1、主图<br />
     * 2、附图<br />
     * 3、广告图
     * 
     * @param value
     *            属性值
     */
    public void setImageType(Integer value) {
        this.imageType = value;
    }

    private String imageDesc;

    /**
     * 获取 图片描述。
     */
    public String getImageDesc() {
        return this.imageDesc;
    }

    /**
     * 设置 图片描述。
     * 
     * @param value
     *            属性值
     */
    public void setImageDesc(String value) {
        this.imageDesc = value;
    }

    private Integer sortNum;

    /**
     * 获取 排序。
     */
    public Integer getSortNum() {
        return this.sortNum;
    }

    /**
     * 设置 排序。
     * 
     * @param value
     *            属性值
     */
    public void setSortNum(Integer value) {
        this.sortNum = value;
    }

    private Integer platform;

    /**
     * 获取平台标识
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 设置平台标识
     * 
     * @param platform
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    private String productFullName;

    /**
     * 获取 商品全名。
     */
    public String getProductFullName() {
        return productFullName;
    }

    /**
     * 设置 商品全名。
     * 
     * @param value
     *            属性值
     */
    public void setProductFullName(String productFullName) {
        this.productFullName = productFullName;
    }

}