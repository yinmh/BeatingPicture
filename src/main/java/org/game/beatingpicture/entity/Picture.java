package org.game.beatingpicture.entity;

import lombok.Data;

@Data
public class Picture {
    private int id;
    private String picturePath;
    private String pictureName;
    private long harm;
    private int status;

}
