package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.game.beatingpicture.entity.Boss;

@Mapper
public interface BossMapper {
    Boss getBossByAreaId(Integer areaId);
}
