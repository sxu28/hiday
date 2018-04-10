package com.haier.m.entity.region;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * V3地址信息
 *                   
 * @Filename: 
 * @Version: 1.0
 * @Author: 陈闯
 * @Email: chuang.chen@dhc.com.cn
 *
 */
public class ChildrenAddRegionsType implements Serializable{
	private static final long serialVersionUID = -8077375498660676078L;
	private int value;
	private String text;
	private int grade;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
