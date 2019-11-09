package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExpMapper {
    Integer getExpByRankId(Integer rankId);

    void updateRankByUserInfoId(Integer userInfoId);

    void updateExpByUserInfoId(@Param("gExp")Integer gExp,@Param("userInfoId")Integer userInfoId);

    void updateExpByUserInfoIdSet(@Param("gExp")Integer gExp,@Param("userInfoId")Integer userInfoId);
}
