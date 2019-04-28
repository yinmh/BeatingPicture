package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.game.beatingpicture.entity.Sign;

import java.util.List;

@Mapper
public interface SignMapper {
    List<Sign> getAllSign();

    Sign getSignByUserInfoId(int id);

    void updateSigned(int flag);
}
