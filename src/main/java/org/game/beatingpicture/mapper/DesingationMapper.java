package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.game.beatingpicture.entity.Desingation;

import java.util.List;

@Mapper
public interface DesingationMapper {
    List<Desingation> getDesingation(Integer desingationId);

    Desingation getDesingationById(Integer id);
}
