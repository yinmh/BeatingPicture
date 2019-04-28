package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.mapper.ExpMapper;
import org.game.beatingpicture.service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpServiceImpl implements ExpService {

    @Autowired
    private ExpMapper expMapper;

    @Override
    public long getExpByRankId(int rankId) {
        return expMapper.getExpByRankId(rankId);
    }

    @Override
    public void updateRankByUserInfoId(int userInfoId) {
        expMapper.updateRankByUserInfoId(userInfoId);
    }

    @Override
    public void updateExpByUserInfoId(long gExp, int userInfoId) {
        expMapper.updateExpByUserInfoId(gExp,userInfoId);
    }

    @Override
    public void updateExpByUserInfoIdSet(long gExp, int userInfoId) {
        expMapper.updateExpByUserInfoIdSet(gExp,userInfoId);
    }
}
