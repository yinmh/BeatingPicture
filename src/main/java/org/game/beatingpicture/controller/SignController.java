package org.game.beatingpicture.controller;

import io.swagger.models.auth.In;
import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.entity.Sign;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.service.SignService;
import org.game.beatingpicture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
* 用于处理签到功能
* */
@RestController
@RequestMapping("/sign")
public class SignController {
    @Autowired
    private SignService signService;
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllSign")
    public ResponseEntity getAllSign(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",signService.getAllSign());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int nowDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        map.put("nowDay",nowDay);
        return ResponseEntity.ok(map);
    }

    @RequestMapping("/getSignByUserInfoId")
    public ResponseEntity getSignByUserInfoId(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        Sign sign = signService.getSignByUserInfoId(userInfo.getId());
//        SignVo signVo = new SignVo();
//        signVo.setId(sign.getId());
//        signVo.setPrizePictureId(sign.getPrizePictureId());
//        signVo.setTitle(sign.getTitle());
//        signVo.setIcon(sign.getIcon());
//        signVo.setNowDay(new Date());
        return ResponseEntity.ok(sign);
    }


    @PostMapping("/updateSigned")
    public ResponseEntity updateSigned(Integer flag){
        signService.updateSigned(flag);
        return ResponseEntity.ok(0);
    }


}
