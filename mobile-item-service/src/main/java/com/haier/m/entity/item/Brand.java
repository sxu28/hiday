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
 * <tr>
 * <td>siteId</td>
 * <td>{@link Integer}</td>
 * <td>int</td>
 * <td></td>
 * </tr>
 * <tr>
 * <td>brandName</td>
 * <td>{@link Integer}</td>
 * <td>String</td>
 * <td>品牌名称</td>
 * </tr>
 * <td>brandCode</td>
 * <td>{@link Integer}</td>
 * <td>String</td>
 * <td>品牌在MDM系统中的代码</td>
 * </tr>
 * <td>brandLogo</td>
 * <td>{@link Integer}</td>
 * <td>String</td>
 * <td>品牌Logo文件id</td>
 * </tr>
 * <td>brandUrl</td>
 * <td>{@link Integer}</td>
 * <td>String</td>
 * <td>官方网站地址</td>
 * </tr>
 ** <td>isBest</td>
 * <td>{@link Integer}</td>
 * <td>int</td>
 * <td>是否推荐</td>
 * </tr>
 * </table>


/**
 * @Version: 1.0
 * @Author: liguohua 李国华
 * @Email: liguohua@uming.net
 */
public class Brand implements Serializable {

    private Integer id;

    private Integer siteId;

    private String brandName;

    private String brandCode;

    private String brandLogo;

    private String brandUrl;

    private int isBest;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
    }

    public int getIsBest() {
        return isBest;
    }

    public void setIsBest(int isBest) {
        this.isBest = isBest;
    }
}
