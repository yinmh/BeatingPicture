package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.game.beatingpicture.entity.UploadPicture;

@Mapper
public interface UploadMapper {
    void addUploadPicture(UploadPicture uploadPicture);
}
