package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Sign;
import org.game.beatingpicture.mapper.SignMapper;
import org.game.beatingpicture.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignServiceImpl implements SignService {
    @Autowired
    private SignMapper signMapper;

    @Override
    public List<Sign> getAllSign() {
        return signMapper.getAllSign();
    }

    @Override
    public Sign getSignByUserInfoId(Integer userInfoId) {
        return signMapper.getSignByUserInfoId(userInfoId);
    }

    @Override
    public void updateSigned(Integer flag) {
        signMapper.updateSigned(flag);
    }
}
