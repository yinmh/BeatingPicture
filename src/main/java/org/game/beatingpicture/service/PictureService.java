package org.game.beatingpicture.service;

import org.game.beatingpicture.entity.Picture;

import java.util.List;

public interface PictureService {
    List<Picture> getAllPictureByUserInfoId(Integer userInfoId);

    //查找 该角色下 status 为 1 的卡片，即上阵的卡片
    List<Picture> getAllPictureByStatus(Integer userInfoId);

    void updatePictureStatus(Integer id, Integer flag);

    int findCount(Integer userInfoId);
}
