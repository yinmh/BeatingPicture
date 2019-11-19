package org.game.beatingpicture.controller;

import org.game.beatingpicture.entity.Picture;
import org.game.beatingpicture.entity.Product;
import org.game.beatingpicture.entity.User;
import org.game.beatingpicture.entity.UserInfo;
import org.game.beatingpicture.service.PictureService;
import org.game.beatingpicture.service.ShopService;
import org.game.beatingpicture.service.UserInfoService;
import org.game.beatingpicture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/getProduct")
    public List<Map<String,Object>> getProduct(Integer categoryId, HttpServletRequest request){
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        List<Picture> userPicture = pictureService.getUserPicture(userInfo.getId());
        List<Picture> userCollect = pictureService.getUserCollect(userInfo.getId());
        if (categoryId == 0){
            List<Product> productList = shopService.findAll();
            for (Product product : productList) {
                HashMap<String, Object> map = new HashMap<>();
                Picture picture = pictureService.getPictureById(product.getId());
                map.put("discount",product.getDiscount());
                map.put("price",product.getPrice());
                map.put("name",picture.getPictureName());
                map.put("attack",picture.getAttack());
                map.put("defense",picture.getDefense());
                map.put("hit",picture.getHit());
                map.put("miss",picture.getMiss());
                map.put("id",picture.getId());
                map.put("path",picture.getPicturePath());
                userPicture.parallelStream().forEach(pic ->{//查询用户是否已经购买
                    if(pic.getId() == product.getPictureId()){
                        map.put("shoped",1);
                    }
                });
                userCollect.parallelStream().forEach(pic ->{//查询用户是否已经收藏
                    if(pic.getId() == product.getPictureId()){
                        map.put("collected",1);
                    }
                });
                maps.add(map);
            }
            return maps;
        }else {
            List<Product> products = shopService.findAllByCategoryId(categoryId);
            for (Product product : products) {
                HashMap<String, Object> map = new HashMap<>();
                Picture picture = pictureService.getPictureById(product.getId());
                map.put("discount",product.getDiscount());
                map.put("price",product.getPrice());
                map.put("name",picture.getPictureName());
                map.put("attack",picture.getAttack());
                map.put("defense",picture.getDefense());
                map.put("hit",picture.getHit());
                map.put("miss",picture.getMiss());
                map.put("path",picture.getPicturePath());
                map.put("id",picture.getId());
                userPicture.parallelStream().forEach(pic ->{
                    if(pic.getId() == product.getPictureId()){
                        map.put("shoped",1);
                    }
                });
                userCollect.parallelStream().forEach(pic ->{
                    if(pic.getId() == product.getPictureId()){
                        map.put("collected",1);
                    }
                });
                maps.add(map);
            }
            return maps;
        }
    }

    @RequestMapping("/getCategoryList")
    public ResponseEntity getCategoryList(){
        return ResponseEntity.ok(shopService.findCategoryList());
    }

    //购买卡片
    @RequestMapping("/shop")
    @Transactional
    public ResponseEntity shop(HttpServletRequest request,Integer productId){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        if (productId != null){
            Product product = shopService.findById(productId);
            Integer price = product.getPrice();
            Integer discount = product.getDiscount();
            Long coin =Math.round(price * (discount * -0.1));
            userInfoService.updateCoin(coin.intValue(),userInfo.getId());
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId",userInfo.getId());
            map.put("pictureId",product.getPictureId());
            map.put("status",1);
            pictureService.getPicture(map);
            return ResponseEntity.ok(true);
        }
        return null;
    }

    //收藏/取消收藏商品
    @RequestMapping("/collectOrCancel")
    public ResponseEntity collectOrCancel(HttpServletRequest request,Integer pictureId){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        boolean flag = pictureService.collectOrCancel(pictureId, userInfo.getId());
        if (!flag){
            return ResponseEntity.ok(flag);
        }
        return ResponseEntity.ok(flag);
    }
}
