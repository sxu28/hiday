package com.haier.m.service.item.test;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.GsonBuilder;

public abstract class TestBase extends TestCase {
    protected static Logger log = LoggerFactory.getLogger(TestBase.class);

    public static ClassPathXmlApplicationContext context = null;

    public void setUp() {
        log.info("===========================================================================");
        log.info(">>>>>>>>>>>>>>>>>>>>>>> " + super.getName() + "():");
        if (context == null) {

            context = new ClassPathXmlApplicationContext(
                    "classpath:service-deploy.xml");
            context.start();
            System.out.println("mobile-item-service started.");
        }
        init();
    }

    protected abstract void init();

    /**
     * 打印测试对象
     * 
     * @param obj
     */
    public void print(Object obj) {
        this.print(obj, true);
    }

    public void print(Object obj, boolean pretty) {
        GsonBuilder gb = new GsonBuilder();
        if (pretty)
            gb.setPrettyPrinting();
        gb.setDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(gb.create().toJson(obj));
    }
}