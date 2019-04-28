package org.game.beatingpicture.controller;

import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.mapper.UserInfoMapper;
import org.game.beatingpicture.service.DesingationService;
import org.game.beatingpicture.service.ExpService;
import org.game.beatingpicture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/exp")
public class ExpController {

    @Autowired
    private ExpService expService;

    @Autowired
    private UserService userService;

    @PostMapping("/getExpByRankId")
    public ResponseEntity getExpByRankId(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        long nExp = expService.getExpByRankId(userInfo.getRankId());
        return ResponseEntity.ok(nExp);
    }

    /*
    * 用于经验获取和等级提升的接口
    * */
    @Transactional
    @GetMapping("/upgrade")
    public ResponseEntity upgrade(long gExp,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        long nExp = expService.getExpByRankId(userInfo.getRankId());
        long hExp = userInfo.getHExp();
        if((hExp + gExp) < nExp){
            expService.updateExpByUserInfoId(gExp,userInfo.getId());
        }else if((hExp + gExp) == nExp){
            expService.updateRankByUserInfoId(userInfo.getId());
            expService.updateExpByUserInfoIdSet(0,userInfo.getId());
        }else {
            expService.updateExpByUserInfoIdSet((gExp + hExp - nExp),userInfo.getId());
            expService.updateRankByUserInfoId(userInfo.getId());
        }
        return ResponseEntity.ok(0);
    }


}
