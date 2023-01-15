SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL DEFAULT '',
  `category_id` bigint unsigned NOT NULL DEFAULT '1',
  `default_sku_id` bigint NOT NULL DEFAULT '0' COMMENT '默认skuid',
  `item_image` varchar(255) NOT NULL DEFAULT '',
  `item_desc` varchar(255) NOT NULL DEFAULT '',
  `status` tinyint DEFAULT '0' COMMENT '上架状态 1：上架 0：下架',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of item
-- ----------------------------
BEGIN;
INSERT INTO `item` VALUES (1, '沐浴露', 2, 0, 'https://img1.baidu.com/it/u=2060009719,1463033359&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', '沐浴露', 1, '2020-04-05 16:00:00', '2020-04-05 16:00:00', 0);
INSERT INTO `item` VALUES (2, '洗发水', 2, 0, 'https://t1.roadlady.com/uploads/allimg/2209/145T03U5-0.jpg', '洗发水', 1, '2020-04-05 16:00:26', '2020-04-05 16:00:26', 0);
INSERT INTO `item` VALUES (3, '衣服', 3, 0, 'https://imgservice.suning.cn/uimg1/b2c/image/RyOD34D9qxtuvtdA6uOgPg.jpg', '衣服', 0, '2023-01-02 15:34:42', '2023-01-02 15:34:42', 0);
INSERT INTO `item` VALUES (4, '裤子', 3, 0, 'https://bkimg.cdn.bcebos.com/pic/96dda144ad345982b2b7dd0b44a526adcbef76092e53', '裤子', 0, '2023-01-02 15:34:46', '2023-01-02 15:34:46', 0);
INSERT INTO `item` VALUES (5, '袜子', 3, 0, 'https://imgservice.suning.cn/uimg1/b2c/image/FttayraC3CBcaCGpYItQBQ.jpg_800w_800h_4e', '袜子', 1, '2023-01-02 15:34:49', '2023-01-02 15:34:49', 0);
INSERT INTO `item` VALUES (6, '苹果', 1, 0, 'https://lmg.jj20.com/up/allimg/tp02/1Z91P02I21Y9-0-lp.jpg', '苹果', 0, '2023-01-02 15:35:06', '2023-01-02 15:35:06', 0);
INSERT INTO `item` VALUES (7, '橙子', 1, 0, 'https://bpic.51yuansu.com/pic3/cover/03/27/68/5b7abefce5942_610.jpg', '橙子', 0, '2023-01-02 15:35:19', '2023-01-02 15:35:19', 0);
INSERT INTO `item` VALUES (8, '桃子', 1, 0, '', '桃子', 0, '2023-01-08 20:13:57', '2023-01-08 20:13:57', 0);
COMMIT;

-- ----------------------------
-- Table structure for item_category
-- ----------------------------
DROP TABLE IF EXISTS `item_category`;
CREATE TABLE `item_category` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int unsigned DEFAULT '0',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '',
  `gmt_created` datetime DEFAULT NULL,
  `gmt_updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- ----------------------------
-- Records of item_category
-- ----------------------------
BEGIN;
INSERT INTO `item_category` VALUES (1, 0, '水果', '2023-01-07 16:12:31', '2023-01-07 16:12:32', '0');
INSERT INTO `item_category` VALUES (2, 0, '化妆品', '2023-01-07 16:12:54', '2023-01-07 16:12:56', '0');
INSERT INTO `item_category` VALUES (3, 0, '服装', '2023-01-07 17:16:44', '2023-01-07 17:16:47', '0');
COMMIT;

-- ----------------------------
-- Table structure for item_sku
-- ----------------------------
DROP TABLE IF EXISTS `item_sku`;
CREATE TABLE `item_sku` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `sku_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `item_id` bigint unsigned NOT NULL DEFAULT '1',
  `sku_price` bigint NOT NULL DEFAULT '0',
  `sku_stock` bigint NOT NULL DEFAULT '0',
  `sku_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `status` tinyint NOT NULL DEFAULT '0' COMMENT '上架状态 1：上架 0：下架',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gmt_updated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of item_sku
-- ----------------------------
BEGIN;
INSERT INTO `item_sku` VALUES (11, '沐浴露200 ml', 1, 2600, 108, 'https://img1.baidu.com/it/u=2060009719,1463033359&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', 0, '2023-01-14 17:50:52', '2023-01-14 17:50:52', 0);
INSERT INTO `item_sku` VALUES (12, '沐浴露400 ml', 1, 4000, 100, 'https://img1.baidu.com/it/u=2060009719,1463033359&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', 0, '2023-01-14 17:50:52', '2023-01-14 17:50:52', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
