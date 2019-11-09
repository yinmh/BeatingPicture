package org.game.beatingpicture.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UploadPicture {
    private Integer id;
    private Integer userId;
    private String pictureName;
    private Integer attack;
    private Integer defense;
    private Integer hit;
    private Integer miss;
    private Integer power;
    private String uploadReason;
    private Date uploadTime;
}
