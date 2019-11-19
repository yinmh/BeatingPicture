package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.game.beatingpicture.entity.Picture;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Mapper
public interface PictureMapper {

    List<Picture> getAllPictureByUserInfoId(Integer userInfoId);

    //查找 该角色下 status 为 1 的卡片，即上阵的卡片
    List<Picture> getAllPictureByStatus(Integer userInfoId);

    //查找 该角色下拥有的所有卡片
    List<Picture> getUserPicture(Integer userInfoId);

    void updatePictureStatus(@Param("id") Integer id,@Param("flag")Integer flag);
    //查询上阵卡片的个数
    int findCount(Integer userInfoId);
    //查询用户是否已经购买此卡片
    int selectUserPictureCount(@Param("userInfoId")Integer userInfoId,@Param("pictureId")Integer pictureId);

    Picture selectPictureById(Integer id);

    //查询用户收藏
    List<Picture> getUserCollect(Integer userInfoId);

    //查询用户是否收藏卡片
    int selectCollected(@Param("pictureId")Integer pictureId,@Param("userInfoId")Integer userInfoId);
    //收藏
    int collect(@Param("pictureId")Integer pictureId,@Param("userInfoId")Integer userInfoId);
    //取消收藏
    int cancelCollect(@Param("pictureId")Integer pictureId,@Param("userInfoId")Integer userInfoId);

    //获取卡片
    int addPicture(Map<String,Object> getPicture);

}
