package com.haier.m.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.common.util.StringUtil;

public class RedisUtils {
    private static Logger log = LoggerFactory.getLogger(RedisUtils.class);

    public static Map<String, String> readProperties(String filePath) {
        Properties p = new Properties();
        boolean readFromClasspath = false;
        if (filePath.startsWith("classpath:")) {
            filePath = filePath.substring("classpath:".length());
            readFromClasspath = true;
        }

        InputStream configStream = null;
        if (readFromClasspath) {
            configStream = RedisUtils.class.getResourceAsStream(filePath);
        } else {
            try {
                configStream = new FileInputStream(new File(filePath));
            } catch (FileNotFoundException e) {
                log.error("", e);
                return null;
            }
        }
        try {
            Map<String, String> configMap = new HashMap<String, String>();
            p.load(configStream);
            for (Object key : p.keySet()) {
                String value = p.getProperty(key.toString()) == null ? null
                    : p.getProperty(key.toString());
                if (StringUtil.isEmpty(value)) {
                    value = null;
                }
                configMap.put(key.toString(), value);
            }
            return configMap;
        } catch (IOException e) {
            log.error("", e);
        }
        return null;
    }
}
