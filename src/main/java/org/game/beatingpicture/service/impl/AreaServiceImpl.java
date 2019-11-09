package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Area;
import org.game.beatingpicture.mapper.AreaMapper;
import org.game.beatingpicture.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> findAll() {
        return areaMapper.findAll();
    }

    @Override
    public void updateStatus(Integer status,Integer areaId) {
        areaMapper.updateStatus(status,areaId);
    }
}
