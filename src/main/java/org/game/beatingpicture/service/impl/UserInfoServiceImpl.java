package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.entity.HeadImg;
import org.game.beatingpicture.entity.Rank;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.mapper.UserInfoMapper;
import org.game.beatingpicture.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<HeadImg> getAllHeadImg() {
        return userInfoMapper.findAllHeadImg();
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        if(userInfo != null){
            userInfoMapper.createUserInfo(userInfo);
        }
    }

    @Override
    public void updateHeadImg(int userInfoId, int headImgId) {
         userInfoMapper.updateHeadImg(userInfoId,headImgId);
    }

    @Override
    public HeadImg getUserHeadImgByHeadImgId(int userInfoId) {
        return userInfoMapper.getUserHeadImgByHeadImgId(userInfoId);
    }

    @Override
    public void updateDesingationById(int id,int integralValue, int userInfoId) {
         userInfoMapper.updateDesingationById(id,integralValue,userInfoId);
    }

    @Override
    public void updateCoin(int coin, int userInfoId) {
        userInfoMapper.updateCoin(coin,userInfoId);
    }

    @Override
    public UserInfo findById(int userInfoId) {
        return userInfoMapper.findById(userInfoId);
    }
}
