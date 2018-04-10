package com.haier.m.tiemredis;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.redisson.BaseMasterSlaveServersConfig;
import org.redisson.ClusterServersConfig;
import org.redisson.Config;
import org.redisson.ElasticacheServersConfig;
import org.redisson.MasterSlaveServersConfig;
import org.redisson.ReadMode;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.redisson.SentinelServersConfig;
import org.redisson.SingleServerConfig;
import org.redisson.codec.SerializationCodec;
import org.redisson.connection.balancer.RandomLoadBalancer;
import org.redisson.connection.balancer.RoundRobinLoadBalancer;
import org.redisson.connection.balancer.WeightedRoundRobinBalancer;
import org.redisson.core.RMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.haier.m.util.RedisUtils;


public class InternalRedisCache implements Cache {
    private static Logger           log                           = LoggerFactory
        .getLogger(InternalRedisCache.class);

    private static final String     REDIS_MODE_CLUSTER            = "cluster";
    private static final String     REDIS_MODE_ELASTICACHE        = "elasticache";
    private static final String     REDIS_MODE_SINGLE             = "single";
    private static final String     REDIS_MODE_SENTINEL           = "sentinel";
    private static final String     REDIS_MODE_MASTER_SLAVE       = "masterSlave";

    private static final String     REDIS_LOAD_BALANCE_RANDOM     = "random";
    private static final String     REDIS_LOAD_BALANCE_ROUNDROBIN = "roundrobin";
    private static final String     REDIS_LOAD_BALANCE_WEIGHT     = "weight";

    private static final String     CONFIG_PATH                   = "classpath:/redis_dev.properties";

    private static Config           config                        = null;
    protected static RedissonClient client                        = null;
    private static Object           lockObj                       = new Object();

    public InternalRedisCache(String path) {
        synchronized (lockObj) {
            if (client == null) {
                if (!StringUtils.isNotBlank(path)) {
                    path = CONFIG_PATH;
                }
                Map<String, String> configMap = RedisUtils.readProperties(path);
                config = new Config();
                config.setCodec(new SerializationCodec());

                String mode = configMap.get("mode");

                BaseMasterSlaveServersConfig smssc = new BaseMasterSlaveServersConfig();
                if (configMap.get("clientName") != null) {
                    smssc.setClientName(configMap.get("clientName"));
                }
                if (configMap.get("idleConnectionTimeout") != null)
                    smssc.setIdleConnectionTimeout(
                        Integer.parseInt(configMap.get("idleConnectionTimeout")));
                if (configMap.get("connectTimeout") != null)
                    smssc.setConnectTimeout(Integer.parseInt(configMap.get("connectTimeout")));
                if (configMap.get("timeout") != null)
                    smssc.setTimeout(Integer.parseInt(configMap.get("timeout")));
                if (configMap.get("retryAttempts") != null)
                    smssc.setRetryAttempts(Integer.parseInt(configMap.get("retryAttempts")));
                if (configMap.get("retryInterval") != null)
                    smssc.setRetryInterval(Integer.parseInt(configMap.get("retryInterval")));
                if (configMap.get("reconnectionTimeout") != null)
                    smssc.setReconnectionTimeout(
                        Integer.parseInt(configMap.get("reconnectionTimeout")));
                if (configMap.get("password") != null)
                    smssc.setPassword(configMap.get("password"));
                if (configMap.get("failedAttempts") != null)
                    smssc.setFailedAttempts(Integer.parseInt(configMap.get("failedAttempts")));

                if (configMap.get("slaveSubscriptionConnectionMinimumIdleSize") != null)
                    smssc.setSlaveSubscriptionConnectionMinimumIdleSize(Integer
                        .parseInt(configMap.get("slaveSubscriptionConnectionMinimumIdleSize")));
                if (configMap.get("slaveSubscriptionConnectionPoolSize") != null)
                    smssc.setSlaveSubscriptionConnectionPoolSize(
                        Integer.parseInt(configMap.get("slaveSubscriptionConnectionPoolSize")));
                if (configMap.get("slaveConnectionMinimumIdleSize") != null)
                    smssc.setSlaveConnectionMinimumIdleSize(
                        Integer.parseInt(configMap.get("slaveConnectionMinimumIdleSize")));
                if (configMap.get("slaveConnectionPoolSize") != null)
                    smssc.setSlaveConnectionPoolSize(
                        Integer.parseInt(configMap.get("slaveConnectionPoolSize")));
                if (configMap.get("masterConnectionMinimumIdleSize") != null)
                    smssc.setMasterConnectionMinimumIdleSize(
                        Integer.parseInt(configMap.get("masterConnectionMinimumIdleSize")));
                if (configMap.get("masterConnectionPoolSize") != null)
                    smssc.setMasterConnectionPoolSize(
                        Integer.parseInt(configMap.get("masterConnectionPoolSize")));
                if (configMap.get("loadBalancer") != null) {
                    String lbConfig = configMap.get("loadBalancer");
                    if (lbConfig.equals(REDIS_LOAD_BALANCE_RANDOM)) {
                        smssc.setLoadBalancer(new RandomLoadBalancer());
                    } else if (lbConfig.equals(REDIS_LOAD_BALANCE_ROUNDROBIN)) {
                        smssc.setLoadBalancer(new RoundRobinLoadBalancer());
                    }
                }
                if (configMap.get("readMode") != null) {
                    String readMode = configMap.get("readMode");
                    if (readMode.equalsIgnoreCase("SLAVE")) {
                        smssc.setReadMode(ReadMode.SLAVE);
                    } else if (readMode.equalsIgnoreCase("MASTER")) {
                        smssc.setReadMode(ReadMode.MASTER);
                    } else if (readMode.equalsIgnoreCase("MASTER_SLAVE")) {
                        smssc.setReadMode(ReadMode.MASTER_SLAVE);
                    }
                }
                if (mode.equalsIgnoreCase(REDIS_MODE_CLUSTER)) {
                    ClusterServersConfig csc = new ClusterServersConfig();

                    String nodes = configMap.get("nodes");

                    if (StringUtils.isBlank(nodes)) {
                        log.error(
                            "Redis配置错误,configPath=" + CONFIG_PATH + "mode=" + mode + ",nodes属性为空");
                        throw new RuntimeException(
                            "Redis配置错误,configPath=" + CONFIG_PATH + ",mode=" + mode + ",nodes属性为空");
                    }

                    setLoadBalanceWeight(configMap, smssc, nodes.split(","));
                    BeanUtils.copyProperties(smssc, csc);

                    if (configMap.get("scanInterval") != null)
                        csc.setScanInterval(Integer.parseInt(configMap.get("scanInterval")));
                    csc.addNodeAddress(nodes.split(","));
                    config.useClusterServers(csc);
                } else if (mode.equalsIgnoreCase(REDIS_MODE_MASTER_SLAVE)) {
                    MasterSlaveServersConfig mssc = new MasterSlaveServersConfig();

                    String masterNode = configMap.get("masterNode");
                    String slaveNodes = configMap.get("slaveNodes");

                    if (StringUtils.isBlank(masterNode) || StringUtils.isBlank(slaveNodes)) {
                        log.error("Redis配置错误,configPath=" + CONFIG_PATH + "mode=" + mode
                                  + ",masterNodes或者slaveNodes属性为空");
                        throw new RuntimeException("Redis配置错误,configPath=" + CONFIG_PATH + ",mode="
                                                   + mode + ",masterNode或者slaveNodes属性为空");
                    }
                    setLoadBalanceWeight(configMap, smssc, slaveNodes.split(","));
                    BeanUtils.copyProperties(smssc, mssc);

                    if (configMap.get("database") != null) {
                        mssc.setDatabase(Integer.parseInt(configMap.get("database")));
                    }
                    mssc.setMasterAddress(masterNode);
                    mssc.addSlaveAddress(slaveNodes.split(","));
                    config.useMasterSlaveServers(mssc);
                } else if (mode.equalsIgnoreCase(REDIS_MODE_ELASTICACHE)) {
                    ElasticacheServersConfig esc = new ElasticacheServersConfig();
                    String nodes = configMap.get("nodes");

                    if (StringUtils.isBlank(nodes)) {
                        log.error(
                            "Redis配置错误,configPath=" + CONFIG_PATH + "mode=" + mode + ",nodes属性为空");
                        throw new RuntimeException(
                            "Redis配置错误,configPath=" + CONFIG_PATH + ",mode=" + mode + ",nodes属性为空");
                    }
                    setLoadBalanceWeight(configMap, smssc, nodes.split(","));
                    BeanUtils.copyProperties(smssc, esc);

                    if (configMap.get("scanInterval") != null)
                        esc.setScanInterval(Integer.parseInt(configMap.get("scanInterval")));
                    if (configMap.get("database") != null) {
                        esc.setDatabase(Integer.parseInt(configMap.get("database")));
                    }
                    esc.addNodeAddress(nodes.split(","));
                    config.useElasticacheServers(esc);
                } else if (mode.equalsIgnoreCase(REDIS_MODE_SINGLE)) {
                    String node = configMap.get("node");
                    if (StringUtils.isBlank(node)) {
                        log.error(
                            "Redis配置错误,configPath=" + CONFIG_PATH + "mode=" + mode + ",node属性为空");
                        throw new RuntimeException(
                            "Redis配置错误,configPath=" + CONFIG_PATH + ",mode=" + mode + ",node属性为空");
                    }
                    SingleServerConfig ssc = config.useSingleServer();
                    ssc.setAddress(node);
                    if (configMap.get("subscriptionConnectionMinimumIdleSize") != null)
                        ssc.setSubscriptionConnectionMinimumIdleSize(Integer
                            .parseInt(configMap.get("subscriptionConnectionMinimumIdleSize")));
                    if (configMap.get("subscriptionConnectionPoolSize") != null)
                        ssc.setSubscriptionConnectionPoolSize(
                            Integer.parseInt(configMap.get("subscriptionConnectionPoolSize")));
                    if (configMap.get("connectionMinimumIdleSize ") != null)
                        ssc.setConnectionMinimumIdleSize(
                            Integer.parseInt(configMap.get("connectionMinimumIdleSize")));
                    if (configMap.get("connectionPoolSize ") != null)
                        ssc.setConnectionPoolSize(
                            Integer.parseInt(configMap.get("connectionPoolSize")));
                    if (configMap.get("database ") != null)
                        ssc.setDatabase(Integer.parseInt(configMap.get("database")));
                    config.useSingleServer(ssc);
                } else if (mode.equalsIgnoreCase(REDIS_MODE_SENTINEL)) {
                    SentinelServersConfig ssc = new SentinelServersConfig();

                    String nodes = configMap.get("nodes");
                    if (StringUtils.isBlank(nodes)) {
                        log.error(
                            "Redis配置错误,configPath=" + CONFIG_PATH + "mode=" + mode + ",nodes属性为空");
                        throw new RuntimeException(
                            "Redis配置错误,configPath=" + CONFIG_PATH + ",mode=" + mode + ",nodes属性为空");
                    }
                    setLoadBalanceWeight(configMap, smssc, nodes.split(","));
                    BeanUtils.copyProperties(smssc, ssc);
                    ssc.addSentinelAddress(nodes.split(","));

                    if (configMap.get("masterName") != null) {
                        ssc.setMasterName(configMap.get("masterName"));
                    }
                    if (configMap.get("database") != null) {
                        ssc.setDatabase(Integer.parseInt(configMap.get("database")));
                    }
                    config.useSentinelServers(ssc);
                }

                client = Redisson.create(config);
            } else {
            }
        }
    }

    private void setLoadBalanceWeight(Map<String, String> configMap,
                                      BaseMasterSlaveServersConfig smssc, String[] nodes) {
        if (configMap.get("loadBalancer") != null) {
            String lbConfig = configMap.get("loadBalancer");
            if (lbConfig.equals(REDIS_LOAD_BALANCE_WEIGHT)) {
                String[] weightStr = null;
                String defaultWeightStr = configMap.get("defaultWeight");
                Map<String, Integer> weights = new HashMap<String, Integer>();
                int defaultWeight = StringUtils.isNotBlank(defaultWeightStr)
                    ? Integer.parseInt(defaultWeightStr) : 1;

                if (configMap.get("weights") == null) {
                    log.error("weights is empty!");
                    throw new RuntimeException("weights is empty!");
                }
                weightStr = configMap.get("weights").split(",");
                if (nodes.length != weightStr.length) {
                    log.error("nodes length not equal weight length!");
                    throw new RuntimeException("nodes length not equal weight length!");
                }
                for (int i = 0; i < nodes.length; i++) {
                    int weight = defaultWeight;
                    if (StringUtils.isNotBlank(weightStr[i])) {
                        weight = Integer.parseInt(weightStr[i]);
                    }
                    weights.put(nodes[i], weight);
                }
                smssc.setLoadBalancer(new WeightedRoundRobinBalancer(weights, defaultWeight));
            }
        }
    }

    @Override
    public boolean putObject(String key, Object value, long cacheTime) {
        try {
            if (cacheTime < 0) {
                client.getBucket(key).set(value);
            } else {
                client.getBucket(key).set(value, cacheTime, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception ex) {
            log.error("", ex);
            return false;
        }
    }

    @Override
    public Object getObject(String key) {
        if (client.getBucket(key).isExists())
            return client.getBucket(key).get();
        return null;
    }

    @Override
    public boolean removeObject(String key) {
        return client.getBucket(key).delete();
    }

    @Override
    public boolean addToList(String key, Object value, long cacheTime) {
        try {
            boolean r = client.getList(key).add(value);
            if (r && cacheTime > 0)
                client.getList(key).expire(cacheTime, TimeUnit.SECONDS);
            return r;
        } catch (Exception ex) {
            log.error("", ex);
            return false;
        }

    }

    @Override
    public boolean addToList(String key, int index, Object value, long cacheTime) {
        try {
            client.getList(key).add(value);
            if (cacheTime > 0)
                client.getList(key).expire(cacheTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception ex) {
            log.error("", ex);
            return false;
        }
    }

    @Override
    public boolean addAllToList(String key, List values, long cacheTime) {
        try {
            client.getList(key).addAll(values);
            if (cacheTime > 0)
                client.getList(key).expire(cacheTime, TimeUnit.SECONDS);
            return true;
        } catch (Exception ex) {
            log.error("", ex);
            return false;
        }
    }

    @Override
    public Object getFromList(String key, int index) {
        return client.getList(key).get(index);
    }

    @Override
    public Object[] getArrayFromList(String key) {
        if (client.getList(key).isExists()) {
            return client.getList(key).toArray();
        }
        return null;
    }

    @Override
    public boolean removeFromList(String key, int index) {
        try {
            client.getList(key).remove(index);
            return true;
        } catch (Exception ex) {
            log.error("", ex);
            return false;
        }
    }

    @Override
    public boolean removeList(String key) {
        return client.getList(key).delete();
    }

    @Override
    public int findObjectInList(String key, Object obj) {
        if (obj == null)
            return -1;
        Object[] objs = getArrayFromList(key);
        for (int i = 0; i < objs.length; i++) {
            Object tobj = objs[i];
            if (obj.equals(tobj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean compareAndSetObject(String key, Object expect, Object update) {
        return client.getBucket(key).compareAndSet(expect, update);
    }

    @Override
    public boolean putLong(String key, Long value, long cacheTime) {
        try {
            client.getAtomicLong(key).set(value);
            if (cacheTime > 0) {
                client.getAtomicLong(key).expire(cacheTime, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception ex) {
            log.error("", ex);
            return false;
        }
    }

    @Override
    public Long getLong(String key) {
        if (client.getAtomicLong(key).isExists()) {
            return client.getAtomicLong(key).get();
        }
        return null;
    }

    @Override
    public boolean removeLong(String key) {
        return client.getAtomicLong(key).delete();
    }

    @Override
    public Long addAndGetLong(String key, Long delta) {
        return client.getAtomicLong(key).addAndGet(delta);
    }

    @Override
    public Long getAndAddLong(String key, Long delta) {
        return client.getAtomicLong(key).getAndAdd(delta);
    }

    @Override
    public Long decrementAndGetLong(String key, Long delta) {
        return client.getAtomicLong(key).decrementAndGet();
    }

    @Override
    public Long getAndDecrementLong(String key, Long delta) {
        return client.getAtomicLong(key).getAndDecrement();
    }

    @Override
    public boolean setObjectToList(String key, int index, Object obj) {
        try {
            client.getList(key).set(index, obj);
            return true;
        } catch (Exception ex) {
            log.error("", ex);
            return false;
        }
    }

    @Override
    public boolean isExistList(String key) {
        return client.getList(key).isExists();
    }

    @Override
    public Collection<String> findKeyByPattern(String pattern) {
        return client.getKeys().findKeysByPattern(pattern);
    }

    @Override
    public boolean putObjectToMap(String name, String key, Object value, long cacheTime) {
        try {
            RMap<String, Object> rmap = client.getMap(name);
            rmap.put(key, value);
            if (cacheTime > 0) {
                client.getMap(name).expire(cacheTime, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception ex) {
            log.error("", ex);
            return false;
        }
    }

    @Override
    public Object getObjectFromMap(String name, String key) {
        if (client.getMap(name).isExists()) {
            RMap<String, Object> rmap = client.getMap(name);
            return rmap.get(key);
        }
        return null;
    }

    @Override
    public Map<String, Object> getObjectsFromMap(String name, Set<String> keys) {
        if (client.getMap(name).isExists()) {
            RMap<String, Object> rmap = client.getMap(name);
            return rmap.getAll(keys);
        }
        return null;
    }

    @Override
    public Set<String> getKeySetFromMap(String name) {
        if (client.getMap(name).isExists()) {
            RMap<String, Object> rmap = client.getMap(name);
            return new LinkedHashSet<String>(rmap.keySet());
        }
        return null;
    }

    @Override
    public void removeKeysFromMap(String name, String[] keys) {
        if (client.getMap(name).isExists()) {
            RMap<String, Object> rmap = client.getMap(name);
            rmap.fastRemove(keys);
        }

    }

    @Override
    public Object addAndGetToMap(String name, String key, Number delta) {
        RMap<String, Object> rmap = client.getMap(name);
        return rmap.addAndGet(key, delta);
    }

    @Override
    public boolean removeMap(String name) {
        if (client.getMap(name).isExists()) {
            return client.getMap(name).delete();
        }
        return true;
    }

    @Override
    public Set<Map.Entry<Object, Object>> getAllFromMap(String name) {
        if (client.getMap(name).isExists()) {
            return new LinkedHashSet<Map.Entry<Object, Object>>(client.getMap(name).entrySet());
        }
        return null;
    }

    @Override
    public Object getNativeCache() {
        return client;
    }
}
