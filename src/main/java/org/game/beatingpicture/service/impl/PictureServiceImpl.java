package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Picture;
import org.game.beatingpicture.mapper.PictureMapper;
import org.game.beatingpicture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureMapper pictureMapper;

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
}
