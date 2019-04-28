package org.game.beatingpicture.service;

import org.game.beatingpicture.entity.Desingation;

import java.util.List;

public interface DesingationService {
    List<Desingation> getDesingation(int desingationId);

    Desingation getDesingationById(int id);
}
