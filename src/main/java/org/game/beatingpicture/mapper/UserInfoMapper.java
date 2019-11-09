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

    Desingation getDesingationById(Integer id);

    Rank getRankById(Integer id);

    void updateHeadImg(@Param("userInfoId") Integer userInfoId, @Param("headImgId") Integer headImgId);

    HeadImg getUserHeadImgByHeadImgId(Integer userInfoId);

    void updateDesingationById(@Param("id") Integer id, @Param("integralValue") Integer integralValue, @Param("userInfoId") Integer userInfoId);

    void updateCoin(@Param("coin") Integer coin, @Param("userInfoId") Integer userInfo);

    UserInfo findById(Integer userInfoId);
}
