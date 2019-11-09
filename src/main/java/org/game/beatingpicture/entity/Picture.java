package org.game.beatingpicture.entity;


import lombok.Data;

@Data
public class Picture {
    private Integer id;
    private String picturePath;
    private String pictureName;
    private Integer attack;
    private Integer defense;
    private Integer hit;
    private Integer miss;
    private Integer status;

}
