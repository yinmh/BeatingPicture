package org.game.beatingpicture.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.service.UserService;
import org.game.beatingpicture.util.PasswordHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    @RequestMapping("/createRole")
    public String createRole(){
        return "user/createFrom";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, HttpServletRequest request){
        String result = "redirect:/index";
        String fail = "redirect:/login";
        String errorMsg = "";

        // shiro认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            User user = userService.getUserByUserName(username);
            if(user != null){
                user.setPassword("");
               request.getSession().setAttribute("user",user);
            }
        } catch (UnknownAccountException e) {
            result = fail;
            errorMsg = "账户不存在";
        } catch (DisabledAccountException e) {
            result = fail;
            errorMsg = "账户已冻结";
        } catch (AuthenticationException e) {
            result = fail;
            errorMsg = "密码错误";
        } catch (Exception e) {
            result = fail;
            errorMsg = "登陆异常";
            log.error(e.getMessage(),e);
        }

        request.setAttribute("error",errorMsg);
        return result;
    }



    @RequestMapping("/doLogout")
    public String doLogout(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }

    @RequestMapping("/getSession")
    public ResponseEntity getSession(HttpServletRequest request){
        return ResponseEntity.ok( request.getSession().getAttribute("user"));
    }

//    public static void main(String[] args) {
//        String PASS = PasswordHash.createHash("admin");
//        String PASS2 = PasswordHash.createHash("admin");
//        System.err.println(PASS);
//        System.err.println(PASS2);
//        System.err.println(PasswordHash.validatePassword("admin",PASS2));
//    }

}
