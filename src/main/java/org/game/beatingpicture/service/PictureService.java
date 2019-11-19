package org.game.beatingpicture.service;

import org.apache.ibatis.annotations.Param;
import org.game.beatingpicture.entity.Picture;

import java.util.List;
import java.util.Map;

public interface PictureService {
    Picture getPictureById(Integer id);

    //查询用户是否已经购买此卡片
    Boolean findUserPictureCount(Integer userInfo,Integer pictureId);

    List<Picture> getAllPictureByUserInfoId(Integer userInfoId);

    //查找 该角色下 status 为 1 的卡片，即上阵的卡片
    List<Picture> getAllPictureByStatus(Integer userInfoId);

    void updatePictureStatus(Integer id, Integer flag);

    int findCount(Integer userInfoId);

    //查找 该角色下拥有的所有卡片
    List<Picture> getUserPicture(Integer userInfoId);

    //查询用户收藏
    List<Picture> getUserCollect(Integer userInfoId);

    //收藏/取消收藏商品
    boolean collectOrCancel(Integer pictureId,Integer userInfoId);

    //获取卡片
    boolean getPicture(Map<String,Object> getPicture);
}
