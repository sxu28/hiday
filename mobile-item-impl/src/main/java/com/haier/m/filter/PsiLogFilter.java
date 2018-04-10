package com.haier.m.filter;

import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSON;
import com.haier.common.util.DateUtil;
import com.haier.openplatform.console.domain.InvokeSumBean;
import com.haier.openplatform.console.domain.InvokeSumBeans;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PsiLogFilter implements Filter {
    private Logger log = LoggerFactory.getLogger("psilogger");

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            long startTime = System.currentTimeMillis();
            Result result = invoker.invoke(invocation);
            long endTime = System.currentTimeMillis();
            Map<String, InvokeSumBean> tm = new HashMap<String, InvokeSumBean>();
            InvokeSumBean tmpISB = new InvokeSumBean();
            tmpISB.setApiNM(invoker.getInterface().getName() + "." + invocation.getMethodName());
            tmpISB.setCallNum(1L);
            tmpISB.setResponseTime(endTime - startTime);
            tmpISB.setAppNM("WEIDIAN");
            tmpISB.setNodeNM(InetAddress.getLocalHost().getHostName().toString());
            tmpISB.setNodeIP(InetAddress.getLocalHost().getHostAddress().toString());
            tmpISB.setGmtCreate(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            tm.put("WEIDIAN", tmpISB);
            InvokeSumBeans isbs = new InvokeSumBeans(new ArrayList<InvokeSumBean>(tm.values()));
            XStream xs = new XStream(new DomDriver());
            xs.autodetectAnnotations(true);
            xs.setMode(1001);
//            log.info(JSON.toJSONString(new PsiLogEntity("WEIDIAN", "Direct", invoker
//                .getInterface().getName() + ":" + invocation.getMethodName(), xs.toXML(isbs))));
            return result;
        } catch (UnknownHostException e) {
            return null;
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
