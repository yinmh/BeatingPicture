package org.game.beatingpicture.service;

import org.game.beatingpicture.entity.Category;
import org.game.beatingpicture.entity.Product;

import java.util.List;

public interface ShopService {
    Product findById(Integer id);
    List<Product> findAll();
    List<Product> findAllByCategoryId(Integer categoryId);
    //类别集合
    List<Category> findCategoryList();
}
