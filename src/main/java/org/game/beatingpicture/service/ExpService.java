package org.game.beatingpicture.service;

public interface ExpService {
    Integer getExpByRankId(Integer rankId);

    void updateRankByUserInfoId(Integer userInfoId);

    void updateExpByUserInfoId(Integer gExp,Integer userInfoId);
    void updateExpByUserInfoIdSet(Integer gExp,Integer userInfoId);
}
