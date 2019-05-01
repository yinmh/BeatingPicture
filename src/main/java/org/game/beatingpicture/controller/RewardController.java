package org.game.beatingpicture.controller;

import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.mapper.UserInfoMapper;
import org.game.beatingpicture.service.DesingationService;
import org.game.beatingpicture.service.RewardService;
import org.game.beatingpicture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reward")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    @PostMapping("/updateRewarded")
    public ResponseEntity updateRewarded(int flag) {
        rewardService.updateRewarded(flag);
        return ResponseEntity.ok(0);
    }

}
