package org.game.beatingpicture.service.impl;

import org.game.beatingpicture.entity.Area;
import org.game.beatingpicture.entity.Category;
import org.game.beatingpicture.entity.Product;
import org.game.beatingpicture.mapper.AreaMapper;
import org.game.beatingpicture.mapper.ShopMapper;
import org.game.beatingpicture.service.AreaService;
import org.game.beatingpicture.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Product findById(Integer id) {
        return shopMapper.selectById(id);
    }

    @Override
    public List<Product> findAll() {
        return shopMapper.findAll();
    }

    @Override
    public List<Product> findAllByCategoryId(Integer categoryId) {
        return shopMapper.findAllByCategoryId(categoryId);
    }
    //类别集合
    @Override
    public List<Category> findCategoryList() {
        return shopMapper.selectCategoryList();
    }

}
