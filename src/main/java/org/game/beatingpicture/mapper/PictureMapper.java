package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.game.beatingpicture.entity.Picture;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface PictureMapper {

    List<Picture> getAllPictureByUserInfoId(int userInfoId);

    //查找 该角色下 status 为 1 的卡片，即上阵的卡片
    List<Picture> getAllPictureByStatus(int userInfoId);

    void updatePictureStatus(@Param("id") int id,@Param("flag")int flag);
    //查询上阵卡片的个数
    int findCount(int userInfoId);
}
