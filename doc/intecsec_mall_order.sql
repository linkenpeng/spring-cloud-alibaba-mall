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

 Date: 15/01/2023 11:08:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `gmt_updated` datetime DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order
-- ----------------------------
BEGIN;
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
  `gmt_updated` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order_consignee
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for mall_order_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_item`;
CREATE TABLE `mall_order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL DEFAULT '0' COMMENT '订单id',
  `sku_id` bigint unsigned NOT NULL DEFAULT '0' COMMENT '商品skuid',
  `item_id` bigint NOT NULL DEFAULT '0' COMMENT '商品id',
  `sku_price` bigint NOT NULL DEFAULT '0' COMMENT '商品价格',
  `sku_num` int NOT NULL DEFAULT '0' COMMENT '购买数量',
  `sku_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '商品名称',
  `actual_price` bigint NOT NULL DEFAULT '0' COMMENT '实付价格，sku_price-coupon_amount-point_amount-discount_amount',
  `coupon_amount` bigint NOT NULL DEFAULT '0' COMMENT '优惠券优惠金额(分)',
  `point_amount` bigint NOT NULL DEFAULT '0' COMMENT '积分优惠金额(分)',
  `discount_amount` bigint NOT NULL DEFAULT '0' COMMENT '其他总优惠金额，不含优惠券，积分优惠(分)',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_order_item
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
