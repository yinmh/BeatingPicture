package org.game.beatingpicture.entity;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private String categoryName;
    private Integer parentId;
    private String description;
}
