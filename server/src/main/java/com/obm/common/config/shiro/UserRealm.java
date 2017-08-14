package com.obm.common.config.shiro;

import com.obm.common.util.StringUtils;
import com.obm.biz.user.entity.UserEntity;
import com.obm.biz.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义实现登录相关数据进行shiro的封装，进行shiro权限管理
 */
public class UserRealm  extends AuthorizingRealm{

    private static final Logger logger = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    UserService userImpl;
    /**
     *  授权：为当前登录的subject授予角色与权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前登录用户的录入的用户名等价于(String)principalConllection.fromRealm(getName()).iterator().next();
        String loginName = super.getAvailablePrincipal(principalCollection).toString();
        //到数据库查询是否存在此对象
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //实际开发，当前登录用户的角色和权限信息是从数据库来获取的，我这里写死是为了方便测试
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("admin");
        info.setRoles(roleSet);
//        //根据用户ID查询权限（permission），放入到Authorization里。
//        List<SysPermission> permissionList = sysPermissionService.selectByMap(map);
//        Set<String> permissionSet = new HashSet<String>();
//        for(SysPermission Permission : permissionList){
//            permissionSet.add(Permission.getName());
//        }
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("query");
        info.setStringPermissions(permissionSet);
        //角色权限加载
        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();

        logger.info("用户名：{}", token.getUsername());
        logger.info("用户密码：{}", token.getPassword());
        if (username == null) {
            throw new AccountException("用户名不能为空");
        }
        UserEntity entity = new UserEntity();
        entity.setUsername(token.getUsername());
        //默认传过来的密码是byte字节需要转换成string
        entity.setPasswd(StringUtils.charsToString(token.getPassword()));
        UserEntity loginEntity = userImpl.queryLogin(entity);
        if(loginEntity == null){
            throw new AccountException("用户名或密码错误");
        }
        logger.info("登录用户信息【{}】",loginEntity);
        return new SimpleAuthenticationInfo(loginEntity,loginEntity.getPasswd(),loginEntity.getUsername());
    }
}
