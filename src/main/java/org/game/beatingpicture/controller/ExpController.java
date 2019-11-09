package org.game.beatingpicture.controller;

import io.swagger.models.auth.In;
import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.mapper.UserInfoMapper;
import org.game.beatingpicture.service.*;
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

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private AreaService areaService;

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
    @PostMapping("/upgradeAndUpdateCoin")
    public ResponseEntity upgradeAndUpdateCoin(Integer areaId, Integer gExp, Integer coin, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        Integer nExp = expService.getExpByRankId(userInfo.getRankId());
        Integer hExp = userInfo.getHExp();
        if((hExp + gExp) < nExp){
            expService.updateExpByUserInfoId(gExp,userInfo.getId());
            userInfoService.updateCoin(coin,userInfo.getId());
            areaService.updateStatus(0,areaId);
        }else if((hExp + gExp) == nExp){
            expService.updateRankByUserInfoId(userInfo.getId());
            expService.updateExpByUserInfoIdSet(0,userInfo.getId());
            userInfoService.updateCoin(coin,userInfo.getId());
            areaService.updateStatus(0,areaId);
        }else {
            expService.updateExpByUserInfoIdSet((gExp + hExp - nExp),userInfo.getId());
            expService.updateRankByUserInfoId(userInfo.getId());
            userInfoService.updateCoin(coin,userInfo.getId());
            areaService.updateStatus(0,areaId);
        }
        return ResponseEntity.ok(0);
    }


}
