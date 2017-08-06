package com.obm.controller;
import com.obm.user.entity.UserEntity;
import com.obm.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
            logger.info("登录成功---------------");
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
        return "redirect:admin/index.html";
    }
}
