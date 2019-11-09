package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Boss;
import org.game.beatingpicture.mapper.BossMapper;
import org.game.beatingpicture.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BossServiceImpl implements BossService {
    @Autowired
    private BossMapper bossMapper;

    @Override
    public Boss getBossByAreaId(Integer areaId) {
        return bossMapper.getBossByAreaId(areaId);
    }
}
