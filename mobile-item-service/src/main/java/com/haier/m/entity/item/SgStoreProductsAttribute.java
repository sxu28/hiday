package com.haier.m.entity.item;

import java.io.Serializable;
/**
 * 店铺商品属性组合表
 * <p>Table: <strong>sg_store_products_attribute</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *     <th nowrap>属性名</th><th nowrap>属性类型</th><th nowrap>字段名</th><th nowrap>字段类型</th><th nowrap>说明</th>
 *   </tr>
 *   <tr><td>id</td><td>{@link Integer}</td><td>id</td><td>int</td><td>主键</td></tr>
 *   <tr><td>productId</td><td>{@link Integer}</td><td>product_id</td><td>int</td><td>商品ID</td></tr>
 *   <tr><td>sku</td><td>{@link String}</td><td>sku</td><td>varchar</td><td>物料编码</td></tr>
 *   <tr><td>skku</td><td>{@link String}</td><td>skku</td><td>varchar</td><td>子商品物料编码</td></tr>
 *   <tr><td>storeId</td><td>{@link Integer}</td><td>store_id</td><td>int</td><td>店铺ID</td></tr>
 *   <tr><td>attrIds</td><td>{@link String}</td><td>attr_ids</td><td>varchar</td><td>属性ids</td></tr>
 *   <tr><td>attrValueIds</td><td>{@link String}</td><td>attr_value_ids</td><td>varchar</td><td>属性值Ids</td></tr>
 *   <tr><td>pic</td><td>{@link String}</td><td>pic</td><td>varchar</td><td>图片</td></tr>
 *   <tr><td>num</td><td>{@link Integer}</td><td>num</td><td>int</td><td>库存数目</td></tr>
 *   <tr><td>price</td><td>{@link java.math.BigDecimal}</td><td>price</td><td>decimal</td><td>价格</td></tr>
 * </table>
 *
 */
public class SgStoreProductsAttribute implements Serializable  {
 
 	private Integer id;
 	private Integer productId;
 	private String sku;
 	private String skku;
 	private Integer storeId;
 	private String attrIds;
 	private String attrValueIds;
 	private String pic;
 	private Integer num;
 	private java.math.BigDecimal price;

	/**
     * 获取主键
     */
	public Integer getId(){
		return this.id;
	}
 		
	/**
     * 设置主键
     */
	public void setId(Integer id){
		this.id = id;
	}
 		
	/**
     * 获取商品ID
     */
	public Integer getProductId(){
		return this.productId;
	}
 		
	/**
     * 设置商品ID
     */
	public void setProductId(Integer productId){
		this.productId = productId;
	}
 		
	/**
     * 获取物料编码
     */
	public String getSku(){
		return this.sku;
	}
 		
	/**
     * 设置物料编码
     */
	public void setSku(String sku){
		this.sku = sku;
	}
 		
	/**
     * 获取子商品物料编码
     */
	public String getSkku(){
		return this.skku;
	}
 		
	/**
     * 设置子商品物料编码
     */
	public void setSkku(String skku){
		this.skku = skku;
	}
 		
	/**
     * 获取店铺ID
     */
	public Integer getStoreId(){
		return this.storeId;
	}
 		
	/**
     * 设置店铺ID
     */
	public void setStoreId(Integer storeId){
		this.storeId = storeId;
	}
 		
	/**
     * 获取属性ids
     */
	public String getAttrIds(){
		return this.attrIds;
	}
 		
	/**
     * 设置属性ids
     */
	public void setAttrIds(String attrIds){
		this.attrIds = attrIds;
	}
 		
	/**
     * 获取属性值Ids
     */
	public String getAttrValueIds(){
		return this.attrValueIds;
	}
 		
	/**
     * 设置属性值Ids
     */
	public void setAttrValueIds(String attrValueIds){
		this.attrValueIds = attrValueIds;
	}
 		
	/**
     * 获取图片
     */
	public String getPic(){
		return this.pic;
	}
 		
	/**
     * 设置图片
     */
	public void setPic(String pic){
		this.pic = pic;
	}
 		
	/**
     * 获取库存数目
     */
	public Integer getNum(){
		return this.num;
	}

	/**
     * 设置库存数目
     */
	public void setNum(Integer num){
		this.num = num;
	}

	/**
     * 获取价格
     */
	public java.math.BigDecimal getPrice(){
		return this.price;
	}
 		
	/**
     * 设置价格
     */
	public void setPrice(java.math.BigDecimal price){
		this.price = price;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SgStoreProductsAttribute that = (SgStoreProductsAttribute) o;

		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}