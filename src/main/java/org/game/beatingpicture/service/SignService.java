package org.game.beatingpicture.service;

import org.game.beatingpicture.entity.Sign;

import java.util.List;

public interface SignService {
    List<Sign> getAllSign();

    Sign getSignByUserInfoId(Integer userInfoId);

    void updateSigned(Integer flag);
}
