package com.obm.controller;
import com.obm.biz.user.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private  static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/doLogin")
    public String doLogin(){
        return "redirect:admin/index.html";
    }

    @RequestMapping("/ajaxLogin")
    public String ajaxLogin(UserEntity model){
        UsernamePasswordToken token = new UsernamePasswordToken(model.getUsername(), model.getPasswd());
        try {
            SecurityUtils.getSubject().login(token);
            logger.info("{},登录成功",model.getUsername());
        } catch (UnknownAccountException uae) {
            logger.error("There is no user with username of " + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            logger.error("Password for account " + token.getPrincipal() + " was incorrect!");
        } catch (LockedAccountException lae) {
            logger.error("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
        }
        // ... catch more exceptions here (maybe custom ones specific to your application?
        catch (AuthenticationException ae) {
            logger.error("登录失败：{}",ae.getMessage());
        }
        return "index";
    }

    @RequestMapping("/user/queryList")
    @ResponseBody
    public List<UserEntity> queryList(UserEntity model){
        List<UserEntity> list = new ArrayList<>();
        UserEntity entity = new UserEntity();
        entity.setUserId("1");
        entity.setUsername("1");
        entity.setPasswd("1");
        list.add(entity);

        entity = new UserEntity();
        entity.setUserId("2");
        entity.setUsername("2");
        entity.setPasswd("2");
        list.add(entity);

        entity = new UserEntity();
        entity.setUserId("3");
        entity.setUsername("3");
        entity.setPasswd("3");
        list.add(entity);
        return list;
    }
}
