package org.game.beatingpicture.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.game.beatingpicture.entity.Area;
import org.game.beatingpicture.entity.Category;
import org.game.beatingpicture.entity.Product;

import java.util.List;

@Mapper
public interface ShopMapper {
    Product selectById(Integer id);
    List<Product> findAll();
    List<Product> findAllByCategoryId(Integer categoryId);
    //类别集合
    List<Category> selectCategoryList();
}
