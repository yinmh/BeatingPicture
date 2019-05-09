package org.game.beatingpicture.service;

import org.game.beatingpicture.entity.Picture;

import java.util.List;

public interface PictureService {
    List<Picture> getAllPictureByUserInfoId(int userInfoId);

    //查找 该角色下 status 为 1 的卡片，即上阵的卡片
    List<Picture> getAllPictureByStatus(int userInfoId);

    void updatePictureStatus(int id, int flag);

    int findCount(int userInfoId);
}
