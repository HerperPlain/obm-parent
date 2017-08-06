package com.obm.shiro;

import com.obm.redis.RedisCacheManager;
import com.obm.redis.RedisSessionDao;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class ShiroConfig {
    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
    @Resource
    private RedisSessionDao sessionDao;

    @Bean
    public UserRealm getUserRealm(){
        return new UserRealm();
    }
    @Bean
    public LifecycleBeanPostProcessor getLifecyceBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    @Bean
    public RedisCacheManager redisCacheManager(){
        return  new RedisCacheManager();
    }

//    @Bean
//    public SessionManager sessionManager(){
//        logger.info("创建默认的sessionManager");
//        DefaultSessionManager sessionManager = new DefaultSessionManager();
//        logger.info("给默认的sessionManager初始化redisCacheManager类：用来进行redis中ShiroCache操作");
//        sessionManager.setCacheManager(redisCacheManager());
//        logger.info("给默认的sessionManager初始化sessionDao类：用来进行redis中session操作");
//        sessionManager.setSessionDAO(sessionDao);
//        sessionManager.setGlobalSessionTimeout(1800);
//        return sessionManager;
//    }


    @Bean
    public SecurityManager securityManager(){
        logger.info("创建默认的DefaultWebSecurityManager");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        logger.info("给默认的DefaultWebSecurityManager初始化sessionManager");
//        securityManager.setSessionManager(sessionManager());
        logger.info("给默认的DefaultWebSecurityManager初始化redisCacheManager");
//        securityManager.setCacheManager(redisCacheManager());
        logger.info("给默认的DefaultWebSecurityManager初始化登录处理方法");
        securityManager.setRealm(getUserRealm());
        return  securityManager;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager());
        return aasa;
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        logger.info("初始化shiro，进行权限过滤配置");
        Map<String,String> filterChainDefinitionMap = new HashMap<String,String>();
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/");
        shiroFilterFactoryBean.setSuccessUrl("/doLogin");
//        filterChainDefinitionMap.put("/**","authc");
        filterChainDefinitionMap.put("/admin/**","authc");
        filterChainDefinitionMap.put("/login/**","anon");
        //数据库链接池监控界面
        filterChainDefinitionMap.put("/druid/**","authc");
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return  shiroFilterFactoryBean;
    }
}
