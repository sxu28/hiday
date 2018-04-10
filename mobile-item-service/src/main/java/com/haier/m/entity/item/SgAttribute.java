package com.haier.m.entity.item;

import java.io.Serializable;
/**
 * 店铺商品属性表
 * <p>Table: <strong>sg_attribute</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *     <th nowrap>属性名</th><th nowrap>属性类型</th><th nowrap>字段名</th><th nowrap>字段类型</th><th nowrap>说明</th>
 *   </tr>
 *   <tr><td>id</td><td>{@link Integer}</td><td>id</td><td>int</td><td>主键</td></tr>
 *   <tr><td>storeId</td><td>{@link Integer}</td><td>store_id</td><td>int</td><td>店铺ID</td></tr>
 *   <tr><td>productId</td><td>{@link Integer}</td><td>product_id</td><td>int</td><td>产品ID</td></tr>
 *   <tr><td>sku</td><td>{@link String}</td><td>sku</td><td>varchar</td><td>物料编码</td></tr>
 *   <tr><td>attrCode</td><td>{@link String}</td><td>attr_code</td><td>varchar</td><td>属性码</td></tr>
 *   <tr><td>attrName</td><td>{@link String}</td><td>attr_name</td><td>varchar</td><td>属性名称</td></tr>
 *   <tr><td>attrValueCode</td><td>{@link String}</td><td>attr_value_code</td><td>varchar</td><td>属性值code</td></tr>
 *   <tr><td>attrValueName</td><td>{@link String}</td><td>attr_value_name</td><td>varchar</td><td>属性值名称</td></tr>
 *   <tr><td>remark</td><td>{@link String}</td><td>remark</td><td>varchar</td><td>备注</td></tr>
 *   <tr><td>orders</td><td>{@link Integer}</td><td>orders</td><td>tinyint</td><td>顺序</td></tr>
 * </table>
 *
 */
public class SgAttribute implements Serializable {
 
 	private Integer id;
 	private Integer storeId;
 	private Integer productId;
 	private String sku;
 	private String attrCode;
 	private String attrName;
 	private String attrValueCode;
 	private String attrValueName;
 	private String remark;
 	private Integer orders;

 		
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
     * 获取产品ID
     */
	public Integer getProductId(){
		return this.productId;
	}
 		
	/**
     * 设置产品ID
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
     * 获取属性码
     */
	public String getAttrCode(){
		return this.attrCode;
	}
 		
	/**
     * 设置属性码
     */
	public void setAttrCode(String attrCode){
		this.attrCode = attrCode;
	}
 		
	/**
     * 获取属性名称
     */
	public String getAttrName(){
		return this.attrName;
	}
 		
	/**
     * 设置属性名称
     */
	public void setAttrName(String attrName){
		this.attrName = attrName;
	}
 		
	/**
     * 获取属性值code
     */
	public String getAttrValueCode(){
		return this.attrValueCode;
	}
 		
	/**
     * 设置属性值code
     */
	public void setAttrValueCode(String attrValueCode){
		this.attrValueCode = attrValueCode;
	}
 		
	/**
     * 获取属性值名称
     */
	public String getAttrValueName(){
		return this.attrValueName;
	}
 		
	/**
     * 设置属性值名称
     */
	public void setAttrValueName(String attrValueName){
		this.attrValueName = attrValueName;
	}
 		
	/**
     * 获取备注
     */
	public String getRemark(){
		return this.remark;
	}
 		
	/**
     * 设置备注
     */
	public void setRemark(String remark){
		this.remark = remark;
	}
 		
	/**
     * 获取顺序
     */
	public Integer getOrders(){
		return this.orders;
	}
 		
	/**
     * 设置顺序
     */
	public void setOrders(Integer orders){
		this.orders = orders;
	}
 		
 }