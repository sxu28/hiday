package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

public class RelationOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cPayTime;
	
	private BigDecimal couponAmount;

	public Integer getcPayTime() {
		return cPayTime;
	}

	public void setcPayTime(Integer cPayTime) {
		this.cPayTime = cPayTime;
	}

	public BigDecimal getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
}
