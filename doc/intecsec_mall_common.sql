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

 Date: 15/01/2023 11:14:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mall_common_dict
-- ----------------------------
DROP TABLE IF EXISTS `mall_common_dict`;
CREATE TABLE `mall_common_dict` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` bigint unsigned NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  `dict_code` varchar(100) NOT NULL,
  `gmt_created` datetime DEFAULT NULL,
  `gmt_updated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delete_mark` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mall_common_dict
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
