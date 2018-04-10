package com.haier.m.tiemredis;

public class CacheFactory {
    private static String redisConfigPath = null;

    public String getRedisConfigPath() {
        return redisConfigPath;
    }

    public void setRedisConfigPath(String redisConfigPath) {
        CacheFactory.redisConfigPath = "classpath:/" + redisConfigPath;
    }

    public static Cache getCache(String name) {
        if (name.equalsIgnoreCase("redis")) {
            return new InternalRedisCache(redisConfigPath);
        }
        return null;
    }
}
