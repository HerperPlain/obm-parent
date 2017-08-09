package com.obm.common.config.redis;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ShiroCache<K,V> implements Cache<K , V> {
    private static final String REDIS_SHIRO_CACHE = "obm-shiro-cache-";
    private String cacheKey;
    private RedisTemplate<K , V> redisTemplate;
    private long globExpire = 30;

    public ShiroCache(String name,RedisTemplate client){
        this.cacheKey = REDIS_SHIRO_CACHE + name + ":";
        this.redisTemplate = client;
    }
    private K getCacheKey(Object key){
        return (K) (this.cacheKey+key);
    }

    @Override
    public V get(K key) throws CacheException {
        redisTemplate.boundValueOps(getCacheKey(key)).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        V old = get(key);
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return old;
    }

    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return null;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<V>();
        for (K key : set){
            list.add(get(key));
        }
        return list;
    }
}
