package com.obm.common.config.redis;

import org.apache.shiro.session.mgt.AbstractSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);
    @Bean
    public CacheManager cacheManager(RedisTemplate<Object,Object> redisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(AbstractSessionManager.DEFAULT_GLOBAL_SESSION_TIMEOUT);
        logger.info("初始化缓存管理器：加载redis模板^_^");
        return cacheManager;
    }
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<Object,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        // 设置key value的类型
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        logger.info("初始化redis模板：模板用于操作redis，增删改查^_^");
        return template;
    }
}
