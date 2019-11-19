package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Picture;
import org.game.beatingpicture.mapper.PictureMapper;
import org.game.beatingpicture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;


    @Override
    public Picture getPictureById(Integer id) {
        return pictureMapper.selectPictureById(id);
    }

    //查询用户是否已经购买此卡片
    @Override
    public Boolean findUserPictureCount(Integer userInfo, Integer pictureId) {
        int row = pictureMapper.selectUserPictureCount(userInfo, pictureId);
        if (row > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Picture> getAllPictureByUserInfoId(Integer userInfoId) {
        return pictureMapper.getAllPictureByUserInfoId(userInfoId);
    }

    @Override
    public List<Picture> getAllPictureByStatus(Integer userInfoId) {
        return pictureMapper.getAllPictureByStatus(userInfoId);
    }

    @Override
    public void updatePictureStatus(Integer id, Integer flag) {
        pictureMapper.updatePictureStatus(id,flag);
    }

    @Override
    public int findCount(Integer userInfoId) {
        return pictureMapper.findCount(userInfoId);
    }

    //查找 该角色下拥有的所有卡片
    @Override
    public List<Picture> getUserPicture(Integer userInfoId) {
        return pictureMapper.getUserPicture(userInfoId);
    }
    //查询用户收藏
    @Override
    public List<Picture> getUserCollect(Integer userInfoId) {
        return pictureMapper.getUserCollect(userInfoId);
    }

    //收藏/取消收藏商品
    @Override
    public boolean collectOrCancel(Integer pictureId, Integer userInfoId) {
        int count = pictureMapper.selectCollected(pictureId, userInfoId);
        if (count == 1){
            pictureMapper.cancelCollect(pictureId,userInfoId);
            return true;
        }else {
            pictureMapper.collect(pictureId,userInfoId);
            return true;
        }
    }

    //获取卡片
    @Override
    public boolean getPicture(Map<String,Object> getPicture) {
        getPicture.put("getTime",new Date());
        int row = pictureMapper.addPicture(getPicture);
        if (row > 0){
            return true;
        }else {
            return false;
        }
    }
}
