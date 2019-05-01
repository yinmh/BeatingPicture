package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.mapper.RewardMapper;
import org.game.beatingpicture.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardServiceImpl implements RewardService {
    @Autowired
    private RewardMapper rewardMapper;
    @Override
    public void updateRewarded(int flag) {
         rewardMapper.updateRewarded(flag);
    }
}
