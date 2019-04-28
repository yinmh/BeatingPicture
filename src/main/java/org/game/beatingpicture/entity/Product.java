package org.game.beatingpicture.entity;

import lombok.Data;

@Data
public class Product {
    private int id;
    private int pictureId;
    private int categoryId;
    private int price;
    private float discount;
    private int status;

}
