package org.game.beatingpicture.entity;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private Integer pictureId;
    private Integer categoryId;
    private Integer price;
    private Integer discount;
    private Integer status;
}
