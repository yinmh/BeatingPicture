package org.game.beatingpicture.service;

public interface ExpService {
    long getExpByRankId(int rankId);

    void updateRankByUserInfoId(int userInfoId);

    void updateExpByUserInfoId(long gExp,int userInfoId);
    void updateExpByUserInfoIdSet(long gExp,int userInfoId);
}
