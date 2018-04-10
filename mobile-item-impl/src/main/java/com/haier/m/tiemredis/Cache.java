package com.haier.m.tiemredis;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface Cache {
    /**
     * 以key-value形式存储进redis中
     * @param key
     * @param value
     * @param cacheTime 失效时间（秒）
     * @return
     */
    public boolean putObject(String key, Object value, long cacheTime);

    /**
     * 取得对应key存储的value
     * @param key
     * @return
     */
    public Object getObject(String key);

    /**
     * 删除对应的key-value对
     * @param key
     * @return
     */
    public boolean removeObject(String key);

    /**
     * 向List中添加数据
     * @param key
     * @param value
     * @param cacheTime 当前数据过期时间
     * @return
     */
    public boolean addToList(String key, Object value, long cacheTime);

    /**
     * 向List指定位置插入数据
     * @param key
     * @param index 顺序号
     * @param value
     * @param cacheTime
     * @return
     */
    public boolean addToList(String key, int index, Object value, long cacheTime);

    /**
     * 向List中批量添加数据
     * @param key
     * @param values
     * @param cacheTime
     * @return
     */
    public boolean addAllToList(String key, List values, long cacheTime);

    /**
     * 获得List指定位置的数据
     * @param key
     * @param index
     * @return
     */
    public Object getFromList(String key, int index);

    /**
     * 获得List中所有数据
     * @param key
     * @return
     */
    public Object[] getArrayFromList(String key);

    /**
     * 删除List指定位置数据
     * @param key
     * @param index
     * @return
     */
    public boolean removeFromList(String key, int index);

    /**
     * 清空整个List
     * @param key
     * @return
     */
    public boolean removeList(String key);

    /**
     * 查找指定数据在List中的位置
     * @param key
     * @param obj
     * @return 返回所在的位置信息，如果没有找到返回-1
     */
    public int findObjectInList(String key, Object obj);

    /**
     * 如果给定的期望对象与缓存中的对象相同，则将新对象更新至指定key中，反之则不进行更新操作
     * @param key
     * @param expect 期望对象
     * @param update 更新更像
     * @return 如果修改成功相同返回true，如果修改不成功返回false
     */
    public boolean compareAndSetObject(String key, Object expect, Object update);

    /**
     * 向缓存中存入长整型值，长整型可以进行原子增减操作
     * @param key
     * @param value
     * @param cacheTime
     * @return
     */
    public boolean putLong(String key, Long value, long cacheTime);

    /**
     * 获得key对应的长整型值
     * @param key
     * @return
     */
    public Long getLong(String key);

    /**
     * 删除key对应的长整型值
     * @param key
     * @return
     */
    public boolean removeLong(String key);

    /**
     * 对指定的key值进行自增操作，并且返回自增后的值
     * @param key
     * @param delta
     * @return
     */
    public Long addAndGetLong(String key, Long delta);

    /**
     * 对指定的key值进行自增操作，并且返回自增前的值
     * @param key
     * @param delta
     * @return
     */
    public Long getAndAddLong(String key, Long delta);

    /**
     * 对指定的key值进行自减操作，并且返回自减后的值
     * @param key
     * @param delta
     * @return
     */
    public Long decrementAndGetLong(String key, Long delta);

    /**
     * 对指定的key值进行自减操作，并且返回自减前的值
     * @param key
     * @param delta
     * @return
     */
    public Long getAndDecrementLong(String key, Long delta);

    /**
     * 替换List指定位置的元素
     * @param key
     * @param index
     * @param obj
     * @return
     */
    public boolean setObjectToList(String key, int index, Object obj);

    /**
     * 缓存中是否存在指定的List
     * @param key
     * @return
     */
    public boolean isExistList(String key);

    /**
     * 按照所提供的模式字符串匹配并返回key值集合
     * @param pattern 可以输入形如abc*,abc?,a[bc]的查找模式字符串
     * @return
     */
    public Collection<String> findKeyByPattern(String pattern);

    /**
     * 向指定的Map集合中添加元素，已有则覆盖
     * @param name Map名称
     * @param key
     * @param value
     * @param cacheTime
     * @return
     */
    public boolean putObjectToMap(String name, String key, Object value, long cacheTime);

    /**
     * 从指定Map集合中获取key对应的value值
     * @param name
     * @param key
     * @return
     */
    public Object getObjectFromMap(String name, String key);

    /**
     * 根据给定的key集合获取对应的value值
     * @param name
     * @param keys
     * @return
     */
    public Map<String, Object> getObjectsFromMap(String name, Set<String> keys);

    /**
     * 获得Map中所有的key
     * @param name
     * @return
     */
    public Set<String> getKeySetFromMap(String name);

    /**
     * 删除Map中指定的key
     * @param name
     * @param keys
     * @return
     */
    public void removeKeysFromMap(String name, String[] key);

    /**
     * 对Map中指定的key进行自增操作(此key对应的value必须为number)
     * @param name
     * @param key
     * @param delta 自增数量
     * @return
     */
    public Object addAndGetToMap(String name, String key, Number delta);

    /**
     * 删除指定的Map集合
     * @param name
     * @return
     */
    public boolean removeMap(String name);

    /**
     * 获得Map中所有key-value对
     * @param name
     * @return
     */
    public Set<Map.Entry<Object,Object>> getAllFromMap(String name);
    /**
     * <p>获得底层cache操作对象</p>
     * <b><font color="red">如果没有特殊需求，请绝对不要随意使用此操作对象，否则可能会造成系统不稳定，代码难以维护等后果</font></b>
     * @return 返回缓存底层操作对象
     */
    public Object getNativeCache();
}
