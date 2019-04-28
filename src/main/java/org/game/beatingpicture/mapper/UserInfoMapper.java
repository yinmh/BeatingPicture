package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.entity.HeadImg;
import org.game.beatingpicture.entity.Rank;
import org.game.beatingpicture.entity.UserInfo;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    /**
     * 查看所有头像的方法
     */
    List<HeadImg> findAllHeadImg();

    void createUserInfo(UserInfo userInfo);

    Desingation getDesingationById(int id);

    Rank getRankById(int id);

    void updateHeadImg(@Param("userInfoId") int userInfoId, @Param("headImgId") int headImgId);

    HeadImg getUserHeadImgByHeadImgId(int userInfoId);

    void updateDesingationById(@Param("id") int id, @Param("integralValue") int integralValue, @Param("userInfoId") int userInfoId);

    void updateCoin(@Param("coin") int coin, @Param("userInfoId") int userInfo);
}
