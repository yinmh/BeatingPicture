package org.game.beatingpicture.service.impl;

import io.swagger.models.auth.In;
import org.game.beatingpicture.mapper.ExpMapper;
import org.game.beatingpicture.service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpServiceImpl implements ExpService {

    @Autowired
    private ExpMapper expMapper;

    @Override
    public Integer getExpByRankId(Integer rankId) {
        return expMapper.getExpByRankId(rankId);
    }

    @Override
    public void updateRankByUserInfoId(Integer userInfoId) {
        expMapper.updateRankByUserInfoId(userInfoId);
    }

    @Override
    public void updateExpByUserInfoId(Integer gExp, Integer userInfoId) {
        expMapper.updateExpByUserInfoId(gExp,userInfoId);
    }

    @Override
    public void updateExpByUserInfoIdSet(Integer gExp, Integer userInfoId) {
        expMapper.updateExpByUserInfoIdSet(gExp,userInfoId);
    }
}
