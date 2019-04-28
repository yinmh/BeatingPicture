package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExpMapper {
    long getExpByRankId(int rankId);

    void updateRankByUserInfoId(int userInfoId);

    void updateExpByUserInfoId(@Param("gExp")long gExp,@Param("userInfoId")int userInfoId);

    void updateExpByUserInfoIdSet(@Param("gExp")long gExp,@Param("userInfoId")int userInfoId);
}
