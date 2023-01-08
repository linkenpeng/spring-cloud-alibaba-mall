/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : intecsec_mall

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 08/01/2023 21:19:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_item`;
CREATE TABLE `mall_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL DEFAULT '',
  `category_id` bigint unsigned NOT NULL DEFAULT '1',
  `item_price` bigint NOT NULL DEFAULT '0',
  `item_image` varchar(255) NOT NULL DEFAULT '',
  `item_desc` varchar(255) NOT NULL DEFAULT '',
  `status` tinyint DEFAULT '0' COMMENT '上架状态 1：上架 0：下架',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_item
-- ----------------------------
BEGIN;
INSERT INTO `mall_item` VALUES (1, '沐浴露', 2, 2600, 'https://img1.baidu.com/it/u=2060009719,1463033359&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', '沐浴露', 1, '2020-04-05 16:00:00', '2020-04-05 16:00:00', 0);
INSERT INTO `mall_item` VALUES (2, '洗发水', 2, 4300, 'https://t1.roadlady.com/uploads/allimg/2209/145T03U5-0.jpg', '洗发水', 1, '2020-04-05 16:00:26', '2020-04-05 16:00:26', 0);
INSERT INTO `mall_item` VALUES (3, '衣服', 3, 12800, 'https://imgservice.suning.cn/uimg1/b2c/image/RyOD34D9qxtuvtdA6uOgPg.jpg', '衣服', 0, '2023-01-02 15:34:42', '2023-01-02 15:34:42', 0);
INSERT INTO `mall_item` VALUES (4, '裤子', 3, 9800, 'https://bkimg.cdn.bcebos.com/pic/96dda144ad345982b2b7dd0b44a526adcbef76092e53', '裤子', 0, '2023-01-02 15:34:46', '2023-01-02 15:34:46', 0);
INSERT INTO `mall_item` VALUES (5, '袜子', 3, 1920, 'https://imgservice.suning.cn/uimg1/b2c/image/FttayraC3CBcaCGpYItQBQ.jpg_800w_800h_4e', '袜子', 1, '2023-01-02 15:34:49', '2023-01-02 15:34:49', 0);
INSERT INTO `mall_item` VALUES (6, '苹果', 1, 890, 'https://lmg.jj20.com/up/allimg/tp02/1Z91P02I21Y9-0-lp.jpg', '苹果', 0, '2023-01-02 15:35:06', '2023-01-02 15:35:06', 0);
INSERT INTO `mall_item` VALUES (7, '橙子', 1, 560, 'https://bpic.51yuansu.com/pic3/cover/03/27/68/5b7abefce5942_610.jpg', '橙子', 0, '2023-01-02 15:35:19', '2023-01-02 15:35:19', 0);
INSERT INTO `mall_item` VALUES (8, '桃子', 1, 12500, '', '桃子', 0, '2023-01-08 20:13:57', '2023-01-08 20:13:57', 0);
INSERT INTO `mall_item` VALUES (9, '1', 1, 1, '', '1', 1, '2023-01-08 20:30:42', '2023-01-08 20:30:42', 0);
INSERT INTO `mall_item` VALUES (10, '22', 2, 22, '', '22', 1, '2023-01-08 20:34:54', '2023-01-08 20:34:54', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_item_category
-- ----------------------------
DROP TABLE IF EXISTS `mall_item_category`;
CREATE TABLE `mall_item_category` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int unsigned DEFAULT '0',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of mall_item_category
-- ----------------------------
BEGIN;
INSERT INTO `mall_item_category` VALUES (1, 0, '水果', '2023-01-07 16:12:31', '2023-01-07 16:12:32', '0');
INSERT INTO `mall_item_category` VALUES (2, 0, '化妆品', '2023-01-07 16:12:54', '2023-01-07 16:12:56', '0');
INSERT INTO `mall_item_category` VALUES (3, 0, '服装', '2023-01-07 17:16:44', '2023-01-07 17:16:47', '0');
COMMIT;

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(64) NOT NULL DEFAULT '',
  `user_id` bigint NOT NULL,
  `order_status` mediumint NOT NULL,
  `price_amount` bigint NOT NULL DEFAULT '0',
  `discount_amount` bigint DEFAULT '0',
  `coupon_amount` bigint DEFAULT '0',
  `point_amount` bigint DEFAULT '0',
  `delivery_fee` bigint DEFAULT '0',
  `pay_amount` bigint DEFAULT '0',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order
-- ----------------------------
BEGIN;
INSERT INTO `mall_order` VALUES (1, '20221126195310966', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:10', '2022-11-26 19:53:10', 0);
INSERT INTO `mall_order` VALUES (2, '20221126195340830', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:40', '2022-11-26 19:53:40', 0);
INSERT INTO `mall_order` VALUES (3, '20221126195341062', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order` VALUES (4, '20221126195341211', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order` VALUES (5, '20221126195341417', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order` VALUES (6, '20221126195341622', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order` VALUES (7, '20221126195341870', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order` VALUES (8, '20221126195342103', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order` VALUES (9, '20221126195342283', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order` VALUES (10, '20221126195342428', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order` VALUES (11, '20221126195342612', 1, 10, 6900, 0, 0, 0, 0, 6900, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_order_consignee
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_consignee`;
CREATE TABLE `mall_order_consignee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL DEFAULT '0',
  `user_id` bigint NOT NULL DEFAULT '0',
  `province` varchar(15) DEFAULT '',
  `city` varchar(20) DEFAULT '',
  `area` varchar(30) DEFAULT '' COMMENT '20',
  `address` varchar(100) DEFAULT '',
  `consignee_name` varchar(50) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order_consignee
-- ----------------------------
BEGIN;
INSERT INTO `mall_order_consignee` VALUES (1, 1, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:11', '2022-11-26 19:53:11', 0);
INSERT INTO `mall_order_consignee` VALUES (2, 2, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:40', '2022-11-26 19:53:40', 0);
INSERT INTO `mall_order_consignee` VALUES (3, 3, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_consignee` VALUES (4, 4, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_consignee` VALUES (5, 5, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_consignee` VALUES (6, 6, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_consignee` VALUES (7, 7, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_consignee` VALUES (8, 8, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_consignee` VALUES (9, 9, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_consignee` VALUES (10, 10, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_consignee` VALUES (11, 11, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_item`;
CREATE TABLE `mall_order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL DEFAULT '0' COMMENT '订单id',
  `item_id` bigint NOT NULL DEFAULT '0' COMMENT '商品id',
  `item_price` bigint NOT NULL DEFAULT '0' COMMENT '商品价格',
  `item_num` int NOT NULL DEFAULT '0' COMMENT '购买数量',
  `item_name` varchar(128) NOT NULL DEFAULT '' COMMENT '商品名称',
  `actual_price` bigint NOT NULL DEFAULT '0' COMMENT '实付价格，商品价格-优惠价格',
  `coupon_amount` bigint NOT NULL DEFAULT '0' COMMENT '优惠券优惠金额(分)',
  `point_amount` bigint NOT NULL DEFAULT '0' COMMENT '积分优惠金额(分)',
  `discount_amount` bigint NOT NULL DEFAULT '0' COMMENT '总优惠金额(分)',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order_item
-- ----------------------------
BEGIN;
INSERT INTO `mall_order_item` VALUES (1, 1, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:11', '2022-11-26 19:53:11', 0);
INSERT INTO `mall_order_item` VALUES (2, 1, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:11', '2022-11-26 19:53:11', 0);
INSERT INTO `mall_order_item` VALUES (3, 2, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:40', '2022-11-26 19:53:40', 0);
INSERT INTO `mall_order_item` VALUES (4, 2, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:40', '2022-11-26 19:53:40', 0);
INSERT INTO `mall_order_item` VALUES (5, 3, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (6, 3, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (7, 4, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (8, 4, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (9, 5, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (10, 5, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (11, 6, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (12, 6, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (13, 7, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (14, 7, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:41', '2022-11-26 19:53:41', 0);
INSERT INTO `mall_order_item` VALUES (15, 8, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_item` VALUES (16, 8, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_item` VALUES (17, 9, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_item` VALUES (18, 9, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_item` VALUES (19, 10, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_item` VALUES (20, 10, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_item` VALUES (21, 11, 1, 2600, 2, '沐浴露', 0, 0, 0, 0, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
INSERT INTO `mall_order_item` VALUES (22, 11, 2, 4300, 3, '洗发水', 0, 0, 0, 0, '2022-11-26 19:53:42', '2022-11-26 19:53:42', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_user
-- ----------------------------
DROP TABLE IF EXISTS `mall_user`;
CREATE TABLE `mall_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  `age` int DEFAULT '0',
  `salt` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `nick_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '',
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '头像',
  `role` smallint NOT NULL DEFAULT '1',
  `version` int unsigned DEFAULT '0',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_username` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_user
-- ----------------------------
BEGIN;
INSERT INTO `mall_user` VALUES (15, 'abc123', '$2a$10$NVuWH9S3OQy8Y5vwKs0b8OlTU7H6o6GfbSVX7Al.DHuC8Aqnw6GsW', 0, '$2a$10$NVuWH9S3OQy8Y5vwKs0b8O', '', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 2, 1, '2022-12-16 22:11:30', '2022-12-31 17:44:43', 0);
INSERT INTO `mall_user` VALUES (17, 'peter', '$2a$10$60jZqn9c4lRiYjG1FXtp8OdnNubWjoE6W3GF8MH5Zegh1f6KMwQC2', 0, '$2a$10$60jZqn9c4lRiYjG1FXtp8O', '', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 1, 1, '2022-12-17 09:02:38', '2022-12-31 17:44:44', 0);
INSERT INTO `mall_user` VALUES (18, 'linken', '$2a$10$PE7K6nwEWSw0NE/57aL1DOgUEenCdM.uEF4sY/tmqO8uFFr4GbfRO', 0, '$2a$10$PE7K6nwEWSw0NE/57aL1DO', '', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 1, 1, '2022-12-31 10:01:35', '2022-12-31 17:44:46', 0);
INSERT INTO `mall_user` VALUES (19, 'admin', '$2a$10$OGc2MpPPbgHlnAqn30/2xuexAvWB6t.H3oGA/GNtXkz0eXj4eMRLu', 0, '$2a$10$OGc2MpPPbgHlnAqn30/2xu', '', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', 2, 1, '2022-12-31 10:03:00', '2022-12-31 17:44:47', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_user_consignee
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_consignee`;
CREATE TABLE `mall_user_consignee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  `province` varchar(15) DEFAULT '',
  `city` varchar(20) DEFAULT '',
  `area` varchar(30) DEFAULT '' COMMENT '20',
  `address` varchar(100) DEFAULT '',
  `consignee_name` varchar(50) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `gmt_created` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_update` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_user_consignee
-- ----------------------------
BEGIN;
INSERT INTO `mall_user_consignee` VALUES (1, 1, '广东省', '广州市', '天河区', '天河北路11号', '陈先生', '15873905393', '2020-04-26 18:47:45', '2020-06-28 15:49:45', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
