package org.game.beatingpicture.service;

import org.apache.ibatis.annotations.Param;
import org.game.beatingpicture.entity.HeadImg;
import org.game.beatingpicture.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    List<HeadImg> getAllHeadImg();

    void addUserInfo(UserInfo userInfo);

    void updateHeadImg(int userInfoId, int headImgId);

    HeadImg getUserHeadImgByHeadImgId(int userInfoId);

    void updateDesingationById(int id,int integralValue, int userInfoId);

    void updateCoin(int coin,int userInfoId);

    UserInfo findById(int userInfoId);

}
