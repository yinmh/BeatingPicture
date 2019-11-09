package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.game.beatingpicture.entity.Area;

import java.util.List;

@Mapper
public interface AreaMapper {
    List<Area> findAll();

    void updateStatus(@Param("status") Integer status, @Param("areaId") Integer areaId);
}
