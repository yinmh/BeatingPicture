package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Desingation;
import org.game.beatingpicture.mapper.DesingationMapper;
import org.game.beatingpicture.service.DesingationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesingationServiceImpl implements DesingationService {
    @Autowired
    private DesingationMapper desingationMapper;
    @Override
    public List<Desingation> getDesingation(Integer desingationId) {
        return desingationMapper.getDesingation(desingationId);
    }

    @Override
    public Desingation getDesingationById(Integer id) {
        return desingationMapper.getDesingationById(id);
    }
}
