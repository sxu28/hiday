package com.haier.m.filter;

import com.alibaba.fastjson.JSON;
import com.haier.common.util.DateUtil;
import com.haier.openplatform.console.domain.ExCaptureBean;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Date;

public class PsiLogAspect {

    private Logger log = LoggerFactory.getLogger("psilogger");

    public void logBefore() {

    }

    public void logException(JoinPoint joinPoint, Exception ex) {
        try {
            long startTime = System.currentTimeMillis();
            ExCaptureBean ecb = new ExCaptureBean();
            ecb.setServiceAPIName(joinPoint.getTarget().getClass().getName());
            ecb.setAppName("WEIDIAN");
            ecb.setActionName("");
            ecb.setNodeName(InetAddress.getLocalHost().getHostName().toString());
            ecb.setNodeIP(InetAddress.getLocalHost().getHostAddress().toString());
            ecb.setInputValue("");
            ecb.setInsight("");
            ecb.setGmtCreate(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));//日期格式为yyyy-MM-dd HH:mm:ss类型的字符串
            ecb.setExcuteTime((System.currentTimeMillis() - startTime) + "");
            ecb.setErrorCD("");//异常名称
            ecb.setExceptionNM("");
            ecb.setServiceException(ex.toString());
            ecb.setIssueTypeName("1");
            XStream xs = new XStream(new DomDriver());
            xs.autodetectAnnotations(true);
            xs.setMode(1001);
//            log.info(JSON.toJSONString(new PsiLogEntity("WEIDIAN", "Error", joinPoint.getTarget()
//                .getClass().getName()
//                                                                             + ":"
//                                                                             + joinPoint
//                                                                                 .getSignature()
//                                                                                 .getName(), xs
//                .toXML(ecb))));
        } catch (Exception e) {
        }
    }

    public class PsiLogEntity implements Serializable {
        /**
         *Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 7896867143678691985L;
        private String appName;
        private String type;
        private String metricsId;
        private String value;
        private Long date;

        public PsiLogEntity() {

        }

        public PsiLogEntity(String appName, String type, String metricsId, String value) {
            this.appName = appName;
            this.type = type;
            this.metricsId = metricsId;
            this.value = value;
            this.date = System.currentTimeMillis();
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMetricsId() {
            return metricsId;
        }

        public void setMetricsId(String metricsId) {
            this.metricsId = metricsId;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Long getDate() {
            return date;
        }

        public void setDate(Long date) {
            this.date = date;
        }
    }
}
