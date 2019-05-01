package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.UploadPicture;
import org.game.beatingpicture.mapper.UploadMapper;
import org.game.beatingpicture.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private UploadMapper uploadMapper;
    @Override
    public void addUploadPicture(UploadPicture uploadPicture) {
        uploadMapper.addUploadPicture(uploadPicture);
    }
}
