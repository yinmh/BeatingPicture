package org.game.beatingpicture.entity;

import lombok.Data;

@Data
public class Category {
    private int id;
    private String categoryName;
    private int parentId;
    private String description;
}
