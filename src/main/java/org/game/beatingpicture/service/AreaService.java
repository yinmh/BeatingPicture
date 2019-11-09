package org.game.beatingpicture.service;

import io.swagger.models.auth.In;
import org.game.beatingpicture.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> findAll();

    void updateStatus(Integer status, Integer areaId);
}
