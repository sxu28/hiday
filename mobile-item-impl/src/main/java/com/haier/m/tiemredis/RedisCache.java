package com.haier.m.tiemredis;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

public class RedisCache extends InternalRedisCache implements Cache {
    private String name = null;

    public RedisCache(String name, String path) {
        super(path);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return super.getNativeCache();
    }

    @Override
    public ValueWrapper get(Object key) {
        Object value = getObjectFromMap(name, key.toString());
        return value == null ? null : new SimpleValueWrapper(value);
    }

    @Override
    public void put(Object key, Object value) {
        putObjectToMap(name, key.toString(), value, -1);
    }

    @Override
    public void evict(Object key) {
        removeKeysFromMap(name, new String[] { key.toString() });
    }

    @Override
    public void clear() {
        removeMap(name);
    }

}
