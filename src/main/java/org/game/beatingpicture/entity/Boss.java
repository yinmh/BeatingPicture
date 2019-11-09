package org.game.beatingpicture.entity;

import lombok.Data;

@Data
public class Boss {
    private int id;
    private String name;
    private int areaId;
    private long blood;
    private int attack;
    private long gExp;
    private int coin;
    private int defense;
}
