package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RewardMapper {

    void updateRewarded(Integer flag);
}
