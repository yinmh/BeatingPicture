package org.game.beatingpicture.service;

import org.apache.ibatis.annotations.Param;
import org.game.beatingpicture.entity.HeadImg;
import org.game.beatingpicture.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<HeadImg> getAllHeadImg();

    void addUserInfo(UserInfo userInfo);

    void updateHeadImg(Integer userInfoId, Integer headImgId);

    HeadImg getUserHeadImgByHeadImgId(Integer userInfoId);

    void updateDesingationById(Integer id,Integer integralValue, Integer userInfoId);

    void updateCoin(Integer coin,Integer userInfoId);

    UserInfo findById(Integer userInfoId);

}
