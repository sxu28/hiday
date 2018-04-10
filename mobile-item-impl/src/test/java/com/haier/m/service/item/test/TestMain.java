package com.haier.m.service.item.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.haier.common.ServiceResult;
import com.haier.common.util.JsonUtil;
import com.haier.m.service.region.RegionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:service-deploy.xml");
		context.start();
		System.out.println("mobile-item-service started.");

		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


//	public static void main(String[] args) {
//		List<String> list1=new ArrayList<String>();
//		List<String> list2=new ArrayList<String>();
//		list1.add("1");
//		list1.add("2");
//		list1.add("3");
//
//
//		list2.add("4");
//		list2.add("3");
//		list2.add("2");
//		list2.add("1");
//		System.out.println(list1.retainAll(list2));
//		System.out.println(JsonUtil.toJson(list1));
//		System.out.println(JsonUtil.toJson(list2));
//
//	}

}
