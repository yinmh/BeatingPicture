package org.game.beatingpicture.service;

import org.game.beatingpicture.entity.Desingation;

import java.util.List;

public interface DesingationService {
        List<Desingation> getDesingation(Integer desingationId);

    Desingation getDesingationById(Integer id);
}
