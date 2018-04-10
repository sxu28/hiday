package com.haier.m.entity.item;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Table: <strong>productcates</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *     <th nowrap>属性名</th><th nowrap>属性类型</th><th nowrap>字段名</th><th nowrap>字段类型</th><th nowrap>说明</th>
 *   </tr>
 *   <tr><td>id</td><td>{@link Integer}</td><td>id</td><td>int</td><td>&nbsp;</td></tr>
 *   <tr><td>siteId</td><td>{@link Integer}</td><td>siteId</td><td>int</td><td>&nbsp;</td></tr>
 *   <tr><td>parentId</td><td>{@link Integer}</td><td>parentId</td><td>int</td><td>&nbsp;</td></tr>
 *   <tr><td>parentPath</td><td>{@link String}</td><td>parentPath</td><td>varchar</td><td>&nbsp;</td></tr>
 *   <tr><td>cateName</td><td>{@link String}</td><td>cateName</td><td>varchar</td><td>&nbsp;</td></tr>
 *   <tr><td>sortNum</td><td>{@link Integer}</td><td>sortNum</td><td>tinyint</td><td>&nbsp;</td></tr>
 *   <tr><td>isHidden</td><td>{@link Integer}</td><td>isHidden</td><td>tinyint</td><td>&nbsp;</td></tr>
 *   <tr><td>cateFilters</td><td>{@link String}</td><td>cateFilters</td><td>text</td><td>&nbsp;</td></tr>
 *   <tr><td>extendCateFilters</td><td>{@link String}</td><td>extendCateFilters</td><td>text</td><td>&nbsp;</td></tr>
 *   <tr><td>priceRange</td><td>{@link String}</td><td>priceRange</td><td>text</td><td>&nbsp;</td></tr>
 *   <tr><td>packDesc</td><td>{@link String}</td><td>packDesc</td><td>text</td><td>&nbsp;</td></tr>
 *   <tr><td>deliveryDesc</td><td>{@link String}</td><td>deliveryDesc</td><td>text</td><td>&nbsp;</td></tr>
 *   <tr><td>afterService</td><td>{@link String}</td><td>afterService</td><td>text</td><td>&nbsp;</td></tr>
 *   <tr><td>lastModifyTime</td><td>{@link Integer}</td><td>lastModifyTime</td><td>int</td><td>&nbsp;</td></tr>
 * </table>
 *
 * @author 刘志斌
 * @date 2013-7-5
 * @email yudi@sina.com
 */
public class ProductCates implements Serializable {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -2788227923747792958L;

    private Integer           id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    private Integer siteId;

    public Integer getSiteId() {
        return this.siteId;
    }

    public void setSiteId(Integer value) {
        this.siteId = value;
    }

    private Integer parentId;

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer value) {
        this.parentId = value;
    }

    private String parentPath;

    public String getParentPath() {
        return this.parentPath;
    }

    public void setParentPath(String value) {
        this.parentPath = value;
    }

    private String cateName;

    public String getCateName() {
        return this.cateName;
    }

    public void setCateName(String value) {
        this.cateName = value;
    }

    private Integer sortNum;

    public Integer getSortNum() {
        return this.sortNum;
    }

    public void setSortNum(Integer value) {
        this.sortNum = value;
    }

    private Integer isHidden;

    public Integer getIsHidden() {
        return this.isHidden;
    }

    public void setIsHidden(Integer value) {
        this.isHidden = value;
    }

    private String cateFilters;

    public String getCateFilters() {
        return this.cateFilters;
    }

    public void setCateFilters(String value) {
        this.cateFilters = value;
    }

    private String extendCateFilters;

    public String getExtendCateFilters() {
        return this.extendCateFilters;
    }

    public void setExtendCateFilters(String value) {
        this.extendCateFilters = value;
    }

    private String priceRange;

    public String getPriceRange() {
        return this.priceRange;
    }

    public void setPriceRange(String value) {
        this.priceRange = value;
    }

    private String packDesc;

    public String getPackDesc() {
        return this.packDesc;
    }

    public void setPackDesc(String value) {
        this.packDesc = value;
    }

    private String deliveryDesc;

    public String getDeliveryDesc() {
        return this.deliveryDesc;
    }

    public void setDeliveryDesc(String value) {
        this.deliveryDesc = value;
    }

    private String afterService;

    public String getAfterService() {
        return this.afterService;
    }

    public void setAfterService(String value) {
        this.afterService = value;
    }

    private Integer lastModifyTime = 0;

    public Integer getLastModifyTime() {
        return this.lastModifyTime;
    }

    public void setLastModifyTime(Integer value) {
        this.lastModifyTime = value;
    }

    private Date modified;

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

}