package org.game.beatingpicture.controller;

import org.game.beatingpicture.entity.*;
import org.game.beatingpicture.mapper.UserInfoMapper;
import org.game.beatingpicture.mapper.UserMapper;
import org.game.beatingpicture.service.DesingationService;
import org.game.beatingpicture.service.SignService;
import org.game.beatingpicture.service.UserInfoService;
import org.game.beatingpicture.service.UserService;
import org.game.beatingpicture.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DesingationService desingationService;

    @Autowired
    private SignService signService;

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserService userService;

    @RequestMapping("/getAllHeadImg")
    public ResponseEntity getAllHeadImg(){
        return ResponseEntity.ok(userInfoService.getAllHeadImg());
    }


//    @RequestMapping("/getUserHeadImgByUserInfoId")
//    public ResponseEntity getUserHeadImgByUserInfoId(HttpServletRequest request){
//        User user = (User)request.getSession().getAttribute("user");
//        UserInfo userinfo = userService.getUserInfoByUserId(user.getId());
//        return ResponseEntity.ok(userInfoService.getUserHeadImgByUserInfoId(userinfo.getHeadImgId()));
//    }

    @RequestMapping("/getUserInfoByUserId")
    public ResponseEntity getUserInfoByUserId(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        UserInfoVo userInfoVo = new UserInfoVo();
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        HeadImg headImg = userInfoService.getUserHeadImgByHeadImgId(userInfo.getHeadImgId());
        userInfoVo.setHeadImgPath(headImg.getHeadImgPath());
        Desingation desingation = userInfoMapper.getDesingationById(userInfo.getDesignationId());
        Rank rank = userInfoMapper.getRankById(userInfo.getRankId());
        userInfoVo.setRankName(rank.getRankName());
        userInfoVo.setDesignationName(desingation.getName());
        userInfoVo.setUserId(userInfo.getUserId());
        userInfoVo.setCoin(userInfo.getCoin());
        userInfoVo.setGoldMoney(userInfo.getGoldMoney());
        userInfoVo.setHeadImgId(userInfo.getHeadImgId());
        userInfoVo.setPower(userInfo.getPower());
        userInfoVo.setIntegral(userInfo.getIntegral());
        userInfoVo.setSex(userInfo.getSex());
        userInfoVo.setRoleName(userInfo.getRoleName());
        userInfoVo.setId(userInfo.getId());
        userInfoVo.setSigned(userInfo.getSigned());
        userInfoVo.setHExp(userInfo.getHExp());
        return ResponseEntity.ok(userInfoVo);
    }


    @PostMapping("/updateHeadImg")
    public ModelAndView updateHeadImg(HttpServletRequest request,int headImgId){
        User user = (User)request.getSession().getAttribute("user");
        UserInfo userinfo = userService.getUserInfoByUserId(user.getId());
        userInfoService.updateHeadImg(userinfo.getId(),headImgId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("code",0);
        modelAndView.setView(new View() {
            @Override
            public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
                httpServletResponse.sendRedirect("/index");
            }
        });
        return modelAndView;
    }

    @PostMapping("/addUserInfo")
    public ModelAndView addUserInfo(HttpServletRequest request,UserInfo userInfo){
        User user = (User)request.getSession().getAttribute("user");
        userInfo.setUserId(user.getId());
        userInfoService.addUserInfo(userInfo);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("code",0);
        modelAndView.setView(new View() {
            @Override
            public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
                httpServletResponse.sendRedirect("/index");
            }
        });
        return modelAndView;
    }

    @PostMapping("/exchangeDesingation")
    public ResponseEntity exchangeDesingation(int id,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        Desingation desingation = desingationService.getDesingationById(id);
        int integralValue = desingation.getIntegral();
        //System.out.println(integralValue);
        userInfoService.updateDesingationById(id,integralValue,userInfo.getId());
        return ResponseEntity.ok(0);
    }

    @RequestMapping("/updateCoin")
    public ResponseEntity updateCoin(int id,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        UserInfo userInfo = userService.getUserInfoByUserId(user.getId());
        Sign sign = signService.getSignByUserInfoId(id);
//        System.out.println(sign);
        userInfoService.updateCoin(sign.getGetCoin(),userInfo.getId());
        return ResponseEntity.ok(0);
    }
}
