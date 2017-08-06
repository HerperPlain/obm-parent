package com.obm.redis;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
public class RedisSessionDao extends EnterpriseCacheSessionDAO{

    private static final Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);
    // session time out 30 minute *60 second
    private static int expireTime = 1800;

    private static  String prefix = "obm-shiro-session";
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.doCreate(session);
        logger.info("创建session:{}",session.getId());
        redisTemplate.opsForValue().set(prefix+sessionId.toString(),session);
        logger.info("把session放入redis中key:={},value:={}",prefix+sessionId.toString(),session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.debug("从缓存中获取sesion：{}",sessionId);
        // 从缓存中获取session，如果没有则从数据库中获取
        Session session = super.doReadSession(sessionId);
        if(session == null){
            session = (Session) redisTemplate.opsForValue().get(prefix+sessionId.toString());
        }

        return session;
    }

    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        logger.debug("从缓存中获取sesion：{}",session.getId());
        String key = prefix+session.getId();
        if(!redisTemplate.hasKey(key)){
            redisTemplate.opsForValue().set(key,session);
        }
        redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);

    }

    @Override
    protected void doDelete(Session session) {
        logger.debug("从缓存中删除sesion：{}",session.getId());
        super.doDelete(session);
        redisTemplate.delete(prefix+session.getId().toString());
    }
}
