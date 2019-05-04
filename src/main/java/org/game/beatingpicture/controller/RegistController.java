package org.game.beatingpicture.controller;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.service.UserService;
import org.game.beatingpicture.util.PasswordHash;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RegistController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toregist")
    public String toregist(){
        return "registion";
    }

    @PostMapping("/registuser")
    public void registUser(User user){
        //todo
        user.setPassword(PasswordHash.createHash(user.getPassword()));
        userService.registUser(user);
    }
}
