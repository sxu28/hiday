package com.haier.m.entity.order;

import java.io.Serializable;
/**
 * 订单删除记录表
 * 
 * <p>Table: <strong>orders_recover</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *     <th nowrap>属性名</th><th nowrap>属性类型</th><th nowrap>字段名</th><th nowrap>字段类型</th><th nowrap>说明</th>
 *   </tr>
 *   <tr><td>id</td><td>{@link java.lang.Integer}</td><td>id</td><td>int</td><td>id</td></tr>
 *   <tr><td>memberId</td><td>{@link java.lang.Integer}</td><td>member_id</td><td>int</td><td>会员ID</td></tr>
 *   <tr><td>orderId</td><td>{@link java.lang.Integer}</td><td>order_id</td><td>int</td><td>订单ID</td></tr>
 *   <tr><td>deleteStatus</td><td>{@link java.lang.Integer}</td><td>deleteStatus</td><td>tinyint</td><td>订单删除状态 1：删除，2：永久删除</td></tr>
 * </table>
 *
 * @author wangzhanqing
 */
public class OrdersRecover implements Serializable {
 
 	/**
     * 
     */
    private static final long serialVersionUID = 8699224042390896261L;
    private java.lang.Integer id;
 	private java.lang.Integer memberId;
 	private java.lang.Integer orderId;
 	private java.lang.Integer deleteStatus;
 	
 		
	/**
     * 获取id
     */
	public java.lang.Integer getId(){
		return this.id;
	}
 		
	/**
     * 设置id
     */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
 		
	/**
     * 获取会员ID
     */
	public java.lang.Integer getMemberId(){
		return this.memberId;
	}
 		
	/**
     * 设置会员ID
     */
	public void setMemberId(java.lang.Integer memberId){
		this.memberId = memberId;
	}
 		
	/**
     * 获取订单ID
     */
	public java.lang.Integer getOrderId(){
		return this.orderId;
	}
 		
	/**
     * 设置订单ID
     */
	public void setOrderId(java.lang.Integer orderId){
		this.orderId = orderId;
	}
 		
	/**
     * 获取订单删除状态 1：删除，2：永久删除
     */
	public java.lang.Integer getDeleteStatus(){
		return this.deleteStatus;
	}
 		
	/**
     * 设置订单删除状态 1：删除，2：永久删除
     */
	public void setDeleteStatus(java.lang.Integer deleteStatus){
		this.deleteStatus = deleteStatus;
	}
 }