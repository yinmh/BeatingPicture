/*
Navicat MySQL Data Transfer

Source Server         : 3306
Source Server Version : 50624
Source Host           : 127.0.0.1:3306
Source Database       : beating_picture

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-11-09 16:18:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域表主键',
  `area_name` varchar(255) DEFAULT NULL COMMENT '区域',
  `status` tinyint(4) DEFAULT '1' COMMENT '区域状态 （boss是否更新）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '云雾峰', '0');
INSERT INTO `area` VALUES ('2', '夺宝栈', '1');
INSERT INTO `area` VALUES ('3', '崆峒山', '1');
INSERT INTO `area` VALUES ('4', '神兵阁', '1');
INSERT INTO `area` VALUES ('5', '藏宝洞一层', '1');
INSERT INTO `area` VALUES ('6', '藏宝洞二层', '1');
INSERT INTO `area` VALUES ('7', '藏宝洞三层', '1');
INSERT INTO `area` VALUES ('8', '无名府', '1');

-- ----------------------------
-- Table structure for boss
-- ----------------------------
DROP TABLE IF EXISTS `boss`;
CREATE TABLE `boss` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'boss表主键 id',
  `name` varchar(255) DEFAULT NULL COMMENT 'boss名称',
  `area_id` int(11) DEFAULT NULL COMMENT '区域id',
  `blood` bigint(20) DEFAULT NULL COMMENT '血量',
  `attack` int(11) DEFAULT NULL COMMENT '伤害',
  `defense` int(11) DEFAULT '1' COMMENT '防御',
  `g_exp` bigint(20) DEFAULT NULL COMMENT '击杀获得经验',
  `coin` int(11) DEFAULT NULL COMMENT '击杀获得金币',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of boss
-- ----------------------------
INSERT INTO `boss` VALUES ('1', '帝释天', '1', '100000', '1000', '666', '400', '60');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类表主键 id',
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '上级分类',
  `description` varchar(255) DEFAULT NULL COMMENT '分类描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for desingation
-- ----------------------------
DROP TABLE IF EXISTS `desingation`;
CREATE TABLE `desingation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '称号表主键 id',
  `name` varchar(255) DEFAULT NULL COMMENT '称号',
  `integral` bigint(20) DEFAULT '0' COMMENT '所需积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of desingation
-- ----------------------------
INSERT INTO `desingation` VALUES ('1', '斗图小白', '500');
INSERT INTO `desingation` VALUES ('2', '斗图新秀', '1000');
INSERT INTO `desingation` VALUES ('3', '斗图侠士', '1500');
INSERT INTO `desingation` VALUES ('4', '斗图勇士', '2600');
INSERT INTO `desingation` VALUES ('5', '斗图强者', '5000');
INSERT INTO `desingation` VALUES ('6', '斗图高手', '10000');
INSERT INTO `desingation` VALUES ('7', '斗图王者', '18000');
INSERT INTO `desingation` VALUES ('8', '神一样的存在', '25000');
INSERT INTO `desingation` VALUES ('9', '你就是爸爸', '50000');
INSERT INTO `desingation` VALUES ('10', '无上限了', '10000000');

-- ----------------------------
-- Table structure for head_img
-- ----------------------------
DROP TABLE IF EXISTS `head_img`;
CREATE TABLE `head_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `head_img_path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of head_img
-- ----------------------------
INSERT INTO `head_img` VALUES ('1', './image/head/1.jpg');
INSERT INTO `head_img` VALUES ('2', './image/head/2.jpg');
INSERT INTO `head_img` VALUES ('3', './image/head/3.jpg');
INSERT INTO `head_img` VALUES ('4', './image/head/4.jpg');
INSERT INTO `head_img` VALUES ('5', './image/head/5.jpg');
INSERT INTO `head_img` VALUES ('6', './image/head/6.jpg');
INSERT INTO `head_img` VALUES ('7', './image/head/7.jpg');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------

-- ----------------------------
-- Table structure for manager_role
-- ----------------------------
DROP TABLE IF EXISTS `manager_role`;
CREATE TABLE `manager_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager_role
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT 'url路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '卡牌表主键 id',
  `picture_path` varchar(255) DEFAULT NULL COMMENT '卡牌路径',
  `picture_name` varchar(255) DEFAULT NULL COMMENT '卡牌名',
  `power` varchar(255) DEFAULT NULL COMMENT '战力',
  `attack` bigint(20) DEFAULT NULL COMMENT '攻击',
  `defense` int(11) DEFAULT NULL COMMENT '防御',
  `hit` int(11) DEFAULT NULL COMMENT '暴击',
  `miss` int(11) DEFAULT NULL COMMENT '闪避',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', './image/picture/21.jpg', '图片1', '100', '1000', null, null, null);
INSERT INTO `picture` VALUES ('2', './image/picture/22.jpg', '图片2', '200', '2000', null, null, null);
INSERT INTO `picture` VALUES ('3', './image/picture/23.jpg', '图片3', '555', '3000', null, null, null);
INSERT INTO `picture` VALUES ('4', './image/picture/24.jpg', '图片4', '600', '4000', null, null, null);
INSERT INTO `picture` VALUES ('5', './image/picture/25.jpg', '图片5', '700', '5000', null, null, null);
INSERT INTO `picture` VALUES ('6', './image/picture/26.jpg', '图片6', '320', '6000', null, null, null);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品表主键 id',
  `category_id` int(11) DEFAULT NULL COMMENT '分类id',
  `price` int(11) DEFAULT NULL COMMENT '价格  ',
  `discount` int(11) DEFAULT '10' COMMENT '折扣',
  `status` int(11) DEFAULT '1' COMMENT '状态 1-上架 0-下架',
  `picture_id` int(11) DEFAULT NULL COMMENT '图片id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级表主键 id',
  `rank_name` varchar(128) NOT NULL COMMENT '等级',
  `exp` bigint(20) DEFAULT NULL COMMENT '升下级所需经验',
  `get_gold_money` int(11) DEFAULT NULL COMMENT '升级获取元宝数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rank
-- ----------------------------
INSERT INTO `rank` VALUES ('1', '1级', '1000', null);
INSERT INTO `rank` VALUES ('2', '2级', '1500', null);
INSERT INTO `rank` VALUES ('3', '3级', '2200', null);
INSERT INTO `rank` VALUES ('4', '4级', '2900', null);
INSERT INTO `rank` VALUES ('5', '5级', '3500', null);
INSERT INTO `rank` VALUES ('6', '6级', '4300', null);
INSERT INTO `rank` VALUES ('7', '7级', '5400', null);
INSERT INTO `rank` VALUES ('8', '8级', '6666', null);

-- ----------------------------
-- Table structure for rare_pet
-- ----------------------------
DROP TABLE IF EXISTS `rare_pet`;
CREATE TABLE `rare_pet` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '珍兽表 id',
  `name` varchar(255) DEFAULT NULL,
  `harm` int(11) DEFAULT NULL COMMENT '伤害',
  `power` int(11) DEFAULT NULL COMMENT '战力',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rare_pet
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for roll_img
-- ----------------------------
DROP TABLE IF EXISTS `roll_img`;
CREATE TABLE `roll_img` (
  `id` int(11) NOT NULL COMMENT '商城轮播图 id',
  `roll_img_path` varchar(255) DEFAULT NULL COMMENT '轮播图路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roll_img
-- ----------------------------

-- ----------------------------
-- Table structure for sign
-- ----------------------------
DROP TABLE IF EXISTS `sign`;
CREATE TABLE `sign` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `get_coin` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sign
-- ----------------------------
INSERT INTO `sign` VALUES ('0', '星期天', '100', '&#xe756;');
INSERT INTO `sign` VALUES ('1', '星期一', '100', '&#xe608;');
INSERT INTO `sign` VALUES ('2', '星期二', '100', '&#xe650;');
INSERT INTO `sign` VALUES ('3', '星期三', '100', '&#xe67a;');
INSERT INTO `sign` VALUES ('4', '星期四', '100', '&#xe6af;');
INSERT INTO `sign` VALUES ('5', '星期五', '100', '&#xe62e;');
INSERT INTO `sign` VALUES ('6', '星期六', '100', '&#xe735;');

-- ----------------------------
-- Table structure for throne
-- ----------------------------
DROP TABLE IF EXISTS `throne`;
CREATE TABLE `throne` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '神兵表主键 id',
  `name` varchar(255) DEFAULT NULL COMMENT '神兵名称',
  `element_num` int(11) DEFAULT NULL COMMENT '所需稀有元素数量',
  `need_gold_money` int(11) DEFAULT NULL COMMENT '所需元宝数',
  `power` int(11) DEFAULT NULL COMMENT '战力',
  `attack` int(11) DEFAULT NULL COMMENT '伤害',
  `hit` int(11) DEFAULT NULL COMMENT '暴击',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of throne
-- ----------------------------

-- ----------------------------
-- Table structure for upload_picture
-- ----------------------------
DROP TABLE IF EXISTS `upload_picture`;
CREATE TABLE `upload_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '上传表主键 id',
  `user_id` int(11) DEFAULT NULL COMMENT '上传者id',
  `picture_name` varchar(255) DEFAULT NULL COMMENT '卡片名称',
  `attack` int(11) DEFAULT NULL COMMENT '攻击',
  `defense` int(11) DEFAULT NULL COMMENT '防御',
  `hit` int(11) DEFAULT NULL COMMENT '暴击',
  `miss` int(11) DEFAULT NULL COMMENT '闪避',
  `power` int(11) DEFAULT NULL COMMENT '战力',
  `upload_reason` varchar(2048) DEFAULT NULL COMMENT '上传理由',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload_picture
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` int(2) DEFAULT '1',
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('5', 'admin', '10:c337a74dccbbe8e9ddf62c2e39f8b26b3f76f02cd6cc102c:e2b0eeb9b6f7a68d2a0e85c5f0ead24c8608bc5eeff914fd', '1', null);
INSERT INTO `user` VALUES ('6', 'test', '10:c337a74dccbbe8e9ddf62c2e39f8b26b3f76f02cd6cc102c:e2b0eeb9b6f7a68d2a0e85c5f0ead24c8608bc5eeff914fd', '1', null);
INSERT INTO `user` VALUES ('17', 'test1', '10:c337a74dccbbe8e9ddf62c2e39f8b26b3f76f02cd6cc102c:e2b0eeb9b6f7a68d2a0e85c5f0ead24c8608bc5eeff914fd', '1', null);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户信息类 主键',
  `head_img_id` int(11) NOT NULL COMMENT '头像id',
  `coin` bigint(20) DEFAULT '0' COMMENT '金币',
  `power` int(11) DEFAULT '3000' COMMENT '战斗力',
  `designation_id` int(11) DEFAULT '1' COMMENT '称号id',
  `rank_id` int(11) NOT NULL DEFAULT '1' COMMENT '等级id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `gold_money` bigint(20) DEFAULT '0' COMMENT '元宝',
  `integral` int(11) DEFAULT '0' COMMENT '积分 用于兑换称号',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `role_name` varchar(255) DEFAULT NULL COMMENT 'jiao色名称',
  `signed` int(11) DEFAULT '1' COMMENT '可签到',
  `h_exp` bigint(20) DEFAULT '0' COMMENT '拥有经验',
  `rewarded` int(11) DEFAULT '1' COMMENT '可抽奖',
  `attack` int(11) DEFAULT NULL COMMENT '攻击',
  `defense` int(11) DEFAULT NULL COMMENT '防御',
  `hit` int(11) DEFAULT NULL COMMENT '暴击',
  `miss` int(11) DEFAULT NULL COMMENT '闪避',
  `rare_pet_id` int(11) DEFAULT NULL COMMENT '珍兽id',
  `throne_id` int(11) DEFAULT NULL COMMENT '神器id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('14', '5', '103199', '6666666', '7', '4', '5', '999999', '16299', '男', 'ADMIN', '1', '1100', '1', null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('15', '1', '100', '666', '1', '1', '6', '0', '0', '女', '我是测试人员', '1', '0', '1', null, null, null, null, null, null);
INSERT INTO `user_info` VALUES ('16', '3', '100', '666', '1', '1', '17', '0', '0', '女', '陌生', '1', '0', '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user_picture
-- ----------------------------
DROP TABLE IF EXISTS `user_picture`;
CREATE TABLE `user_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户图片主键 id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `picture_id` int(11) NOT NULL COMMENT '图片id',
  `get_time` datetime DEFAULT NULL COMMENT '获取时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '上阵状态 1-上阵 -未上阵',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_picture
-- ----------------------------
INSERT INTO `user_picture` VALUES ('1', '14', '1', '2019-05-28 22:52:40', '1');
INSERT INTO `user_picture` VALUES ('2', '14', '2', '2019-08-09 10:17:55', '0');
INSERT INTO `user_picture` VALUES ('3', '14', '3', '2019-08-09 10:17:56', '1');
INSERT INTO `user_picture` VALUES ('4', '14', '4', '2019-11-07 09:29:39', '1');
INSERT INTO `user_picture` VALUES ('5', '14', '5', '2019-05-27 23:06:46', '1');
INSERT INTO `user_picture` VALUES ('6', '14', '6', '2019-05-28 22:52:34', '1');
