package org.game.beatingpicture.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UploadPicture {
    private int id;
    private int userId;
    private String pictureName;
    private Date uploadTime;
}
