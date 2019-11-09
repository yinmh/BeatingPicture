package org.game.beatingpicture.controller;


import org.game.beatingpicture.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reward")
public class RewardController {
    @Autowired
    private RewardService rewardService;

    @PostMapping("/updateRewarded")
    public ResponseEntity updateRewarded(Integer flag) {
        rewardService.updateRewarded(flag);
        return ResponseEntity.ok(0);
    }

}
